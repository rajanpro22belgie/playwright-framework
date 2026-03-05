pipeline {
    agent any

    triggers {
        cron('0 2 * * *')   // run every day at 02:00 (server time)
    }

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
                sh 'mvn -q exec:java -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
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
