// WellNest Platform - JavaScript Functions

// Resolve API base dynamically to match the current host/port (avoids CORS/mismatched port issues)
const API_BASE_URL = `${window.location.origin}/api`;

// Utility Functions
function showAlert(message, type = 'success') {
    const alertDiv = document.createElement('div');
    alertDiv.className = `alert alert-${type}`;
    alertDiv.textContent = message;
    document.body.insertBefore(alertDiv, document.body.firstChild);
    setTimeout(() => alertDiv.remove(), 5000);
}

function formatDate(dateString) {
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', { 
        year: 'numeric', 
        month: 'long', 
        day: 'numeric' 
    });
}

// Blog Functions
async function loadBlogs(category = null) {
    try {
        const url = category ? `${API_BASE_URL}/blogs?category=${category}` : `${API_BASE_URL}/blogs`;
        const response = await fetch(url);
        if (!response.ok) throw new Error(`HTTP ${response.status}`);
        const blogs = await response.json();
        displayBlogs(blogs);
    } catch (error) {
        console.error('Error loading blogs:', error);
        showAlert('Failed to load blogs', 'error');
    }
}

function displayBlogs(blogs) {
    const blogList = document.getElementById('blog-list');
    if (!blogList) return;
    
    if (blogs.length === 0) {
        blogList.innerHTML = '<p class="text-center">No blogs found.</p>';
        return;
    }
    
    blogList.innerHTML = blogs.map(blog => `
        <div class="blog-card">
            ${blog.imageUrl ? `<img src="${blog.imageUrl}" alt="${blog.title}" class="blog-image">` : ''}
            <div class="blog-content">
                <span class="blog-category">${blog.category}</span>
                <h3 class="blog-title">${blog.title}</h3>
                <p>${blog.content.substring(0, 150)}...</p>
                <div class="blog-meta">
                    <div>
                        <strong>${blog.authorName}</strong> • ${formatDate(blog.publishedDate)}
                    </div>
                    <div class="blog-actions">
                        <button class="like-btn" onclick="toggleLike(${blog.id}, '${getCurrentUser()}')">
                            ❤️ ${blog.likesCount}
                        </button>
                        <a href="blog-detail.html?id=${blog.id}" class="comment-btn">💬 ${blog.commentsCount}</a>
                    </div>
                </div>
                <a href="blog-detail.html?id=${blog.id}" class="btn btn-primary btn-small mt-2">Read More</a>
            </div>
        </div>
    `).join('');
}

async function loadBlogDetail() {
    const urlParams = new URLSearchParams(window.location.search);
    const blogId = urlParams.get('id');
    
    if (!blogId) {
        showAlert('Blog ID not found', 'error');
        return;
    }
    
    try {
        const response = await fetch(`${API_BASE_URL}/blogs/${blogId}`);
        if (!response.ok) throw new Error(`HTTP ${response.status}`);
        
        const blog = await response.json();
        displayBlogDetail(blog);
        loadComments(blogId);
        checkLikeStatus(blogId);
    } catch (error) {
        console.error('Error loading blog:', error);
        showAlert('Failed to load blog', 'error');
    }
}

function displayBlogDetail(blog) {
    document.getElementById('blog-title').textContent = blog.title;
    document.getElementById('blog-category').textContent = blog.category;
    document.getElementById('blog-author').textContent = blog.authorName;
    document.getElementById('blog-date').textContent = formatDate(blog.publishedDate);
    document.getElementById('blog-content').textContent = blog.content;
    
    if (blog.imageUrl) {
        document.getElementById('blog-image').src = blog.imageUrl;
        document.getElementById('blog-image').style.display = 'block';
    }
}

async function loadComments(blogId) {
    try {
        const response = await fetch(`${API_BASE_URL}/blogs/${blogId}/comments`);
        if (!response.ok) throw new Error(`HTTP ${response.status}`);
        const comments = await response.json();
        displayComments(comments);
    } catch (error) {
        console.error('Error loading comments:', error);
    }
}

