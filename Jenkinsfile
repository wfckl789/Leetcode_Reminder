pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/wfckl789/Leetcode_Reminder.git'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }

<<<<<<< HEAD
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
=======
    stage('Test') {
      steps {
        sh 'mvn test'
      }
>>>>>>> 59e8c51bf9781479c3561b571a1a9ddebb9d338e
    }

  }
}