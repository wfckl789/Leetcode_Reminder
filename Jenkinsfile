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

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
  }
}