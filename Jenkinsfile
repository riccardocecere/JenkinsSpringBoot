pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t springboot-demo:latest .'
                }
            }
        }

        stage('Run Docker Image') {
            steps {
                script {
                    sh 'docker run springboot-demo:latest'
                }
            }
        }
    }
}