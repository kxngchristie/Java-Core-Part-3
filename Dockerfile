# Using a small JDK base image
FROM eclipse-temurin:25-jdk-alpine

# Setting environment variables for Maven version and PATH
ENV MAVEN_VERSION=3.9.11 \
    PATH=/usr/share/maven/bin:$PATH

# Installing Maven and required tools
RUN apk add --no-cache curl unzip bash \
    && curl -fsSL https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xz -C /usr/share \
    && mv /usr/share/apache-maven-${MAVEN_VERSION} /usr/share/maven

# Setting working directory
WORKDIR /Java-Core-Part-3

# Copying pom.xml first for dependency caching
COPY pom.xml .

# Downloads all dependencies
RUN mvn dependency:resolve

# Copying source code
COPY src ./src

# Compiles and packages the application
RUN mvn clean package -DskipTests

# ENTRYPOINT for running tests
ENTRYPOINT ["mvn", "clean test"]