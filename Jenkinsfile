pipeline {
//     environment {
//         JAVA_HOME = '/opt/java/jdk-21.0.2+13'
//         PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
//     }

    agent any

    stages {

        stage('Check Java Version') {
                steps {
                    sh 'java -version'
                    sh 'google-chrome --version || echo "Google Chrome not installed"'
                }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test -Dselenium.headless=true'
            }
        }
    }
}