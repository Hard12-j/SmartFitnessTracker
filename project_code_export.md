# Project Folder Structure
```
.
├── .gitattributes
├── .gitignore
├── .mailmap
├── README.md
├── WellNest_Slides.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── healthTracker
    │   │           └── implementation
    │   │               ├── RegisterAndLoginWithSecurityApplication.java
    │   │               ├── config
    │   │               │   ├── CustomAuthenticationFailureHandler.java
    │   │               │   ├── SecurityConfig.java
    │   │               │   └── WebConfig.java
    │   │               ├── controller
    │   │               │   ├── AdminDashboardController.java
    │   │               │   ├── AuthController.java
    │   │               │   ├── BlogController.java
    │   │               │   ├── BlogViewController.java
    │   │               │   ├── BmiController.java
    │   │               │   ├── DailyLogController.java
    │   │               │   ├── GlobalControllerAdvice.java
    │   │               │   ├── MealController.java
    │   │               │   ├── TrainerDashboardController.java
    │   │               │   ├── TrainerMatchingController.java
    │   │               │   └── WorkoutController.java
    │   │               ├── dto
    │   │               │   ├── BlogCommentDTO.java
    │   │               │   ├── BlogDTO.java
    │   │               │   ├── PasswordResetDto.java
    │   │               │   └── UserDto.java
    │   │               ├── model
    │   │               │   ├── Blog.java
    │   │               │   ├── BlogComment.java
    │   │               │   ├── BlogLike.java
    │   │               │   ├── DailyLog.java
    │   │               │   ├── DietPlan.java
    │   │               │   ├── ExercisePlan.java
    │   │               │   ├── HealthTip.java
    │   │               │   ├── Meal.java
    │   │               │   ├── PasswordResetToken.java
    │   │               │   ├── User.java
    │   │               │   └── Workout.java
    │   │               ├── repository
    │   │               │   ├── BlogCommentRepository.java
    │   │               │   ├── BlogLikeRepository.java
    │   │               │   ├── BlogRepository.java
    │   │               │   ├── DailyLogRepository.java
    │   │               │   ├── DietPlanRepository.java
    │   │               │   ├── ExercisePlanRepository.java
    │   │               │   ├── MealRepository.java
    │   │               │   ├── PasswordResetTokenRepository.java
    │   │               │   ├── UserRepository.java
    │   │               │   └── WorkoutRepository.java
    │   │               └── service
    │   │                   ├── BlogService.java
    │   │                   ├── CustomUserDetails.java
    │   │                   ├── DailyLogService.java
    │   │                   ├── EmailService.java
    │   │                   ├── HealthTipService.java
    │   │                   ├── MealService.java
    │   │                   ├── PlanService.java
    │   │                   ├── TrainerService.java
    │   │                   ├── UserService.java
    │   │                   └── WorkoutService.java
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       │   ├── WellNest Smart Health & Fitness Companion.pdf
    │       │   ├── css
    │       │   │   └── style.css
    │       │   └── js
    │       └── templates
    │           ├── admin-dashboard.html
    │           ├── admin-stats.html
    │           ├── article-create.html
    │           ├── article-detail.html
    │           ├── article-edit.html
    │           ├── articles.html
    │           ├── assign-plan.html
    │           ├── bmi_calculator.html
    │           ├── community.html
    │           ├── daily-log.html
    │           ├── forgot_password.html
    │           ├── login.html
    │           ├── meal.html
    │           ├── profile.html
    │           ├── register.html
    │           ├── reset_password.html
    │           ├── trainer-dashboard.html
    │           ├── trainer-matching.html
    │           ├── user-analysis.html
    │           ├── verify_otp.html
    │           ├── welcome.html
    │           └── workout.html
    └── test
        └── java
            └── com
                ├── codeWithRaman
                └── healthTracker
                    └── implementation
                        └── RegisterAndLoginWithSecurityApplicationTests.java
```

# Code Files

## mvnw
```
#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup batch script, version 3.3.2
#
# Optional ENV vars
# -----------------
#   JAVA_HOME - location of a JDK home dir, required when download maven via java source
#   MVNW_REPOURL - repo url base for downloading maven distribution
#   MVNW_USERNAME/MVNW_PASSWORD - user and password for downloading maven
#   MVNW_VERBOSE - true: enable verbose log; debug: trace the mvnw script; others: silence the output
# ----------------------------------------------------------------------------

set -euf
[ "${MVNW_VERBOSE-}" != debug ] || set -x

# OS specific support.
native_path() { printf %s\\n "$1"; }
case "$(uname)" in
CYGWIN* | MINGW*)
  [ -z "${JAVA_HOME-}" ] || JAVA_HOME="$(cygpath --unix "$JAVA_HOME")"
  native_path() { cygpath --path --windows "$1"; }
  ;;
esac

# set JAVACMD and JAVACCMD
set_java_home() {
  # For Cygwin and MinGW, ensure paths are in Unix format before anything is touched
  if [ -n "${JAVA_HOME-}" ]; then
    if [ -x "$JAVA_HOME/jre/sh/java" ]; then
      # IBM's JDK on AIX uses strange locations for the executables
      JAVACMD="$JAVA_HOME/jre/sh/java"
      JAVACCMD="$JAVA_HOME/jre/sh/javac"
    else
      JAVACMD="$JAVA_HOME/bin/java"
      JAVACCMD="$JAVA_HOME/bin/javac"

      if [ ! -x "$JAVACMD" ] || [ ! -x "$JAVACCMD" ]; then
        echo "The JAVA_HOME environment variable is not defined correctly, so mvnw cannot run." >&2
        echo "JAVA_HOME is set to \"$JAVA_HOME\", but \"\$JAVA_HOME/bin/java\" or \"\$JAVA_HOME/bin/javac\" does not exist." >&2
        return 1
      fi
    fi
  else
    JAVACMD="$(
      'set' +e
      'unset' -f command 2>/dev/null
      'command' -v java
    )" || :
    JAVACCMD="$(
      'set' +e
      'unset' -f command 2>/dev/null
      'command' -v javac
    )" || :

    if [ ! -x "${JAVACMD-}" ] || [ ! -x "${JAVACCMD-}" ]; then
      echo "The java/javac command does not exist in PATH nor is JAVA_HOME set, so mvnw cannot run." >&2
      return 1
    fi
  fi
}

# hash string like Java String::hashCode
hash_string() {
  str="${1:-}" h=0
  while [ -n "$str" ]; do
    char="${str%"${str#?}"}"
    h=$(((h * 31 + $(LC_CTYPE=C printf %d "'$char")) % 4294967296))
    str="${str#?}"
  done
  printf %x\\n $h
}

verbose() { :; }
[ "${MVNW_VERBOSE-}" != true ] || verbose() { printf %s\\n "${1-}"; }

die() {
  printf %s\\n "$1" >&2
  exit 1
}

trim() {
  # MWRAPPER-139:
  #   Trims trailing and leading whitespace, carriage returns, tabs, and linefeeds.
  #   Needed for removing poorly interpreted newline sequences when running in more
  #   exotic environments such as mingw bash on Windows.
  printf "%s" "${1}" | tr -d '[:space:]'
}

# parse distributionUrl and optional distributionSha256Sum, requires .mvn/wrapper/maven-wrapper.properties
while IFS="=" read -r key value; do
  case "${key-}" in
  distributionUrl) distributionUrl=$(trim "${value-}") ;;
  distributionSha256Sum) distributionSha256Sum=$(trim "${value-}") ;;
  esac
done <"${0%/*}/.mvn/wrapper/maven-wrapper.properties"
[ -n "${distributionUrl-}" ] || die "cannot read distributionUrl property in ${0%/*}/.mvn/wrapper/maven-wrapper.properties"

case "${distributionUrl##*/}" in
maven-mvnd-*bin.*)
  MVN_CMD=mvnd.sh _MVNW_REPO_PATTERN=/maven/mvnd/
  case "${PROCESSOR_ARCHITECTURE-}${PROCESSOR_ARCHITEW6432-}:$(uname -a)" in
  *AMD64:CYGWIN* | *AMD64:MINGW*) distributionPlatform=windows-amd64 ;;
  :Darwin*x86_64) distributionPlatform=darwin-amd64 ;;
  :Darwin*arm64) distributionPlatform=darwin-aarch64 ;;
  :Linux*x86_64*) distributionPlatform=linux-amd64 ;;
  *)
    echo "Cannot detect native platform for mvnd on $(uname)-$(uname -m), use pure java version" >&2
    distributionPlatform=linux-amd64
    ;;
  esac
  distributionUrl="${distributionUrl%-bin.*}-$distributionPlatform.zip"
  ;;
maven-mvnd-*) MVN_CMD=mvnd.sh _MVNW_REPO_PATTERN=/maven/mvnd/ ;;
*) MVN_CMD="mvn${0##*/mvnw}" _MVNW_REPO_PATTERN=/org/apache/maven/ ;;
esac

# apply MVNW_REPOURL and calculate MAVEN_HOME
# maven home pattern: ~/.m2/wrapper/dists/{apache-maven-<version>,maven-mvnd-<version>-<platform>}/<hash>
[ -z "${MVNW_REPOURL-}" ] || distributionUrl="$MVNW_REPOURL$_MVNW_REPO_PATTERN${distributionUrl#*"$_MVNW_REPO_PATTERN"}"
distributionUrlName="${distributionUrl##*/}"
distributionUrlNameMain="${distributionUrlName%.*}"
distributionUrlNameMain="${distributionUrlNameMain%-bin}"
MAVEN_USER_HOME="${MAVEN_USER_HOME:-${HOME}/.m2}"
MAVEN_HOME="${MAVEN_USER_HOME}/wrapper/dists/${distributionUrlNameMain-}/$(hash_string "$distributionUrl")"

exec_maven() {
  unset MVNW_VERBOSE MVNW_USERNAME MVNW_PASSWORD MVNW_REPOURL || :
  exec "$MAVEN_HOME/bin/$MVN_CMD" "$@" || die "cannot exec $MAVEN_HOME/bin/$MVN_CMD"
}

if [ -d "$MAVEN_HOME" ]; then
  verbose "found existing MAVEN_HOME at $MAVEN_HOME"
  exec_maven "$@"
fi

case "${distributionUrl-}" in
*?-bin.zip | *?maven-mvnd-?*-?*.zip) ;;
*) die "distributionUrl is not valid, must match *-bin.zip or maven-mvnd-*.zip, but found '${distributionUrl-}'" ;;
esac

# prepare tmp dir
if TMP_DOWNLOAD_DIR="$(mktemp -d)" && [ -d "$TMP_DOWNLOAD_DIR" ]; then
  clean() { rm -rf -- "$TMP_DOWNLOAD_DIR"; }
  trap clean HUP INT TERM EXIT
else
  die "cannot create temp dir"
fi

mkdir -p -- "${MAVEN_HOME%/*}"

# Download and Install Apache Maven
verbose "Couldn't find MAVEN_HOME, downloading and installing it ..."
verbose "Downloading from: $distributionUrl"
verbose "Downloading to: $TMP_DOWNLOAD_DIR/$distributionUrlName"

# select .zip or .tar.gz
if ! command -v unzip >/dev/null; then
  distributionUrl="${distributionUrl%.zip}.tar.gz"
  distributionUrlName="${distributionUrl##*/}"
fi

# verbose opt
__MVNW_QUIET_WGET=--quiet __MVNW_QUIET_CURL=--silent __MVNW_QUIET_UNZIP=-q __MVNW_QUIET_TAR=''
[ "${MVNW_VERBOSE-}" != true ] || __MVNW_QUIET_WGET='' __MVNW_QUIET_CURL='' __MVNW_QUIET_UNZIP='' __MVNW_QUIET_TAR=v

# normalize http auth
case "${MVNW_PASSWORD:+has-password}" in
'') MVNW_USERNAME='' MVNW_PASSWORD='' ;;
has-password) [ -n "${MVNW_USERNAME-}" ] || MVNW_USERNAME='' MVNW_PASSWORD='' ;;
esac

if [ -z "${MVNW_USERNAME-}" ] && command -v wget >/dev/null; then
  verbose "Found wget ... using wget"
  wget ${__MVNW_QUIET_WGET:+"$__MVNW_QUIET_WGET"} "$distributionUrl" -O "$TMP_DOWNLOAD_DIR/$distributionUrlName" || die "wget: Failed to fetch $distributionUrl"
elif [ -z "${MVNW_USERNAME-}" ] && command -v curl >/dev/null; then
  verbose "Found curl ... using curl"
  curl ${__MVNW_QUIET_CURL:+"$__MVNW_QUIET_CURL"} -f -L -o "$TMP_DOWNLOAD_DIR/$distributionUrlName" "$distributionUrl" || die "curl: Failed to fetch $distributionUrl"
elif set_java_home; then
  verbose "Falling back to use Java to download"
  javaSource="$TMP_DOWNLOAD_DIR/Downloader.java"
  targetZip="$TMP_DOWNLOAD_DIR/$distributionUrlName"
  cat >"$javaSource" <<-END
	public class Downloader extends java.net.Authenticator
	{
	  protected java.net.PasswordAuthentication getPasswordAuthentication()
	  {
	    return new java.net.PasswordAuthentication( System.getenv( "MVNW_USERNAME" ), System.getenv( "MVNW_PASSWORD" ).toCharArray() );
	  }
	  public static void main( String[] args ) throws Exception
	  {
	    setDefault( new Downloader() );
	    java.nio.file.Files.copy( java.net.URI.create( args[0] ).toURL().openStream(), java.nio.file.Paths.get( args[1] ).toAbsolutePath().normalize() );
	  }
	}
	END
  # For Cygwin/MinGW, switch paths to Windows format before running javac and java
  verbose " - Compiling Downloader.java ..."
  "$(native_path "$JAVACCMD")" "$(native_path "$javaSource")" || die "Failed to compile Downloader.java"
  verbose " - Running Downloader.java ..."
  "$(native_path "$JAVACMD")" -cp "$(native_path "$TMP_DOWNLOAD_DIR")" Downloader "$distributionUrl" "$(native_path "$targetZip")"
fi

# If specified, validate the SHA-256 sum of the Maven distribution zip file
if [ -n "${distributionSha256Sum-}" ]; then
  distributionSha256Result=false
  if [ "$MVN_CMD" = mvnd.sh ]; then
    echo "Checksum validation is not supported for maven-mvnd." >&2
    echo "Please disable validation by removing 'distributionSha256Sum' from your maven-wrapper.properties." >&2
    exit 1
  elif command -v sha256sum >/dev/null; then
    if echo "$distributionSha256Sum  $TMP_DOWNLOAD_DIR/$distributionUrlName" | sha256sum -c >/dev/null 2>&1; then
      distributionSha256Result=true
    fi
  elif command -v shasum >/dev/null; then
    if echo "$distributionSha256Sum  $TMP_DOWNLOAD_DIR/$distributionUrlName" | shasum -a 256 -c >/dev/null 2>&1; then
      distributionSha256Result=true
    fi
  else
    echo "Checksum validation was requested but neither 'sha256sum' or 'shasum' are available." >&2
    echo "Please install either command, or disable validation by removing 'distributionSha256Sum' from your maven-wrapper.properties." >&2
    exit 1
  fi
  if [ $distributionSha256Result = false ]; then
    echo "Error: Failed to validate Maven distribution SHA-256, your Maven distribution might be compromised." >&2
    echo "If you updated your Maven version, you need to update the specified distributionSha256Sum property." >&2
    exit 1
  fi
fi

# unzip and move
if command -v unzip >/dev/null; then
  unzip ${__MVNW_QUIET_UNZIP:+"$__MVNW_QUIET_UNZIP"} "$TMP_DOWNLOAD_DIR/$distributionUrlName" -d "$TMP_DOWNLOAD_DIR" || die "failed to unzip"
else
  tar xzf${__MVNW_QUIET_TAR:+"$__MVNW_QUIET_TAR"} "$TMP_DOWNLOAD_DIR/$distributionUrlName" -C "$TMP_DOWNLOAD_DIR" || die "failed to untar"
fi
printf %s\\n "$distributionUrl" >"$TMP_DOWNLOAD_DIR/$distributionUrlNameMain/mvnw.url"
mv -- "$TMP_DOWNLOAD_DIR/$distributionUrlNameMain" "$MAVEN_HOME" || [ -d "$MAVEN_HOME" ] || die "fail to move MAVEN_HOME"

clean || :
exec_maven "$@"

```

## pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.healthTracker.implementation</groupId>
	<artifactId>SmartHealthTracker</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>RegisterAndLoginWithSecurity</name>
	<description>Demo project for Spring Boot</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>21</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>

        <!-- https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api -->
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
            <version>3.1.1</version>
        </dependency>

        <!-- Validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-springsecurity6</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>

        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.42</version>
        </dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>8</source>
                    <target>8</target>
                </configuration>
            </plugin>
        </plugins>
	</build>

</project>

```

## README.md
```md
# Smart Health Tracker - Wellnest
 Easisest and only important code to develop a login and registeration aplication 

```

## WellNest_Slides.md
```md
# Slide-by-Slide Content for WellNest Presentation

### Slide 1: Title Slide
- **Main Heading**: WellNest: Smart Health & Fitness Companion
- **Sub Heading**: Internship Project Presentation - [Your Name]
- **Details**:
    - Under the Mentorship of: [Mentor Name]
    - Internship Period: [Start Date] to [End Date]
    - Technology: Java Full-Stack Development

### Slide 2: Introduction
- **Overview**: WellNest is a comprehensive health management platform designed to simplify the journey toward a healthier lifestyle.
- **Key Proposition**: By integrating tracking, analytics, and professional guidance into one ecosystem, it eliminates the need for multiple disconnected apps.
- **Vision**: To empower individuals with data-driven insights and bridge the gap between users and fitness professionals.

### Slide 3: Problem Statement
- **Fragmented Tracking**: Users often use different apps for calories, workouts, and sleep, leading to a disconnected view of health.
- **Lack of Consistency**: Without visual progress and professional feedback, many users abandon their fitness goals early.
- **Limited Access to Experts**: Finding a personal trainer tailored to specific goals can be challenging and opaque.

### Slide 4: Project Objectives & Outcomes
- **Holistic Monitoring**: Provide tools for daily tracking of nutrition, activity, hydration, and sleep.
- **Intelligent Analytics**: Use data visualization to show trends and identify areas for improvement.
- **Role-Based Interaction**: Enable a secondary portal for trainers to monitor and guide their clients.
- **Community Engagement**: Foster a social environment through fitness blogging.

### Slide 5: Technology Stack - Backend
- **Framework**: Spring Boot 3.3.4 (Rapid Development, Embedded Server).
- **Security**: Spring Security (Authentication, Role-Based Access Control).
- **Data Access**: Spring Data JPA with Hibernate (Object-Relational Mapping).
- **Build System**: Maven (Dependency Management).
- **Language**: Java 21.

### Slide 6: Technology Stack - Frontend
- **Templating Engine**: Thymeleaf (Server-side rendering, seamless Spring integration).
- **Styling**: Vanilla CSS3 (Custom design system, Responsive layouts).
- **Visualizations**: Chart.js (Interactive line, bar, and doughnut charts).
- **Icons**: Bootstrap Icons / FontAwesome.

### Slide 7: Database Management
- **Primary Database**: MySQL.
- **Persistence Strategy**:
    - JPA Entities for User, Workout, Meal, Blog, etc.
    - Relational integrity with Foreign Key constraints.
    - Optimized queries for historical data retrieval.

### Slide 8: Module 1: Authentication
- **Secure Onboarding**: Implementation of a robust registration and login system.
- **JWT-ready logic**: Prepared for token-based authentication (if scaled to mobile).
- **Role Control**: Distinguishes between 'ROLE_USER' and 'ROLE_TRAINER' to serve different dashboards and permissions.

### Slide 9: Fitness Profile Setup
- **Personalized Data**: Users input Age, Height, Current Weight, and Target Weight.
- **Goal Definition**: Choice of fitness path (Muscle Gain, Fat Loss, General Fitness).
- **Customized Experience**: The application uses these inputs to calculate goals and display relevant health tips.

### Slide 10: Module 2: Workout Tracking
- **Detail Logging**: Track exercise name, type (Cardio/Strength), duration, and output.
- **Calorie Estimation**: Logical calculation of calories burned based on workout intensity.
- **Historical View**: Access to past workout sessions to track strength and endurance gains.

### Slide 11: Nutrition & Habits
- **Meal Logger**: Organize intake by Breakfast, Lunch, Dinner, and Snacks.
- **Hydration Tracking**: Monitor daily water intake against a target (e.g., 3-4 liters).
- **Sleep Log**: Track sleep duration to analyze the correlation between rest and performance.

### Slide 12: Module 3: BMI Integration
- **Body Mass Index (BMI)**: An integrated tool using profile data (Height/Weight).
- **Categorization**: Instantly labels status as Underweight, Normal, Overweight, or Obese.
- **Health Guidance**: Provides immediate advice based on the calculated BMI category.

### Slide 13: Daily Health Tips API
- **Dynamic Content**: Fetches a "Tip of the Day" using an internal service or external API.
- **Varied Categories**: Covers Nutrition, Hydration, Mental Wellness, and Physical Activity.
- **UI Integration**: Featured prominently on the dashboard to provide daily value.

### Slide 14: Module 4: Analytics Dashboard
- **Visual Trends**: Charts showing "Weekly Workout Frequency vs. Duration".
- **Comparative Analysis**: Graphs for "Calories Consumed vs. Calories Burned".
- **Pattern Recognition**: Overlays Water intake and Sleep patterns to find health correlations.

### Slide 15: Goal Progress Monitoring
- **Visual Indicators**: Color-coded progress bars (Green for on-track, Yellow/Red for behind).
- **Actionable Insights**: Specific advice appearing when goals are not met (e.g., "Consider a 15-min walk").
- **Real-time Updates**: Progress recalculates instantly upon logging new activity.

### Slide 16: Module 5: Health Blog
- **Expert Articles**: Admins and Trainers can post authoritative fitness content.
- **Community Interaction**: Users can like and comment on posts to share experiences.
- **Dynamic Templating**: Clean, card-based UI for browsing health topics.

### Slide 17: Smart Trainer Matching
- **Goal-Based Algorithm**: Recommends trainers whose specialization matches the user's fitness goal.
- **Trainer Dashboard**: Dedicated view for trainers to see their matched students and assign plans.
- **Direct Guidance**: One-way plan assignment (Exercises/Diet) from Trainer to User dashboard.

### Slide 18: System Architecture
- **Layered Design**:
    - Controller: Handles HTTP requests and routing.
    - Service: Contains core business logic (BMI calc, Matching logic).
    - Repository: Manages Database interation.
    - Model/Entity: Defines the state and relationship of data objects.

### Slide 19: Database Schema
- **Entity Relationships**:
    - User (1) to (N) Workouts/Meals/Logs.
    - User (1) to (N) Blog Likes/Comments.
    - Trainer (N) to (M) Students via Matches.
- **Schema Efficiency**: Normalization to minimize redundancy while ensuring fast lookups.

### Slide 20: Conclusion & Future Scope
- **Internship Impact**: Hands-on experience with Spring Boot, Security, and complex Frontend visualizations.
- **Upcoming Features**:
    - Integration with Smart Watches (IoT).
    - AI-based personalized meal planning.
    - Real-time chat between trainers and users.
- **Closing**: Thank you for your guidance. Any questions?

```

## src\main\java\com\healthTracker\implementation\RegisterAndLoginWithSecurityApplication.java
```java
package com.healthTracker.implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegisterAndLoginWithSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterAndLoginWithSecurityApplication.class, args);
	}

}

```

## src\main\java\com\healthTracker\implementation\config\CustomAuthenticationFailureHandler.java
```java
package com.healthTracker.implementation.config;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        if (exception instanceof UsernameNotFoundException) {
            setDefaultFailureUrl("/login?error=email");
        } else if (exception instanceof BadCredentialsException) {
            setDefaultFailureUrl("/login?error=password");
        } else {
            setDefaultFailureUrl("/login?error");
        }

        super.onAuthenticationFailure(request, response, exception);
    }
}