function displayComments(comments) {
    const commentsContainer = document.getElementById('comments-container');
    if (!commentsContainer) return;
    
    if (comments.length === 0) {
        commentsContainer.innerHTML = '<p>No comments yet. Be the first to comment!</p>';
        return;
    }
    
    commentsContainer.innerHTML = comments.map(comment => `
        <div class="comment">
            <div class="comment-header">
                <span class="comment-author">${comment.userName}</span>
                <span class="comment-date">${formatDate(comment.createdAt)}</span>
            </div>
            <div class="comment-text">${comment.commentText}</div>
            ${comment.userName === getCurrentUser() ? `
                <div class="comment-actions">
                    <button class="btn btn-small btn-outline" onclick="editComment(${comment.id}, '${comment.commentText}')">Edit</button>
                    <button class="btn btn-small btn-danger" onclick="deleteComment(${comment.id})">Delete</button>
                </div>
            ` : ''}
        </div>
    `).join('');
}

async function addComment(blogId) {
    const commentText = document.getElementById('comment-text').value;
    const userName = getCurrentUser();
    
    if (!commentText.trim()) {
        showAlert('Please enter a comment', 'error');
        return;
    }
    
    try {
        const response = await fetch(`${API_BASE_URL}/blogs/${blogId}/comments`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ userName, commentText })
        });
        
        if (response.ok) {
            document.getElementById('comment-text').value = '';
            loadComments(blogId);
            showAlert('Comment added successfully');
        }
    } catch (error) {
        console.error('Error adding comment:', error);
        showAlert('Failed to add comment', 'error');
    }
}

async function deleteComment(commentId) {
    if (!confirm('Are you sure you want to delete this comment?')) return;
    
    try {
        const response = await fetch(`${API_BASE_URL}/blogs/comments/${commentId}`, {
            method: 'DELETE'
        });
        
        if (response.ok) {
            const urlParams = new URLSearchParams(window.location.search);
            loadComments(urlParams.get('id'));
            showAlert('Comment deleted successfully');
        }
    } catch (error) {
        console.error('Error deleting comment:', error);
        showAlert('Failed to delete comment', 'error');
    }
}

async function toggleLike(blogId, userName) {
    try {
        const response = await fetch(`${API_BASE_URL}/blogs/${blogId}/like`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ userName })
        });
        
        if (response.ok) {
            const result = await response.json();
            updateLikeButton(blogId, result.liked, result.likesCount);
        }
    } catch (error) {
        console.error('Error toggling like:', error);
    }
}

async function checkLikeStatus(blogId) {
    const userName = getCurrentUser();
    try {
        const response = await fetch(`${API_BASE_URL}/blogs/${blogId}/like-status?userName=${userName}`);
        if (response.ok) {
            const result = await response.json();
            updateLikeButton(blogId, result.liked);
        }
    } catch (error) {
        console.error('Error checking like status:', error);
    }
}

function updateLikeButton(blogId, isLiked, likesCount = null) {
    const likeBtn = document.querySelector(`.like-btn[onclick*="${blogId}"]`);
    if (likeBtn) {
        likeBtn.classList.toggle('liked', isLiked);
        if (likesCount !== null) {
            likeBtn.innerHTML = `❤️ ${likesCount}`;
        }
    }
}

// Trainer Functions
async function loadTrainers() {
    try {
        const response = await fetch(`${API_BASE_URL}/trainers`);
        const trainers = await response.json();
        displayTrainers(trainers);
    } catch (error) {
        console.error('Error loading trainers:', error);
        showAlert('Failed to load trainers', 'error');
    }
}

function displayTrainers(trainers) {
    const trainerList = document.getElementById('trainer-list');
    if (!trainerList) return;
    
    if (trainers.length === 0) {
        trainerList.innerHTML = '<p class="text-center">No trainers found.</p>';
        return;
    }
    
    trainerList.innerHTML = trainers.map(trainer => `
        <div class="trainer-card">
            ${trainer.matchScore ? `<span class="match-score">${trainer.matchScore}% Match</span>` : ''}
            <h3 class="trainer-name">${trainer.name}</h3>
            <div class="trainer-rating">
                ⭐ ${trainer.rating ? trainer.rating.toFixed(1) : 'N/A'}
                <span>(${trainer.experienceYears} years exp.)</span>
            </div>
            <div class="trainer-specializations">
                ${trainer.specializations.map(spec => `<span class="specialization-tag">${spec}</span>`).join('')}
            </div>
            <p>${trainer.profileSummary || 'No description available.'}</p>
            ${trainer.location ? `<p><strong>Location:</strong> ${trainer.location}</p>` : ''}
            <div class="mt-2">
                ${trainer.email ? `<a href="mailto:${trainer.email}" class="btn btn-primary btn-small">Contact</a>` : ''}
                ${trainer.phone ? `<a href="tel:${trainer.phone}" class="btn btn-secondary btn-small">Call</a>` : ''}
            </div>
        </div>
    `).join('');
}

