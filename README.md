# aws-ses-adapter

The `aws-ses-adapter` is a spring boot integrated with AWS SES (Amazon - Simple Email Service) used for sending email from Spring Boot App to Gmail.

## Features

* Send mail from Spring Boot App to Gmail by AWS SES

## Tech Stack

* Java 21
* Spring Boot
* AWS SDK - SESV2
* Lombok

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com.c4lab.aws.ses.adapter
            ├── common.util/
│   │       ├── config/
│   │       ├── controller/
│   │       ├── response/
│   │       ├── service/
│   │       └── Application.java
│   └── resources/
│       └── application.yml
└── test/
```

## Requirements

Before running the project, install:

* Java 21+
* Gradle

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/sok-hs/aws-ses-adapter
cd aws-ses-adapter
```

### 2. Run the application

Using the Gradle Wrapper:

```bash
./gradlew bootRun
```

## API Endpoints

| Method | Endpoint                            | Description                                      |
| ------ |-------------------------------------|--------------------------------------------------|
| GET    | `/api/send-email/welcome`           | Send Welcome Email with HTML Content             |
| GET    | `/api/send-email/verification-code` | Send Verification Code Email with HTML Content   |
| GET    | `/api/send-email/password-reset`    | Send Password Reset Email with HTML Content      |
| GET    | `/api/send-email/system-error`      | Send System Error Email with Plaint Text Content |

## Environment Variables

```env
AWS_PROFILE=ses-local
AWS_REGION=ap-southeast-1
```

## Author

**Your Name**

* GitHub: `@sok-hs`