```

## src\main\java\com\healthTracker\implementation\config\SecurityConfig.java
```java
package com.healthTracker.implementation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.healthTracker.implementation.service.CustomUserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final CustomUserDetails customUserDetails;

	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

	public SecurityConfig(CustomUserDetails customUserDetails) {
		this.customUserDetails = customUserDetails;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customUserDetails);
		provider.setPasswordEncoder(passwordEncoder());
		provider.setHideUserNotFoundExceptions(false);
		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(request -> request
						.requestMatchers("/register", "/login", "/forgot-password", "/reset-password", "/verify-otp",
								"/uploads/**", "/css/**", "/js/**", "/images/**")
						.permitAll()
						.requestMatchers("/welcome", "/profile", "/update-profile", "/update-goals", "/articles/**",
								"/api/blogs/**")
						.hasAnyRole("USER", "TRAINER", "ADMIN")
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/trainer/**").hasAnyRole("TRAINER", "ADMIN")
						.requestMatchers("/workouts/**", "/meals/**", "/daily-logs/**", "/bmi/**", "/calculate-bmi/**",
								"/trainer-matching/**", "/api/trainers/match/**", "/api/trainers/book")
						.hasRole("USER")
						.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
						.failureHandler(customAuthenticationFailureHandler).defaultSuccessUrl("/welcome", true)
						.permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/login").permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

```

## src\main\java\com\healthTracker\implementation\config\WebConfig.java
```java
package com.healthTracker.implementation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("uploads", registry);
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        if (dirName.startsWith("../"))
            dirName = dirName.replace("../", "");

        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\AdminDashboardController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.DailyLogService;
import com.healthTracker.implementation.service.MealService;
import com.healthTracker.implementation.service.UserService;
import com.healthTracker.implementation.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private MealService mealService;

    @Autowired
    private DailyLogService dailyLogService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model, Principal principal) {
        List<User> allUsers = userService.getAllUsers();

        List<User> regularUsers = allUsers.stream()
                .filter(u -> "USER".equalsIgnoreCase(u.getRole()))
                .collect(Collectors.toList());

        List<User> trainers = allUsers.stream()
                .filter(u -> "TRAINER".equalsIgnoreCase(u.getRole()))
                .collect(Collectors.toList());

        model.addAttribute("users", regularUsers);
        model.addAttribute("trainers", trainers);
        model.addAttribute("adminName", principal.getName());
        return "admin-dashboard";
    }

    @PostMapping("/verify-user/{id}")
    public String verifyUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setVerifiedUser(true);
            userService.updateUser(user);
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/unverify-user/{id}")
    public String unverifyUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setVerifiedUser(false);
            userService.updateUser(user);
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/verify-trainer/{id}")
    public String verifyTrainer(@PathVariable Long id) {
        userService.verifyTrainer(id);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/unverify-trainer/{id}")
    public String unverifyTrainer(@PathVariable Long id) {
        userService.unverifyTrainer(id);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/stats/{id}")
    public String viewStats(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("targetUser", user);

        // Fetch stats for the user
        model.addAttribute("workouts", workoutService.findWorkoutsByUser(user));
        model.addAttribute("meals", mealService.findMealsByUser(user));
        model.addAttribute("logs", dailyLogService.findDailyLogsByUser(user));

        return "admin-stats";
    }

    @GetMapping("/api/user-details/{id}")
    @ResponseBody
    public java.util.Map<String, Object> getUserDetails(@PathVariable Long id) {
        User user = userService.getUserById(id);
        java.util.Map<String, Object> response = new java.util.HashMap<>();
        if (user != null) {
            response.put("user", user);
            response.put("workouts", workoutService.findWorkoutsByUser(user));
            response.put("meals", mealService.findMealsByUser(user));
            response.put("logs", dailyLogService.findDailyLogsByUser(user));

            if (user.getAssignedTrainerId() != null) {
                User trainer = userService.getUserById(user.getAssignedTrainerId());
                if (trainer != null) {
                    response.put("trainerName", trainer.getFirst() + " " + trainer.getLast());
                }
            }
        }
        return response;
    }

    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/dashboard";
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\AuthController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.dto.UserDto;
import com.healthTracker.implementation.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.healthTracker.implementation.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserDto userDto,
            org.springframework.validation.BindingResult result,
            Model model,
            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        System.out.println(userDto.getPassword().equals(userDto.getCnfPassword()));

        if (result.hasErrors()) {
            return "register";
        }

        if (!userDto.getPassword().equals(userDto.getCnfPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            return "register";
        }

        try {
            User user = new User();
            user.setFirst(userDto.getFirst());
            user.setLast(userDto.getLast());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setRole(userDto.getRole());

            // Set trainer fields
            user.setSpecialization(userDto.getSpecialization());
            user.setExperience(userDto.getExperience());
            user.setTrainerLocation(userDto.getTrainerLocation());
            user.setAvailability(userDto.getAvailability());
            user.setContactNo(userDto.getContactNo());

            userService.registerUser(user);
            System.out.println("successfully registered");
            redirectAttributes.addFlashAttribute("success", "User registered successfully!");
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("Passwords do not match!");
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private com.healthTracker.implementation.service.HealthTipService healthTipService;

    @Autowired
    private com.healthTracker.implementation.service.DailyLogService dailyLogService;
    @Autowired
    private com.healthTracker.implementation.service.WorkoutService workoutService;
    @Autowired
    private com.healthTracker.implementation.service.MealService mealService;
    @Autowired
    private com.healthTracker.implementation.service.PlanService planService;

    @GetMapping("/welcome")
    public String welcome(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userService.getUserByUsername(principal.getName());

        if ("TRAINER".equalsIgnoreCase(user.getRole())) {
            return "redirect:/trainer/dashboard";
        }
        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin/dashboard";
        }

        // Today's Date
        java.time.LocalDate today = java.time.LocalDate.now();

        // Fetch Data
        List<com.healthTracker.implementation.model.Meal> meals = mealService.findMealsByUser(user);
        List<com.healthTracker.implementation.model.Workout> workouts = workoutService.findWorkoutsByUser(user);
        List<com.healthTracker.implementation.model.DailyLog> logs = dailyLogService.findDailyLogsByUser(user);

        // Calculate Today's Summary
        int caloriesEaten = meals.stream()
                .filter(m -> m.getDate().equals(today))
                .mapToInt(com.healthTracker.implementation.model.Meal::getCalories)
                .sum();

        int caloriesBurned = workouts.stream()
                .filter(w -> w.getDate().equals(today))
                .mapToInt(com.healthTracker.implementation.model.Workout::getCalories)
                .sum();

        int steps = logs.stream()
                .filter(l -> l.getDate().equals(today))
                .mapToInt(com.healthTracker.implementation.model.DailyLog::getSteps)
                .sum();

        double sleep = logs.stream()
                .filter(l -> l.getDate().equals(today))
                .mapToDouble(com.healthTracker.implementation.model.DailyLog::getSleepDuration)
                .sum();

        double waterIntake = logs.stream()
                .filter(l -> l.getDate().equals(today))
                .mapToDouble(com.healthTracker.implementation.model.DailyLog::getWaterIntake)
                .sum();

        model.addAttribute("caloriesEaten", caloriesEaten);
        model.addAttribute("caloriesBurned", caloriesBurned);
        model.addAttribute("steps", steps);
        model.addAttribute("sleep", sleep);
        model.addAttribute("waterIntake", waterIntake);

        // Calculate Weekly Summary (Last 7 days)
        java.util.List<String> datesHistory = new java.util.ArrayList<>();
        java.util.List<Integer> caloriesEatenHistory = new java.util.ArrayList<>();
        java.util.List<Integer> caloriesBurnedHistory = new java.util.ArrayList<>();
        java.util.List<Integer> stepsHistory = new java.util.ArrayList<>();
        java.util.List<Long> workoutFrequencyHistory = new java.util.ArrayList<>();
        java.util.List<Integer> workoutDurationHistory = new java.util.ArrayList<>();
        java.util.List<Double> waterIntakeHistory = new java.util.ArrayList<>();
        java.util.List<Double> sleepHistory = new java.util.ArrayList<>();

        java.util.Map<String, java.util.List<Integer>> workoutDataByType = new java.util.HashMap<>();

        for (int i = 6; i >= 0; i--) {
            java.time.LocalDate date = today.minusDays(i);
            datesHistory.add(date.format(java.time.format.DateTimeFormatter.ofPattern("MMM dd")));

            int dailyCalEaten = meals.stream()
                    .filter(m -> m.getDate().equals(date))
                    .mapToInt(com.healthTracker.implementation.model.Meal::getCalories)
                    .sum();
            caloriesEatenHistory.add(dailyCalEaten);

            int dailyCalBurned = workouts.stream()
                    .filter(w -> w.getDate().equals(date))
                    .mapToInt(com.healthTracker.implementation.model.Workout::getCalories)
                    .sum();
            caloriesBurnedHistory.add(dailyCalBurned);

            int dailySteps = logs.stream()
                    .filter(l -> l.getDate().equals(date))
                    .mapToInt(com.healthTracker.implementation.model.DailyLog::getSteps)
                    .sum();
            stepsHistory.add(dailySteps);

            // Fetch and Group Workouts by Type for this date
            java.util.List<com.healthTracker.implementation.model.Workout> dailyWorkouts = workouts.stream()
                    .filter(w -> w.getDate().equals(date))
                    .collect(java.util.stream.Collectors.toList());

            // Track unique types across all days to ensure data lists are full
            java.util.Set<String> allTypes = workouts.stream()
                    .filter(w -> w.getDate().isAfter(today.minusDays(7)) || w.getDate().equals(today.minusDays(7)))
                    .map(com.healthTracker.implementation.model.Workout::getType)
                    .filter(java.util.Objects::nonNull)
                    .collect(java.util.stream.Collectors.toSet());

            for (String type : allTypes) {
                int durationForType = dailyWorkouts.stream()
                        .filter(w -> type.equals(w.getType()))
                        .mapToInt(com.healthTracker.implementation.model.Workout::getDuration)
                        .sum();
                workoutDataByType.computeIfAbsent(type, k -> new java.util.ArrayList<>()).add(durationForType);
            }

            double dailyWater = logs.stream()
                    .filter(l -> l.getDate().equals(date))
                    .mapToDouble(com.healthTracker.implementation.model.DailyLog::getWaterIntake)
                    .sum();
            waterIntakeHistory.add(dailyWater);

            double dailySleep = logs.stream()
                    .filter(l -> l.getDate().equals(date))
                    .mapToDouble(com.healthTracker.implementation.model.DailyLog::getSleepDuration)
                    .sum();
            sleepHistory.add(dailySleep);
        }

        model.addAttribute("datesHistory", datesHistory);
        model.addAttribute("caloriesEatenHistory", caloriesEatenHistory);
        model.addAttribute("caloriesBurnedHistory", caloriesBurnedHistory);
        model.addAttribute("stepsHistory", stepsHistory);
        model.addAttribute("workoutDataByType", workoutDataByType);
        model.addAttribute("waterIntakeHistory", waterIntakeHistory);
        model.addAttribute("sleepHistory", sleepHistory);

        // Goal Tracking
        Integer dailyStepGoal = user.getDailyStepGoal() != null ? user.getDailyStepGoal() : 10000;
        Integer weeklyWorkoutGoal = user.getWeeklyWorkoutGoal() != null ? user.getWeeklyWorkoutGoal() : 5;
        Double weightGoal = user.getWeightGoal() != null ? user.getWeightGoal() : 70.0;
        Double waterIntakeGoal = user.getWaterIntakeGoal() != null ? user.getWaterIntakeGoal() : 3.0;

        double currentWeight = 0;
        try {
            if (user.getWeight() != null && !user.getWeight().isEmpty()) {
                currentWeight = Double.parseDouble(user.getWeight());
            }
        } catch (Exception e) {
            currentWeight = 0;
        }

        // Calculate Workouts in Last 7 Days (Unique Days)
        long weeklyWorkoutsCompleted = workouts.stream()
                .filter(w -> w.getDate().isAfter(today.minusDays(7)) || w.getDate().equals(today.minusDays(7)))
                .map(com.healthTracker.implementation.model.Workout::getDate)
                .distinct()
                .count();

        model.addAttribute("dailyStepGoal", dailyStepGoal);
        model.addAttribute("weeklyWorkoutGoal", weeklyWorkoutGoal);
        model.addAttribute("weeklyWorkoutsCompleted", weeklyWorkoutsCompleted);
        model.addAttribute("weightGoal", weightGoal);
        model.addAttribute("currentWeight", currentWeight);
        model.addAttribute("waterIntakeGoal", waterIntakeGoal);
        model.addAttribute("user", user);

        // Assigned Plans
        model.addAttribute("assignedDiet", planService.getDietPlansForUser(user.getId()));
        model.addAttribute("assignedExercises", planService.getExercisePlansForUser(user.getId()));

        model.addAttribute("healthTip", healthTipService.getDailyTip());
        return "welcome";
    }

    @GetMapping("profile")
    public String profile() {
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute User user,
            @org.springframework.web.bind.annotation.RequestParam("profileImage") org.springframework.web.multipart.MultipartFile profileImage) {
        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                String fileName = user.getId() + "_" + profileImage.getOriginalFilename();
                java.nio.file.Path uploadPath = java.nio.file.Paths.get("uploads/profile_images");
                if (!java.nio.file.Files.exists(uploadPath)) {
                    java.nio.file.Files.createDirectories(uploadPath);
                }

                try (java.io.InputStream inputStream = profileImage.getInputStream()) {
                    java.nio.file.Path filePath = uploadPath.resolve(fileName);
                    java.nio.file.Files.copy(inputStream, filePath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                    user.setProfileImageUrl("/uploads/profile_images/" + fileName);
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        userService.updateUserProfile(user);
        return "redirect:/profile";
    }

    @PostMapping("/update-goals")
    public String updateGoals(@ModelAttribute User user) {
        // We reuse updateUserProfile as it only updates non-null fields
        userService.updateUserProfile(user);
        return "redirect:/welcome";
    }

    @Autowired
    private com.healthTracker.implementation.service.EmailService emailService;

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot_password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(jakarta.servlet.http.HttpServletRequest request, Model model,
            @org.springframework.web.bind.annotation.RequestParam("email") String userEmail,
            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        User user = userService.getUserByUsername(userEmail);
        if (user == null) {
            model.addAttribute("error", "We didn't find an account for that e-mail address.");
            return "forgot_password";
        }

        try {
            String otp = userService.createPasswordResetTokenForUser(user);

            emailService.sendEmail(user.getUsername(), "Reset Password OTP",
                    "Your One-Time Password (OTP) for password reset is: " + otp + "\nThis OTP is valid for 1 hour.");
            redirectAttributes.addFlashAttribute("message",
                    "We have sent an OTP to your email. Please enter it below.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error processing request: " + e.getMessage());
            return "forgot_password";
        }

        return "redirect:/verify-otp";
    }

    @GetMapping("/verify-otp")
    public String showVerifyOtpForm() {
        return "verify_otp";
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@org.springframework.web.bind.annotation.RequestParam("otp") String otp, Model model,
            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        String validationResult = userService.validatePasswordResetToken(otp);
        if (validationResult != null) {
            model.addAttribute("error", "Invalid or expired OTP.");
            return "verify_otp";
        }
        return "redirect:/reset-password?token=" + otp;
    }

    @GetMapping("/reset-password")
    public String showResetPasswordForm(@org.springframework.web.bind.annotation.RequestParam("token") String token,
            Model model) {
        String result = userService.validatePasswordResetToken(token);
        if (result != null) {
            model.addAttribute("error", "Invalid or expired token. Please request a new password reset.");
            return "reset_password"; // Show error on the page instead of redirecting to login
        }
        com.healthTracker.implementation.dto.PasswordResetDto passwordResetDto = new com.healthTracker.implementation.dto.PasswordResetDto();
        passwordResetDto.setToken(token);
        model.addAttribute("passwordResetDto", passwordResetDto);
        return "reset_password";
    }

    @PostMapping("/reset-password")
    public String processResetPassword(
            @Valid @ModelAttribute("passwordResetDto") com.healthTracker.implementation.dto.PasswordResetDto passwordResetDto,
            org.springframework.validation.BindingResult result,
            Model model,
            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "reset_password";
        }

        if (!passwordResetDto.getPassword().equals(passwordResetDto.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            return "reset_password";
        }

        String token = passwordResetDto.getToken();
        String validationResult = userService.validatePasswordResetToken(token);
        if (validationResult != null) {
            model.addAttribute("error", "Invalid or expired token.");
            return "redirect:/login";
        }

        User user = userService.getUserByPasswordResetToken(token);
        if (user != null) {
            userService.changeUserPassword(user, passwordResetDto.getPassword());
            redirectAttributes.addFlashAttribute("success", "Password reset successfully! You can now login.");
            return "redirect:/login";
        } else {
            model.addAttribute("error", "User not found.");
            return "reset_password";
        }
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\BlogController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.dto.BlogDTO;
import com.healthTracker.implementation.dto.BlogCommentDTO;
import com.healthTracker.implementation.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private com.healthTracker.implementation.service.UserService userService;

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getAllBlogs(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String contentType,
            @RequestParam(required = false) String authorType) {
        List<BlogDTO> blogs;
        if (authorType != null && !authorType.isEmpty()) {
            blogs = blogService.getBlogsByAuthorType(authorType);
            if (category != null && !category.isEmpty()) {
                blogs = blogs.stream().filter(b -> category.equalsIgnoreCase(b.getCategory()))
                        .collect(java.util.stream.Collectors.toList());
            }
            if (contentType != null && !contentType.isEmpty()) {
                blogs = blogs.stream().filter(b -> contentType.equalsIgnoreCase(b.getContentType()))
                        .collect(java.util.stream.Collectors.toList());
            }
        } else if (contentType != null && !contentType.isEmpty()) {
            blogs = blogService.getBlogsByContentType(contentType);
            if (category != null && !category.isEmpty()) {
                blogs = blogs.stream().filter(b -> category.equalsIgnoreCase(b.getCategory()))
                        .collect(java.util.stream.Collectors.toList());
            }
        } else if (category != null && !category.isEmpty()) {
            blogs = blogService.getBlogsByCategory(category);
        } else {
            blogs = blogService.getAllBlogs();
        }
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Long id) {
        try {
            BlogDTO blog = blogService.getBlogById(id);
            return ResponseEntity.ok(blog);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<BlogDTO> createBlog(
            @RequestPart("blog") BlogDTO blogDTO,
            @RequestPart(value = "image", required = false) MultipartFile image,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        String currentUsername = principal.getName();
        com.healthTracker.implementation.model.User user = userService.getUserByUsername(currentUsername);

        // Security Check: Unverified users cannot create Articles
        if ("USER".equalsIgnoreCase(user.getRole()) &&
                "ARTICLE".equalsIgnoreCase(blogDTO.getContentType()) &&
                !user.isVerifiedUser()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        blogDTO.setAuthorUsername(currentUsername);
        blogDTO.setAuthorName(user.getFirst() + " " + user.getLast());
        if (blogDTO.getAuthorType() == null) {
            blogDTO.setAuthorType(user.getRole() != null ? user.getRole() : "USER");
        }

        try {
            if (image != null && !image.isEmpty()) {
                String imageUrl = blogService.saveBlogImage(image);
                blogDTO.setImageUrl(imageUrl);
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        BlogDTO createdBlog = blogService.createBlog(blogDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
    }

    @PutMapping(value = "/{id}", consumes = { "multipart/form-data" })
    public ResponseEntity<BlogDTO> updateBlog(
            @PathVariable Long id,
            @RequestPart("blog") BlogDTO blogDTO,
            @RequestPart(value = "image", required = false) MultipartFile image,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        try {
            BlogDTO existingBlog = blogService.getBlogById(id);
            if (!canManageBlog(existingBlog, principal)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            if (image != null && !image.isEmpty()) {
                String imageUrl = blogService.saveBlogImage(image);
                blogDTO.setImageUrl(imageUrl);
            } else {
                // Preserve existing image if no new one is uploaded and no explicit URL is
                // provided
                if (blogDTO.getImageUrl() == null || blogDTO.getImageUrl().isEmpty()) {
                    blogDTO.setImageUrl(existingBlog.getImageUrl());
                }
            }

            BlogDTO updatedBlog = blogService.updateBlog(id, blogDTO);
            return ResponseEntity.ok(updatedBlog);
        } catch (RuntimeException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBlog(@PathVariable Long id, java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        try {
            BlogDTO existingBlog = blogService.getBlogById(id);
            if (!canManageBlog(existingBlog, principal)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            blogService.deleteBlog(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Blog deleted successfully");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private boolean canManageBlog(BlogDTO blog, java.security.Principal principal) {
        if (principal == null || blog == null)
            return false;
        String currentUsername = principal.getName().trim().toLowerCase();

        boolean usernameMatch = blog.getAuthorUsername() != null &&
                blog.getAuthorUsername().trim().toLowerCase().equals(currentUsername);
        boolean nameMatch = blog.getAuthorName() != null &&
                blog.getAuthorName().trim().toLowerCase().equals(currentUsername);

        return usernameMatch || nameMatch;
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<BlogCommentDTO>> getComments(@PathVariable Long id) {
        List<BlogCommentDTO> comments = blogService.getCommentsByBlogId(id);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<BlogCommentDTO> addComment(@PathVariable Long id, @RequestBody BlogCommentDTO commentDTO,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        commentDTO.setBlogId(id);
        BlogCommentDTO createdComment = blogService.addComment(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Map<String, String>> deleteComment(@PathVariable Long commentId,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        try {
            blogService.deleteComment(commentId);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Comment deleted successfully");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Map<String, Object>> toggleLike(@PathVariable Long id,
            @RequestBody Map<String, String> request) {
        try {
            String userName = request.get("userName");
            boolean isLiked = blogService.toggleLike(id, userName);
            Map<String, Object> response = new HashMap<>();
            response.put("liked", isLiked);
            response.put("likesCount", blogService.getBlogById(id).getLikesCount());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/like-status")
    public ResponseEntity<Map<String, Boolean>> getLikeStatus(@PathVariable Long id, @RequestParam String userName) {
        try {
            boolean isLiked = blogService.isLikedByUser(id, userName);
            Map<String, Boolean> response = new HashMap<>();
            response.put("liked", isLiked);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\BlogViewController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/articles")
public class BlogViewController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showBlogs(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "articles";
    }

    @GetMapping("/articles")
    public String showArticles(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "articles";
    }

    @GetMapping("/community")
    public String showCommunity(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "community";
    }

    @GetMapping("/create")
    public String showCreateBlog(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "article-create";
    }

    @GetMapping("/edit")
    public String showEditBlog(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "article-edit";
    }

    @GetMapping("/detail")
    public String showBlogDetail(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "article-detail";
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\BmiController.java
```java
package com.healthTracker.implementation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

    @GetMapping("/bmi")
    public String bmiPage() {
        return "bmi_calculator";
    }

    @PostMapping("/calculate-bmi")
    public String calculateBmi(@RequestParam("height") Double height,
            @RequestParam("weight") Double weight,
            Model model) {
        if (height == null || weight == null || height <= 0 || weight <= 0) {
            model.addAttribute("error", "Please enter valid height and weight values.");
            return "bmi_calculator";
        }

        double bmi = weight / ((height / 100) * (height / 100));
        String bmiValue = String.format("%.2f", bmi);

        String status;
        String guidance;
        String colorClass;

        if (bmi < 18.5) {
            status = "Underweight";
            guidance = "Focus on nutrient-rich foods and strength training to build muscle mass.";
            colorClass = "text-orange";
        } else if (bmi < 24.9) {
            status = "Normal Weight";
            guidance = "Great job! Maintain a balanced diet and regular exercise routine.";
            colorClass = "text-green";
        } else if (bmi < 29.9) {
            status = "Overweight";
            guidance = "Consider a balanced diet and increased physical activity to manage weight.";
            colorClass = "text-orange";
        } else {
            status = "Obese";
            guidance = "Consult a healthcare provider for a personalized weight management plan.";
            colorClass = "text-red";
        }

        model.addAttribute("bmiValue", bmiValue);
        model.addAttribute("bmiStatus", status);
        model.addAttribute("bmiGuidance", guidance);
        model.addAttribute("colorClass", colorClass);
        model.addAttribute("height", height);
        model.addAttribute("weight", weight);

        return "bmi_calculator";
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\DailyLogController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.DailyLog;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.DailyLogService;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/daily-logs")
public class DailyLogController {

    @Autowired
    private DailyLogService dailyLogService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listDailyLogs(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<DailyLog> dailyLogs = dailyLogService.findDailyLogsByUser(user);
        model.addAttribute("dailyLogs", dailyLogs);
        model.addAttribute("dailyLog", new DailyLog());
        return "daily-log";
    }

    @PostMapping
    public String addDailyLog(@ModelAttribute DailyLog dailyLog, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        dailyLog.setUser(user);
        dailyLogService.saveDailyLog(dailyLog);
        return "redirect:/daily-logs";
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\GlobalControllerAdvice.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void addCurrentUser(Principal principal, Model model) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\MealController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.Meal;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.MealService;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listMeals(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Meal> meals = mealService.findMealsByUser(user);
        model.addAttribute("meals", meals);
        model.addAttribute("meal", new Meal());
        return "meal";
    }

    @PostMapping
    public String addMeal(@ModelAttribute Meal meal, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        meal.setUser(user);
        mealService.saveMeal(meal);
        return "redirect:/meals";
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\TrainerDashboardController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.*;
import com.healthTracker.implementation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/trainer")
public class TrainerDashboardController {

        @Autowired
        private UserService userService;

        @Autowired
        private PlanService planService;

        @Autowired
        private HealthTipService healthTipService;

        @Autowired
        private MealService mealService;

        @Autowired
        private WorkoutService workoutService;

        @Autowired
        private DailyLogService dailyLogService;

        @GetMapping("/dashboard")
        public String trainerDashboard(Model model, Principal principal) {
                if (principal == null)
                        return "redirect:/login";

                User trainer = userService.getUserByUsername(principal.getName());
                List<User> assignedUsers = userService.getAllUsers().stream()
                                .filter(u -> trainer.getId().equals(u.getAssignedTrainerId()))
                                .collect(Collectors.toList());

                model.addAttribute("trainer", trainer);
                model.addAttribute("users", assignedUsers);
                model.addAttribute("healthTip", healthTipService.getDailyTip());
                return "trainer-dashboard";
        }

        @GetMapping("/assign-plan/{userId}")
        public String assignPlan(@PathVariable Long userId, Model model, Principal principal) {
                if (principal == null)
                        return "redirect:/login";

                User user = userService.getUserById(userId);
                model.addAttribute("user", user);
                model.addAttribute("dietPlans", planService.getDietPlansForUser(userId));
                model.addAttribute("exercisePlans", planService.getExercisePlansForUser(userId));
                return "assign-plan";
        }

        @PostMapping("/assign-diet")
        public String saveDiet(@ModelAttribute DietPlan dietPlan, Principal principal) {
                User trainer = userService.getUserByUsername(principal.getName());
                dietPlan.setTrainerId(trainer.getId());
                planService.saveDietPlan(dietPlan);
                return "redirect:/trainer/assign-plan/" + dietPlan.getUserId();
        }

        @PostMapping("/assign-exercise")
        public String saveExercise(@ModelAttribute ExercisePlan exercisePlan, Principal principal) {
                User trainer = userService.getUserByUsername(principal.getName());
                exercisePlan.setTrainerId(trainer.getId());
                planService.saveExercisePlan(exercisePlan);
                return "redirect:/trainer/assign-plan/" + exercisePlan.getUserId();
        }

        @GetMapping("/analysis/{userId}")
        public String userAnalysis(@PathVariable Long userId, Model model, Principal principal) {
                if (principal == null)
                        return "redirect:/login";

                User trainer = userService.getUserByUsername(principal.getName());
                User user = userService.getUserById(userId);

                // Security check
                if (user == null || !trainer.getId().equals(user.getAssignedTrainerId())) {
                        return "redirect:/trainer/dashboard";
                }

                model.addAttribute("user", user);
                model.addAttribute("trainer", trainer);

                // Analysis Logic (copied from AuthController.java)
                LocalDate today = LocalDate.now();
                List<Meal> meals = mealService.findMealsByUser(user);
                List<Workout> workouts = workoutService.findWorkoutsByUser(user);
                List<DailyLog> logs = dailyLogService.findDailyLogsByUser(user);

                // Calculate Today's Summary
                int caloriesEaten = meals.stream()
                                .filter(m -> m.getDate().equals(today))
                                .mapToInt(Meal::getCalories)
                                .sum();

                int caloriesBurned = workouts.stream()
                                .filter(w -> w.getDate().equals(today))
                                .mapToInt(Workout::getCalories)
                                .sum();

                int steps = logs.stream()
                                .filter(l -> l.getDate().equals(today))
                                .mapToInt(DailyLog::getSteps)
                                .sum();

                double sleep = logs.stream()
                                .filter(l -> l.getDate().equals(today))
                                .mapToDouble(DailyLog::getSleepDuration)
                                .sum();

                model.addAttribute("caloriesEaten", caloriesEaten);
                model.addAttribute("caloriesBurned", caloriesBurned);
                model.addAttribute("steps", steps);
                model.addAttribute("sleep", sleep);

                // Calculate Weekly Summary (Last 7 days)
                List<String> datesHistory = new ArrayList<>();
                List<Integer> caloriesEatenHistory = new ArrayList<>();
                List<Integer> caloriesBurnedHistory = new ArrayList<>();
                List<Integer> stepsHistory = new ArrayList<>();
                List<Long> workoutFrequencyHistory = new ArrayList<>();
                List<Integer> workoutDurationHistory = new ArrayList<>();
                List<Double> waterIntakeHistory = new ArrayList<>();
                List<Double> sleepHistory = new ArrayList<>();

                java.util.Map<String, List<Integer>> workoutDataByType = new java.util.HashMap<>();

                for (int i = 6; i >= 0; i--) {
                        LocalDate date = today.minusDays(i);
                        datesHistory.add(date.format(DateTimeFormatter.ofPattern("MMM dd")));

                        int dailyCalEaten = meals.stream()
                                        .filter(m -> m.getDate().equals(date))
                                        .mapToInt(Meal::getCalories)
                                        .sum();
                        caloriesEatenHistory.add(dailyCalEaten);

                        int dailyCalBurned = workouts.stream()
                                        .filter(w -> w.getDate().equals(date))
                                        .mapToInt(Workout::getCalories)
                                        .sum();
                        caloriesBurnedHistory.add(dailyCalBurned);

                        int dailySteps = logs.stream()
                                        .filter(l -> l.getDate().equals(date))
                                        .mapToInt(DailyLog::getSteps)
                                        .sum();
                        stepsHistory.add(dailySteps);

                        // Fetch and Group Workouts by Type for this date
                        List<Workout> dailyWorkouts = workouts.stream()
                                        .filter(w -> w.getDate().equals(date))
                                        .collect(Collectors.toList());

                        // Track unique types across all days to ensure data lists are full
                        java.util.Set<String> allTypes = workouts.stream()
                                        .filter(w -> w.getDate().isAfter(today.minusDays(7))
                                                        || w.getDate().equals(today.minusDays(7)))
                                        .map(Workout::getType)
                                        .filter(java.util.Objects::nonNull)
                                        .collect(java.util.stream.Collectors.toSet());

                        for (String type : allTypes) {
                                int durationForType = dailyWorkouts.stream()
                                                .filter(w -> type.equals(w.getType()))
                                                .mapToInt(Workout::getDuration)
                                                .sum();
                                workoutDataByType.computeIfAbsent(type, k -> new ArrayList<>()).add(durationForType);
                        }

                        double dailyWater = logs.stream()
                                        .filter(l -> l.getDate().equals(date))
                                        .mapToDouble(DailyLog::getWaterIntake)
                                        .sum();
                        waterIntakeHistory.add(dailyWater);

                        double dailySleep = logs.stream()
                                        .filter(l -> l.getDate().equals(date))
                                        .mapToDouble(DailyLog::getSleepDuration)
                                        .sum();
                        sleepHistory.add(dailySleep);
                }

                model.addAttribute("datesHistory", datesHistory);
                model.addAttribute("caloriesEatenHistory", caloriesEatenHistory);
                model.addAttribute("caloriesBurnedHistory", caloriesBurnedHistory);
                model.addAttribute("stepsHistory", stepsHistory);
                model.addAttribute("workoutDataByType", workoutDataByType);
                model.addAttribute("waterIntakeHistory", waterIntakeHistory);
                model.addAttribute("sleepHistory", sleepHistory);

                // Goal Tracking
                Integer dailyStepGoal = user.getDailyStepGoal() != null ? user.getDailyStepGoal() : 10000;
                Integer weeklyWorkoutGoal = user.getWeeklyWorkoutGoal() != null ? user.getWeeklyWorkoutGoal() : 5;

                long weeklyWorkoutsCompleted = workouts.stream()
                                .filter(w -> w.getDate().isAfter(today.minusDays(7))
                                                || w.getDate().equals(today.minusDays(7)))
                                .map(Workout::getDate)
                                .distinct()
                                .count();

                model.addAttribute("dailyStepGoal", dailyStepGoal);
                model.addAttribute("weeklyWorkoutGoal", weeklyWorkoutGoal);
                model.addAttribute("weeklyWorkoutsCompleted", weeklyWorkoutsCompleted);

                return "user-analysis";
        }
}

```

## src\main\java\com\healthTracker\implementation\controller\TrainerMatchingController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.TrainerService;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class TrainerMatchingController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private UserService userService;

    @GetMapping("/trainer-matching")
    public String showTrainerMatching(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "trainer-matching";
    }

    @GetMapping("/api/trainers/match")
    @ResponseBody
    public ResponseEntity<List<User>> matchTrainers(Principal principal, @RequestParam(required = false) String goal) {
        if (principal == null) {
            return ResponseEntity.status(401).build();
        }

        String userGoal = goal;
        if (userGoal == null || userGoal.isEmpty()) {
            User user = userService.getUserByUsername(principal.getName());
            userGoal = user.getGoals();
        }

        List<User> recommended = trainerService.getRecommendedTrainers(userGoal);
        return ResponseEntity.ok(recommended);
    }

    @PostMapping("/api/trainers/book")
    @ResponseBody
    public ResponseEntity<?> bookTrainer(Principal principal, @RequestParam Long trainerId) {
        if (principal == null) {
            return ResponseEntity.status(401).build();
        }

        User user = userService.getUserByUsername(principal.getName());
        user.setAssignedTrainerId(trainerId);
        userService.updateUserProfile(user);

        return ResponseEntity.ok().body(Map.of("message", "Trainer booked successfully!"));
    }
}

```

## src\main\java\com\healthTracker\implementation\controller\WorkoutController.java
```java
package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.model.Workout;
import com.healthTracker.implementation.service.UserService;
import com.healthTracker.implementation.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listWorkouts(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Workout> workouts = workoutService.findWorkoutsByUser(user);
        model.addAttribute("workouts", workouts);
        model.addAttribute("workout", new Workout());
        return "workout";
    }

    @PostMapping
    public String addWorkout(@ModelAttribute Workout workout, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        workout.setUser(user);
        workoutService.saveWorkout(workout);
        return "redirect:/workouts";
    }
}

```

## src\main\java\com\healthTracker\implementation\dto\BlogCommentDTO.java
```java
package com.healthTracker.implementation.dto;

import java.time.LocalDateTime;

public class BlogCommentDTO {
    private Long id;
    private Long blogId;
    private String userName;
    private String commentText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BlogCommentDTO() {
    }

    public BlogCommentDTO(Long id, Long blogId, String userName, String commentText, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.blogId = blogId;
        this.userName = userName;
        this.commentText = commentText;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BlogCommentDTO{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", userName='" + userName + '\'' +
                ", commentText='" + commentText + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

```

## src\main\java\com\healthTracker\implementation\dto\BlogDTO.java
```java
package com.healthTracker.implementation.dto;

import java.time.LocalDateTime;

public class BlogDTO {
    private Long id;
    private String title;
    private String category;
    private String content;
    private String authorName;
    private String authorUsername;
    private String authorType;
    private LocalDateTime publishedDate;
    private String imageUrl;
    private String status;
    private long likesCount;
    private long commentsCount;
    private String contentType;

    public BlogDTO() {
    }

    public BlogDTO(Long id, String title, String category, String content, String authorName, String authorUsername,
            String authorType, LocalDateTime publishedDate, String imageUrl, String status, long likesCount,
            long commentsCount, String contentType) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
        this.authorName = authorName;
        this.authorUsername = authorUsername;
        this.authorType = authorType;
        this.publishedDate = publishedDate;
        this.imageUrl = imageUrl;
        this.status = status;
        this.likesCount = likesCount;
        this.commentsCount = commentsCount;
        this.contentType = contentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public String getAuthorType() {
        return authorType;
    }

    public void setAuthorType(String authorType) {
        this.authorType = authorType;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorUsername='" + authorUsername + '\'' +
                ", authorType='" + authorType + '\'' +
                ", publishedDate=" + publishedDate +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", likesCount=" + likesCount +
                ", commentsCount=" + commentsCount +
                '}';
    }
}

```

## src\main\java\com\healthTracker\implementation\dto\PasswordResetDto.java
```java
package com.healthTracker.implementation.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResetDto {

    private String token;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@_]).{9,}$", message = "Password length must be > 8, contain 1 uppercase, 1 lowercase, 1 number, and 1 special character (@ or _)")
    private String password;

    private String confirmPassword;
}

```

## src\main\java\com\healthTracker\implementation\dto\UserDto.java
```java
package com.healthTracker.implementation.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String first;
    private String last;
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@_]).{9,}$", message = "Password length must be > 8, contain 1 uppercase, 1 lowercase, 1 number, and 1 special character (@ or _)")
    private String password;

    private String cnfPassword;
    private String role;

    // Trainer specific fields
    private String specialization;
    private String experience;
    private String trainerLocation;
    private String availability;
    private String contactNo;
}

```

## src\main\java\com\healthTracker\implementation\model\Blog.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String authorName;

    @Column(nullable = false)
    private String authorUsername;

    @Column(nullable = false)
    private String authorType; // USER, TRAINER, ADMIN

    @Column(nullable = false, updatable = false)
    private LocalDateTime publishedDate;

    private String imageUrl;

    @Column(nullable = false)
    private String status = "PUBLISHED"; // PUBLISHED, PENDING, REJECTED

    @Column(nullable = false)
    private String contentType = "ARTICLE"; // ARTICLE, POST

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogLike> likes = new ArrayList<>();

    public Blog() {
    }

    public Blog(Long id, String title, String category, String content, String authorName, String authorUsername,
            String authorType, LocalDateTime publishedDate, String imageUrl, String status, LocalDateTime createdAt,
            LocalDateTime updatedAt, List<BlogComment> comments, List<BlogLike> likes) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
        this.authorName = authorName;
        this.authorUsername = authorUsername;
        this.authorType = authorType;
        this.publishedDate = publishedDate;
        this.imageUrl = imageUrl;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.comments = comments;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public String getAuthorType() {
        return authorType;
    }

    public void setAuthorType(String authorType) {
        this.authorType = authorType;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }

    public List<BlogLike> getLikes() {
        return likes;
    }

    public void setLikes(List<BlogLike> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorUsername='" + authorUsername + '\'' +
                ", authorType='" + authorType + '\'' +
                ", publishedDate=" + publishedDate +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @PrePersist
    protected void onCreate() {
        publishedDate = LocalDateTime.now();
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

```

## src\main\java\com\healthTracker\implementation\model\BlogComment.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blog_comments")
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String commentText;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public BlogComment() {
    }

    public BlogComment(Long id, Blog blog, String userName, String commentText, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.blog = blog;
        this.userName = userName;
        this.commentText = commentText;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BlogComment{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", commentText='" + commentText + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

```

## src\main\java\com\healthTracker\implementation\model\BlogLike.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blog_likes", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "blog_id", "user_name" })
})
public class BlogLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public BlogLike() {
    }

    public BlogLike(Long id, Blog blog, String userName, LocalDateTime createdAt) {
        this.id = id;
        this.blog = blog;
        this.userName = userName;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "BlogLike{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}

```

## src\main\java\com\healthTracker\implementation\model\DailyLog.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "daily_log")
public class DailyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double waterIntake; // in liters
    private double sleepDuration; // in hours
    private int steps;
    private String notes;
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(double waterIntake) {
        this.waterIntake = waterIntake;
    }

    public double getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(double sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

```

## src\main\java\com\healthTracker\implementation\model\DietPlan.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long trainerId;
    private Long userId;

    private String mealName;
    private String description;
    private String dayOfWeek; // e.g., MON, TUE, etc.
    private Integer calories;
}

```

## src\main\java\com\healthTracker\implementation\model\ExercisePlan.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class ExercisePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long trainerId;
    private Long userId;

    private String exerciseName;
    private Integer sets;
    private Integer reps;
    private String description;
    private String dayOfWeek;
}

```

## src\main\java\com\healthTracker\implementation\model\HealthTip.java
```java
package com.healthTracker.implementation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthTip {
    private String title;
    private String description;
    private String category; // e.g., "Nutrition", "Exercise", "Mental Health"
}

```

## src\main\java\com\healthTracker\implementation\model\Meal.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Breakfast, Lunch, Dinner, Snack
    private int calories;
    private double protein;
    private double carbs;
    private double fats;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

```

## src\main\java\com\healthTracker\implementation\model\PasswordResetToken.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private LocalDateTime expiryDate;

    public PasswordResetToken() {
    }

    public PasswordResetToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expiryDate = LocalDateTime.now().plusHours(1); // Token valid for 1 hour
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}

```

## src\main\java\com\healthTracker\implementation\model\User.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first;
    private String last;
    private String username;
    private String password;
    private String role;
    @Transient
    private String cnfPassword;

    private String age;
    private String weight;
    private String height;
    private String goals;

    private Integer dailyStepGoal = 10000;
    private Integer weeklyWorkoutGoal = 5;
    private Double weightGoal;
    private Double waterIntakeGoal = 3.0;

    // Trainer specific fields
    private String specialization;
    private String trainerLocation;
    private String availability;
    private String experience;
    private String contactNo;
    private boolean isVerifiedTrainer = false;
    private boolean isVerifiedUser = false;
    private String profileImageUrl;
    private Long assignedTrainerId;
}

```

## src\main\java\com\healthTracker\implementation\model\Workout.java
```java
package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int duration; // in minutes
    private int calories;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

```

## src\main\java\com\healthTracker\implementation\repository\BlogCommentRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {
    List<BlogComment> findByBlogIdOrderByCreatedAtAsc(Long blogId);
}

```

## src\main\java\com\healthTracker\implementation\repository\BlogLikeRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.BlogLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogLikeRepository extends JpaRepository<BlogLike, Long> {
    Optional<BlogLike> findByBlogIdAndUserName(Long blogId, String userName);

    boolean existsByBlogIdAndUserName(Long blogId, String userName);

    long countByBlogId(Long blogId);
}

```

## src\main\java\com\healthTracker\implementation\repository\BlogRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByStatusOrderByPublishedDateDesc(String status);

    List<Blog> findByCategoryOrderByPublishedDateDesc(String category);

    List<Blog> findByContentTypeOrderByPublishedDateDesc(String contentType);

    List<Blog> findByAuthorTypeOrderByPublishedDateDesc(String authorType);

    List<Blog> findByAuthorNameOrderByPublishedDateDesc(String authorName);

    @Query("SELECT b FROM Blog b ORDER BY b.publishedDate DESC")
    List<Blog> findAllOrderByPublishedDateDesc();
}

```

## src\main\java\com\healthTracker\implementation\repository\DailyLogRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.DailyLog;
import com.healthTracker.implementation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyLogRepository extends JpaRepository<DailyLog, Long> {
    List<DailyLog> findByUser(User user);
}

```

## src\main\java\com\healthTracker\implementation\repository\DietPlanRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
    List<DietPlan> findByUserId(Long userId);

    List<DietPlan> findByTrainerId(Long trainerId);

    List<DietPlan> findByUserIdAndDayOfWeek(Long userId, String dayOfWeek);
}

```

## src\main\java\com\healthTracker\implementation\repository\ExercisePlanRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.ExercisePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercisePlanRepository extends JpaRepository<ExercisePlan, Long> {
    List<ExercisePlan> findByUserId(Long userId);

    List<ExercisePlan> findByTrainerId(Long trainerId);

    List<ExercisePlan> findByUserIdAndDayOfWeek(Long userId, String dayOfWeek);
}

```

## src\main\java\com\healthTracker\implementation\repository\MealRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.Meal;
import com.healthTracker.implementation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUser(User user);
}

```

## src\main\java\com\healthTracker\implementation\repository\PasswordResetTokenRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.PasswordResetToken;
import com.healthTracker.implementation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);

    void deleteByUser(User user);

    PasswordResetToken findByUser(User user);
}

```

## src\main\java\com\healthTracker\implementation\repository\UserRepository.java
```java
package com.healthTracker.implementation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthTracker.implementation.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

}

```

## src\main\java\com\healthTracker\implementation\repository\WorkoutRepository.java
```java
package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUser(User user);
}

```

## src\main\java\com\healthTracker\implementation\service\BlogService.java
```java
package com.healthTracker.implementation.service;

import com.healthTracker.implementation.dto.BlogDTO;
import com.healthTracker.implementation.dto.BlogCommentDTO;
import com.healthTracker.implementation.model.Blog;
import com.healthTracker.implementation.model.BlogComment;
import com.healthTracker.implementation.model.BlogLike;
import com.healthTracker.implementation.repository.BlogCommentRepository;
import com.healthTracker.implementation.repository.BlogLikeRepository;
import com.healthTracker.implementation.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogCommentRepository commentRepository;

    @Autowired
    private BlogLikeRepository likeRepository;

    public List<BlogDTO> getAllBlogs() {
        return blogRepository.findAllOrderByPublishedDateDesc().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BlogDTO> getBlogsByCategory(String category) {
        return blogRepository.findByCategoryOrderByPublishedDateDesc(category).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BlogDTO> getBlogsByContentType(String contentType) {
        return blogRepository.findByContentTypeOrderByPublishedDateDesc(contentType).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BlogDTO> getBlogsByAuthorType(String authorType) {
        return blogRepository.findByAuthorTypeOrderByPublishedDateDesc(authorType).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BlogDTO getBlogById(Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
        return convertToDTO(blog);
    }

    public BlogDTO createBlog(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setCategory(blogDTO.getCategory());
        blog.setContent(blogDTO.getContent());
        blog.setAuthorName(blogDTO.getAuthorName());
        blog.setAuthorUsername(blogDTO.getAuthorUsername());
        blog.setAuthorType(blogDTO.getAuthorType());
        blog.setImageUrl(blogDTO.getImageUrl());
        blog.setStatus(blogDTO.getStatus() != null ? blogDTO.getStatus() : "PUBLISHED");
        blog.setContentType(blogDTO.getContentType() != null ? blogDTO.getContentType() : "ARTICLE");

        Blog savedBlog = blogRepository.save(blog);
        return convertToDTO(savedBlog);
    }

    public BlogDTO updateBlog(Long id, BlogDTO blogDTO) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));

        blog.setTitle(blogDTO.getTitle());
        blog.setCategory(blogDTO.getCategory());
        blog.setContent(blogDTO.getContent());
        blog.setImageUrl(blogDTO.getImageUrl());
        if (blogDTO.getStatus() != null) {
            blog.setStatus(blogDTO.getStatus());
        }
        if (blogDTO.getContentType() != null) {
            blog.setContentType(blogDTO.getContentType());
        }

        Blog updatedBlog = blogRepository.save(blog);
        return convertToDTO(updatedBlog);
    }

    public void deleteBlog(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new RuntimeException("Blog not found with id: " + id);
        }
        blogRepository.deleteById(id);
    }

    public List<BlogCommentDTO> getCommentsByBlogId(Long blogId) {
        return commentRepository.findByBlogIdOrderByCreatedAtAsc(blogId).stream()
                .map(this::convertCommentToDTO)
                .collect(Collectors.toList());
    }

    public BlogCommentDTO addComment(BlogCommentDTO commentDTO) {
        Blog blog = blogRepository.findById(commentDTO.getBlogId())
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + commentDTO.getBlogId()));

        BlogComment comment = new BlogComment();
        comment.setBlog(blog);
        comment.setUserName(commentDTO.getUserName());
        comment.setCommentText(commentDTO.getCommentText());

        BlogComment savedComment = commentRepository.save(comment);
        return convertCommentToDTO(savedComment);
    }

    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new RuntimeException("Comment not found with id: " + commentId);
        }
        commentRepository.deleteById(commentId);
    }

    public boolean toggleLike(Long blogId, String userName) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + blogId));

        return likeRepository.findByBlogIdAndUserName(blogId, userName)
                .map(like -> {
                    likeRepository.delete(like);
                    return false; // Unlike
                })
                .orElseGet(() -> {
                    BlogLike like = new BlogLike();
                    like.setBlog(blog);
                    like.setUserName(userName);
                    likeRepository.save(like);
                    return true; // Like
                });
    }

    public boolean isLikedByUser(Long blogId, String userName) {
        return likeRepository.existsByBlogIdAndUserName(blogId, userName);
    }

    public String saveBlogImage(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty())
            return null;

        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get("uploads/blogs");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        return "/uploads/blogs/" + fileName;
    }

    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setCategory(blog.getCategory());
        dto.setContent(blog.getContent());
        dto.setAuthorName(blog.getAuthorName());
        dto.setAuthorUsername(blog.getAuthorUsername());
        dto.setAuthorType(blog.getAuthorType());
        dto.setPublishedDate(blog.getPublishedDate());
        dto.setImageUrl(blog.getImageUrl());
        dto.setStatus(blog.getStatus());
        dto.setContentType(blog.getContentType());
        dto.setLikesCount(likeRepository.countByBlogId(blog.getId()));
        dto.setCommentsCount(commentRepository.findByBlogIdOrderByCreatedAtAsc(blog.getId()).size());
        return dto;
    }

    private BlogCommentDTO convertCommentToDTO(BlogComment comment) {
        BlogCommentDTO dto = new BlogCommentDTO();
        dto.setId(comment.getId());
        dto.setBlogId(comment.getBlog().getId());
        dto.setUserName(comment.getUserName());
        dto.setCommentText(comment.getCommentText());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }
}

```

## src\main\java\com\healthTracker\implementation\service\CustomUserDetails.java
```java
package com.healthTracker.implementation.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.UserRepository;

@Service
public class CustomUserDetails implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetails(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found with given username");
		}

		boolean isEnabled = true;
		if ("TRAINER".equalsIgnoreCase(user.getRole())) {
			isEnabled = user.isVerifiedTrainer();
		}
		// USER and ADMIN are enabled by default

		if (!isEnabled) {
			throw new org.springframework.security.authentication.DisabledException(
					"Your account is pending admin verification.");
		}

		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole().toUpperCase())
				.build();
	}

}

```

## src\main\java\com\healthTracker\implementation\service\DailyLogService.java
```java
package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.DailyLog;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.DailyLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyLogService {

    @Autowired
    private DailyLogRepository dailyLogRepository;

    public DailyLog saveDailyLog(DailyLog dailyLog) {
        return dailyLogRepository.save(dailyLog);
    }

    public List<DailyLog> findDailyLogsByUser(User user) {
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

        return dailyLogRepository.findByUser(user).stream()
                .filter(l -> !l.getDate().isBefore(startOfMonth) && !l.getDate().isAfter(endOfMonth))
                .collect(Collectors.toList());
    }
}

```

## src\main\java\com\healthTracker\implementation\service\EmailService.java
```java
package com.healthTracker.implementation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}

```

## src\main\java\com\healthTracker\implementation\service\HealthTipService.java
```java
package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.HealthTip;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HealthTipService {

    private final List<HealthTip> tips = new ArrayList<>();
    private final Random random = new Random();

    public HealthTipService() {
        // Initialize with a curated list of tips
        tips.add(new HealthTip("Stay Hydrated",
                "Drink at least 8 glasses of water daily to maintain optimal health and energy levels.", "Hydration"));
        tips.add(new HealthTip("Prioritize Sleep",
                "Aim for 7-9 hours of quality sleep each night to aid recovery and focus.", "Sleep"));
        tips.add(new HealthTip("Move Your Body",
                "Take a short 10-minute walk after meals to help digestion and blood sugar control.", "Exercise"));
        tips.add(new HealthTip("Eat More Greens",
                "Include a serving of leafy greens in at least one meal today for essential vitamins.", "Nutrition"));
        tips.add(new HealthTip("Mindful Breathing",
                "Take 5 minutes to practice deep breathing to reduce stress and anxiety.", "Mental Health"));
        tips.add(new HealthTip("Limit Sugar", "Try to replace sugary snacks with fruits or nuts for sustained energy.",
                "Nutrition"));
        tips.add(new HealthTip("Stretch Daily", "Stretching improves flexibility and reduces the risk of injury.",
                "Exercise"));
        tips.add(new HealthTip("Screen Detox",
                "Avoid screens for at least 30 minutes before bed to improve sleep quality.", "Sleep"));
    }

    public HealthTip getDailyTip() {
        int index = random.nextInt(tips.size());
        return tips.get(index);
    }
}

```

## src\main\java\com\healthTracker\implementation\service\MealService.java
```java
package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.Meal;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public List<Meal> findMealsByUser(User user) {
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

        return mealRepository.findByUser(user).stream()
                .filter(m -> !m.getDate().isBefore(startOfMonth) && !m.getDate().isAfter(endOfMonth))
                .collect(Collectors.toList());
    }
}

```

## src\main\java\com\healthTracker\implementation\service\PlanService.java
```java
package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.DietPlan;
import com.healthTracker.implementation.model.ExercisePlan;
import com.healthTracker.implementation.repository.DietPlanRepository;
import com.healthTracker.implementation.repository.ExercisePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private DietPlanRepository dietPlanRepository;

    @Autowired
    private ExercisePlanRepository exercisePlanRepository;

    public DietPlan saveDietPlan(DietPlan dietPlan) {
        return dietPlanRepository.save(dietPlan);
    }

    public ExercisePlan saveExercisePlan(ExercisePlan exercisePlan) {
        return exercisePlanRepository.save(exercisePlan);
    }

    public List<DietPlan> getDietPlansForUser(Long userId) {
        return dietPlanRepository.findByUserId(userId);
    }

    public List<ExercisePlan> getExercisePlansForUser(Long userId) {
        return exercisePlanRepository.findByUserId(userId);
    }

    public List<DietPlan> getDietPlansForTrainer(Long trainerId) {
        return dietPlanRepository.findByTrainerId(trainerId);
    }

    public List<ExercisePlan> getExercisePlansForTrainer(Long trainerId) {
        return exercisePlanRepository.findByTrainerId(trainerId);
    }

    public void deleteDietPlan(Long id) {
        dietPlanRepository.deleteById(id);
    }

    public void deleteExercisePlan(Long id) {
        exercisePlanRepository.deleteById(id);
    }
}

```

## src\main\java\com\healthTracker\implementation\service\TrainerService.java
```java
package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllTrainers() {
        return userRepository.findAll().stream()
                .filter(user -> "TRAINER".equalsIgnoreCase(user.getRole()))
                .collect(Collectors.toList());
    }

    public List<User> getRecommendedTrainers(String userGoal) {
        List<User> trainers = getAllTrainers();
        if (userGoal == null || userGoal.isEmpty()) {
            return trainers;
        }

        // Simple matching logic: case-insensitive check if user goal is in trainer's
        // specialization
        return trainers.stream()
                .filter(trainer -> trainer.getSpecialization() != null &&
                        (trainer.getSpecialization().toLowerCase().contains(userGoal.toLowerCase()) ||
                                userGoal.toLowerCase().contains(trainer.getSpecialization().toLowerCase())))
                .collect(Collectors.toList());
    }
}

```

## src\main\java\com\healthTracker\implementation\service\UserService.java
```java
package com.healthTracker.implementation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.UserRepository;
import org.springframework.util.ObjectUtils;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateUserProfile(User user) {
        User dbUser = userRepository.findById(user.getId()).get();
        if (!ObjectUtils.isEmpty(dbUser)) {
            dbUser.setAge(user.getAge());
            dbUser.setWeight(user.getWeight());
            dbUser.setHeight(user.getHeight());
            dbUser.setGoals(user.getGoals());
            if (user.getDailyStepGoal() != null)
                dbUser.setDailyStepGoal(user.getDailyStepGoal());
            if (user.getWeeklyWorkoutGoal() != null)
                dbUser.setWeeklyWorkoutGoal(user.getWeeklyWorkoutGoal());
            if (user.getWeightGoal() != null)
                dbUser.setWeightGoal(user.getWeightGoal());
            if (user.getWaterIntakeGoal() != null)
                dbUser.setWaterIntakeGoal(user.getWaterIntakeGoal());
            if (user.getProfileImageUrl() != null)
                dbUser.setProfileImageUrl(user.getProfileImageUrl());

            // Update trainer fields if they are provided
            if (user.getSpecialization() != null)
                dbUser.setSpecialization(user.getSpecialization());
            if (user.getTrainerLocation() != null)
                dbUser.setTrainerLocation(user.getTrainerLocation());
            if (user.getAvailability() != null)
                dbUser.setAvailability(user.getAvailability());
            if (user.getExperience() != null)
                dbUser.setExperience(user.getExperience());
            if (user.getContactNo() != null)
                dbUser.setContactNo(user.getContactNo());

            userRepository.save(dbUser);
        }
        return dbUser;
    }

    @Autowired
    private com.healthTracker.implementation.repository.PasswordResetTokenRepository tokenRepository;

    @org.springframework.transaction.annotation.Transactional
    public String createPasswordResetTokenForUser(User user) {
        String token = String.valueOf(new java.util.Random().nextInt(900000) + 100000);
        com.healthTracker.implementation.model.PasswordResetToken myToken = tokenRepository.findByUser(user);
        if (myToken != null) {
            myToken.setToken(token);
            myToken.setExpiryDate(java.time.LocalDateTime.now().plusHours(1));
            tokenRepository.save(myToken);
        } else {
            myToken = new com.healthTracker.implementation.model.PasswordResetToken(token, user);
            tokenRepository.save(myToken);
        }
        return token;
    }

    public String validatePasswordResetToken(String token) {
        com.healthTracker.implementation.model.PasswordResetToken passToken = tokenRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                        : null;
    }

    private boolean isTokenFound(com.healthTracker.implementation.model.PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(com.healthTracker.implementation.model.PasswordResetToken passToken) {
        final java.time.LocalDateTime cal = passToken.getExpiryDate();
        return cal.isBefore(java.time.LocalDateTime.now());
    }

    public User getUserByPasswordResetToken(String token) {
        return tokenRepository.findByToken(token).getUser();
    }

    public void changeUserPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void verifyTrainer(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null && "TRAINER".equalsIgnoreCase(user.getRole())) {
            user.setVerifiedTrainer(true);
            userRepository.save(user);
        }
    }

    public void unverifyTrainer(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null && "TRAINER".equalsIgnoreCase(user.getRole())) {
            user.setVerifiedTrainer(false);
            userRepository.save(user);
        }
    }
}

```

## src\main\java\com\healthTracker\implementation\service\WorkoutService.java
```java
package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.model.Workout;
import com.healthTracker.implementation.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> findWorkoutsByUser(User user) {
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

        return workoutRepository.findByUser(user).stream()
                .filter(w -> !w.getDate().isBefore(startOfMonth) && !w.getDate().isAfter(endOfMonth))
                .collect(Collectors.toList());
    }
}

```

## src\main\resources\application.properties
```properties
spring.application.name=RegisterAndLoginWithSecurity
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/jwtexample3?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


# SMTP Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username= <Email>
spring.mail.password= <password>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

```

## src\main\resources\static\css\style.css
```css
body{
    background-color: rgb(45, 45, 45);
}

::placeholder{
    color: olive;
}

.container{
    display: flex;
    gap: 10px;
    background-color: whitesmoke;
    width : 30%;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border: solid black 2px;
    border-radius: 20px;
    margin: 5% 30%;
    padding : 5%;
}

.form-grp{
    margin-top: 10px;
}

.link{
    margin-top: 20px;
    color: olive;
    font-size:smaller;
}

.input{
    margin-top: 5px;
    height: 25px;
    border: solid olive 2px;
    border-radius: 5px;
}

.user{
    display: flex;
    flex-direction: row;
    justify-content:space-around;
    gap: 5px;
    margin-top: 20px;
}

.btn{
    height: 40px;
    width: 150px;
    background-color: rgb(11, 81, 8);
    color: whitesmoke;
    border-radius: 5px;
}

.btn:hover{
    background-color: whitesmoke;
    color: olive;
    border: solid 2px rgb(11, 81, 8);
}



.heading{
    color: olive;
}
```

## src\main\resources\templates\admin-dashboard.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Admin Dashboard - Health Tracker</title>
    <style>
        :root {
            --primary-color: #6366f1;
            --primary-hover: #4f46e5;
            --bg-color: #0f172a;
            --card-bg: #1e293b;
            --text-main: #f1f5f9;
            --text-secondary: #94a3b8;
            --danger: #ef4444;
            --success: #10b981;
            --accent: #38bdf8;
        }

        body {
            font-family: 'Inter', system-ui, -apple-system, sans-serif;
            background-color: var(--bg-color);
            color: var(--text-main);
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: var(--card-bg);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: 800;
            color: var(--accent);
            text-decoration: none;
            letter-spacing: -0.025em;
        }

        .nav-links {
            display: flex;
            gap: 1.5rem;
            align-items: center;
        }

        .nav-link {
            text-decoration: none;
            color: var(--text-secondary);
            font-weight: 500;
            transition: all 0.2s;
        }

        .nav-link:hover {
            color: var(--text-main);
        }

        .btn-logout {
            background-color: var(--danger);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 0.5rem;
            text-decoration: none;
            font-size: 0.875rem;
            font-weight: 600;
        }

        .container {
            max-width: 1200px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .header {
            margin-bottom: 3rem;
        }

        .header h1 {
            font-size: 2.25rem;
            font-weight: 800;
            margin-bottom: 0.5rem;
        }

        .header p {
            color: var(--text-secondary);
            font-size: 1.1rem;
        }

        .tabs {
            display: flex;
            gap: 1rem;
            margin-bottom: 2rem;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
            padding-bottom: 1rem;
        }

        .tab-btn {
            background: none;
            border: none;
            color: var(--text-secondary);
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            padding: 0.5rem 1rem;
            border-radius: 0.5rem;
            transition: all 0.2s;
        }

        .tab-btn.active {
            background-color: rgba(99, 102, 241, 0.1);
            color: var(--primary-color);
        }

        .section {
            display: none;
            animation: fadeIn 0.3s ease-out;
        }

        .section.active {
            display: block;
        }

        .table-container {
            background-color: var(--card-bg);
            border-radius: 1rem;
            overflow: hidden;
            border: 1px solid rgba(255, 255, 255, 0.05);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            text-align: left;
        }

        th {
            background-color: rgba(255, 255, 255, 0.02);
            padding: 1rem 1.5rem;
            color: var(--text-secondary);
            font-weight: 600;
            font-size: 0.875rem;
            text-transform: uppercase;
            letter-spacing: 0.05em;
        }

        td {
            padding: 1.25rem 1.5rem;
            border-top: 1px solid rgba(255, 255, 255, 0.05);
            font-size: 0.95rem;
        }

        .badge {
            padding: 0.25rem 0.75rem;
            border-radius: 9999px;
            font-size: 0.75rem;
            font-weight: 600;
        }

        .badge-verified {
            background-color: rgba(16, 185, 129, 0.1);
            color: var(--success);
        }

        .badge-pending {
            background-color: rgba(245, 158, 11, 0.1);
            color: #f59e0b;
        }

        .btn-action {
            padding: 0.5rem 1rem;
            border-radius: 0.5rem;
            font-size: 0.875rem;
            font-weight: 600;
            cursor: pointer;
            border: none;
            transition: all 0.2s;
            text-decoration: none;
            display: inline-block;
        }

        .btn-verify {
            background-color: var(--success);
            color: white;
            margin-right: 0.5rem;
        }

        .btn-unverify {
            background-color: #f59e0b;
            color: white;
            margin-right: 0.5rem;
        }

        .btn-delete {
            background-color: rgba(239, 68, 68, 0.1);
            color: var(--danger);
        }

        .btn-delete:hover {
            background-color: var(--danger);
            color: white;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(10px);
            }

            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        /* Modal Styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(15, 23, 42, 0.8);
            backdrop-filter: blur(4px);
        }

        .modal-content {
            background-color: var(--card-bg);
            margin: 5% auto;
            padding: 2rem;
            border-radius: 1rem;
            width: 90%;
            max-width: 800px;
            max-height: 85vh;
            overflow-y: auto;
            border: 1px solid rgba(255, 255, 255, 0.1);
            position: relative;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
        }

        .close {
            position: absolute;
            right: 1.5rem;
            top: 1rem;
            color: var(--text-secondary);
            font-size: 2rem;
            font-weight: bold;
            cursor: pointer;
            transition: color 0.2s;
        }

        .close:hover {
            color: var(--danger);
        }

        .details-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 1.5rem;
            margin-bottom: 2rem;
        }

        .detail-item {
            background-color: rgba(255, 255, 255, 0.02);
            padding: 1rem;
            border-radius: 0.75rem;
        }

        .detail-label {
            color: var(--text-secondary);
            font-size: 0.75rem;
            text-transform: uppercase;
            font-weight: 600;
            margin-bottom: 0.25rem;
        }

        .detail-value {
            font-size: 1.1rem;
            font-weight: 700;
        }

        .stats-section {
            margin-top: 2rem;
        }

        .stats-section h3 {
            color: var(--accent);
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
            padding-bottom: 0.5rem;
            margin-bottom: 1rem;
        }

        .mini-table {
            width: 100%;
            border-collapse: collapse;
            font-size: 0.85rem;
        }

        .mini-table th,
        .mini-table td {
            padding: 0.5rem;
            text-align: left;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/admin/dashboard" class="navbar-brand">AdminPanel</a>
        <div class="nav-links">
            <a href="/admin/dashboard" class="nav-link" style="color: var(--accent);">Admin Dashboard</a>
            <a href="/articles" class="nav-link">BLOG</a>
            <a href="/profile" class="nav-link">My Profile</a>
            <a href="/logout" class="btn-logout">Logout</a>
        </div>
    </nav>

    <div class="container">
        <div class="header">
            <h1>System Management</h1>
            <p>Monitor users, verify trainers, and manage accounts.</p>
        </div>

        <div class="tabs">
            <button class="tab-btn active" onclick="showSection('users', this)">Users</button>
            <button class="tab-btn" onclick="showSection('trainers', this)">Trainers</button>
        </div>

        <div id="users" class="section active">
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Username</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr th:each="user : ${users}">
                            <td th:text="${user.id}">1</td>
                            <td>
                                <a href="javascript:void(0)" th:onclick="'showUserStats(' + ${user.id} + ')'"
                                    th:text="${user.first} + ' ' + ${user.last}"
                                    style="color: var(--accent); text-decoration: none; font-weight: 600;">John Doe</a>
                            </td>
                            <td th:text="${user.username}">john@example.com</td>
                            <td>
                                <span th:if="${user.verifiedUser}" class="badge badge-verified">Verified</span>
                                <span th:unless="${user.verifiedUser}" class="badge badge-pending">Pending</span>
                            </td>
                            <td>
                                <form th:if="!${user.verifiedUser}"
                                    th:action="@{/admin/verify-user/{id}(id=${user.id})}" method="post"
                                    style="display: inline;">
                                    <button type="submit" class="btn-action btn-verify">Verify</button>
                                </form>
                                <form th:if="${user.verifiedUser}"
                                    th:action="@{/admin/unverify-user/{id}(id=${user.id})}" method="post"
                                    style="display: inline;">
                                    <button type="submit" class="btn-action btn-unverify">Unverify</button>
                                </form>
                                <form th:action="@{/admin/delete-user/{id}(id=${user.id})}" method="post"
                                    style="display: inline;"
                                    onsubmit="return confirm('Are you sure you want to delete this user?')">
                                    <button type="submit" class="btn-action btn-delete">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="trainers" class="section">
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr th:each="trainer : ${trainers}">
                            <td th:text="${trainer.id}">2</td>
                            <td>
                                <a href="javascript:void(0)" th:onclick="'showUserStats(' + ${trainer.id} + ')'"
                                    th:text="${trainer.first} + ' ' + ${trainer.last}"
                                    style="color: var(--accent); text-decoration: none; font-weight: 600;">Jane
                                    Smith</a>
                            </td>
                            <td>
                                <span th:if="${trainer.verifiedTrainer}" class="badge badge-verified">Verified</span>
                                <span th:unless="${trainer.verifiedTrainer}" class="badge badge-pending">Pending</span>
                            </td>
                            <td>
                                <form th:if="!${trainer.verifiedTrainer}"
                                    th:action="@{/admin/verify-trainer/{id}(id=${trainer.id})}" method="post"
                                    style="display: inline;">
                                    <button type="submit" class="btn-action btn-verify">Verify</button>
                                </form>
                                <form th:if="${trainer.verifiedTrainer}"
                                    th:action="@{/admin/unverify-trainer/{id}(id=${trainer.id})}" method="post"
                                    style="display: inline;">
                                    <button type="submit" class="btn-action btn-unverify">Unverify</button>
                                </form>
                                <form th:action="@{/admin/delete-user/{id}(id=${trainer.id})}" method="post"
                                    style="display: inline;"
                                    onsubmit="return confirm('Are you sure you want to delete this trainer?')">
                                    <button type="submit" class="btn-action btn-delete">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Stats Modal -->
    <div id="statsModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <div id="modalBody">
                <div style="text-align: center; padding: 3rem;">
                    <p style="color: var(--text-secondary);">Loading details...</p>
                </div>
            </div>
        </div>
    </div>

    <script>
        function showSection(sectionId, btn) {
            document.querySelectorAll('.section').forEach(s => s.classList.remove('active'));
            document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
            document.getElementById(sectionId).classList.add('active');
            btn.classList.add('active');
        }

        async function showUserStats(userId) {
            const modal = document.getElementById('statsModal');
            const modalBody = document.getElementById('modalBody');
            modal.style.display = 'block';
            modalBody.innerHTML = '<div style="text-align: center; padding: 3rem;"><p style="color: var(--text-secondary);">Loading details...</p></div>';

            try {
                const response = await fetch(`/admin/api/user-details/${userId}`);
                const data = await response.json();

                if (!data.user) {
                    modalBody.innerHTML = '<p>User not found.</p>';
                    return;
                }

                const user = data.user;
                const workouts = data.workouts || [];
                const meals = data.meals || [];

                let profileDetails = '';
                if (user.role === 'TRAINER') {
                    profileDetails = `
                        <div class="detail-item">
                            <div class="detail-label">Specialization</div>
                            <div class="detail-value">${user.specialization || 'Not specified'}</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-label">Experience</div>
                            <div class="detail-value">${user.experience || 'Not specified'}</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-label">Location / Contact</div>
                            <div class="detail-value">${user.trainerLocation || '--'} / ${user.contactNo || '--'}</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-label">Availability</div>
                            <div class="detail-value">${user.availability || '--'}</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-label">Verification Status</div>
                            <div class="detail-value">${user.verifiedTrainer ? '<span style="color: var(--success)">Verified</span>' : '<span style="color: #f59e0b">Pending</span>'}</div>
                        </div>
                    `;
                } else {
                    profileDetails = `
                        <div class="detail-item" style="grid-column: 1 / -1; display: flex; align-items: center; gap: 1rem;">
                            <img src="${user.profileImageUrl || '/images/default-avatar.png'}" style="width: 60px; height: 60px; border-radius: 50%; object-fit: cover; border: 2px solid var(--accent);" onerror="this.src='https://ui-avatars.com/api/?name=${user.first}+${user.last}&background=38bdf8&color=fff'">
                            <div>
                                <div class="detail-label">Profile Image</div>
                                <div class="detail-value">User Avatar</div>
                            </div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-label">Age / Height / Weight</div>
                            <div class="detail-value">${user.age || '--'} / ${user.height || '--'} cm / ${user.weight || '--'} kg</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-label">Assigned Trainer</div>
                            <div class="detail-value">${data.trainerName ? `${data.trainerName} (ID: ${user.assignedTrainerId})` : 'None'}</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-label">Verification Status</div>
                            <div class="detail-value">${user.verifiedUser ? '<span style="color: var(--success)">Verified</span>' : '<span style="color: #f59e0b">Pending</span>'}</div>
                        </div>
                    `;
                }

                let html = `
                    <h2 style="margin-top: 0;">${user.first} ${user.last}</h2>
                    <p style="color: var(--text-secondary); margin-top: -0.5rem; margin-bottom: 2rem;">${user.username} | ${user.role}</p>
                    
                    <div class="details-grid">
                        ${profileDetails}
                    </div>

                    ${user.role === 'USER' ? `
                        <div class="stats-section">
                            <h3>Recent Workouts (${workouts.length})</h3>
                            ${workouts.length > 0 ? `
                                <table class="mini-table">
                                    <thead>
                                        <tr>
                                            <th>Date</th>
                                            <th>Type</th>
                                            <th>Duration</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        ${workouts.slice(0, 5).map(w => `
                                            <tr>
                                                <td>${w.date}</td>
                                                <td>${w.type}</td>
                                                <td>${w.duration} min</td>
                                            </tr>
                                        `).join('')}
                                    </tbody>
                                </table>
                            ` : '<p style="color: var(--text-secondary); font-size: 0.9rem;">No workouts recorded.</p>'}
                        </div>

                        <div class="stats-section">
                            <h3>Diet Logs (${meals.length})</h3>
                            ${meals.length > 0 ? `
                                <table class="mini-table">
                                    <thead>
                                        <tr>
                                            <th>Date</th>
                                            <th>Meal</th>
                                            <th>Calories</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        ${meals.slice(0, 5).map(m => `
                                            <tr>
                                                <td>${m.date}</td>
                                                <td>${m.mealName}</td>
                                                <td>${m.calories} kcal</td>
                                            </tr>
                                        `).join('')}
                                    </tbody>
                                </table>
                            ` : '<p style="color: var(--text-secondary); font-size: 0.9rem;">No meals recorded.</p>'}
                        </div>
                    ` : ''}
                `;

                modalBody.innerHTML = html;
            } catch (error) {
                console.error('Error fetching details:', error);
                modalBody.innerHTML = '<p style="color: var(--danger)">Failed to load details.</p>';
            }
        }

        function closeModal() {
            document.getElementById('statsModal').style.display = 'none';
        }

        window.onclick = function (event) {
            const modal = document.getElementById('statsModal');
            if (event.target == modal) {
                closeModal();
            }
        }
    </script>
</body>

</html>
```

## src\main\resources\templates\admin-stats.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>User Stats - Admin Panel</title>
    <style>
        :root {
            --primary-color: #6366f1;
            --bg-color: #0f172a;
            --card-bg: #1e293b;
            --text-main: #f1f5f9;
            --text-secondary: #94a3b8;
            --accent: #38bdf8;
        }

        body {
            font-family: 'Inter', system-ui, -apple-system, sans-serif;
            background-color: var(--bg-color);
            color: var(--text-main);
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: var(--card-bg);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: 800;
            color: var(--accent);
            text-decoration: none;
        }

        .container {
            max-width: 1000px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .btn-back {
            color: var(--text-secondary);
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            gap: 0.5rem;
            margin-bottom: 1.5rem;
            font-weight: 500;
        }

        .btn-back:hover {
            color: var(--text-main);
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 1rem;
            padding: 2rem;
            margin-bottom: 2rem;
            border: 1px solid rgba(255, 255, 255, 0.05);
        }

        .section-title {
            font-size: 1.25rem;
            font-weight: 700;
            margin-bottom: 1.5rem;
            color: var(--accent);
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
            padding-bottom: 0.5rem;
        }

        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 1.5rem;
            margin-bottom: 2rem;
        }

        .stat-item {
            background-color: rgba(255, 255, 255, 0.02);
            padding: 1.25rem;
            border-radius: 0.75rem;
            text-align: center;
        }

        .stat-label {
            color: var(--text-secondary);
            font-size: 0.875rem;
            margin-bottom: 0.25rem;
        }

        .stat-value {
            font-size: 1.5rem;
            font-weight: 700;
            color: var(--text-main);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1rem;
        }

        th {
            text-align: left;
            color: var(--text-secondary);
            font-size: 0.875rem;
            padding: 0.75rem;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
        }

        td {
            padding: 0.75rem;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
            font-size: 0.9rem;
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/admin/dashboard" class="navbar-brand">AdminPanel</a>
    </nav>

    <div class="container">
        <a href="/admin/dashboard" class="btn-back">← Back to Dashboard</a>

        <div class="card">
            <h1 th:text="${targetUser.first} + ' ' + ${targetUser.last}">User Name</h1>
            <p th:text="${targetUser.username}" style="color: var(--text-secondary); margin-top: -1rem;">
                username@mail.com</p>

            <div class="stats-grid">
                <div class="stat-item">
                    <div class="stat-label">Role</div>
                    <div class="stat-value" th:text="${targetUser.role}">USER</div>
                </div>
                <div class="stat-item">
                    <div class="stat-label">Workouts</div>
                    <div class="stat-value" th:text="${#lists.size(workouts)}">0</div>
                </div>
                <div class="stat-item">
                    <div class="stat-label">Meals</div>
                    <div class="stat-value" th:text="${#lists.size(meals)}">0</div>
                </div>
                <div class="stat-item">
                    <div class="stat-label">Weight (Current)</div>
                    <div class="stat-value" th:text="${targetUser.weight} ?: 'N/A'">70</div>
                </div>
            </div>
        </div>

        <div class="card">
            <h2 class="section-title">Recent Workouts</h2>
            <table th:if="${!#lists.isEmpty(workouts)}">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Type</th>
                        <th>Duration</th>
                        <th>Calories</th>
                    </tr>
                </thead>
                <tbody>
                    <tr th:each="w : ${workouts}">
                        <td th:text="${w.date}">2023-01-01</td>
                        <td th:text="${w.type}">Running</td>
                        <td th:text="${w.duration} + ' min'">30 min</td>
                        <td th:text="${w.calories} + ' kcal'">300 kcal</td>
                    </tr>
                </tbody>
            </table>
            <p th:if="${#lists.isEmpty(workouts)}" style="color: var(--text-secondary);">No workouts recorded yet.</p>
        </div>

        <div class="card">
            <h2 class="section-title">Diet Logs</h2>
            <table th:if="${!#lists.isEmpty(meals)}">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Meal</th>
                        <th>Calories</th>
                    </tr>
                </thead>
                <tbody>
                    <tr th:each="m : ${meals}">
                        <td th:text="${m.date}">2023-01-01</td>
                        <td th:text="${m.mealName}">Breakfast</td>
                        <td th:text="${m.calories} + ' kcal'">400 kcal</td>
                    </tr>
                </tbody>
            </table>
            <p th:if="${#lists.isEmpty(meals)}" style="color: var(--text-secondary);">No meals recorded yet.</p>
        </div>
    </div>
</body>

</html>
```

## src\main\resources\templates\article-create.html
```html
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>Create Content - Health Tracker</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #6366f1;
            --primary-hover: #4f46e5;
            --bg-dark: #0f172a;
            --card-bg: #1e293b;
            --text-main: #f1f5f9;
            --text-secondary: #94a3b8;
            --success: #10b981;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg-dark);
            margin: 0;
            color: var(--text-main);
            min-height: 100vh;
        }

        .navbar {
            background-color: rgba(30, 41, 59, 0.7);
            backdrop-filter: blur(12px);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
        }

        .navbar-brand {
            font-size: 1.25rem;
            font-weight: 800;
            color: var(--primary-color);
            text-decoration: none;
        }

        .container {
            max-width: 700px;
            margin: 4rem auto;
            padding: 2.5rem;
            background-color: var(--card-bg);
            border-radius: 1.5rem;
            border: 1px solid rgba(255, 255, 255, 0.05);
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
        }

        .form-title {
            font-size: 1.75rem;
            font-weight: 800;
            margin-bottom: 2rem;
            text-align: center;
            letter-spacing: -0.025em;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            font-size: 0.9rem;
            color: var(--text-secondary);
        }

        .form-control {
            width: 100%;
            padding: 0.875rem 1rem;
            background-color: rgba(15, 23, 42, 0.5);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 0.75rem;
            color: var(--text-main);
            font-family: inherit;
            font-size: 1rem;
            transition: all 0.2s;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--primary-color);
            background-color: rgba(15, 23, 42, 0.8);
            box-shadow: 0 0 0 4px rgba(99, 102, 241, 0.1);
        }

        .type-selector {
            display: flex;
            gap: 1.5rem;
            background: rgba(15, 23, 42, 0.5);
            padding: 0.5rem;
            border-radius: 1rem;
            border: 1px solid rgba(255, 255, 255, 0.1);
        }

        .type-option {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
            cursor: pointer;
            padding: 0.75rem;
            border-radius: 0.75rem;
            font-weight: 600;
            font-size: 0.9rem;
            transition: all 0.2s;
            color: var(--text-secondary);
        }

        .type-option input {
            display: none;
        }

        .type-option:has(input:checked) {
            background-color: var(--primary-color);
            color: white;
        }

        .btn {
            width: 100%;
            padding: 1rem;
            border-radius: 0.75rem;
            font-weight: 700;
            font-size: 1rem;
            cursor: pointer;
            transition: all 0.2s;
            border: none;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
        }

        .btn-primary {
            background-color: var(--primary-color);
            color: white;
            margin-top: 2rem;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 15px -3px rgba(99, 102, 241, 0.3);
        }

        .btn-secondary {
            background: none;
            color: var(--text-secondary);
            font-weight: 500;
            margin-top: 1rem;
        }

        .btn-secondary:hover {
            color: var(--text-main);
        }

        .btn-logout {
            background-color: var(--danger);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 0.5rem;
            text-decoration: none;
            font-size: 0.8rem;
            font-weight: 700;
            transition: all 0.2s;
        }

        .btn-logout:hover {
            opacity: 0.9;
            transform: translateY(-1px);
        }
    </style>
</head>

<body>
    <nav class="navbar"
        style="background-color: #d4e7f7; box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1); padding: 1rem 2rem; display: flex; justify-content: space-between; align-items: center;">
        <a href="/welcome" class="navbar-brand"
            style="font-size: 1.5rem; font-weight: bold; color: #4F46E5; text-decoration: none;">HealthTracker</a>
        <div style="display: flex; gap: 1.5rem; align-items: center;">
            <a th:href="${#authorization.expression('hasRole(''ADMIN'')') ? '/admin/dashboard' : (#authorization.expression('hasRole(''TRAINER'')') ? '/trainer/dashboard' : '/welcome')}"
                style="color: #6B7280; text-decoration: none; font-weight: 600; font-size: 0.8rem; transition: color 0.2s;">DASHBOARD</a>
            <a href="/articles"
                style="color: #6B7280; text-decoration: none; font-weight: 600; font-size: 0.8rem; transition: color 0.2s;">CANCEL</a>
            <a href="/logout" class="btn-logout">LOGOUT</a>
        </div>
    </nav>

    <!-- ROBUST RESTRICTION CHECK -->
    <!-- We use toUpperCase() to handle "user", "User", "USER" etc. -->
    <div class="container"
        th:with="isUnverifiedUser=${user != null and user.role != null and user.role.toUpperCase() == 'USER' and !user.verifiedUser}">
        <h1 class="form-title">Create Blog</h1>

        <form id="blog-form">
            <div class="form-group">
                <label class="form-label">CONTENT TYPE</label>

                <div class="type-selector">
                    <!-- Article Option - COMPLETELY REMOVED if unverified USER -->
                    <label class="type-option" th:if="${!isUnverifiedUser}">
                        <input type="radio" name="contentType" value="ARTICLE" checked>
                        Article
                    </label>

                    <!-- Social Post Option - Checked by default if Article is hidden -->
                    <label class="type-option">
                        <input type="radio" name="contentType" value="POST" th:checked="${isUnverifiedUser}">
                        Social Post
                    </label>
                </div>

                <!-- Notice for unverified users -->
                <div id="verified-msg" th:if="${isUnverifiedUser}"
                    style="display:block; color: #94a3b8; font-size: 0.8rem; margin-top: 1rem; text-align: center; background: rgba(0,0,0,0.2); padding: 0.75rem; border-radius: 0.75rem; border: 1px solid rgba(255,255,255,0.05);">
                    <i class="bi bi-shield-lock-fill" style="color: var(--primary-color);"></i>
                    Publishing **Articles** with images is reserved for verified healthy living experts.
                    <br><span style="font-size: 0.75rem; opacity: 0.8;">Get verified by an admin to unlock this
                        feature.</span>
                </div>
            </div>

            <div class="form-group">
                <label class="form-label">TITLE</label>
                <input type="text" id="blog-title" class="form-control" placeholder="What's on your mind?" required>
            </div>

            <div class="form-group">
                <label class="form-label">CATEGORY</label>
                <select id="blog-category" class="form-control" required>
                    <option value="NUTRITION">Nutrition</option>
                    <option value="WORKOUT">Workout</option>
                    <option value="MENTAL_HEALTH">Mental Health</option>
                    <option value="TIPS">Tips</option>
                    <option value="SUCCESS_STORIES">Success Stories</option>
                </select>
            </div>

            <div class="form-group">
                <label class="form-label">CONTENT</label>
                <textarea id="blog-content" class="form-control" rows="8"
                    placeholder="Share your knowledge or experience..." required></textarea>
            </div>

            <div class="form-group" id="image-group">
                <label class="form-label">IMAGE URL (OPTIONAL)</label>
                <input type="url" id="blog-image-url" class="form-control" placeholder="https://example.com/image.jpg">
            </div>

            <div class="form-group" id="file-group">
                <label class="form-label">OR UPLOAD IMAGE</label>
                <input type="file" id="blog-image-file" class="form-control" accept="image/*">
            </div>

            <button type="submit" class="btn btn-primary">Publish Now</button>
            <a href="/articles" class="btn btn-secondary">Go Back</a>
        </form>
    </div>

    <script th:inline="javascript">
        function toggleImageField() {
            const checkedInput = document.querySelector('input[name="contentType"]:checked');
            const typeValue = checkedInput ? checkedInput.value : 'POST';
            const group = document.getElementById('image-group');
            const fileGroup = document.getElementById('file-group');

            if (group) group.style.display = typeValue === 'POST' ? 'none' : 'block';
            if (fileGroup) fileGroup.style.display = typeValue === 'POST' ? 'none' : 'block';
        }

        document.querySelectorAll('input[name="contentType"]').forEach(input => {
            input.addEventListener('change', toggleImageField);
        });

        toggleImageField();

        document.getElementById('blog-form').addEventListener('submit', async (e) => {
            e.preventDefault();

            const checkedInput = document.querySelector('input[name="contentType"]:checked');
            const typeValue = checkedInput ? checkedInput.value : 'POST';

            const blogData = {
                title: document.getElementById('blog-title').value,
                category: document.getElementById('blog-category').value,
                content: document.getElementById('blog-content').value,
                imageUrl: document.getElementById('blog-image-url').value,
                contentType: typeValue
            };

            const formData = new FormData();
            formData.append('blog', new Blob([JSON.stringify(blogData)], { type: 'application/json' }));

            const imageFile = document.getElementById('blog-image-file').files[0];
            if (imageFile) {
                formData.append('image', imageFile);
            }

            try {
                const response = await fetch('/api/blogs', {
                    method: 'POST',
                    body: formData
                });
                if (response.ok) window.location.href = '/articles';
                else if (response.status === 403) alert("Unauthorized: Unverified users cannot create Articles.");
                else alert("Failed to publish. Please check all fields.");
            } catch (error) {
                console.error('Error:', error);
                alert("Network error. Please try again.");
            }
        });
    </script>
</body>

</html>
```

## src\main\resources\templates\article-detail.html
```html
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>Post Detail - Health Tracker</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #6366f1;
            --primary-hover: #4f46e5;
            --bg-dark: #0f172a;
            --card-bg: #1e293b;
            --text-main: #f1f5f9;
            --text-secondary: #94a3b8;
            --danger: #ef4444;
            --success: #10b981;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg-dark);
            margin: 0;
            color: var(--text-main);
            line-height: 1.6;
        }

        .navbar {
            background-color: rgba(30, 41, 59, 0.7);
            backdrop-filter: blur(12px);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
            position: sticky;
            top: 0;
        }

        .navbar-brand {
            font-size: 1.25rem;
            font-weight: 800;
            color: var(--primary-color);
            text-decoration: none;
        }

        .container {
            max-width: 800px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .post-container {
            background-color: var(--card-bg);
            border-radius: 1.5rem;
            overflow: hidden;
            border: 1px solid rgba(255, 255, 255, 0.05);
            margin-bottom: 2rem;
        }

        .post-header {
            padding: 2.5rem;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
        }

        .post-category {
            font-size: 0.75rem;
            font-weight: 800;
            color: var(--primary-color);
            text-transform: uppercase;
            letter-spacing: 0.1em;
            margin-bottom: 1rem;
            display: block;
        }

        .post-title {
            font-size: 2.5rem;
            font-weight: 800;
            margin: 0 0 1.5rem 0;
            letter-spacing: -0.025em;
        }

        .post-meta {
            display: flex;
            align-items: center;
            gap: 1rem;
            color: var(--text-secondary);
            font-size: 0.9rem;
        }

        .author-avatar {
            width: 40px;
            height: 40px;
            background: rgba(99, 102, 241, 0.2);
            color: var(--primary-color);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-weight: 700;
        }

        .post-image {
            width: 100%;
            max-height: 450px;
            object-fit: cover;
        }

        .post-body {
            padding: 2.5rem;
            font-size: 1.125rem;
            color: var(--text-main);
            white-space: pre-wrap;
        }

        .post-footer {
            padding: 1.5rem 2.5rem;
            background: rgba(15, 23, 42, 0.3);
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-top: 1px solid rgba(255, 255, 255, 0.05);
        }

        .btn {
            padding: 0.6rem 1.25rem;
            border-radius: 0.75rem;
            font-weight: 700;
            font-size: 0.9rem;
            cursor: pointer;
            transition: all 0.2s;
            border: none;
            display: flex;
            align-items: center;
            gap: 0.5rem;
        }

        .btn-like {
            background-color: rgba(239, 68, 68, 0.1);
            color: var(--danger);
        }

        .btn-like.liked {
            background-color: var(--danger);
            color: white;
        }

        .btn-delete {
            background: rgba(239, 68, 68, 0.1);
            color: var(--danger);
        }

        .btn-edit {
            background: rgba(99, 102, 241, 0.1);
            color: var(--primary-color);
            text-decoration: none;
        }

        /* Comments Section */
        .comments-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 2rem;
        }

        .comment-input-area {
            background: var(--card-bg);
            padding: 1.5rem;
            border-radius: 1rem;
            margin-bottom: 2.5rem;
            border: 1px solid rgba(255, 255, 255, 0.05);
        }

        .comment-textarea {
            width: 100%;
            background: rgba(15, 23, 42, 0.3);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 0.75rem;
            padding: 1rem;
            color: var(--text-main);
            font-family: inherit;
            resize: none;
            margin-bottom: 1rem;
            box-sizing: border-box;
        }

        .comment-item {
            display: flex;
            gap: 1rem;
            margin-bottom: 2rem;
        }

        .comment-bubble {
            background: var(--card-bg);
            padding: 1.25rem;
            border-radius: 0 1.25rem 1.25rem 1.25rem;
            flex: 1;
            border: 1px solid rgba(255, 255, 255, 0.05);
        }

        .comment-author {
            font-weight: 700;
            font-size: 0.9rem;
            margin-bottom: 0.25rem;
            display: block;
        }

        .comment-text {
            font-size: 0.95rem;
            color: var(--text-main);
        }

        .comment-time {
            font-size: 0.75rem;
            color: var(--text-secondary);
            margin-top: 0.5rem;
            display: block;
        }

        .action-link {
            color: var(--danger);
            text-decoration: none;
            font-size: 0.8rem;
            font-weight: 600;
            margin-top: 0.5rem;
            background: none;
            border: none;
            cursor: pointer;
            padding: 0;
        }

        .btn-logout {
            background-color: var(--danger);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 0.5rem;
            text-decoration: none;
            font-size: 0.8rem;
            font-weight: 700;
            transition: all 0.2s;
        }

        .btn-logout:hover {
            opacity: 0.9;
            transform: translateY(-1px);
        }
    </style>
