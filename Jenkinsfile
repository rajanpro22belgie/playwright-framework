pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Playwright Browsers') {
            steps {
                bat 'mvn -q exec:java -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'reports/**', fingerprint: true
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
