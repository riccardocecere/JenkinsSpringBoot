# JenkinsSpringBoot
Jenkins CICD Pipeline for a Docker SpringBoot Application build and deploy

---
## Description and Architectures
This is a Jenkins pipeline for a Java Spring Boot Appliction.
In this configuration will be created the following resources:
- **1 Docker in Docker container**  
- **1 Docker Jenkins contianer** with all resource necessaries for networking
- **1 Application Containers**
- **1 Jenkins Pipeline Project**


The project observe the following structure:

```
jenkinsSpringBoot/
.
├── README.md            
├── jenkins                 //jenkins architecture directory
│   ├── Dokerfile           //docker module for jenkins custom image build
│   ├── job.groovy          //Pipeline Project script
│   ├── run-jenkins.sh      //script for jenkins architecture deploy
│   ├── jenkins-jobs.sh     //script for pipeline project initialization
│   ├── jenkins-modules.sh  //script for jenkins module installation
│   └── build-jenkins.sh    //script for jenkins image build
│
├── src                     //java application code directory
│   ├── main                //code directory
│   │   ...                 //java code files
│   └── test                //test directory
│       ...                 //java test files
│       
├── pom.xml                 //springboot dependencies module
├── Dockefile               //docker module for java image build
├── Jenkinsfile             //application pipeline description
├── versions.tf             //version of terraform and providers
└── variables.tf            //main variable declaration manifest
```

---
## Installation and Usage

1. build the jenkins image:
>./jenkins/build-jenkins.sh

2. deploy jenkins server:
>./jenkins/run-jenkins.sh

3. import jenkins modeuls:
>./jenkins/jenkins-modules.sh

5. import jenkins pipeline project:
>./jenkins/jenkins-jobs.sh

6. access to the jenkins server dashboard and launch the build in the pipeline project page at the url:
<http://locahost:8090>

7. after the build succeded test the application sending the following requests
- <http://localhost:8080/spring-boot/hello>
- <http://localhost:8080/spring-boot/hello?name=Ric>