</head>

<body>
    <nav class="navbar"
        style="background-color: #d4e7f7; box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1); padding: 1rem 2rem; display: flex; justify-content: space-between; align-items: center;">
        <a href="/welcome" class="navbar-brand"
            style="font-size: 1.5rem; font-weight: bold; color: #4F46E5; text-decoration: none;">HealthTracker</a>
        <div style="display: flex; gap: 1.5rem; align-items: center;">
            <a th:href="${#authorization.expression('hasRole(''ADMIN'')') ? '/admin/dashboard' : (#authorization.expression('hasRole(''TRAINER'')') ? '/trainer/dashboard' : '/welcome')}"
                style="color: #6B7280; text-decoration: none; font-weight: 600; font-size: 0.8rem; transition: color 0.2s;">DASHBOARD</a>
            <a href="/articles"
                style="color: #6B7280; text-decoration: none; font-weight: 600; font-size: 0.8rem; transition: color 0.2s;">BACK</a>
            <a href="/logout" class="btn-logout">LOGOUT</a>
        </div>
    </nav>

    <div class="container">
        <article class="post-container">
            <header class="post-header">
                <span id="blog-category" class="post-category"></span>
                <h1 id="blog-title" class="post-title"></h1>
                <div class="post-meta">
                    <div id="author-initials" class="author-avatar"></div>
                    <div>
                        <span id="blog-author-name" style="display: block; font-weight: 600;"></span>
                        <span id="blog-date" class="post-date"></span>
                    </div>
                </div>
            </header>

            <img id="blog-image" src="" alt="" class="post-image" style="display: none;">

            <div id="blog-content" class="post-body"></div>

            <footer class="post-footer">
                <button id="like-btn" class="btn btn-like" onclick="toggleLike()">
                    ❤️ <span id="likes-count">0</span>
                </button>

                <div id="author-actions" style="display: none; gap: 0.75rem;">
                    <a id="edit-btn" href="#" class="btn btn-edit">Edit</a>
                    <button class="btn btn-delete" onclick="deleteBlog()">Delete</button>
                </div>
            </footer>
        </article>

        <section class="comments-section">
            <div class="comments-header">
                <h2 style="font-weight: 800; letter-spacing: -0.025em; margin: 0;">Comments (<span
                        id="comments-count">0</span>)</h2>
            </div>

            <div class="comment-input-area">
                <textarea id="comment-textarea" class="comment-textarea" rows="3"
                    placeholder="Write a comment..."></textarea>
                <button class="btn" style="background-color: var(--primary-color); color: white; margin-left: auto;"
                    onclick="submitComment()">Post Comment</button>
            </div>

            <div id="comment-list">
                <!-- Comments populated by JS -->
            </div>
        </section>
    </div>

    <script th:inline="javascript">
        const currentUser = /*[[${user != null ? user.first + ' ' + user.last : ''}]]*/ '';
        const currentUsername = /*[[${user != null ? user.username : ''}]]*/ '';
        const currentUserRole = /*[[${user != null ? user.role : ''}]]*/ '';

        const urlParams = new URLSearchParams(window.location.search);
        const blogId = urlParams.get('id');

        if (!blogId) window.location.href = '/articles';

        async function loadBlogDetail() {
            try {
                const response = await fetch(`/api/blogs/${blogId}`);
                const blog = await response.json();

                document.getElementById('blog-title').textContent = blog.title;
                document.getElementById('blog-category').textContent = blog.category;
                document.getElementById('blog-author-name').textContent = blog.authorName;
                document.getElementById('blog-date').textContent = new Date(blog.publishedDate).toLocaleDateString(undefined, { month: 'long', day: 'numeric', year: 'numeric' });
                document.getElementById('blog-content').textContent = blog.content;
                document.getElementById('likes-count').textContent = blog.likesCount;
                document.getElementById('comments-count').textContent = blog.commentsCount;

                const initials = blog.authorName.split(' ').map(n => n[0]).join('').toUpperCase();
                document.getElementById('author-initials').textContent = initials;

                if (blog.imageUrl && blog.contentType !== 'POST') {
                    const img = document.getElementById('blog-image');
                    img.src = blog.imageUrl;
                    img.style.display = 'block';
                } else {
                    document.getElementById('blog-image').style.display = 'none';
                }

                const normalizedSessionUser = currentUsername ? currentUsername.trim().toLowerCase() : '';
                const isAuthor = (blog.authorUsername && blog.authorUsername.trim().toLowerCase() === normalizedSessionUser) ||
                    (blog.authorName && blog.authorName.trim().toLowerCase() === normalizedSessionUser);

                const canManage = (currentUserRole === 'ADMIN') || isAuthor;

                if (canManage) {
                    document.getElementById('author-actions').style.display = 'flex';
                    document.getElementById('edit-btn').href = `/articles/edit?id=${blog.id}`;
                }

                loadComments();
                checkLikeStatus();
            } catch (error) {
                console.error(error);
                window.location.href = '/articles';
            }
        }

        async function loadComments() {
            const response = await fetch(`/api/blogs/${blogId}/comments`);
            const comments = await response.json();
            const list = document.getElementById('comment-list');
            list.innerHTML = '';

            comments.forEach(comment => {
                const initials = comment.userName.split(' ').map(n => n[0]).join('').toUpperCase();
                const div = document.createElement('div');
                div.className = 'comment-item';
                div.innerHTML = `
                    <div class="author-avatar" style="width: 32px; height: 32px; font-size: 0.8rem;">${initials}</div>
                    <div class="comment-bubble">
                        <span class="comment-author">${comment.userName}</span>
                        <div class="comment-text">${comment.commentText}</div>
                        <span class="comment-time">${new Date(comment.createdAt).toLocaleString()}</span>
                        ${comment.userName === currentUser ? `<button class="action-link" onclick="deleteComment(${comment.id})">Delete</button>` : ''}
                    </div>
                `;
                list.appendChild(div);
            });
        }

        async function submitComment() {
            const text = document.getElementById('comment-textarea').value.trim();
            if (!text) return;
            const response = await fetch(`/api/blogs/${blogId}/comments`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ userName: currentUser, commentText: text })
            });
            if (response.ok) {
                document.getElementById('comment-textarea').value = '';
                loadComments();
                const countEl = document.getElementById('comments-count');
                countEl.textContent = parseInt(countEl.textContent) + 1;
            }
        }

        async function toggleLike() {
            const response = await fetch(`/api/blogs/${blogId}/like`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ userName: currentUser })
            });
            const data = await response.json();
            document.getElementById('likes-count').textContent = data.likesCount;
            document.getElementById('like-btn').classList.toggle('liked', data.liked);
        }

        async function checkLikeStatus() {
            const response = await fetch(`/api/blogs/${blogId}/like-status?userName=${encodeURIComponent(currentUser)}`);
            const data = await response.json();
            document.getElementById('like-btn').classList.toggle('liked', data.liked);
        }

        async function deleteBlog() {
            if (!confirm('Delete this post?')) return;
            const response = await fetch(`/api/blogs/${blogId}`, { method: 'DELETE' });
            if (response.ok) window.location.href = '/articles';
        }

        async function deleteComment(id) {
            if (!confirm('Delete comment?')) return;
            const response = await fetch(`/api/blogs/comments/${id}`, { method: 'DELETE' });
            if (response.ok) {
                loadComments();
                const countEl = document.getElementById('comments-count');
                countEl.textContent = Math.max(0, parseInt(countEl.textContent) - 1);
            }
        }

        document.addEventListener('DOMContentLoaded', loadBlogDetail);
    </script>