async function findMatchingTrainers() {
    const userName = getCurrentUser();
    if (!userName) {
        showAlert('Please set your user name first', 'error');
        return;
    }
    
    try {
        const response = await fetch(`${API_BASE_URL}/trainers/match/${userName}`);
        if (!response.ok) throw new Error('Profile not found');
        
        const trainers = await response.json();
        displayTrainers(trainers);
        showAlert(`Found ${trainers.length} matching trainers!`);
    } catch (error) {
        console.error('Error finding trainers:', error);
        showAlert('Please create your fitness profile first', 'error');
    }
}

async function saveProfile() {
    const profile = {
        userName: document.getElementById('user-name').value,
        fitnessGoal: document.getElementById('fitness-goal').value,
        preferredWorkoutType: document.getElementById('workout-type').value,
        age: parseInt(document.getElementById('age').value),
        experienceLevel: document.getElementById('experience-level').value,
        preferredTrainingStyle: document.getElementById('training-style').value,
        location: document.getElementById('location').value
    };
    
    try {
        const response = await fetch(`${API_BASE_URL}/trainers/profiles`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(profile)
        });
        
        if (response.ok) {
            showAlert('Profile saved successfully!');
            setTimeout(() => window.location.href = 'trainer-matching.html', 2000);
        }
    } catch (error) {
        console.error('Error saving profile:', error);
        showAlert('Failed to save profile', 'error');
    }
}

// Blog Form Functions
async function saveBlog() {
    const urlParams = new URLSearchParams(window.location.search);
    const blogId = urlParams.get('id');
    
    const blog = {
        title: document.getElementById('blog-title').value,
        category: document.getElementById('blog-category').value,
        content: document.getElementById('blog-content').value,
        authorName: getCurrentUser(),
        authorType: 'USER',
        imageUrl: document.getElementById('blog-image-url').value,
        status: 'PUBLISHED'
    };
    
    try {
        const url = blogId ? `${API_BASE_URL}/blogs/${blogId}` : `${API_BASE_URL}/blogs`;
        const method = blogId ? 'PUT' : 'POST';
        
        const response = await fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(blog)
        });
        
        if (!response.ok) {
            const msg = await response.text();
            throw new Error(msg || `HTTP ${response.status}`);
        }
        
        showAlert(blogId ? 'Blog updated successfully!' : 'Blog created successfully!');
        setTimeout(() => window.location.href = 'blogs.html', 2000);
    } catch (error) {
        console.error('Error saving blog:', error);
        showAlert('Failed to save blog', 'error');
    }
}

async function loadBlogForEdit() {
    const urlParams = new URLSearchParams(window.location.search);
    const blogId = urlParams.get('id');
    
    if (!blogId) return;
    
    try {
        const response = await fetch(`${API_BASE_URL}/blogs/${blogId}`);
        if (response.ok) {
            const blog = await response.json();
            document.getElementById('blog-title').value = blog.title;
            document.getElementById('blog-category').value = blog.category;
            document.getElementById('blog-content').value = blog.content;
            document.getElementById('blog-image-url').value = blog.imageUrl || '';
        }
    } catch (error) {
        console.error('Error loading blog:', error);
    }
}

// User Management
function getCurrentUser() {
    let userName = localStorage.getItem('currentUser');
    if (!userName) {
        userName = prompt('Please enter your name:');
        if (userName) {
            localStorage.setItem('currentUser', userName);
        }
    }
    return userName || 'Guest';
}

function setCurrentUser() {
    const userName = prompt('Enter your name:');
    if (userName) {
        localStorage.setItem('currentUser', userName);
        showAlert('User name set successfully!');
        location.reload();
    }
}

// Initialize
document.addEventListener('DOMContentLoaded', function() {
    const currentUser = localStorage.getItem('currentUser');
    if (currentUser) {
        const userDisplay = document.getElementById('current-user');
        if (userDisplay) {
            userDisplay.textContent = currentUser;
        }
    }
});

