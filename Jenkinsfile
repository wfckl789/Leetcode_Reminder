pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                git 'https://github.com/wfckl789/Leetcode_Reminder.git'
            }
        }
        stage('build') {
            steps {
                echo 'start building'
                sh 'mvn clean package'
            }
        }
        stage('test') {
            steps {
                echo 'start testing'
                sh 'mvn test'
            }
        }
    }
}