</body>

</html>
```

## src\main\resources\templates\article-edit.html
```html
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>Edit Content - Health Tracker</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #6366f1;
            --primary-hover: #4f46e5;
            --bg-dark: #0f172a;
            --card-bg: #1e293b;
            --text-main: #f1f5f9;
            --text-secondary: #94a3b8;
            --success: #10b981;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg-dark);
            margin: 0;
            color: var(--text-main);
            min-height: 100vh;
        }

        .navbar {
            background-color: rgba(30, 41, 59, 0.7);
            backdrop-filter: blur(12px);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
        }

        .navbar-brand {
            font-size: 1.25rem;
            font-weight: 800;
            color: var(--primary-color);
            text-decoration: none;
        }

        .container {
            max-width: 700px;
            margin: 4rem auto;
            padding: 2.5rem;
            background-color: var(--card-bg);
            border-radius: 1.5rem;
            border: 1px solid rgba(255, 255, 255, 0.05);
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
        }

        .form-title {
            font-size: 1.75rem;
            font-weight: 800;
            margin-bottom: 2rem;
            text-align: center;
            letter-spacing: -0.025em;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            font-size: 0.9rem;
            color: var(--text-secondary);
        }

        .form-control {
            width: 100%;
            padding: 0.875rem 1rem;
            background-color: rgba(15, 23, 42, 0.5);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 0.75rem;
            color: var(--text-main);
            font-family: inherit;
            font-size: 1rem;
            transition: all 0.2s;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--primary-color);
            background-color: rgba(15, 23, 42, 0.8);
            box-shadow: 0 0 0 4px rgba(99, 102, 241, 0.1);
        }

        .btn {
            width: 100%;
            padding: 1rem;
            border-radius: 0.75rem;
            font-weight: 700;
            font-size: 1rem;
            cursor: pointer;
            transition: all 0.2s;
            border: none;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
        }

        .btn-primary {
            background-color: var(--primary-color);
            color: white;
            margin-top: 2rem;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 15px -3px rgba(99, 102, 241, 0.3);
        }

        .btn-secondary {
            background: none;
            color: var(--text-secondary);
            font-weight: 500;
            margin-top: 1rem;
        }

        .btn-secondary:hover {
            color: var(--text-main);
        }

        .btn-logout {
            background-color: var(--danger);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 0.5rem;
            text-decoration: none;
            font-size: 0.8rem;
            font-weight: 700;
            transition: all 0.2s;
        }

        .btn-logout:hover {
            opacity: 0.9;
            transform: translateY(-1px);
        }
    </style>
</head>

