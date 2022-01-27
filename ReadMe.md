# User Service
Exposes a single GET endpoint(/api/users) that will return all the users, registered and unregistered, including the project ids the users belong to. If users do not belong to a project, project ids attribute would contain an empty array in the response payload.
## Required components for running the application in development mode
* GIT Client
* JDK 8
* Maven 3.8
* STS (if you have already then import the project or clone from the STS directly)
## Install
* Before Cloning the GIT Repo, follow below steps to generate and install the SSL Certs for the External API Endpoints
  `https://github.com/escline/InstallCert`
  Note: There other ways like importing the SSL certs from the Keytools or passing the SSL Certs to spring boot config
* Once the SSL Certs are installed into JAVA_HOME/JRE/lib/secruity/ folder, Clone the GIT Repo
## Start the internal application in development mode
### Via Command Line
* Open Command line window
* Go to the Project Directory, cd user.service
* run the 'npm install' - to make sure the build is success
* run the 'mvn spring-boot:run' which starts the service
### Via STS
* Once the project cloned from GIT Repo and imported into STS
* Right Click on the Project
* Click on "Run As > Spring Boot App"
## Containarization
### Pre-Reqs
* Install Docker (https://docs.docker.com/get-docker/)
### Build & Running in Local
* Open the Command Line and go to the project home directory (/user.service)
* Run below commands to build image
> mvn clean install
> docker build -t myservices/user.service .
* Deploy / Run the image
> docker run -p 8080:8080 myservices/user.service
* Check the container is running, open another command lin and run below
> docker ps
* to stop the container run below command
>docker stop containerID <grab the containerID from above docker ps command >

### Validating
* Once the app is running either via STS/Command Line/Docker run
* Open the browser or Postman and hit the below endpoint which produces the results
'http://localhost:8080/api/users' (GET)
* Enabled Swagger API Docs
'http://localhost:8080/swagger-ui.html'

## Additional Information
### Moved all the Endpoints to the application.properties file.
### Added base component to enable the authentication
### Swagger API Doc can be disabled based on the environment..