<body>
    <nav class="navbar"
        style="background-color: #d4e7f7; box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1); padding: 1rem 2rem; display: flex; justify-content: space-between; align-items: center;">
        <a href="/welcome" class="navbar-brand"
            style="font-size: 1.5rem; font-weight: bold; color: #4F46E5; text-decoration: none;">HealthTracker</a>
        <div style="display: flex; gap: 1.5rem; align-items: center;">
            <a th:href="${#authorization.expression('hasRole(''ADMIN'')') ? '/admin/dashboard' : (#authorization.expression('hasRole(''TRAINER'')') ? '/trainer/dashboard' : '/welcome')}"
                style="color: #6B7280; text-decoration: none; font-weight: 600; font-size: 0.8rem; transition: color 0.2s;">DASHBOARD</a>
            <a href="/articles"
                style="color: #6B7280; text-decoration: none; font-weight: 600; font-size: 0.8rem; transition: color 0.2s;">CANCEL</a>
            <a href="/logout" class="btn-logout">LOGOUT</a>
        </div>
    </nav>

    <div class="container">
        <h1 class="form-title">Edit Blog</h1>

        <form id="edit-form">
            <div class="form-group">
                <label class="form-label">CONTENT TYPE</label>
                <select id="blog-type" class="form-control" required>
                    <option value="ARTICLE">Article</option>
                    <option value="POST">Social Post</option>
                </select>
            </div>

            <div class="form-group">
                <label class="form-label">TITLE</label>
                <input type="text" id="blog-title" class="form-control" required>
            </div>

            <div class="form-group">
                <label class="form-label">CATEGORY</label>
                <select id="blog-category" class="form-control" required>
                    <option value="NUTRITION">Nutrition</option>
                    <option value="WORKOUT">Workout</option>
                    <option value="MENTAL_HEALTH">Mental Health</option>
                    <option value="TIPS">Tips</option>
                    <option value="SUCCESS_STORIES">Success Stories</option>
                </select>
            </div>

            <div class="form-group">
                <label class="form-label">CONTENT</label>
                <textarea id="blog-content" class="form-control" rows="8" required></textarea>
            </div>

            <div class="form-group" id="image-group">
                <label class="form-label">IMAGE URL (OPTIONAL)</label>
                <input type="url" id="blog-image-url" class="form-control" placeholder="https://example.com/image.jpg">
            </div>

            <div class="form-group" id="file-group">
                <label class="form-label">OR UPLOAD NEW IMAGE</label>
                <input type="file" id="blog-image-file" class="form-control" accept="image/*">
            </div>

            <button type="submit" class="btn btn-primary">Update Blog</button>
            <a href="/articles" id="cancel-btn" class="btn btn-secondary">Discard Changes</a>
        </form>
    </div>

    <script th:inline="javascript">
        const urlParams = new URLSearchParams(window.location.search);
        const blogId = urlParams.get('id');

        if (!blogId) window.location.href = '/articles';

        function toggleImageField() {
            const typeEl = document.getElementById('blog-type');
            const group = document.getElementById('image-group');
            if (typeEl && group) {
                group.style.display = typeEl.value === 'POST' ? 'none' : 'block';
            }
        }

        document.getElementById('blog-type').addEventListener('change', toggleImageField);

        async function loadBlogData() {
            try {
                const response = await fetch(`/api/blogs/${blogId}`);
                if (response.ok) {
                    const blog = await response.json();
                    document.getElementById('blog-title').value = blog.title;
                    document.getElementById('blog-category').value = blog.category;
                    document.getElementById('blog-content').value = blog.content;
                    document.getElementById('blog-image-url').value = blog.imageUrl || '';
                    if (document.getElementById('blog-type')) {
                        document.getElementById('blog-type').value = blog.contentType;
                    }
                    document.getElementById('cancel-btn').href = `/articles/detail?id=${blogId}`;
                    toggleImageField();
                } else {
                    window.location.href = '/articles';
                }
            } catch (error) {
                console.error('Error:', error);
            }
        }

        document.getElementById('edit-form').addEventListener('submit', async (e) => {
            e.preventDefault();
            const blogData = {
                title: document.getElementById('blog-title').value,
                category: document.getElementById('blog-category').value,
                content: document.getElementById('blog-content').value,
                imageUrl: document.getElementById('blog-image-url').value,
                contentType: document.getElementById('blog-type').value
            };

            const formData = new FormData();
            formData.append('blog', new Blob([JSON.stringify(blogData)], { type: 'application/json' }));

            const imageFile = document.getElementById('blog-image-file').files[0];
            if (imageFile) {
                formData.append('image', imageFile);
            }

            try {
                const response = await fetch(`/api/blogs/${blogId}`, {
                    method: 'PUT',
                    body: formData
                });
                if (response.ok) window.location.href = `/articles/detail?id=${blogId}`;
            } catch (error) {
                console.error('Error:', error);
            }
        });

        document.addEventListener('DOMContentLoaded', loadBlogData);
    </script>
</body>

</html>
```

## src\main\resources\templates\articles.html
```html
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>Blog - Health Tracker</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #6366f1;
            --primary-hover: #4f46e5;
            --bg-dark: #0f172a;
            --card-bg: #1e293b;
            --text-main: #f1f5f9;
            --text-secondary: #94a3b8;
            --danger: #ef4444;
            --success: #10b981;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg-dark);
            margin: 0;
            color: var(--text-main);
            min-height: 100vh;
        }

        /* Navbar Styles - Matched with Dashboard */
        .navbar {
            background-color: #d4e7f7;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: bold;
            color: #4F46E5;
            text-decoration: none;
        }

        .nav-links {
            display: flex;
            gap: 1.5rem;
            align-items: center;
        }

        .nav-link {
            text-decoration: none;
            color: #6B7280;
            font-weight: 500;
            transition: color 0.2s;
        }

        .nav-link:hover,
        .nav-link.active {
            color: #4F46E5;
        }

        /* Hero Section */
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 2rem 1.5rem;
        }

        .page-header {
            margin-bottom: 3rem;
        }

        .page-title {
            font-size: 2rem;
            font-weight: 800;
            margin: 0 0 2rem 0;
            letter-spacing: -0.025em;
        }

        /* Tabs */
        .tabs-nav {
            display: flex;
            gap: 2rem;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
            margin-bottom: 2rem;
        }

        .tab-btn {
            background: none;
            border: none;
            color: var(--text-secondary);
            padding: 0.75rem 0;
            font-size: 0.85rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            cursor: pointer;
            position: relative;
            transition: color 0.2s;
        }

        .tab-btn:hover {
            color: var(--text-main);
        }

        .tab-btn.active {
            color: var(--success);
        }

        .tab-btn.active::after {
            content: '';
            position: absolute;
            bottom: -1px;
            left: 0;
            width: 100%;
            height: 2px;
            background-color: var(--success);
        }

        /* Grid */
        .content-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(360px, 1fr));
            gap: 1.5rem;
        }

        /* Post Card Redesign */
        .post-card {
            background: linear-gradient(145deg, #1e293b, #1a2333);
            border-radius: 1.25rem;
            padding: 0;
            border: 1px solid rgba(255, 255, 255, 0.08);
            transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
            position: relative;
            display: flex;
            flex-direction: column;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
            overflow: hidden;
        }

        .post-card:hover {
            transform: translateY(-6px);
            border-color: rgba(99, 102, 241, 0.4);
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.2), 0 10px 10px -5px rgba(0, 0, 0, 0.04);
        }

        .post-image-wrapper {
            width: 100%;
            height: 200px;
            overflow: hidden;
            position: relative;
        }

        .post-image-wrapper img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: transform 0.3s;
        }

        .post-card:hover .post-image-wrapper img {
            transform: scale(1.05);
        }

        .post-card-content {
            padding: 1.75rem;
            display: flex;
            flex-direction: column;
            flex-grow: 1;
        }

        .post-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1.5rem;
        }

        .author-meta {
            display: flex;
            align-items: center;
            gap: 1rem;
        }

        .initials-avatar {
            width: 44px;
            height: 44px;
            background: linear-gradient(135deg, #6366f1, #4f46e5);
            color: white;
            border-radius: 12px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-weight: 800;
            font-size: 1rem;
            box-shadow: 0 4px 12px rgba(99, 102, 241, 0.3);
        }

        .author-info {
            display: flex;
            flex-direction: column;
            gap: 0.25rem;
        }

        .author-name {
            font-size: 0.95rem;
            font-weight: 700;
            color: var(--text-main);
            display: flex;
            align-items: center;
            gap: 0.6rem;
        }

        .badge-type {
            font-size: 0.6rem;
            font-weight: 800;
            padding: 0.2rem 0.6rem;
            border-radius: 6px;
            text-transform: uppercase;
            letter-spacing: 0.05em;
        }

        .badge-user {
            background: rgba(16, 185, 129, 0.15);
            color: var(--success);
        }

        .badge-trainer {
            background: rgba(99, 102, 241, 0.15);
            color: var(--primary-color);
        }

        .badge-admin {
            background: rgba(239, 68, 68, 0.15);
            color: var(--danger);
        }

        .post-category {
            font-size: 0.65rem;
            color: var(--primary-color);
            background: rgba(99, 102, 241, 0.1);
            padding: 0.3rem 0.75rem;
            border-radius: 2rem;
            font-weight: 800;
            letter-spacing: 0.075em;
            text-transform: uppercase;
        }

        .post-date {
            font-size: 0.8rem;
            color: var(--text-secondary);
            font-weight: 500;
        }

        .post-title {
            font-size: 1.4rem;
            font-weight: 800;
            margin: 0 0 1rem 0;
            color: var(--text-main);
            text-decoration: none;
            line-height: 1.3;
            transition: color 0.2s;
        }

        .post-title:hover {
            color: var(--primary-color);
        }

        .post-excerpt {
            font-size: 1rem;
            color: var(--text-secondary);
            line-height: 1.6;
            margin-bottom: 2rem;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            line-clamp: 3;
            -webkit-box-orient: vertical;
            overflow: hidden;
            flex-grow: 1;
        }

        .post-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding-top: 1.5rem;
            border-top: 1px solid rgba(255, 255, 255, 0.05);
        }

        .interaction-group {
            display: flex;
            gap: 0.5rem;
        }

        .icon-btn {
            background: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(255, 255, 255, 0.05);
            color: var(--text-secondary);
            padding: 0.6rem 1rem;
            border-radius: 0.75rem;
            font-size: 0.85rem;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.2s;
            display: flex;
            align-items: center;
            gap: 0.5rem;
        }

        .icon-btn:hover {
            background: rgba(255, 255, 255, 0.1);
            color: var(--text-main);
            transform: translateY(-1px);
        }

        .admin-actions {
            display: flex;
            gap: 0.5rem;
        }

        .btn-edit {
            color: var(--primary-color);
            background: rgba(99, 102, 241, 0.1);
            border: 1px solid rgba(99, 102, 241, 0.2);
            padding: 0.5rem 1rem;
            border-radius: 0.75rem;
            text-decoration: none;
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            transition: all 0.2s;
        }

        .btn-edit:hover {
            background: var(--primary-color);
            color: white;
        }

        .btn-delete {
            background: rgba(239, 68, 68, 0.1);
            color: var(--danger);
            border: 1px solid rgba(239, 68, 68, 0.2);
            padding: 0.5rem 1rem;
            border-radius: 0.75rem;
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            cursor: pointer;
            transition: all 0.2s;
        }

        .btn-delete:hover {
            background: var(--danger);
            color: white;
        }

        .create-btn {
            background: var(--success);
            color: white;
            padding: 0.75rem 1.5rem;
            border-radius: 0.5rem;
            text-decoration: none;
            font-weight: 700;
            font-size: 0.9rem;
            transition: opacity 0.2s;
        }

        .quick-comment-area {
            display: none;
            margin-top: 1rem;
            padding-top: 1rem;
            border-top: 1px solid rgba(255, 255, 255, 0.05);
        }

        .comment-input {
            width: 100%;
            background: rgba(15, 23, 42, 0.3);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 0.5rem;
            padding: 0.75rem;
            color: var(--text-main);
            font-family: inherit;
            font-size: 0.85rem;
            resize: none;
            margin-bottom: 0.5rem;
            box-sizing: border-box;
        }

        .btn-logout {
            background-color: var(--danger);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 0.5rem;
            text-decoration: none;
            font-size: 0.8rem;
            font-weight: 700;
            transition: all 0.2s;
        }

        .btn-logout:hover {
            opacity: 0.9;
            transform: translateY(-1px);
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/welcome" class="navbar-brand">HealthTracker</a>
        <div class="nav-links">
            <a th:href="${#authorization.expression('hasRole(''ADMIN'')') ? '/admin/dashboard' : (#authorization.expression('hasRole(''TRAINER'')') ? '/trainer/dashboard' : '/welcome')}"
                class="nav-link">DASHBOARD</a>
            <a href="/articles" class="nav-link active">BLOG</a>
            <a href="/logout" class="btn-logout">LOGOUT</a>
        </div>
    </nav>

    <div class="container">
        <div class="page-header">
            <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 2rem;">
                <h1 class="page-title" style="margin: 0;">Blogs</h1>
                <a href="/articles/create" class="create-btn"
                    style="position: static; box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);">+ Create New</a>
            </div>

            <div class="tabs-nav">
                <button class="tab-btn" onclick="applyFilter({contentType: 'POST'}, this)">Posts</button>
                <button class="tab-btn" onclick="applyFilter({contentType: 'ARTICLE'}, this)">Articles</button>
                <button class="tab-btn active" onclick="applyFilter({}, this)">Community</button>
            </div>
        </div>

        <div id="content-grid" class="content-grid">

            <div id="content-grid" class="content-grid">
                <!-- Dynamically populated -->
            </div>

            <div style="position: fixed; bottom: 2rem; right: 2rem;">
                <a href="/articles/create" class="create-btn">+ Create</a>
            </div>
        </div>

        <script th:inline="javascript">
            const currentUserRole = /*[[${user != null ? user.role : ''}]]*/ '';
            const currentUsername = /*[[${user != null ? user.username : ''}]]*/ '';
            const currentUserFullName = /*[[${user != null ? user.first + ' ' + user.last : ''}]]*/ '';

            async function loadContent(params = {}) {
                let url = '/api/blogs';
                const searchParams = new URLSearchParams();
                for (const [key, value] of Object.entries(params)) {
                    if (value && value !== 'ALL') searchParams.append(key, value);
                }

                const queryString = searchParams.toString();
                if (queryString) url += `?${queryString}`;

                try {
                    const response = await fetch(url);
                    const posts = await response.json();
                    renderPosts(posts, params);
                } catch (error) {
                    console.error('Error loading content:', error);
                }
            }

            function renderPosts(posts, activeParams) {
                const grid = document.getElementById('content-grid');
                grid.innerHTML = '';

                const isCommunity = !activeParams.authorType && (!activeParams.contentType || activeParams.contentType === 'ALL');

                if (posts.length === 0) {
                    grid.innerHTML = '<p style="grid-column: 1/-1; text-align: center; color: var(--text-secondary); padding: 4rem;">No content found here.</p>';
                    return;
                }

                if (isCommunity) {
                    const userPosts = posts.filter(p => (p.contentType || (p.authorType === 'USER' ? 'POST' : 'ARTICLE')) === 'POST');
                    const articles = posts.filter(p => (p.contentType || (p.authorType === 'USER' ? 'POST' : 'ARTICLE')) === 'ARTICLE');

                    const postsSection = document.createElement('div');
                    postsSection.style.gridColumn = '1 / -1';
                    postsSection.innerHTML = `
                        <h2 style="color: var(--success); font-size: 1.1rem; margin-bottom: 1.5rem; display: flex; align-items: center; gap: 0.75rem; letter-spacing: 0.05em;">
                            <span style="width: 4px; height: 1.2rem; background: var(--success); border-radius: 2px;"></span>
                            POSTS
                        </h2>
                        <div class="content-grid" id="posts-subgrid" style="display: grid; grid-template-columns: repeat(auto-fill, minmax(360px, 1fr)); gap: 1.5rem; margin-bottom: 4rem;">
                            ${userPosts.length === 0 ? '<p style="color: var(--text-secondary); font-style: italic;">No posts yet.</p>' : ''}
                        </div>
                    `;
                    grid.appendChild(postsSection);
                    if (userPosts.length > 0) {
                        const subgrid = document.getElementById('posts-subgrid');
                        userPosts.forEach(post => subgrid.appendChild(createPostCard(post)));
                    }

                    const articlesSection = document.createElement('div');
                    articlesSection.style.gridColumn = '1 / -1';
                    articlesSection.innerHTML = `
                        <h2 style="color: var(--primary-color); font-size: 1.1rem; margin-bottom: 1.5rem; display: flex; align-items: center; gap: 0.75rem; letter-spacing: 0.05em;">
                            <span style="width: 4px; height: 1.2rem; background: var(--primary-color); border-radius: 2px;"></span>
                            ARTICLES
                        </h2>
                        <div class="content-grid" id="articles-subgrid" style="display: grid; grid-template-columns: repeat(auto-fill, minmax(360px, 1fr)); gap: 1.5rem;">
                            ${articles.length === 0 ? '<p style="color: var(--text-secondary); font-style: italic;">No articles yet.</p>' : ''}
                        </div>
                    `;
                    grid.appendChild(articlesSection);
                    if (articles.length > 0) {
                        const subgrid = document.getElementById('articles-subgrid');
                        articles.forEach(post => subgrid.appendChild(createPostCard(post)));
                    }
                } else {
                    posts.forEach(post => grid.appendChild(createPostCard(post)));
                }
            }

            function applyFilter(params, btn) {
                document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
                btn.classList.add('active');
                loadContent(params);
            }

            function filterByRole(role, btn) {
                applyFilter({ authorType: role }, btn);
            }

            function createPostCard(post) {
                const initials = post.authorName ? post.authorName.split(' ').map(n => n[0]).join('').toUpperCase() : '??';
                const roleClass = `badge-${post.authorType.toLowerCase()}`;

                let imageHtml = '';
                if (post.imageUrl && post.contentType === 'ARTICLE') {
                    imageHtml = `
                    <div class="post-image-wrapper">
                        <img src="${post.imageUrl}" alt="${post.title}" onerror="this.style.display='none'">
                    </div>
                    `;
                }

                const card = document.createElement('div');
                card.className = 'post-card';
                card.innerHTML = `
                ${imageHtml}
                <div class="post-card-content">
                    <div style="display: flex; justify-content: flex-end; margin-bottom: 1rem;">
                        <span class="post-category">${post.category}</span>
                    </div>

                    <div class="post-header">
                        <div class="author-meta">
                            <div class="initials-avatar">${initials}</div>
                            <div class="author-info">
                                <div class="author-name">
                                    ${post.authorName}
                                    <span class="badge-type ${roleClass}">${post.authorType}</span>
                                </div>
                                <span class="post-date">${new Date(post.publishedDate).toLocaleDateString()}</span>
                            </div>
                        </div>
                    </div>
                    
                    <a href="/articles/detail?id=${post.id}" class="post-title">${post.title}</a>
                    <p class="post-excerpt">${post.content}</p>
                    
                    <div class="post-footer">
                        <div class="interaction-group">
                            <button class="icon-btn" onclick="toggleLikeListing(${post.id}, this)" title="Like">
                                ❤️ <span class="likes-count">${post.likesCount}</span>
                            </button>
                            <button class="icon-btn" onclick="toggleCommentArea(${post.id})" title="Comment">
                                💬 <span id="count-${post.id}">${post.commentsCount}</span>
                            </button>
                            <button class="icon-btn" onclick="window.location.href='/articles/detail?id=${post.id}'" title="View Full">
                                <img src="https://api.iconify.design/solar:arrow-right-up-bold-duotone.svg?color=%2394a3b8" width="18">
                            </button>
                        </div>
                    </div>

                    <div id="comment-area-${post.id}" class="quick-comment-area">
                        <textarea class="comment-input" id="input-${post.id}" placeholder="Write a quick comment..."></textarea>
                        <button class="btn-send-comment" onclick="submitQuickComment(${post.id})">Post</button>
                        <div style="clear:both;"></div>
                    </div>
                </div>
            `;
                return card;
            }

            function toggleCommentArea(id) {
                const area = document.getElementById(`comment-area-${id}`);
                area.style.display = area.style.display === 'block' ? 'none' : 'block';
                if (area.style.display === 'block') {
                    document.getElementById(`input-${id}`).focus();
                }
            }

            async function toggleLikeListing(blogId, btn) {
                if (!currentUserFullName) {
                    alert('Please login to like this post');
                    return;
                }
                try {
                    const response = await fetch(`/api/blogs/${blogId}/like`, {
                        method: 'POST',
                        headers: { 'Content-Type': 'application/json' },
                        body: JSON.stringify({ userName: currentUserFullName })
                    });

                    const data = await response.json();
                    btn.querySelector('.likes-count').textContent = data.likesCount;
                } catch (error) {
                    console.error('Error toggling like:', error);
                }
            }

            async function submitQuickComment(blogId) {
                if (!currentUserFullName) {
                    alert('Please login to comment');
                    return;
                }
                const input = document.getElementById(`input-${blogId}`);
                const text = input.value.trim();
                if (!text) return;

                try {
                    const response = await fetch(`/api/blogs/${blogId}/comments`, {
                        method: 'POST',
                        headers: { 'Content-Type': 'application/json' },
                        body: JSON.stringify({
                            userName: currentUserFullName,
                            commentText: text
                        })
                    });

                    if (response.ok) {
                        input.value = '';
                        toggleCommentArea(blogId);
                        const countEl = document.getElementById(`count-${blogId}`);
                        countEl.textContent = parseInt(countEl.textContent) + 1;
                        alert('Comment posted successfully!');
                    }
                } catch (error) {
                    console.error('Error posting quick comment:', error);
                }
            }

            async function deletePost(id) {
                if (!confirm('Are you sure you want to delete this content?')) return;
                try {
                    const response = await fetch(`/api/blogs/${id}`, { method: 'DELETE' });
                    if (response.ok) {
                        loadContent();
                    }
                } catch (error) {
                    console.error('Delete error:', error);
                }
            }

            document.addEventListener('DOMContentLoaded', () => loadContent());
        </script>
</body>

</html>
```

## src\main\resources\templates\assign-plan.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Assign Plan - Health Tracker</title>
    <style>
        :root {
            --primary-color: #4F46E5;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-dark: #1e293b;
        }

        body {
            font-family: 'Outfit', sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            color: white;
        }

        .navbar {
            background-color: var(--card-bg);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .container {
            max-width: 900px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .form-section {
            background: var(--card-bg);
            border-radius: 1rem;
            padding: 2rem;
            color: var(--text-dark);
            margin-bottom: 2rem;
        }

        .form-group {
            margin-bottom: 1.25rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid #cbd5e1;
            border-radius: 0.5rem;
            box-sizing: border-box;
        }

        .btn-submit {
            background: var(--primary-color);
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 0.5rem;
            cursor: pointer;
            font-weight: 600;
            width: 100%;
        }

        .plan-list {
            margin-top: 1rem;
        }

        .plan-item {
            background: white;
            padding: 1rem;
            border-radius: 0.5rem;
            margin-bottom: 0.5rem;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <div style="display: flex; align-items: center; gap: 1rem;">
            <a href="/trainer/dashboard"
                style="color: var(--primary-color); text-decoration: none; font-weight: bold;">← Back to Clients</a>
            <a href="/articles" style="color: var(--text-dark); text-decoration: none; margin-left: 1rem;">BLOG</a>
            <a href="/community"
                style="color: var(--text-dark); text-decoration: none; margin-left: 1rem;">Community</a>
            <a href="/profile" style="color: var(--text-dark); text-decoration: none; margin-left: 1rem;">My Profile</a>
        </div>
        <h2 th:text="'Assigning Plan for ' + ${user.first}" style="color: var(--text-dark); margin: 0;">Assign Plan</h2>
        <a href="/logout" style="color: #ef4444; text-decoration: none;">Logout</a>
    </nav>

    <div class="container">
        <!-- Diet Plan Section -->
        <div class="form-section">
            <h3>Add Diet Entry</h3>
            <form action="/trainer/assign-diet" method="post">
                <input type="hidden" name="userId" th:value="${user.id}">
                <div class="form-group">
                    <label class="form-label">Day of Week</label>
                    <select name="dayOfWeek" class="form-control">
                        <option value="Monday">Monday</option>
                        <option value="Tuesday">Tuesday</option>
                        <option value="Wednesday">Wednesday</option>
                        <option value="Thursday">Thursday</option>
                        <option value="Friday">Friday</option>
                        <option value="Saturday">Saturday</option>
                        <option value="Sunday">Sunday</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="form-label">Meal Name</label>
                    <input type="text" name="mealName" class="form-control" placeholder="e.g. Oatmeal with Fruits"
                        required>
                </div>
                <div class="form-group">
                    <label class="form-label">Calories</label>
                    <input type="number" name="calories" class="form-control" placeholder="e.g. 450" required>
                </div>
                <div class="form-group">
                    <label class="form-label">Notes</label>
                    <textarea name="description" class="form-control" rows="2"></textarea>
                </div>
                <button type="submit" class="btn-submit">Add to Diet Plan</button>
            </form>

            <div class="plan-list">
                <h4>Existing Diet Entries</h4>
                <div th:each="diet : ${dietPlans}" class="plan-item">
                    <strong th:text="${diet.dayOfWeek} + ': ' + ${diet.mealName}"></strong>
                    <span th:text="'(' + ${diet.calories} + ' cal)'"></span>
                    <p th:text="${diet.description}" style="margin: 0.25rem 0 0; font-size: 0.9rem; color: #64748b;">
                    </p>
                </div>
            </div>
        </div>

        <!-- Exercise Plan Section -->
        <div class="form-section">
            <h3>Add Exercise Entry</h3>
            <form action="/trainer/assign-exercise" method="post">
                <input type="hidden" name="userId" th:value="${user.id}">
                <div class="form-group">
                    <label class="form-label">Day of Week</label>
                    <select name="dayOfWeek" class="form-control">
                        <option value="Monday">Monday</option>
                        <option value="Tuesday">Tuesday</option>
                        <option value="Wednesday">Wednesday</option>
                        <option value="Thursday">Thursday</option>
                        <option value="Friday">Friday</option>
                        <option value="Saturday">Saturday</option>
                        <option value="Sunday">Sunday</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="form-label">Exercise Name</label>
                    <input type="text" name="exerciseName" class="form-control" placeholder="e.g. Bench Press" required>
                </div>
                <div style="display: flex; gap: 1rem;">
                    <div class="form-group" style="flex: 1;">
                        <label class="form-label">Sets</label>
                        <input type="number" name="sets" class="form-control" required>
                    </div>
                    <div class="form-group" style="flex: 1;">
                        <label class="form-label">Reps</label>
                        <input type="number" name="reps" class="form-control" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="form-label">Description</label>
                    <textarea name="description" class="form-control" rows="2"></textarea>
                </div>
                <button type="submit" class="btn-submit">Add to Workout Plan</button>
            </form>

            <div class="plan-list">
                <h4>Existing Workout Entries</h4>
                <div th:each="ex : ${exercisePlans}" class="plan-item">
                    <strong th:text="${ex.dayOfWeek} + ': ' + ${ex.exerciseName}"></strong>
                    <span th:text="${ex.sets} + ' sets x ' + ${ex.reps} + ' reps'"></span>
                    <p th:text="${ex.description}" style="margin: 0.25rem 0 0; font-size: 0.9rem; color: #64748b;"></p>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
```

## src\main\resources\templates\bmi_calculator.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>BMI Calculator - Health Tracker</title>
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-main: #d4e7f7;
            --text-card: #242d3f;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --input-border: #cbd5e1;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: var(--text-main);
        }

        .navbar {
            background-color: var(--card-bg);
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: bold;
            color: var(--primary-color);
            text-decoration: none;
        }

        .nav-links {
            display: flex;
            gap: 1.5rem;
            align-items: center;
        }

        .nav-link {
            text-decoration: none;
            color: var(--text-secondary);
            font-weight: 500;
            transition: color 0.2s;
        }

        .nav-link:hover {
            color: var(--primary-color);
        }

        .btn-logout {
            background-color: var(--danger-color);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 0.375rem;
            text-decoration: none;
            font-size: 0.875rem;
            transition: opacity 0.2s;
        }

        .btn-logout:hover {
            opacity: 0.9;
        }

        .container {
            max-width: 600px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .page-header {
            text-align: center;
            margin-bottom: 3rem;
        }

        .page-header h1 {
            font-size: 2.5rem;
            margin-bottom: 0.5rem;
            color: var(--text-main);
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            color: var(--text-card);
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: var(--text-card);
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--input-border);
            border-radius: 0.5rem;
            font-size: 1rem;
            box-sizing: border-box;
            font-family: inherit;
        }

        .btn-submit {
            background-color: #D97706;
            /* Orange color from mockup */
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 2rem;
            /* Rounded pill shape */
            font-size: 1rem;
            font-weight: bold;
            cursor: pointer;
            width: 100%;
            transition: opacity 0.2s;
        }

        .btn-submit:hover {
            opacity: 0.9;
        }

        .result-section {
            margin-top: 2rem;
            text-align: center;
            padding-top: 2rem;
            border-top: 1px solid rgba(0, 0, 0, 0.1);
        }

        .text-green {
            color: #059669;
        }

        .text-orange {
            color: #D97706;
        }

        .text-red {
            color: #DC2626;
        }

        /* Dropdown Styles */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: var(--card-bg);
            min-width: 160px;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            z-index: 1;
            border-radius: 0.375rem;
            top: 100%;
        }

        .dropdown-content a {
            color: var(--text-secondary);
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            font-weight: 400;
        }

        .dropdown-content a:hover {
            background-color: rgba(79, 70, 229, 0.1);
            color: var(--primary-color);
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/welcome" class="navbar-brand">HealthTracker</a>
        <div class="nav-links">
            <div class="dropdown">
                <a href="#" class="nav-link">Activity ▾</a>
                <div class="dropdown-content">
                    <a href="/workouts">Workouts</a>
                    <a href="/meals">Meals</a>
                    <a href="/daily-logs">Daily Log</a>
                </div>
            </div>
            <a href="/welcome" class="nav-link">Dashboard</a>
            <a href="/profile" class="nav-link">My Profile</a>
            <a href="/logout" class="btn-logout">Logout</a>
        </div>
    </nav>

    <div class="container">
        <div class="page-header">
            <h1>BMI Calculator</h1>
            <p style="color: #d4e7f7;">Calculate your Body Mass Index</p>
        </div>

        <div class="card">
            <form action="/calculate-bmi" method="post">
                <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 1rem;">
                    <div class="form-group">
                        <label class="form-label">Height (cm)</label>
                        <input type="number" step="any" name="height" class="form-control" placeholder="Enter height"
                            required th:value="${height}">
                    </div>
                    <div class="form-group">
                        <label class="form-label">Weight (kg)</label>
                        <input type="number" step="any" name="weight" class="form-control" placeholder="Enter weight"
                            required th:value="${weight}">
                    </div>
                </div>
                <!-- Error display -->
                <div th:if="${error}" style="color: #DC2626; margin-bottom: 1rem; text-align: center;">
                    <span th:text="${error}"></span>
                </div>

                <button type="submit" class="btn-submit">Calculate BMI</button>
            </form>

            <div th:if="${bmiValue}" class="result-section">
                <div style="font-size: 1.1rem; color: var(--text-secondary); margin-bottom: 0.5rem;">Your BMI Result
                </div>
                <div style="font-size: 3rem; font-weight: bold; color: var(--text-card); line-height: 1;"
                    th:text="${bmiValue}">22.5</div>

                <div style="margin: 1rem 0; font-weight: bold; font-size: 1.25rem;" th:class="${colorClass}"
                    th:text="${bmiStatus}">Normal</div>

                <div style="color: var(--text-secondary);" th:text="${bmiGuidance}">
                    Guidance text here.
                </div>
            </div>
        </div>
    </div>
</body>

</html>
```

## src\main\resources\templates\community.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>Community Feed - Health Tracker</title>
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-main: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --accent: #38bdf8;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: var(--text-main);
        }

        .navbar {
            background-color: var(--card-bg);
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: bold;
            color: var(--primary-color);
            text-decoration: none;
        }

        .nav-links {
            display: flex;
            gap: 1.5rem;
            align-items: center;
        }

        .nav-link {
            text-decoration: none;
            color: var(--text-secondary);
            font-weight: 500;
            transition: color 0.2s;
        }

        .nav-link:hover {
            color: var(--primary-color);
        }

        .container {
            max-width: 800px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .header {
            text-align: center;
            margin-bottom: 3rem;
        }

        .section-title {
            font-size: 2.5rem;
            font-weight: 800;
            color: var(--accent);
            margin-bottom: 0.5rem;
        }

        .feed-container {
            display: flex;
            flex-direction: column;
            gap: 2rem;
        }

        .post-card {
            background-color: var(--card-bg);
            border-radius: 1rem;
            padding: 1.5rem;
            color: #242d3f;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
        }

        .post-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1rem;
        }

        .author-info {
            display: flex;
            align-items: center;
            gap: 0.75rem;
        }

        .author-name {
            font-weight: 700;
            font-size: 1rem;
        }

        .badge-type {
            font-size: 0.7rem;
            font-weight: 800;
            text-transform: uppercase;
            padding: 0.2rem 0.6rem;
            border-radius: 999px;
        }

        .badge-article {
            background-color: rgba(79, 70, 229, 0.1);
            color: var(--primary-color);
        }

        .badge-post {
            background-color: rgba(16, 185, 129, 0.1);
            color: #10b981;
        }

        .post-title {
            font-size: 1.25rem;
            font-weight: 700;
            margin-bottom: 0.75rem;
            display: block;
            text-decoration: none;
            color: inherit;
        }

        .post-content {
            font-size: 0.95rem;
            line-height: 1.6;
            margin-bottom: 1rem;
            color: #4b5563;
        }

        .post-footer {
            display: flex;
            gap: 1.5rem;
            border-top: 1px solid rgba(0, 0, 0, 0.05);
            padding-top: 1rem;
            font-size: 0.9rem;
            color: #6b7280;
        }

        .interaction {
            display: flex;
            align-items: center;
            gap: 0.4rem;
            cursor: pointer;
        }

        .interaction:hover {
            color: var(--primary-color);
        }

        .btn-create {
            position: fixed;
            bottom: 2rem;
            right: 2rem;
            background-color: var(--primary-color);
            color: white;
            padding: 1rem 1.5rem;
            border-radius: 2rem;
            text-decoration: none;
            font-weight: 600;
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s;
        }

        .btn-create:hover {
            transform: scale(1.05);
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/welcome" class="navbar-brand">HealthTracker</a>
        <div class="nav-links">
            <a href="/articles" class="nav-link">BLOG</a>
            <a href="/community" class="nav-link" style="color: var(--primary-color);">Community</a>
            <a href="/profile" class="nav-link">My Profile</a>
            <a href="/logout" class="nav-link">Logout</a>
        </div>
    </nav>

    <div class="container">
        <div class="header">
            <h1 class="section-title">Community Feed</h1>
            <p style="color: var(--text-secondary);">Connect and share with the HealthTracker community.</p>
        </div>

        <div id="feed" class="feed-container">
            <!-- Feed items will be loaded here -->
        </div>
    </div>

    <a href="/articles/create" class="btn-create">+ Share Something</a>

    <script th:inline="javascript">
        async function loadFeed() {
            try {
                const response = await fetch('/api/blogs');
                const posts = await response.json();
                renderFeed(posts);
            } catch (error) {
                console.error('Error loading feed:', error);
            }
        }

        function renderFeed(posts) {
            const feed = document.getElementById('feed');
            feed.innerHTML = '';

            if (posts.length === 0) {
                feed.innerHTML = '<p style="text-align: center; color: #94a3b8;">No posts yet. Be the first to share!</p>';
                return;
            }

            posts.forEach(post => {
                const card = document.createElement('div');
                card.className = 'post-card';
                card.innerHTML = `
                    <div class="post-header">
                        <div class="author-info">
                            <span class="author-name">${post.authorName}</span>
                            <span class="badge-type ${post.contentType === 'ARTICLE' ? 'badge-article' : 'badge-post'}">
                                ${post.contentType}
                            </span>
                        </div>
                        <span style="font-size: 0.8rem; color: #94a3b8;">${new Date(post.publishedDate).toLocaleDateString()}</span>
                    </div>
                    <a href="/articles/detail?id=${post.id}" class="post-title">${post.title}</a>
                    <div class="post-content">${post.content.substring(0, 200)}${post.content.length > 200 ? '...' : ''}</div>
                    <div class="post-footer">
                        <span class="interaction">❤️ ${post.likesCount}</span>
                        <span class="interaction">💬 ${post.commentsCount}</span>
                    </div>
                `;
                feed.appendChild(card);
            });
        }

        document.addEventListener('DOMContentLoaded', loadFeed);
    </script>
</body>

</html>
```

## src\main\resources\templates\daily-log.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Daily Log - Health Tracker</title>
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #F3F4F6;
            --card-bg: #FFFFFF;
            --text-main: #1F2937;
            --text-secondary: #6B7280;
            --border-color: #E5E7EB;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: var(--text-main);
        }

        .container {
            max-width: 1000px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .page-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 2rem;
        }

        .page-title {
            font-size: 2rem;
            font-weight: bold;
            color: var(--text-main);
            margin: 0;
        }

        .btn-back {
            text-decoration: none;
            color: var(--text-secondary);
            font-weight: 500;
            display: flex;
            align-items: center;
            gap: 0.5rem;
            transition: color 0.2s;
        }

        .btn-back:hover {
            color: var(--primary-color);
        }

        .grid-layout {
            display: grid;
            grid-template-columns: 1fr;
            gap: 2rem;
        }

        @media (min-width: 768px) {
            .grid-layout {
                grid-template-columns: 1fr 2fr;
            }
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 2rem;
        }

        .card-title {
            font-size: 1.25rem;
            font-weight: 600;
            margin-bottom: 1.5rem;
            color: var(--text-main);
        }

        .form-group {
            margin-bottom: 1.25rem;
        }

        label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 500;
            color: var(--text-secondary);
        }

        input,
        textarea {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--border-color);
            border-radius: 0.5rem;
            box-sizing: border-box;
            font-size: 1rem;
            transition: border-color 0.2s;
        }

        input:focus,
        textarea:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        textarea {
            resize: vertical;
            min-height: 100px;
        }

        .btn-submit {
            width: 100%;
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .btn-submit:hover {
            background-color: var(--primary-hover);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            text-align: left;
            padding: 1rem;
            background-color: #F9FAFB;
            color: var(--text-secondary);
            font-weight: 600;
            border-bottom: 1px solid var(--border-color);
        }

        td {
            padding: 1rem;
            border-bottom: 1px solid var(--border-color);
            color: var(--text-main);
        }

        tr:last-child td {
            border-bottom: none;
        }

        .empty-state {
            text-align: center;
            color: var(--text-secondary);
            padding: 2rem;
        }
    </style>
</head>

<body>

    <div class="container">
        <div class="page-header">
            <h1 class="page-title">Daily Log</h1>
            <a href="/welcome" class="btn-back">← Back to Dashboard</a>
        </div>

        <div class="grid-layout">
            <!-- Add Log Form -->
            <div class="card">
                <h2 class="card-title">Add New Log</h2>
                <form th:action="@{/daily-logs}" th:object="${dailyLog}" method="post">
                    <div class="form-group">
                        <label for="waterIntake">Water Intake (Liters)</label>
                        <input type="number" step="0.1" id="waterIntake" th:field="*{waterIntake}" required>
                    </div>
                    <div class="form-group">
                        <label for="sleepDuration">Sleep Duration (Hours)</label>
                        <input type="number" step="0.1" id="sleepDuration" th:field="*{sleepDuration}" required>
                    </div>
                    <div class="form-group">
                        <label for="steps">Steps Count</label>
                        <input type="number" id="steps" th:field="*{steps}" required>
                    </div>
                    <div class="form-group">
                        <label for="notes">Notes</label>
                        <textarea id="notes" th:field="*{notes}"
                            placeholder="Sleep quality, hydration habits, etc."></textarea>
                    </div>
                    <div class="form-group">
                        <label for="date">Date</label>
                        <input type="date" id="date" th:field="*{date}" required>
                    </div>
                    <button type="submit" class="btn-submit">Add Log</button>
                </form>
            </div>

            <!-- Logs List -->
            <div class="card">
                <h2 class="card-title">Your History</h2>
                <div th:if="${#lists.isEmpty(dailyLogs)}" class="empty-state">
                    No logs yet. Track your habits! 💧
                </div>
                <table th:unless="${#lists.isEmpty(dailyLogs)}">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Water (L)</th>
                            <th>Sleep (h)</th>
                            <th>Steps</th>
                            <th>Notes</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr th:each="log : ${dailyLogs}">
                            <td th:text="${log.date}"></td>
                            <td th:text="${log.waterIntake}"></td>
                            <td th:text="${log.sleepDuration}"></td>
                            <td th:text="${log.steps}"></td>
                            <td th:text="${log.notes}"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>

</html>
```

## src\main\resources\templates\forgot_password.html
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password - Health Tracker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --success-color: #10B981;
            --input-border: #cbd5e1;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: #d4e7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            width: 100%;
            max-width: 400px;
            color: #242d3f;
        }

        .card-header {
            background: none;
            border: none;
            text-align: center;
            margin-bottom: 2rem;
            padding: 0;
        }

        .card-header h3 {
            font-size: 2rem;
            margin-bottom: 0.5rem;
            color: #242d3f;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: #242d3f;
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--input-border);
            border-radius: 0.5rem;
            font-size: 1rem;
            box-sizing: border-box;
            transition: border-color 0.2s;
            font-family: inherit;
            color: #242d3f;
            background-color: #fff;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .btn-primary {
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            width: 100%;
        }

        .btn-primary:hover {
            background-color: var(--primary-hover);
            border-color: var(--primary-hover);
        }

        .text-decoration-none {
            color: var(--primary-color);
            font-weight: 500;
        }

        .text-decoration-none:hover {
            text-decoration: underline;
        }

        .error-msg {
            color: var(--danger-color);
            background-color: rgba(239, 68, 68, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(239, 68, 68, 0.2);
        }

        .success-msg {
            color: var(--success-color);
            background-color: rgba(16, 185, 129, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(16, 185, 129, 0.2);
        }
    </style>
</head>

<body>
    <div class="row justify-content-center w-100">
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="card-header">
                    <h3>Forgot Password</h3>
                </div>
                <div class="card-body p-0">
                    <div th:if="${error}" class="error-msg">
                        <span th:text="${error}"></span>
                    </div>
                    <div th:if="${message}" class="success-msg">
                        <span th:text="${message}"></span>
                    </div>

                    <form th:action="@{/forgot-password}" method="post">
                        <div class="mb-3">
                            <label for="email" class="form-label">Enter your email address</label>
                            <input type="text" class="form-control" id="email" name="email" required
                                placeholder="Enter your email">
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Reset Password</button>
                        </div>
                    </form>
                    <div class="mt-3 text-center">
                        <a th:href="@{/login}" class="text-decoration-none">Back to Login</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
```

## src\main\resources\templates\login.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Login - Health Tracker</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --success-color: #10B981;
            --input-border: #cbd5e1;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: #d4e7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .login-card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            width: 100%;
            max-width: 400px;
            color: #242d3f;
        }

        .login-header {
            text-align: center;
            margin-bottom: 2rem;
        }

        .login-header h1 {
            font-size: 2rem;
            margin-bottom: 0.5rem;
            color: #242d3f;
        }

        .login-header p {
            color: var(--text-secondary);
            font-size: 0.95rem;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: #242d3f;
        }

        .input-group {
            position: relative;
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--input-border);
            border-radius: 0.5rem;
            font-size: 1rem;
            box-sizing: border-box;
            transition: border-color 0.2s;
            font-family: inherit;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .btn-login {
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            width: 100%;
        }

        .btn-login:hover {
            background-color: var(--primary-hover);
        }

        .password-toggle {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            background: none;
            border: none;
            cursor: pointer;
            color: var(--text-secondary);
            padding: 0;
        }

        .link {
            color: var(--primary-color);
            text-decoration: none;
            font-weight: 500;
        }

        .link:hover {
            text-decoration: underline;
        }

        .text-center {
            text-align: center;
        }

        .mt-3 {
            margin-top: 1rem;
        }

        .success-msg {
            color: var(--success-color);
            background-color: rgba(16, 185, 129, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(16, 185, 129, 0.2);
        }

        .error-msg {
            color: var(--danger-color);
            background-color: rgba(239, 68, 68, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(239, 68, 68, 0.2);
        }
    </style>
</head>

<body>
    <div class="login-card">
        <div class="login-header">
            <h1>Login</h1>
            <p>Welcome Back! Please enter your credentials.</p>
        </div>

        <div th:if="${success}" class="success-msg">
            <p th:text="${success}" style="margin:0"></p>
        </div>

        <div th:if="${param.error != null}">
            <!-- Show specific verification error if it exists in session -->
            <div th:if="${session.SPRING_SECURITY_LAST_EXCEPTION != null and session.SPRING_SECURITY_LAST_EXCEPTION.message.contains('verification')}"
                class="error-msg">
                Your account is pending admin verification.
            </div>
            <div
                th:unless="${session.SPRING_SECURITY_LAST_EXCEPTION != null and session.SPRING_SECURITY_LAST_EXCEPTION.message.contains('verification')}">
                <div th:if="${param.error[0] == 'email'}" class="error-msg">
                    Invalid Email.
                </div>
                <div th:if="${param.error[0] == 'password'}" class="error-msg">
                    Incorrect Password.
                </div>
                <div th:if="${param.error[0] != 'email' and param.error[0] != 'password'}" class="error-msg">
                    Invalid username or password.
                </div>
            </div>
        </div>

        <form action="/login" method="post">
            <div class="form-group">
                <label class="form-label">Email</label>
                <input type="text" name="username" class="form-control" placeholder="Enter your email" required />
            </div>

            <div class="form-group">
                <label class="form-label">Password</label>
                <div class="input-group">
                    <input type="password" id="password" name="password" class="form-control"
                        placeholder="Enter your password" required />
                    <button type="button" class="password-toggle" id="toggleLoginPassword">
                        <i class="bi bi-eye" id="loginEyeIcon"></i>
                    </button>
                </div>
            </div>

            <div class="form-group text-center">
                <a href="/forgot-password" class="link" style="font-size: 0.9rem;">Forgot Password?</a>
            </div>

            <button type="submit" class="btn-login">Login</button>

            <div class="text-center mt-3">
                <p style="font-size: 0.9rem; color: var(--text-secondary);">
                    Don't have an account? <a href="/register" class="link">Sign Up</a>
                </p>
            </div>
        </form>
    </div>

    <script>
        const loginPwdInput = document.getElementById('password');
        const loginToggleBtn = document.getElementById('toggleLoginPassword');
        const loginEyeIcon = document.getElementById('loginEyeIcon');

        loginToggleBtn.addEventListener('click', function () {
            const isPassword = loginPwdInput.type === 'password';
            loginPwdInput.type = isPassword ? 'text' : 'password';
            loginEyeIcon.classList.toggle('bi-eye', !isPassword);
            loginEyeIcon.classList.toggle('bi-eye-slash', isPassword);
        });
    </script>
</body>

</html>
```

## src\main\resources\templates\meal.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Meals - Health Tracker</title>
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #F3F4F6;
            --card-bg: #FFFFFF;
            --text-main: #1F2937;
            --text-secondary: #6B7280;
            --border-color: #E5E7EB;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: var(--text-main);
        }

        .container {
            max-width: 1000px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .page-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 2rem;
        }

        .page-title {
            font-size: 2rem;
            font-weight: bold;
            color: var(--text-main);
            margin: 0;
        }

        .btn-back {
            text-decoration: none;
            color: var(--text-secondary);
            font-weight: 500;
            display: flex;
            align-items: center;
            gap: 0.5rem;
            transition: color 0.2s;
        }

        .btn-back:hover {
            color: var(--primary-color);
        }

        .grid-layout {
            display: grid;
            grid-template-columns: 1fr;
            gap: 2rem;
        }

        @media (min-width: 768px) {
            .grid-layout {
                grid-template-columns: 1fr 2fr;
            }
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 2rem;
        }

        .card-title {
            font-size: 1.25rem;
            font-weight: 600;
            margin-bottom: 1.5rem;
            color: var(--text-main);
        }

        .form-group {
            margin-bottom: 1.25rem;
        }

        label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 500;
            color: var(--text-secondary);
        }

        input,
        select {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--border-color);
            border-radius: 0.5rem;
            box-sizing: border-box;
            font-size: 1rem;
            transition: border-color 0.2s;
        }

        input:focus,
        select:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .btn-submit {
            width: 100%;
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .btn-submit:hover {
            background-color: var(--primary-hover);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            text-align: left;
            padding: 1rem;
            background-color: #F9FAFB;
            color: var(--text-secondary);
            font-weight: 600;
            border-bottom: 1px solid var(--border-color);
        }

        td {
            padding: 1rem;
            border-bottom: 1px solid var(--border-color);
            color: var(--text-main);
        }

        tr:last-child td {
            border-bottom: none;
        }

        .empty-state {
            text-align: center;
            color: var(--text-secondary);
            padding: 2rem;
        }
    </style>
</head>

<body>

    <div class="container">
        <div class="page-header">
            <h1 class="page-title">Meals</h1>
            <a href="/welcome" class="btn-back">← Back to Dashboard</a>
        </div>

        <div class="grid-layout">
            <!-- Add Meal Form -->
            <div class="card">
                <h2 class="card-title">Add New Meal</h2>
                <form th:action="@{/meals}" th:object="${meal}" method="post">
                    <div class="form-group">
                        <label for="type">Meal Type</label>
                        <select id="type" th:field="*{type}">
                            <option value="Breakfast">Breakfast</option>
                            <option value="Lunch">Lunch</option>
                            <option value="Dinner">Dinner</option>
                            <option value="Snack">Snack</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="calories">Calories</label>
                        <input type="number" id="calories" th:field="*{calories}" required>
                    </div>
                    <div class="form-group">
                        <label for="protein">Protein (g)</label>
                        <input type="number" step="0.1" id="protein" th:field="*{protein}">
                    </div>
                    <div class="form-group">
                        <label for="carbs">Carbs (g)</label>
                        <input type="number" step="0.1" id="carbs" th:field="*{carbs}">
                    </div>
                    <div class="form-group">
                        <label for="fats">Fats (g)</label>
                        <input type="number" step="0.1" id="fats" th:field="*{fats}">
                    </div>
                    <div class="form-group">
                        <label for="date">Date</label>
                        <input type="date" id="date" th:field="*{date}" required>
                    </div>
                    <button type="submit" class="btn-submit">Add Meal</button>
                </form>
            </div>

            <!-- Meals List -->
            <div class="card">
                <h2 class="card-title">Your History</h2>
                <div th:if="${#lists.isEmpty(meals)}" class="empty-state">
                    No meals logged yet. Eat healthy! 🥗
                </div>
                <table th:unless="${#lists.isEmpty(meals)}">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Type</th>
                            <th>Calories</th>
                            <th>Macros (P/C/F)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr th:each="meal : ${meals}">
                            <td th:text="${meal.date}"></td>
                            <td th:text="${meal.type}"></td>
                            <td th:text="${meal.calories}"></td>
                            <td th:text="${meal.protein} + ' / ' + ${meal.carbs} + ' / ' + ${meal.fats}"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>

</html>
```

## src\main\resources\templates\profile.html
```html
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>My Profile - Health Tracker</title>
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --input-border: #cbd5e1;
            --input-bg-readonly: #f1f5f9;
        }

        /* Dropdown Styles */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: var(--card-bg);
            min-width: 160px;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            z-index: 100;
            border-radius: 0.375rem;
            top: 100%;
        }

        .dropdown-content a {
            color: var(--text-secondary);
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            font-weight: 400;
        }

        .dropdown-content a:hover {
            background-color: rgba(79, 70, 229, 0.1);
            color: var(--primary-color);
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: #d4e7f7;
        }

        .navbar {
            background-color: var(--card-bg);
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: bold;
            color: var(--primary-color);
            text-decoration: none;
        }

        .nav-links {
            display: flex;
            gap: 1.5rem;
            align-items: center;
        }

        .nav-link {
            text-decoration: none;
            color: var(--text-secondary);
            font-weight: 500;
            transition: color 0.2s;
        }

        .nav-link:hover {
            color: var(--primary-color);
        }

        .btn-logout {
            background-color: var(--danger-color);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 0.375rem;
            text-decoration: none;
            font-size: 0.875rem;
            transition: opacity 0.2s;
        }

        .btn-logout:hover {
            opacity: 0.9;
        }

        .container {
            max-width: 800px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .page-header {
            text-align: center;
            margin-bottom: 3rem;
        }

        .page-header h1 {
            font-size: 2.5rem;
            margin-bottom: 0.5rem;
            color: #d4e7f7;
        }

        .profile-card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            color: #242d3f;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: #242d3f;
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--input-border);
            border-radius: 0.5rem;
            font-size: 1rem;
            box-sizing: border-box;
            transition: border-color 0.2s;
            font-family: inherit;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .form-control[readonly] {
            background-color: var(--input-bg-readonly);
            cursor: not-allowed;
            color: var(--text-secondary);
        }

        .btn-save {
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            width: 100%;
        }

        .btn-save:hover {
            background-color: var(--primary-hover);
        }

        .form-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 1.5rem;
        }

        @media (max-width: 640px) {
            .form-grid {
                grid-template-columns: 1fr;
            }
        }

        .profile-image-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 2rem;
            position: relative;
        }

        .profile-image {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            object-fit: cover;
            border: 4px solid var(--primary-color);
            background-color: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .profile-image-placeholder {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            background-color: #e2e8f0;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 3rem;
            color: #94a3b8;
            border: 4px solid var(--primary-color);
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/welcome" class="navbar-brand">HealthTracker</a>
        <div class="nav-links">
            <div class="dropdown" sec:authorize="hasRole('USER')">
                <a href="#" class="nav-link">Activity ▾</a>
                <div class="dropdown-content">
                    <a href="/workouts">Workouts</a>
                    <a href="/meals">Meals</a>
                    <a href="/daily-logs">Daily Log</a>
                </div>
            </div>
            <a href="/bmi" class="nav-link" sec:authorize="hasRole('USER')">BMI Calculator</a>
            <a href="/trainer-matching" class="nav-link" sec:authorize="hasRole('USER')">Trainer Matching</a>
            <a href="/articles" class="nav-link">BLOG</a>
            <a href="/community" class="nav-link">Community</a>
            <a href="/profile" class="nav-link" style="color: var(--primary-color);">My Profile</a>
            <a href="/logout" class="btn-logout">Logout</a>
        </div>
    </nav>

    <div class="container">
        <div class="page-header">
            <h1>My Profile</h1>
        </div>

        <div class="profile-card">
            <div class="profile-image-container">
                <img id="profilePreview" th:if="${user.profileImageUrl != null && user.profileImageUrl != ''}"
                    th:src="${user.profileImageUrl}" alt="Profile Image" class="profile-image">
                <div id="profileImagePlaceholder"
                    th:unless="${user.profileImageUrl != null && user.profileImageUrl != ''}"
                    class="profile-image-placeholder">
                    <span th:text="${#strings.toUpperCase(#strings.substring(user.first, 0, 1))}">U</span>
                </div>
            </div>

            <form action="/update-profile" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" th:value="${user.id}">
                <div class="form-group">
                    <label class="form-label">Upload Profile Image</label>
                    <input type="file" name="profileImage" class="form-control" accept="image/*"
                        onchange="previewImage(this)">
                    <small style="color: #64748b; margin-top: 0.5rem; display: block;">Select a JPG or PNG image (max
                        10MB)</small>
                </div>
                <!-- Hidden field to keep old image if no new one is uploaded -->
                <input type="hidden" name="profileImageUrl" th:value="${user.profileImageUrl}">

                <div class="form-grid">
                    <div class="form-group">
                        <label class="form-label">First Name</label>
                        <input class="form-control" name="first" th:value="${user.first}" type="text" readonly>
                    </div>
                    <div class="form-group">
                        <label class="form-label">Last Name</label>
                        <input type="text" name="last" class="form-control" th:value="${user.last}" readonly>
                    </div>
                </div>

                <div class="form-group">
                    <label class="form-label">Email</label>
                    <input type="text" name="username" class="form-control" th:value="${user.username}" readonly>
                </div>

                <div class="form-grid">
                    <div class="form-group">
                        <label class="form-label">Age</label>
                        <input type="text" name="age" class="form-control" th:value="${user.age}">
                    </div>
                    <div class="form-group">
                        <label class="form-label">Weight (kg)</label>
                        <input type="text" name="weight" class="form-control" th:value="${user.weight}">
                    </div>
                    <div class="form-group">
                        <label class="form-label">Height (cm)</label>
                        <input type="text" name="height" class="form-control" th:value="${user.height}">
                    </div>
                    <div class="form-group" th:if="${user.role != 'TRAINER'}">
                        <label class="form-label">Fitness Goals</label>
                        <input type="text" name="goals" class="form-control" th:value="${user.goals}">
                    </div>
                </div>

                <!-- Trainer Specific Section -->
                <div th:if="${user.role == 'TRAINER'}"
                    style="margin-top: 2rem; border-top: 1px solid #cbd5e1; padding-top: 1rem;">
                    <h3 style="color: #242d3f; margin-bottom: 1rem;">Trainer Profile</h3>
                    <div class="form-grid">
                        <div class="form-group">
                            <label class="form-label">Specialization</label>
                            <input type="text" name="specialization" class="form-control"
                                th:value="${user.specialization}" placeholder="e.g. Muscle Gain, Yoga">
                        </div>
                        <div class="form-group">
                            <label class="form-label">Location</label>
                            <input type="text" name="trainerLocation" class="form-control"
                                th:value="${user.trainerLocation}" placeholder="e.g. New York, Remote">
                        </div>
                        <div class="form-group">
                            <label class="form-label">Experience (Years)</label>
                            <input type="text" name="experience" class="form-control" th:value="${user.experience}"
                                placeholder="e.g. 5+ Years">
                        </div>
                        <div class="form-group">
                            <label class="form-label">Contact Number</label>
                            <input type="text" name="contactNo" class="form-control" th:value="${user.contactNo}"
                                placeholder="Enter contact number">
                        </div>
                        <div class="form-group">
                            <label class="form-label">Availability</label>
                            <input type="text" name="availability" class="form-control" th:value="${user.availability}"
                                placeholder="e.g. Mon-Fri 9am-5pm">
                        </div>
                    </div>
                </div>

                <div style="margin-top: 1rem;">
                    <button type="submit" class="btn-save">Update Profile</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        function previewImage(input) {
            const preview = document.getElementById('profilePreview');
            const placeholder = document.getElementById('profileImagePlaceholder');

            if (input.files && input.files[0]) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    if (preview) {
                        preview.src = e.target.result;
                        preview.style.display = 'block';
                    } else {
                        // If no preview img exists, create one
                        const container = document.querySelector('.profile-image-container');
                        const img = document.createElement('img');
                        img.id = 'profilePreview';
                        img.src = e.target.result;
                        img.className = 'profile-image';
                        container.insertBefore(img, placeholder);
                    }
                    if (placeholder) {
                        placeholder.style.display = 'none';
                    }
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</body>

</html>
```

## src\main\resources\templates\register.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Sign Up - Health Tracker</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --success-color: #10B981;
            --input-border: #cbd5e1;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: #d4e7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .register-card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            width: 100%;
            max-width: 500px;
            color: #242d3f;
            margin: 2rem;
        }

        .register-header {
            text-align: center;
            margin-bottom: 2rem;
        }

        .register-header h1 {
            font-size: 2rem;
            margin-bottom: 0.5rem;
            color: #242d3f;
        }

        .form-group {
            margin-bottom: 1.25rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: #242d3f;
        }

        .input-group {
            position: relative;
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--input-border);
            border-radius: 0.5rem;
            font-size: 1rem;
            box-sizing: border-box;
            transition: border-color 0.2s;
            font-family: inherit;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .btn-register {
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            width: 100%;
            margin-top: 1rem;
        }

        .btn-register:hover {
            background-color: var(--primary-hover);
        }

        .password-toggle {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            background: none;
            border: none;
            cursor: pointer;
            color: var(--text-secondary);
            padding: 0;
        }

        .link {
            color: var(--primary-color);
            text-decoration: none;
            font-weight: 500;
        }

        .link:hover {
            text-decoration: underline;
        }

        .text-center {
            text-align: center;
        }

        .mt-3 {
            margin-top: 1rem;
        }

        .error-msg {
            color: var(--danger-color);
            background-color: rgba(239, 68, 68, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(239, 68, 68, 0.2);
        }

        .success-msg {
            color: var(--success-color);
            background-color: rgba(16, 185, 129, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(16, 185, 129, 0.2);
        }

        select.form-control {
            appearance: none;
            background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' fill='none' viewBox='0 0 20 20'%3e%3cpath stroke='%236b7280' stroke-linecap='round' stroke-linejoin='round' stroke-width='1.5' d='M6 8l4 4 4-4'/%3e%3c/svg%3e");
            background-position: right 0.5rem center;
            background-repeat: no-repeat;
            background-size: 1.5em 1.5em;
            padding-right: 2.5rem;
        }
    </style>
</head>

<body>
    <div class="register-card">
        <div class="register-header">
            <h1>Sign Up</h1>
        </div>

        <!-- Error Messages -->
        <div th:if="${error}" class="error-msg">
            <p th:text="${error}" style="margin:0"></p>
        </div>

        <div th:if="${success}" class="success-msg">
            <p th:text="${success}" style="margin:0"></p>
        </div>

        <div th:if="${passwordError}" class="error-msg" th:text="${passwordError}"></div>

        <!-- Client-side Password Error Container -->
        <div id="jsPasswordError" class="error-msg" style="display:none;"></div>

        <form action="/register" method="post" th:object="${user}" id="registerForm">
            <div class="form-group">
                <label class="form-label">First Name</label>
                <input type="text" name="first" class="form-control" placeholder="Enter your first name" required />
            </div>

            <div class="form-group">
                <label class="form-label">Last Name</label>
                <input type="text" name="last" class="form-control" placeholder="Enter your last name" required />
            </div>

            <div class="form-group">
                <label class="form-label">Email</label>
                <input type="text" name="username" class="form-control" placeholder="Enter your email" required />
            </div>

            <div class="form-group">
                <label class="form-label">Password</label>
                <div class="input-group">
                    <input type="password" id="regPassword" name="password" class="form-control"
                        placeholder="Create a password" required />
                    <button type="button" class="password-toggle" id="toggleRegPassword">
                        <i class="bi bi-eye" id="regEyeIcon"></i>
                    </button>
                </div>
                <div style="color: #EF4444; font-size: 0.875rem; margin-top: 0.25rem;"
                    th:if="${#fields.hasErrors('password')}" th:errors="*{password}"></div>
            </div>

            <div class="form-group">
                <label class="form-label">Confirm Password</label>
                <div class="input-group">
                    <input type="password" id="confirmPassword" name="cnfPassword" class="form-control"
                        placeholder="Confirm your password" required />
                    <button type="button" class="password-toggle" id="toggleConfirmPassword">
                        <i class="bi bi-eye" id="confirmEyeIcon"></i>
                    </button>
                </div>
            </div>

            <div class="form-group">
                <label class="form-label">Role</label>
                <select name="role" class="form-control" id="roleSelect" onchange="toggleTrainerFields()">
                    <option value="USER">User</option>
                    <option value="TRAINER">Trainer</option>
                    <option value="ADMIN">Admin</option>
                </select>
            </div>

            <!-- Trainer Specific Fields -->
            <div id="trainerFields" style="display: none;">
                <div class="form-group">
                    <label class="form-label">Specialization</label>
                    <input type="text" name="specialization" class="form-control"
                        placeholder="e.g. Yoga, Strength Training" />
                </div>
                <div class="form-group">
                    <label class="form-label">Experience</label>
                    <input type="text" name="experience" class="form-control" placeholder="e.g. 5+ years" />
                </div>
                <div class="form-group">
                    <label class="form-label">Location</label>
                    <input type="text" name="trainerLocation" class="form-control" placeholder="City or Gym Name" />
                </div>
                <div class="form-group">
                    <label class="form-label">Availability</label>
                    <input type="text" name="availability" class="form-control" placeholder="e.g. Mon-Fri, 9am-5pm" />
                </div>
                <div class="form-group">
                    <label class="form-label">Contact Number</label>
                    <input type="text" name="contactNo" class="form-control" placeholder="Phone Number" />
                </div>
            </div>

            <button type="submit" class="btn-register">Sign Up</button>

            <div class="text-center mt-3">
                <p style="font-size: 0.9rem; color: var(--text-secondary);">
                    Have an account? <a href="/Login" class="link">Log in</a>
                </p>
            </div>
        </form>
    </div>

    <script>
        const regPwdInput = document.getElementById('regPassword');
        const regToggleBtn = document.getElementById('toggleRegPassword');
        const regEyeIcon = document.getElementById('regEyeIcon');

        const confirmPwdInput = document.getElementById('confirmPassword');
        const confirmToggleBtn = document.getElementById('toggleConfirmPassword');
        const confirmEyeIcon = document.getElementById('confirmEyeIcon');

        regToggleBtn.addEventListener('click', function () {
            const isPassword = regPwdInput.type === 'password';
            regPwdInput.type = isPassword ? 'text' : 'password';
            regEyeIcon.classList.toggle('bi-eye', !isPassword);
            regEyeIcon.classList.toggle('bi-eye-slash', isPassword);
        });

        confirmToggleBtn.addEventListener('click', function () {
            const isPassword = confirmPwdInput.type === 'password';
            confirmPwdInput.type = isPassword ? 'text' : 'password';
            confirmEyeIcon.classList.toggle('bi-eye', !isPassword);
            confirmEyeIcon.classList.toggle('bi-eye-slash', isPassword);
        });

        document.getElementById('registerForm').addEventListener('submit', function (event) {
            const password = document.getElementById('regPassword').value;
            const errorDiv = document.getElementById('jsPasswordError');
            let errors = [];

            const confirmPassword = document.getElementById('confirmPassword').value;

            // Password Criteria
            if (password.length <= 8) {
                errors.push("Password must be greater than 8 characters.");
            }
            if (!/[A-Z]/.test(password)) {
                errors.push("Password must contain at least one uppercase letter.");
            }
            if (!/[a-z]/.test(password)) {
                errors.push("Password must contain at least one lowercase letter.");
            }
            if (!/[0-9]/.test(password)) {
                errors.push("Password must contain at least one number.");
            }
            if (!/[@_]/.test(password)) {
                errors.push("Password must contain at least one special character (@ or _).");
            }
            if (password !== confirmPassword) {
                errors.push("Passwords do not match.");
            }

            if (errors.length > 0) {
                event.preventDefault(); // Stop form submission

                // Construct error message list
                let errorHtml = '<ul style="margin: 0; padding-left: 20px;">';
                errors.forEach(function (msg) {
                    errorHtml += '<li>' + msg + '</li>';
                });
                errorHtml += '</ul>';

                errorDiv.innerHTML = errorHtml;
                errorDiv.style.display = 'block';

                // Clear password fields
                document.getElementById('regPassword').value = '';
                document.getElementById('confirmPassword').value = '';
            } else {
                errorDiv.style.display = 'none';
            }
        });

        function toggleTrainerFields() {
            const role = document.getElementById('roleSelect').value;
            const trainerFields = document.getElementById('trainerFields');
            trainerFields.style.display = (role === 'TRAINER') ? 'block' : 'none';
        }
    </script>
</body>

</html>
```

## src\main\resources\templates\reset_password.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Reset Password - Health Tracker</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --success-color: #10B981;
            --input-border: #cbd5e1;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: #d4e7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .login-card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            width: 100%;
            max-width: 400px;
            color: #242d3f;
        }

        .login-header {
            text-align: center;
            margin-bottom: 2rem;
        }

        .login-header h1 {
            font-size: 2rem;
            margin-bottom: 0.5rem;
            color: #242d3f;
        }

        .login-header p {
            color: var(--text-secondary);
            font-size: 0.95rem;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: #242d3f;
        }

        .input-group {
            position: relative;
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--input-border);
            border-radius: 0.5rem;
            font-size: 1rem;
            box-sizing: border-box;
            transition: border-color 0.2s;
            font-family: inherit;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .btn-login {
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            width: 100%;
        }

        .btn-login:hover {
            background-color: var(--primary-hover);
        }

        .password-toggle {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            background: none;
            border: none;
            cursor: pointer;
            color: var(--text-secondary);
            padding: 0;
        }

        .error-msg {
            color: var(--danger-color);
            background-color: rgba(239, 68, 68, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(239, 68, 68, 0.2);
        }

        .text-danger {
            color: var(--danger-color);
            font-size: 0.875rem;
            margin-top: 0.25rem;
        }
    </style>
</head>

<body>
    <div class="login-card">
        <div class="login-header">
            <h1>Reset Password</h1>
            <p>Enter your new password below.</p>
        </div>

        <div th:if="${error}" class="error-msg">
            <span th:text="${error}"></span>
        </div>

        <!-- Client-side Password Error Container -->
        <div id="jsPasswordError" class="error-msg" style="display:none;"></div>

        <form th:action="@{/reset-password}" th:object="${passwordResetDto}" method="post" id="resetPasswordForm">
            <input type="hidden" th:field="*{token}" />

            <div class="form-group">
                <label for="password" class="form-label">New Password</label>
                <div class="input-group">
                    <input type="password" id="password" th:field="*{password}" class="form-control"
                        placeholder="Enter new password" required />
                    <button type="button" class="password-toggle" id="togglePassword">
                        <i class="bi bi-eye" id="eyeIcon"></i>
                    </button>
                </div>
                <div th:if="${#fields.hasErrors('password')}" class="text-danger">
                    <span th:errors="*{password}"></span>
                </div>
            </div>

            <div class="form-group">
                <label for="confirmPassword" class="form-label">Confirm New Password</label>
                <div class="input-group">
                    <input type="password" id="confirmPassword" th:field="*{confirmPassword}" class="form-control"
                        placeholder="Confirm new password" required />
                    <button type="button" class="password-toggle" id="toggleInfos">
                        <i class="bi bi-eye" id="eyeIconInfos"></i>
                    </button>
                </div>
            </div>

            <button type="submit" class="btn-login">Change Password</button>
        </form>
    </div>

    <script>
        const pwdInput = document.getElementById('password');
        const toggleBtn = document.getElementById('togglePassword');
        const eyeIcon = document.getElementById('eyeIcon');

        const confirmInput = document.getElementById('confirmPassword');
        const toggleInfoBtn = document.getElementById('toggleInfos');
        const eyeIconInfos = document.getElementById('eyeIconInfos');

        toggleBtn.addEventListener('click', function () {
            const isPassword = pwdInput.type === 'password';
            pwdInput.type = isPassword ? 'text' : 'password';
            eyeIcon.classList.toggle('bi-eye', !isPassword);
            eyeIcon.classList.toggle('bi-eye-slash', isPassword);
        });

        toggleInfoBtn.addEventListener('click', function () {
            const isPassword = confirmInput.type === 'password';
            confirmInput.type = isPassword ? 'text' : 'password';
            eyeIconInfos.classList.toggle('bi-eye', !isPassword);
            eyeIconInfos.classList.toggle('bi-eye-slash', isPassword);
        });

        document.getElementById('resetPasswordForm').addEventListener('submit', function (event) {
            const password = document.getElementById('password').value;
            const errorDiv = document.getElementById('jsPasswordError');
            let errors = [];

            const confirmPassword = document.getElementById('confirmPassword').value;

            // Password Criteria
            if (password.length <= 8) {
                errors.push("Password must be greater than 8 characters.");
            }
            if (!/[A-Z]/.test(password)) {
                errors.push("Password must contain at least one uppercase letter.");
            }
            if (!/[a-z]/.test(password)) {
                errors.push("Password must contain at least one lowercase letter.");
            }
            if (!/[0-9]/.test(password)) {
                errors.push("Password must contain at least one number.");
            }
            if (!/[@_]/.test(password)) {
                errors.push("Password must contain at least one special character (@ or _).");
            }
            if (password !== confirmPassword) {
                errors.push("Passwords do not match.");
            }

            if (errors.length > 0) {
                event.preventDefault(); // Stop form submission

                // Construct error message list
                let errorHtml = '<ul style="margin: 0; padding-left: 20px;">';
                errors.forEach(function (msg) {
                    errorHtml += '<li>' + msg + '</li>';
                });
                errorHtml += '</ul>';

                errorDiv.innerHTML = errorHtml;
                errorDiv.style.display = 'block';

                // Clear password fields
                document.getElementById('password').value = '';
                document.getElementById('confirmPassword').value = '';
            } else {
                errorDiv.style.display = 'none';
            }
        });
    </script>
</body>

</html>
```

## src\main\resources\templates\trainer-dashboard.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>Trainer Dashboard - Health Tracker</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #4F46E5;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-dark: #1e293b;
            --text-light: #f8fafc;
        }

        body {
            font-family: 'Outfit', sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            color: var(--text-light);
        }

        .navbar {
            background-color: var(--card-bg);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: bold;
            color: var(--primary-color);
            text-decoration: none;
        }

        .container {
            max-width: 1000px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .user-card {
            background: var(--card-bg);
            border-radius: 1rem;
            padding: 1.5rem;
            margin-bottom: 1rem;
            color: var(--text-dark);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .btn-assign {
            background: var(--primary-color);
            color: white;
            padding: 0.75rem 1.5rem;
            border-radius: 0.5rem;
            text-decoration: none;
            font-weight: 600;
        }

        .welcome-msg {
            margin-bottom: 3rem;
            text-align: center;
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/welcome" class="navbar-brand">HealthTracker</a>
        <div class="nav-links">
            <a href="/articles" style="color: var(--text-dark); text-decoration: none; margin-right: 1.5rem;">BLOG</a>
            <a href="/profile" style="color: var(--text-dark); text-decoration: none; margin-right: 1.5rem;">My
                Profile</a>
            <a href="/logout" style="color: #ef4444; text-decoration: none;">Logout</a>
        </div>
    </nav>

    <div class="container">
        <div class="welcome-msg">
            <h1 th:text="'Hello, Coach ' + ${trainer.first} + '!'">Welcome</h1>
            <p>Manage your clients and assign their daily fitness plans.</p>
        </div>

        <h2>My Clients</h2>
        <div th:if="${#lists.isEmpty(users)}" style="text-align: center; opacity: 0.6; margin-top: 2rem;">
            <p>No users have booked you yet.</p>
        </div>

        <div th:each="user : ${users}" class="user-card">
            <div>
                <h3 th:text="${user.first} + ' ' + ${user.last}" style="margin: 0;">User Name</h3>
                <p th:text="${user.goals}" style="margin: 0.5rem 0 0; color: #64748b;">Goals</p>
                <small th:text="'Age: ' + ${user.age} + ' | Weight: ' + ${user.weight} + 'kg'"></small>
            </div>
            <div style="display: flex; gap: 1rem;">
                <a th:href="@{'/trainer/analysis/' + ${user.id}}" class="btn-assign"
                    style="background: var(--text-dark);">Analysis</a>
                <a th:href="@{'/trainer/assign-plan/' + ${user.id}}" class="btn-assign">Assign Plans</a>
            </div>
        </div>

        <br><br>
        <h2
            style="color: var(--text-light); border-bottom: 2px solid var(--primary-color); padding-bottom: 0.5rem; display: inline-block;">
            Daily Recommendation</h2>
        <div style="margin-top: 1.5rem; margin-bottom: 3rem;">
            <div
                style="background: linear-gradient(135deg, #1e293b 0%, #0f172a 100%); color: white; border-radius: 1rem; padding: 2rem; box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);">
                <div style="display: flex; flex-direction: column; align-items: start; text-align: left;">
                    <h2 style="color: #38bdf8; margin: 0 0 0.5rem 0; font-size: 1.5rem;">
                        <span
                            style="font-size: 1rem; display: block; color: #94a3b8; font-weight: normal; margin-bottom: 0.25rem;">Daily
                            Health Tip</span>
                        <span th:text="${healthTip.title}">Stay Hydrated</span>
                    </h2>
                    <p style="color: #cbd5e1; font-size: 1.1rem; max-width: 800px; margin: 0; line-height: 1.5;"
                        th:text="${healthTip.description}">
                        Drink at least 8 glasses of water daily to maintain optimal health.
                    </p>
                    <div style="margin-top: 1.5rem; padding: 0.25rem 0.75rem; background: rgba(56, 189, 248, 0.1); border-radius: 1rem; color: #38bdf8; font-size: 0.875rem;"
                        th:text="${healthTip.category}">
                        Hydration
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
```

## src\main\resources\templates\trainer-matching.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Match a Trainer - Health Tracker</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-main: #d4e7f7;
            --text-dark: #1e293b;
            --text-secondary: #64748b;
            --accent-color: #10B981;
        }

        /* Dropdown Styles */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: var(--card-bg);
            min-width: 160px;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            z-index: 100;
            border-radius: 0.375rem;
            top: 100%;
        }

        .dropdown-content a {
            color: var(--text-secondary);
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            font-weight: 400;
        }

        .dropdown-content a:hover {
            background-color: rgba(79, 70, 229, 0.1);
            color: var(--primary-color);
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        body {
            font-family: 'Outfit', 'Inter', sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: var(--text-main);
        }

        .navbar {
            background-color: var(--card-bg);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: 800;
            color: var(--primary-color);
            text-decoration: none;
        }

        .container {
            max-width: 1100px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .hero-section {
            text-align: center;
            margin-bottom: 4rem;
        }

        .hero-section h1 {
            font-size: 3rem;
            margin-bottom: 1rem;
            background: linear-gradient(to right, #818cf8, #c084fc);
            -webkit-background-clip: text;
            background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        .search-box {
            background: rgba(212, 231, 247, 0.1);
            backdrop-filter: blur(10px);
            padding: 2rem;
            border-radius: 1rem;
            display: flex;
            gap: 1rem;
            margin-bottom: 3rem;
            border: 1px solid rgba(255, 255, 255, 0.1);
        }

        .search-input {
            flex-grow: 1;
            padding: 0.75rem 1.5rem;
            border-radius: 0.5rem;
            border: none;
            background: white;
            color: var(--text-dark);
            font-size: 1rem;
        }

        .btn-search {
            padding: 0.75rem 2rem;
            background: var(--primary-color);
            color: white;
            border: none;
            border-radius: 0.5rem;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s;
        }

        .btn-search:hover {
            background: var(--primary-hover);
            transform: translateY(-2px);
        }

        .trainer-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
            gap: 2rem;
        }

        .trainer-card {
            background: var(--card-bg);
            border-radius: 1rem;
            overflow: hidden;
            color: var(--text-dark);
            transition: all 0.3s;
            position: relative;
        }

        .trainer-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.3);
        }

        .trainer-badges {
            position: absolute;
            top: 1rem;
            right: 1rem;
            display: flex;
            gap: 0.5rem;
        }

        .badge-verified {
            background: var(--accent-color);
            color: white;
            padding: 0.25rem 0.75rem;
            border-radius: 2rem;
            font-size: 0.75rem;
            font-weight: 700;
        }

        .trainer-info {
            padding: 2rem;
        }

        .trainer-name {
            font-size: 1.5rem;
            font-weight: 700;
            margin-bottom: 0.5rem;
        }

        .trainer-specialization {
            color: var(--primary-color);
            font-weight: 600;
            margin-bottom: 1rem;
            display: flex;
            align-items: center;
            gap: 0.5rem;
        }

        .trainer-detail {
            font-size: 0.9rem;
            color: var(--text-secondary);
            margin-bottom: 0.5rem;
            display: flex;
            align-items: center;
            gap: 0.5rem;
        }

        .btn-book {
            width: 100%;
            padding: 1rem;
            background: var(--primary-color);
            color: white;
            border: none;
            margin-top: 1.5rem;
            border-radius: 0.5rem;
            font-weight: 700;
            cursor: pointer;
            transition: background 0.3s;
        }

        .btn-book:hover {
            background: var(--primary-hover);
        }

        .no-trainers {
            grid-column: 1 / -1;
            text-align: center;
            padding: 4rem;
            opacity: 0.6;
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/welcome" class="navbar-brand">HealthTracker</a>
        <div class="nav-links" style="display:flex; gap: 2rem; align-items: center;">
            <div class="dropdown">
                <a href="#" class="nav-link" style="color:var(--text-dark); text-decoration:none;">Activity ▾</a>
                <div class="dropdown-content">
                    <a href="/workouts">Workouts</a>
                    <a href="/meals">Meals</a>
                    <a href="/daily-logs">Daily Log</a>
                </div>
            </div>
            <a href="/welcome" style="color:var(--text-dark); text-decoration:none;">Dashboard</a>
            <a href="/articles" style="color:var(--text-dark); text-decoration:none;">BLOG</a>
            <a href="/community" style="color:var(--text-dark); text-decoration:none;">Community</a>
            <a href="/logout" style="color:var(--danger-color); text-decoration:none;">Logout</a>
        </div>
    </nav>

    <div class="container">
        <section class="hero-section">
            <h1>Find Your Perfect Trainer</h1>
            <p>Connect with expert trainers to achieve your fitness goals faster.</p>
        </section>

        <div class="search-box">
            <input type="text" id="goal-input" class="search-input"
                th:placeholder="${user.goals != null ? 'Matching for: ' + user.goals : 'Search by goal (e.g. Muscle Gain, Weight Loss)...'}">
            <button class="btn-search" onclick="searchTrainers()">Match Now</button>
        </div>

        <div id="trainer-grid" class="trainer-grid">
            <!-- Trainers loaded via JS -->
            <div class="no-trainers">Loading the best matches for you...</div>
        </div>
    </div>

    <script th:inline="javascript">
        async function fetchTrainers(goal = '') {
            const grid = document.getElementById('trainer-grid');
            try {
                const response = await fetch(`/api/trainers/match?goal=${encodeURIComponent(goal)}`);
                const trainers = await response.json();

                grid.innerHTML = '';
                if (trainers.length === 0) {
                    grid.innerHTML = '<div class="no-trainers"><h3>No trainers found matching your criteria.</h3><p>Try searching for a different goal!</p></div>';
                    return;
                }

                trainers.forEach(trainer => {
                    const card = document.createElement('div');
                    card.className = 'trainer-card';
                    card.innerHTML = `
                        <div class="trainer-badges">
                            ${trainer.verifiedTrainer ? '<span class="badge-verified"><i class="bi bi-patch-check-fill"></i> Verified</span>' : ''}
                        </div>
                        <div class="trainer-info">
                            <div class="trainer-name">${trainer.first} ${trainer.last}</div>
                            <div class="trainer-specialization">
                                <i class="bi bi-award"></i> ${trainer.specialization || 'General Fitness'}
                            </div>
                            <div class="trainer-detail">
                                <i class="bi bi-briefcase"></i> ${trainer.experience || 'Experienced'}
                            </div>
                            <div class="trainer-detail">
                                <i class="bi bi-geo-alt"></i> ${trainer.trainerLocation || 'Remote'}
                            </div>
                            <div class="trainer-detail">
                                <i class="bi bi-calendar-check"></i> ${trainer.availability || 'Available Now'}
                            </div>
                            <div id="contact-info-${trainer.id}" class="trainer-detail" style="margin-top: 1rem; color: var(--primary-color); font-weight: 600;">
                                <i class="bi bi-envelope"></i> ${trainer.username}
                                </br>
                                <i class="bi bi-telephone"></i> ${trainer.contactNo || 'N/A'}
                            </div>
                            <div class="booking-actions" style="margin-top: 1.5rem;">
                                <button class="btn-book" onclick="bookTrainer(${trainer.id})">
                                    Book Trainer
                                </button>
                            </div>
                        </div>
                    `;
                    grid.appendChild(card);
                });
            } catch (error) {
                console.error('Error:', error);
                grid.innerHTML = '<div class="no-trainers">Error loading trainers. Please try again.</div>';
            }
        }

        async function bookTrainer(trainerId) {
            if (!confirm('Are you sure you want to book this trainer?')) return;

            try {
                const response = await fetch(`/api/trainers/book?trainerId=${trainerId}`, {
                    method: 'POST'
                });
                if (response.ok) {
                    alert('Trainer booked successfully! You can now start your fitness journey together.');
                    window.location.reload();
                } else {
                    alert('Failed to book trainer. Please try again.');
                }
            } catch (error) {
                console.error('Error:', error);
                alert('An error occurred.');
            }
        }

        function searchTrainers() {
            const goal = document.getElementById('goal-input').value;
            fetchTrainers(goal);
        }

        // Initial load
        document.addEventListener('DOMContentLoaded', () => fetchTrainers());
    </script>
</body>

</html>
```

## src\main\resources\templates\user-analysis.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>User Analysis - Health Tracker</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-main: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --text-dark: #1e293b;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: var(--text-main);
        }

        .navbar {
            background-color: var(--card-bg);
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: bold;
            color: var(--primary-color);
            text-decoration: none;
        }

        .nav-links {
            display: flex;
            gap: 1.5rem;
            align-items: center;
        }

        .nav-link {
            text-decoration: none;
            color: var(--text-dark);
            font-weight: 500;
            transition: color 0.2s;
        }

        .nav-link:hover {
            color: var(--primary-color);
        }

        .container {
            max-width: 1200px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .header {
            text-align: center;
            margin-bottom: 3rem;
        }

        .header h1 {
            font-size: 2.5rem;
            margin-bottom: 0.5rem;
        }

        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 1.5rem;
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            padding: 2rem;
            text-align: center;
            color: var(--text-dark);
        }

        .stat-value {
            font-size: 2.5rem;
            font-weight: 700;
            color: var(--primary-color);
            margin: 1rem 0;
        }

        .chart-container {
            position: relative;
            height: 300px;
            width: 100%;
        }

        .section-title {
            color: var(--text-main);
            margin-bottom: 2rem;
            font-size: 1.5rem;
            border-bottom: 2px solid var(--primary-color);
            padding-bottom: 0.5rem;
            display: inline-block;
        }

        .btn-back {
            background-color: var(--text-main);
            color: var(--bg-color);
            padding: 0.5rem 1rem;
            border-radius: 0.375rem;
            text-decoration: none;
            font-weight: 600;
            margin-bottom: 1rem;
            display: inline-block;
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="/welcome" class="navbar-brand">HealthTracker</a>
        <div class="nav-links">
            <a href="/trainer/dashboard" class="nav-link">Dashboard</a>
            <a href="/articles" class="nav-link">BLOG</a>
            <a href="/community" class="nav-link">Community</a>
            <a href="/profile" class="nav-link">My Profile</a>
            <a href="/logout" style="color: var(--danger-color); text-decoration: none;">Logout</a>
        </div>
    </nav>

    <div class="container">
        <a href="/trainer/dashboard" class="btn-back">← Back to Dashboard</a>

        <div class="header">
            <h1 th:text="'Analysis: ' + ${user.first} + ' ' + ${user.last}">User Analysis</h1>
            <p>Today and Weekly Progress Summary</p>
        </div>

        <h2 class="section-title">Today Summary</h2>
        <div class="dashboard-grid" style="margin-bottom: 3rem;">
            <div class="card">
                <div style="font-size: 1.2rem; font-weight: 600;">Calories Eaten</div>
                <div class="stat-value" th:text="${caloriesEaten}">0</div>
                <div style="color: var(--text-secondary);">kcal</div>
            </div>
            <div class="card">
                <div style="font-size: 1.2rem; font-weight: 600;">Calories Burned</div>
                <div class="stat-value" th:text="${caloriesBurned}">0</div>
                <div style="color: var(--text-secondary);">kcal</div>
            </div>
            <div class="card">
                <div style="font-size: 1.2rem; font-weight: 600;">Steps</div>
                <div class="stat-value" th:text="${steps}">0</div>
                <div style="color: var(--text-secondary);">steps</div>
            </div>
            <div class="card">
                <div style="font-size: 1.2rem; font-weight: 600;">Sleep</div>
                <div class="stat-value" th:text="${sleep}">0</div>
                <div style="color: var(--text-secondary);">hours</div>
            </div>
        </div>

        <h2 class="section-title">Weekly Summary</h2>
        <div class="dashboard-grid" style="margin-bottom: 3rem;">
            <div class="card">
                <div style="font-size: 1.2rem; font-weight: 600; margin-bottom: 1rem;">Workout Frequency & Duration
                </div>
                <div class="chart-container">
                    <canvas id="workoutChart"></canvas>
                </div>
            </div>
            <div class="card">
                <div style="font-size: 1.2rem; font-weight: 600; margin-bottom: 1rem;">Calories Consumed & Burned</div>
                <div class="chart-container">
                    <canvas id="caloriesCompareChart"></canvas>
                </div>
            </div>
            <div class="card">
                <div style="font-size: 1.2rem; font-weight: 600; margin-bottom: 1rem;">Water Intake & Sleep Pattern
                </div>
                <div class="chart-container">
                    <canvas id="healthPatternChart"></canvas>
                </div>
            </div>
        </div>

        <h2 class="section-title">Goal Progress</h2>
        <div class="dashboard-grid" style="margin-bottom: 3rem;">
            <!-- Daily Steps Goal -->
            <div class="card" style="text-align: left;">
                <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 0.5rem;">
                    <div style="font-size: 1.2rem; font-weight: 600;">Daily Steps Goal</div>
                    <div style="text-align: right;">
                        <div style="font-weight: 600; color: var(--text-secondary); font-size: 0.9rem;">
                            <span th:text="${#numbers.formatInteger(steps, 0, 'COMMA')}">0</span> / <span
                                th:text="${#numbers.formatInteger(dailyStepGoal, 0, 'COMMA')}">10,000</span>
                        </div>
                        <div style="color: var(--primary-color); font-size: 1.2rem; font-weight: 700;">
                            <span
                                th:text="${#numbers.formatInteger(T(java.lang.Math).min((steps * 100.0) / dailyStepGoal, 100.0), 1)}">0</span>%
                        </div>
                    </div>
                </div>
                <div
                    style="background-color: #374151; border-radius: 9999px; height: 10px; width: 100%; margin-top: 0.5rem;">
                    <div
                        th:style="'width: ' + ${T(java.lang.Math).min((steps * 100.0) / dailyStepGoal, 100.0)} + '%; background-color: var(--primary-color); height: 100%; border-radius: 9999px; transition: width 0.5s ease-in-out;'">
                    </div>
                </div>
            </div>

            <!-- Weekly Exercise Goal -->
            <div class="card" style="text-align: left;">
                <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 0.5rem;">
                    <div style="font-size: 1.2rem; font-weight: 600;">Weekly Exercise Goal</div>
                    <div style="text-align: right;">
                        <div style="font-weight: 600; color: var(--text-secondary); font-size: 0.9rem;">
                            <span th:text="${weeklyWorkoutsCompleted}">0</span> / <span
                                th:text="${weeklyWorkoutGoal}">5</span> Days
                        </div>
                        <div style="color: var(--primary-color); font-size: 1.2rem; font-weight: 700;">
                            <span
                                th:text="${#numbers.formatInteger(T(java.lang.Math).min((weeklyWorkoutsCompleted * 100.0) / weeklyWorkoutGoal, 100.0), 1)}">0</span>%
                        </div>
                    </div>
                </div>
                <div
                    style="background-color: #374151; border-radius: 9999px; height: 10px; width: 100%; margin-top: 0.5rem;">
                    <div
                        th:style="'width: ' + ${T(java.lang.Math).min((weeklyWorkoutsCompleted * 100.0) / weeklyWorkoutGoal, 100.0)} + '%; background-color: var(--primary-color); height: 100%; border-radius: 9999px; transition: width 0.5s ease-in-out;'">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script th:inline="javascript">
        /*[+
        const chartDates = [[${ datesHistory }]];
        const workoutDataByType = [[${ workoutDataByType }]];
        const calEaten = [[${ caloriesEatenHistory }]];
        const calBurned = [[${ caloriesBurnedHistory }]];
        const waterIntake = [[${ waterIntakeHistory }]];
        const sleepPattern = [[${ sleepHistory }]];

        // Helper to generate a distinct color for each workout type
        function getWorkoutColor(index) {
            const colors = [
                'rgba(79, 70, 229, 0.8)',  // Indigo
                'rgba(16, 185, 129, 0.8)', // Emerald
                'rgba(245, 158, 11, 0.8)', // Amber
                'rgba(239, 68, 68, 0.8)',  // Red
                'rgba(6, 182, 212, 0.8)',  // Cyan
                'rgba(139, 92, 246, 0.8)', // Violet
                'rgba(236, 72, 153, 0.8)'  // Pink
            ];
            return colors[index % colors.length];
        }

        // Prepare datasets for Workout Chart
        const workoutDatasets = Object.keys(workoutDataByType).map((type, index) => ({
            label: type,
            data: workoutDataByType[type],
            backgroundColor: getWorkoutColor(index),
            borderRadius: 5,
            stack: 'Stack 0'
        }));
        +]*/

        // Workout Frequency & Duration Chart (Stacked Bar)
        new Chart(document.getElementById('workoutChart'), {
            type: 'bar',
            data: {
                labels: chartDates,
                datasets: workoutDatasets
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    tooltip: {
                        callbacks: {
                            label: function (context) {
                                return ` ${context.dataset.label}: ${context.raw} min`;
                            }
                        }
                    },
                    legend: {
                        position: 'bottom',
                        labels: { color: '#6B7280', usePointStyle: true, padding: 15 }
                    }
                },
                scales: {
                    x: {
                        stacked: true,
                        grid: { display: false }
                    },
                    y: {
                        stacked: true,
                        beginAtZero: true,
                        title: { display: true, text: 'Duration (min)', color: '#6B7280' }
                    }
                }
            }
        });

        // Calories Consumed & Burned Chart
        new Chart(document.getElementById('caloriesCompareChart'), {
            type: 'line',
            data: {
                labels: chartDates,
                datasets: [
                    {
                        label: 'Consumed',
                        data: calEaten,
                        borderColor: '#4F46E5',
                        backgroundColor: 'rgba(79, 70, 229, 0.1)',
                        fill: true,
                        tension: 0.4
                    },
                    {
                        label: 'Burned',
                        data: calBurned,
                        borderColor: '#EF4444',
                        backgroundColor: 'rgba(239, 68, 68, 0.1)',
                        fill: true,
                        tension: 0.4
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: { beginAtZero: true, title: { display: true, text: 'Calories (kcal)' } }
                }
            }
        });

        // Water Intake & Sleep Pattern Chart
        new Chart(document.getElementById('healthPatternChart'), {
            type: 'bar',
            data: {
                labels: chartDates,
                datasets: [
                    {
                        label: 'Sleep (hrs)',
                        data: sleepPattern,
                        type: 'line',
                        borderColor: '#EF4444',
                        backgroundColor: '#EF4444',
                        yAxisID: 'y1',
                        tension: 0.4,
                        order: 0
                    },
                    {
                        label: 'Water (L)',
                        data: waterIntake,
                        backgroundColor: '#3B82F6',
                        yAxisID: 'y',
                        borderRadius: 5,
                        order: 1
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        type: 'linear',
                        display: true,
                        position: 'left',
                        title: { display: true, text: 'Liters' }
                    },
                    y1: {
                        type: 'linear',
                        display: true,
                        position: 'right',
                        grid: { drawOnChartArea: false },
                        title: { display: true, text: 'Hours' }
                    }
                }
            }
        });
    </script>
</body>

</html>
```

## src\main\resources\templates\verify_otp.html
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Verify OTP - Health Tracker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
            --success-color: #10B981;
            --input-border: #cbd5e1;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: #d4e7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            width: 100%;
            max-width: 400px;
            color: #242d3f;
        }

        .card-header {
            background: none;
            border: none;
            text-align: center;
            margin-bottom: 2rem;
            padding: 0;
        }

        .card-header h3 {
            font-size: 2rem;
            margin-bottom: 0.5rem;
            color: #242d3f;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: #242d3f;
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--input-border);
            border-radius: 0.5rem;
            font-size: 1rem;
            box-sizing: border-box;
            transition: border-color 0.2s;
            font-family: inherit;
            color: #242d3f;
            background-color: #fff;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .btn-primary {
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
            width: 100%;
        }

        .btn-primary:hover {
            background-color: var(--primary-hover);
            border-color: var(--primary-hover);
        }

        .error-msg {
            color: var(--danger-color);
            background-color: rgba(239, 68, 68, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(239, 68, 68, 0.2);
        }

        .success-msg {
            color: var(--success-color);
            background-color: rgba(16, 185, 129, 0.1);
            padding: 0.75rem;
            border-radius: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid rgba(16, 185, 129, 0.2);
        }
    </style>
</head>

<body>
    <div class="row justify-content-center w-100">
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="card-header">
                    <h3>Verify OTP</h3>
                </div>
                <div class="card-body p-0">
                    <div th:if="${error}" class="error-msg">
                        <span th:text="${error}"></span>
                    </div>
                    <div th:if="${message}" class="success-msg">
                        <span th:text="${message}"></span>
                    </div>

                    <form th:action="@{/verify-otp}" method="post">
                        <div class="mb-3">
                            <label for="otp" class="form-label">Enter OTP sent to your email</label>
                            <input type="text" class="form-control" id="otp" name="otp" required
                                placeholder="Enter 6-digit OTP">
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Verify OTP</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
```

## src\main\resources\templates\welcome.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>Dashboard - Health Tracker</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #242d3f;
            --card-bg: #d4e7f7;
            --text-main: #d4e7f7;
            --text-secondary: #6B7280;
            --danger-color: #EF4444;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: var(--text-main);
        }

        .navbar {
            background-color: var(--card-bg);
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 1rem 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: bold;
            color: var(--primary-color);
            text-decoration: none;
        }

        .nav-links {
            display: flex;
            gap: 1.5rem;
            align-items: center;
        }

        .nav-link {
            text-decoration: none;
            color: var(--text-secondary);
            font-weight: 500;
            transition: color 0.2s;
        }

        .nav-link:hover {
            color: var(--primary-color);
        }

        .btn-logout {
            background-color: var(--danger-color);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 0.375rem;
            text-decoration: none;
            font-size: 0.875rem;
            transition: opacity 0.2s;
        }

        .btn-logout:hover {
            opacity: 0.9;
        }

        .container {
            max-width: 1200px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .welcome-header {
            text-align: center;
            margin-bottom: 3rem;
        }

        .welcome-header h1 {
            font-size: 2.5rem;
            margin-bottom: 0.5rem;
            color: var(--text-main);
        }

        .welcome-header p {
            color: #d4e7f7;
            font-size: 1.1rem;
        }

        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 1.5rem;
        }

        .chart-container {
            position: relative;
            height: 300px;
            width: 100%;
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
            padding: 2rem;
            text-align: center;
            transition: transform 0.2s, box-shadow 0.2s;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            height: 100%;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
        }

        .card-icon {
            font-size: 3rem;
            margin-bottom: 1rem;
        }

        .card-title {
            font-size: 1.5rem;
            font-weight: 600;
            margin-bottom: 0.5rem;
            color: #242d3f;
        }

        .card-desc {
            color: var(--text-secondary);
            margin-bottom: 1.5rem;
            line-height: 1.5;
        }

        .btn-card {
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem 1.5rem;
            border-radius: 0.5rem;
            text-decoration: none;
            font-weight: 500;
            display: inline-block;
            transition: background-color 0.2s;
        }

        .btn-card:hover {
            background-color: var(--primary-hover);
        }

        .btn-card:hover {
            background-color: var(--primary-hover);
        }

        /* Dropdown Styles */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: var(--card-bg);
            min-width: 160px;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            z-index: 1;
            border-radius: 0.375rem;
            top: 100%;
            /* Position below the link */
        }

        .dropdown-content a {
            color: var(--text-secondary);
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            font-weight: 400;
        }

        .dropdown-content a:hover {
            background-color: rgba(79, 70, 229, 0.1);
            color: var(--primary-color);
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .stat-value {
            font-size: 2.5rem;
            font-weight: 700;
            color: var(--primary-color);
            margin: 1rem 0;
        }

        .section-title {
            color: var(--text-main);
            margin-bottom: 2rem;
            margin-top: 3 rem;
            font-size: 1.5rem;
            border-bottom: 2px solid var(--primary-color);
            padding-bottom: 0.5rem;
            display: inline-block;
        }
    </style>
</head>

<body>
    <nav class="navbar">
        <a href="#" class="navbar-brand">HealthTracker</a>
        <div class="nav-links">
            <div class="dropdown" sec:authorize="hasRole('USER')">
                <a href="#" class="nav-link">Activity ▾</a>
                <div class="dropdown-content">
                    <a href="/workouts">Workouts</a>
                    <a href="/meals">Meals</a>
                    <a href="/daily-logs">Daily Log</a>
                </div>
            </div>
            <a href="/bmi" class="nav-link" sec:authorize="hasRole('USER')">BMI Calculator</a>
            <a href="/trainer-matching" class="nav-link" sec:authorize="hasRole('USER')">Trainer Matching</a>
            <a href="/articles" class="nav-link">BLOG</a>
            <a href="/profile" class="nav-link">My Profile</a>
            <a href="/logout" class="btn-logout">Logout</a>
        </div>
    </nav>

    <div class="container">
        <div class="welcome-header">
            <h1>Welcome Back!</h1>
            <p>Track your progress and stay healthy.</p>
        </div>

        <h2 class="section-title">Today Summary</h2>
        <div class="dashboard-grid" style="margin-bottom: 3rem;">
            <div class="card">
                <div class="card-title">Calories Eaten</div>
                <div class="stat-value" th:text="${caloriesEaten}">0</div>
                <div class="card-desc">kcal</div>
            </div>
            <div class="card">
                <div class="card-title">Calories Burned</div>
                <div class="stat-value" th:text="${caloriesBurned}">0</div>
                <div class="card-desc">kcal</div>
            </div>
            <div class="card">
                <div class="card-title">Steps</div>
                <div class="stat-value" th:text="${steps}">0</div>
                <div class="card-desc">steps</div>
            </div>
            <div class="card">
                <div class="card-title">Sleep</div>
                <div class="stat-value" th:text="${sleep}">0</div>
                <div class="card-desc">hours</div>
            </div>
        </div>
        <br>
        <br>
        <h2 class="section-title">Weekly Summary</h2>
        <div class="dashboard-grid" style="margin-bottom: 3rem;">
            <div class="card">
                <div class="card-title">Workout Frequency & Duration</div>
                <div class="chart-container">
                    <canvas id="workoutChart"></canvas>
                </div>
            </div>
            <div class="card">
                <div class="card-title">Calories Consumed & Burned</div>
                <div class="chart-container">
                    <canvas id="caloriesCompareChart"></canvas>
                </div>
            </div>
            <div class="card">
                <div class="card-title">Water Intake & Sleep Pattern</div>
                <div class="chart-container">
                    <canvas id="healthPatternChart"></canvas>
                </div>
            </div>
        </div>
        <br>
        <br>

        <!-- Trainer Assigned Plans (For Users) -->
        <div th:if="${#authorization.expression('hasRole(''USER'')')} and (!${#lists.isEmpty(assignedDiet)} or !${#lists.isEmpty(assignedExercises)})"
            style="margin-bottom: 3rem;">
            <h2 class="section-title" style="margin-bottom: 1.5rem;">Coach's Recommendations</h2>
            <div class="dashboard-grid">
                <!-- Assigned Diet -->
                <div class="card" th:if="!${#lists.isEmpty(assignedDiet)}" style="text-align: left;">
                    <h3 class="card-title" style="color: #242d3f;">Diet Plan</h3>
                    <div th:each="diet : ${assignedDiet}"
                        style="margin-bottom: 1rem; padding-bottom: 0.5rem; border-bottom: 1px solid rgba(255,255,255,0.1);">
                        <div style="display: flex; justify-content: space-between; color : #242d3f;">
                            <strong th:text="${diet.dayOfWeek} + ': ' + ${diet.mealName}"></strong>
                            <small th:text="${diet.calories} + ' cal'" style="color: #242d3f;"></small>
                        </div>
                        <p th:text="${diet.description}"
                            style="font-size: 0.85rem; margin: 0.25rem 0; opacity: 0.8;color : #242d3f;">
                        </p>
                    </div>
                </div>
                <!-- Assigned Exercises -->
                <div class="card" th:if="!${#lists.isEmpty(assignedExercises)}" style="text-align: left;">
                    <h3 class="card-title" style="color: #242d3f;">Workout Plan</h3>
                    <div th:each="ex : ${assignedExercises}"
                        style="margin-bottom: 1rem; padding-bottom: 0.5rem; border-bottom: 1px solid rgba(255,255,255,0.1);">
                        <div style="display: flex; justify-content: space-between;color: #242d3f;">
                            <strong th:text="${ex.dayOfWeek} + ': ' + ${ex.exerciseName}"></strong>
                            <small th:text="${ex.sets} + 'x' + ${ex.reps}" style="color: #242d3f;"></small>
                        </div>
                        <p th:text="${ex.description}"
                            style="font-size: 0.85rem; margin: 0.25rem 0; opacity: 0.8;color : #242d3f;"></p>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>

        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 1.5rem;"
            sec:authorize="hasRole('USER')">
            <h2 class="section-title" style="margin-bottom: 0;">Goal Progress Tracking</h2>
            <button onclick="openGoalModal()" class="btn-card" style="font-size: 0.9rem; padding: 0.5rem 1rem;">Set
                Goals</button>
        </div>

        <div class="dashboard-grid" style="margin-bottom: 3rem;" sec:authorize="hasRole('USER')">
            <div class="card" style="text-align: left;"
                th:with="percent=${T(java.lang.Math).min((currentWeight * 100.0) / weightGoal, 100.0)}">
                <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 0.5rem;">
                    <div class="card-title" style="font-size: 1.2rem; margin: 0;">Weight Goal</div>
                    <div style="text-align: right;">
                        <div style="font-weight: 600; color: var(--text-secondary); font-size: 0.9rem;">
                            <span th:text="${currentWeight}">0</span> / <span th:text="${weightGoal}">70</span> kg
                        </div>
                        <div style="font-size: 1.2rem; font-weight: 700;"
                            th:style="'color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981')) + '; font-size: 1.2rem; font-weight: 700;'">
                            <span th:text="${#numbers.formatInteger(percent, 1)}">0</span>%
                        </div>
                    </div>
                </div>
                <div class="progress-container"
                    style="background-color: #374151; border-radius: 9999px; height: 10px; width: 100%; margin-top: 0.5rem;">
                    <div class="progress-bar"
                        th:style="'width: ' + ${percent} + '%; background-color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981')) + '; height: 100%; border-radius: 9999px; transition: width 0.5s ease-in-out;'">
                    </div>
                </div>
                <div style="margin-top: 0.75rem; font-size: 0.85rem; display: flex; align-items: center; gap: 0.5rem;"
                    th:style="'margin-top: 0.75rem; font-size: 0.85rem; display: flex; align-items: center; gap: 0.5rem; color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981'))">
                    <i class="bi bi-info-circle"></i>
                    <span th:if="${percent < 35}">Consider tracking your calories or increasing daily activity.</span>
                    <span th:if="${percent >= 35 and percent < 70}">Great progress! Keep up the healthy habits to reach
                        your target.</span>
                    <span th:if="${percent >= 70}">You're so close! Stay consistent to achieve your weight goal.</span>
                </div>
            </div>

            <div class="card" style="text-align: left;"
                th:with="percent=${T(java.lang.Math).min((weeklyWorkoutsCompleted * 100.0) / weeklyWorkoutGoal, 100.0)}">
                <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 0.5rem;">
                    <div class="card-title" style="font-size: 1.2rem; margin: 0;">Workout Frequency</div>
                    <div style="text-align: right;">
                        <div style="font-weight: 600; color: var(--text-secondary); font-size: 0.9rem;">
                            <span th:text="${weeklyWorkoutsCompleted}">0</span> / <span
                                th:text="${weeklyWorkoutGoal}">5</span> days
                        </div>
                        <div style="font-size: 1.2rem; font-weight: 700;"
                            th:style="'color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981')) + '; font-size: 1.2rem; font-weight: 700;'">
                            <span th:text="${#numbers.formatInteger(percent, 1)}">0</span>%
                        </div>
                    </div>
                </div>
                <div class="progress-container"
                    style="background-color: #374151; border-radius: 9999px; height: 10px; width: 100%; margin-top: 0.5rem;">
                    <div class="progress-bar"
                        th:style="'width: ' + ${percent} + '%; background-color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981')) + '; height: 100%; border-radius: 9999px; transition: width 0.5s ease-in-out;'">
                    </div>
                </div>
                <div style="margin-top: 0.75rem; font-size: 0.85rem; display: flex; align-items: center; gap: 0.5rem;"
                    th:style="'margin-top: 0.75rem; font-size: 0.85rem; display: flex; align-items: center; gap: 0.5rem; color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981'))">
                    <i class="bi bi-info-circle"></i>
                    <span th:if="${percent < 35}">Even a 15-min home workout counts today. Small steps matter!</span>
                    <span th:if="${percent >= 35 and percent < 70}">Good job! You're making steady progress on your
                        weekly goal.</span>
                    <span th:if="${percent >= 70}">Excellent consistency! Keep it up to finish the week strong.</span>
                </div>
            </div>

            <div class="card" style="text-align: left;"
                th:with="percent=${T(java.lang.Math).min((waterIntake * 100.0) / waterIntakeGoal, 100.0)}">
                <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 0.5rem;">
                    <div class="card-title" style="font-size: 1.2rem; margin: 0;">Water Intake</div>
                    <div style="text-align: right;">
                        <div style="font-weight: 600; color: var(--text-secondary); font-size: 0.9rem;">
                            <span th:text="${#numbers.formatDecimal(waterIntake, 1, 1)}">0.0</span> / <span
                                th:text="${waterIntakeGoal}">3.0</span> L
                        </div>
                        <div style="font-size: 1.2rem; font-weight: 700;"
                            th:style="'color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981')) + '; font-size: 1.2rem; font-weight: 700;'">
                            <span th:text="${#numbers.formatInteger(percent, 1)}">0</span>%
                        </div>
                    </div>
                </div>
                <div class="progress-container"
                    style="background-color: #374151; border-radius: 9999px; height: 10px; width: 100%; margin-top: 0.5rem;">
                    <div class="progress-bar"
                        th:style="'width: ' + ${percent} + '%; background-color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981')) + '; height: 100%; border-radius: 9999px; transition: width 0.5s ease-in-out;'">
                    </div>
                </div>
                <div style="margin-top: 0.75rem; font-size: 0.85rem; display: flex; align-items: center; gap: 0.5rem;"
                    th:style="'margin-top: 0.75rem; font-size: 0.85rem; display: flex; align-items: center; gap: 0.5rem; color: ' + (${percent} < 35 ? '#EF4444' : (${percent} < 70 ? '#F59E0B' : '#10B981'))">
                    <i class="bi bi-info-circle"></i>
                    <span th:if="${percent < 35}">Drink a glass of water now and set a reminder to stay hydrated.</span>
                    <span th:if="${percent >= 35 and percent < 70}">Nice work! Have a few more glasses to reach your
                        daily target.</span>
                    <span th:if="${percent >= 70}">Almost hydrated! Just a bit more to hit your goal today.</span>
                </div>
            </div>
        </div>

        <!-- Goal Setting Modal -->
        <div id="goalModal" class="modal-backdrop">
            <div class="modal-content card">
                <div class="modal-header">
                    <h3>Set Your Goals</h3>
                    <button onclick="closeGoalModal()" class="btn-close"><i class="bi bi-x-lg"></i></button>
                </div>

                <form th:action="@{/update-goals}" method="post">
                    <input type="hidden" name="id" th:value="${user.id}" />

                    <div class="form-group mb-4">
                        <label for="weightGoal" class="form-label">
                            <i class="bi bi-speedometer2"
                                style="color: var(--primary-color); margin-right: 0.5rem;"></i>
                            Weight Goal
                        </label>
                        <div class="input-group-custom">
                            <input type="number" step="0.1" id="weightGoal" name="weightGoal" th:value="${weightGoal}"
                                class="form-control-custom" placeholder="e.g. 70.0" required>
                            <span class="input-suffix">kg</span>
                        </div>
                    </div>

                    <div class="form-group mb-4">
                        <label for="weeklyWorkoutGoal" class="form-label">
                            <i class="bi bi-activity" style="color: var(--primary-color); margin-right: 0.5rem;"></i>
                            Weekly Workout Goal
                        </label>
                        <div class="input-group-custom">
                            <input type="number" id="weeklyWorkoutGoal" name="weeklyWorkoutGoal"
                                th:value="${weeklyWorkoutGoal}" class="form-control-custom" placeholder="e.g. 5"
                                required min="1" max="7">
                            <span class="input-suffix">days/week</span>
                        </div>
                    </div>

                    <div class="form-group mb-4">
                        <label for="waterIntakeGoal" class="form-label">
                            <i class="bi bi-droplet-fill"
                                style="color: var(--primary-color); margin-right: 0.5rem;"></i>
                            Daily Water Goal
                        </label>
                        <div class="input-group-custom">
                            <input type="number" step="0.1" id="waterIntakeGoal" name="waterIntakeGoal"
                                th:value="${waterIntakeGoal}" class="form-control-custom" placeholder="e.g. 3.0"
                                required>
                            <span class="input-suffix">liters/day</span>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" onclick="closeGoalModal()" class="btn-cancel">Cancel</button>
                        <button type="submit" class="btn-save">Save Changes</button>
                    </div>
                </form>
            </div>
        </div>

        <style>
            .modal-backdrop {
                display: none;
                position: fixed;
                z-index: 1000;
                left: 0;
                top: 0;
                width: 100%;
                height: 50%;
                background-color: rgba(15, 23, 42, 0.75);
                backdrop-filter: blur(4px);
                animation: fadeIn 0.2s ease-out;
            }

            .modal-content {
                margin: 5% auto;
                padding: 2rem;
                width: 90%;
                max-width: 450px;
                position: relative;
                animation: slideDown 0.3s ease-out;
                border: 1px solid rgba(255, 255, 255, 0.1);
            }

            .modal-header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 2rem;
            }

            .modal-header h3 {
                margin: 0;
                color: #242d3f;
                font-size: 1.5rem;
            }

            .btn-close {
                background: none;
                border: none;
                font-size: 1.2rem;
                cursor: pointer;
                color: var(--text-secondary);
                padding: 0.5rem;
                border-radius: 50%;
                transition: all 0.2s;
            }

            .btn-close:hover {
                background-color: rgba(0, 0, 0, 0.05);
                color: var(--danger-color);
            }

            .form-label {
                display: block;
                margin-bottom: 0.75rem;
                color: #242d3f;
                font-weight: 600;
                font-size: 0.95rem;
            }

            .input-group-custom {
                position: relative;
                display: flex;
                align-items: center;
            }

            .form-control-custom {
                width: 100%;
                padding: 0.75rem 1rem;
                padding-right: 4rem;
                border: 2px solid #e2e8f0;
                border-radius: 0.5rem;
                font-size: 1rem;
                transition: all 0.2s;
                background-color: #f8fafc;
                color: #334155;
            }

            .form-control-custom:focus {
                outline: none;
                border-color: var(--primary-color);
                box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
                background-color: #fff;
            }

            .input-suffix {
                position: absolute;
                right: 1rem;
                color: var(--text-secondary);
                font-size: 0.875rem;
                pointer-events: none;
            }

            .text-hint {
                font-size: 0.85rem;
                color: var(--text-secondary);
                margin-top: 0.5rem;
                margin-bottom: 0;
            }

            .mb-4 {
                margin-bottom: 1.5rem;
            }

            .modal-footer {
                display: flex;
                gap: 1rem;
                margin-top: 2rem;
            }

            .btn-save {
                flex: 2;
                background-color: var(--primary-color);
                color: white;
                padding: 0.75rem;
                border: none;
                border-radius: 0.5rem;
                font-weight: 600;
                cursor: pointer;
                transition: background-color 0.2s;
            }

            .btn-save:hover {
                background-color: var(--primary-hover);
            }

            .btn-cancel {
                flex: 1;
                background-color: transparent;
                color: var(--text-secondary);
                padding: 0.75rem;
                border: 1px solid #cbd5e1;
                border-radius: 0.5rem;
                font-weight: 600;
                cursor: pointer;
                transition: all 0.2s;
            }

            .btn-cancel:hover {
                background-color: #f1f5f9;
                color: #334155;
            }

            @keyframes fadeIn {
                from {
                    opacity: 0;
                }

                to {
                    opacity: 1;
                }
            }

            @keyframes slideDown {
                from {
                    transform: translateY(-20px);
                    opacity: 0;
                }

                to {
                    transform: translateY(0);
                    opacity: 1;
                }
            }
        </style>

        <script>
            function openGoalModal() {
                const modal = document.getElementById('goalModal');
                modal.style.display = 'block';
                document.body.style.overflow = 'hidden'; // Prevent background scrolling
            }

            function closeGoalModal() {
                const modal = document.getElementById('goalModal');
                modal.style.display = 'none';
                document.body.style.overflow = 'auto'; // Restore scrolling
            }

            // Close modal if clicked outside
            window.onclick = function (event) {
                const modal = document.getElementById('goalModal');
                if (event.target == modal) {
                    closeGoalModal();
                }
            }
        </script>
        <br>
        <br>
        <h2 class="section-title">Daily Recommendation</h2>

        <div class="dashboard-grid" style="margin-bottom: 30px;">
            <div class="card"
                style="background: linear-gradient(135deg, #1e293b 0%, #0f172a 100%); color: white; grid-column: 1 / -1; height: 85%;">
                <div class="card-content"
                    style="display: flex; flex-direction: column; align-items: start; text-align: left;">
                    <h2 class="card-title" style="color: #38bdf8; margin-bottom: 0.5rem;">
                        <span
                            style="font-size: 1.2rem; display: block; color: #94a3b8; font-weight: normal; margin-bottom: 0.25rem;">Daily
                            Health Tip</span>
                        <span th:text="${healthTip.title}">Stay Hydrated</span>
                    </h2>
                    <p class="card-desc" style="color: #cbd5e1; font-size: 1.1rem; max-width: 800px; margin-bottom: 0;"
                        th:text="${healthTip.description}">
                        Drink at least 8 glasses of water daily to maintain optimal health.
                    </p>
                    <div style="margin-top: 1rem; padding: 0.25rem 0.75rem; background: rgba(56, 189, 248, 0.1); border-radius: 1rem; color: #38bdf8; font-size: 0.875rem;"
                        th:text="${healthTip.category}">
                        Hydration
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
    </div>

    <script th:inline="javascript">
        /*[+
        const chartDates = [[${ datesHistory }]];
        const workoutDataByType = [[${ workoutDataByType }]];
        const calEaten = [[${ caloriesEatenHistory }]];
        const calBurned = [[${ caloriesBurnedHistory }]];
        const waterIntake = [[${ waterIntakeHistory }]];
        const sleepPattern = [[${ sleepHistory }]];

        // Helper to generate a distinct color for each workout type
        function getWorkoutColor(index) {
            const colors = [
                'rgba(79, 70, 229, 0.8)',  // Indigo
                'rgba(16, 185, 129, 0.8)', // Emerald
                'rgba(245, 158, 11, 0.8)', // Amber
                'rgba(239, 68, 68, 0.8)',  // Red
                'rgba(6, 182, 212, 0.8)',  // Cyan
                'rgba(139, 92, 246, 0.8)', // Violet
                'rgba(236, 72, 153, 0.8)'  // Pink
            ];
            return colors[index % colors.length];
        }

        // Prepare datasets for Workout Chart
        const workoutDatasets = Object.keys(workoutDataByType).map((type, index) => ({
            label: type,
            data: workoutDataByType[type],
            backgroundColor: getWorkoutColor(index),
            borderRadius: 5,
            stack: 'Stack 0'
        }));

        // Workout Frequency & Duration Chart (Stacked Bar)
        new Chart(document.getElementById('workoutChart'), {
            type: 'bar',
            data: {
                labels: chartDates,
                datasets: workoutDatasets
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    tooltip: {
                        callbacks: {
                            label: function(context) {
                                return ` ${context.dataset.label}: ${context.raw} min`;
                            }
                        }
                    },
                    legend: {
                        position: 'bottom',
                        labels: { color: '#6B7280', usePointStyle: true, padding: 15 }
                    }
                },
                scales: {
                    x: {
                        stacked: true,
                        grid: { display: false }
                    },
                    y: {
                        stacked: true,
                        beginAtZero: true,
                        title: { display: true, text: 'Duration (min)', color: '#6B7280' }
                    }
                }
            }
        });
        +]*/

        // Calories Consumed & Burned Chart
        new Chart(document.getElementById('caloriesCompareChart'), {
            type: 'line',
            data: {
                labels: chartDates,
                datasets: [
                    {
                        label: 'Consumed',
                        data: calEaten,
                        borderColor: '#4F46E5',
                        backgroundColor: 'rgba(79, 70, 229, 0.1)',
                        fill: true,
                        tension: 0.4
                    },
                    {
                        label: 'Burned',
                        data: calBurned,
                        borderColor: '#EF4444',
                        backgroundColor: 'rgba(239, 68, 68, 0.1)',
                        fill: true,
                        tension: 0.4
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: { beginAtZero: true, title: { display: true, text: 'Calories (kcal)' } }
                }
            }
        });

        // Water Intake & Sleep Pattern Chart
        new Chart(document.getElementById('healthPatternChart'), {
            type: 'bar',
            data: {
                labels: chartDates,
                datasets: [
                    {
                        label: 'Sleep (hrs)',
                        data: sleepPattern,
                        type: 'line',
                        borderColor: '#EF4444',
                        backgroundColor: '#EF4444',
                        yAxisID: 'y1',
                        tension: 0.4,
                        order: 0
                    },
                    {
                        label: 'Water (L)',
                        data: waterIntake,
                        backgroundColor: '#3B82F6',
                        yAxisID: 'y',
                        borderRadius: 5,
                        order: 1
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        type: 'linear',
                        display: true,
                        position: 'left',
                        title: { display: true, text: 'Liters' }
                    },
                    y1: {
                        type: 'linear',
                        display: true,
                        position: 'right',
                        grid: { drawOnChartArea: false },
                        title: { display: true, text: 'Hours' }
                    }
                }
            }
        });
    </script>
</body>

</html>
```

## src\main\resources\templates\workout.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Workouts - Health Tracker</title>
    <style>
        :root {
            --primary-color: #4F46E5;
            --primary-hover: #4338CA;
            --bg-color: #F3F4F6;
            --card-bg: #FFFFFF;
            --text-main: #1F2937;
            --text-secondary: #6B7280;
            --border-color: #E5E7EB;
        }

        body {
            font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            padding: 0;
            color: var(--text-main);
        }

        .container {
            max-width: 1000px;
            margin: 3rem auto;
            padding: 0 1.5rem;
        }

        .page-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 2rem;
        }

        .page-title {
            font-size: 2rem;
            font-weight: bold;
            color: var(--text-main);
            margin: 0;
        }

        .btn-back {
            text-decoration: none;
            color: var(--text-secondary);
            font-weight: 500;
            display: flex;
            align-items: center;
            gap: 0.5rem;
            transition: color 0.2s;
        }

        .btn-back:hover {
            color: var(--primary-color);
        }

        .grid-layout {
            display: grid;
            grid-template-columns: 1fr;
            gap: 2rem;
        }

        @media (min-width: 768px) {
            .grid-layout {
                grid-template-columns: 1fr 2fr;
            }
        }

        .card {
            background-color: var(--card-bg);
            border-radius: 0.75rem;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            padding: 2rem;
        }

        .card-title {
            font-size: 1.25rem;
            font-weight: 600;
            margin-bottom: 1.5rem;
            color: var(--text-main);
        }

        .form-group {
            margin-bottom: 1.25rem;
        }

        label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 500;
            color: var(--text-secondary);
        }

        input {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--border-color);
            border-radius: 0.5rem;
            box-sizing: border-box;
            font-size: 1rem;
            transition: border-color 0.2s;
        }

        input:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .btn-submit {
            width: 100%;
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem;
            border: none;
            border-radius: 0.5rem;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .btn-submit:hover {
            background-color: var(--primary-hover);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            text-align: left;
            padding: 1rem;
            background-color: #F9FAFB;
            color: var(--text-secondary);
            font-weight: 600;
            border-bottom: 1px solid var(--border-color);
        }

        td {
            padding: 1rem;
            border-bottom: 1px solid var(--border-color);
            color: var(--text-main);
        }

        tr:last-child td {
            border-bottom: none;
        }

        .empty-state {
            text-align: center;
            color: var(--text-secondary);
            padding: 2rem;
        }
    </style>
</head>

<body>

    <div class="container">
        <div class="page-header">
            <h1 class="page-title">Workouts</h1>
            <a href="/welcome" class="btn-back">← Back to Dashboard</a>
        </div>

        <div class="grid-layout">
            <!-- Add Workout Form -->
            <div class="card">
                <h2 class="card-title">Add New Workout</h2>
                <form th:action="@{/workouts}" th:object="${workout}" method="post">
                    <div class="form-group">
                        <label for="type">Exercise Type</label>
                        <input type="text" id="type" th:field="*{type}" placeholder="e.g., Running, Yoga" required>
                    </div>
                    <div class="form-group">
                        <label for="duration">Duration (minutes)</label>
                        <input type="number" id="duration" th:field="*{duration}" required>
                    </div>
                    <div class="form-group">
                        <label for="calories">Calories Burned</label>
                        <input type="number" id="calories" th:field="*{calories}">
                    </div>
                    <div class="form-group">
                        <label for="date">Date</label>
                        <input type="date" id="date" th:field="*{date}" required>
                    </div>
                    <button type="submit" class="btn-submit">Add Workout</button>
                </form>
            </div>

            <!-- Workouts List -->
            <div class="card">
                <h2 class="card-title">Your History</h2>
                <div th:if="${#lists.isEmpty(workouts)}" class="empty-state">
                    No workouts logged yet. Start moving! 🏃‍♂️
                </div>
                <table th:unless="${#lists.isEmpty(workouts)}">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Type</th>
                            <th>Duration</th>
                            <th>Calories</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr th:each="workout : ${workouts}">
                            <td th:text="${workout.date}"></td>
                            <td th:text="${workout.type}"></td>
                            <td th:text="${workout.duration} + ' mins'"></td>
                            <td th:text="${workout.calories}"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>

</html>
```

## src\test\java\com\healthTracker\implementation\RegisterAndLoginWithSecurityApplicationTests.java
```java
package com.healthTracker.implementation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegisterAndLoginWithSecurityApplicationTests {

	@Test
	void contextLoads() {
	}

}

```
