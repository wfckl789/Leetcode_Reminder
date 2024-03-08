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
        git 'https://github.com/wfckl789/Leetcode_Reminder.git'
        sh 'mvn clean package'
      }
    }

    stage('Test') {
      steps {
        git 'https://github.com/wfckl789/Leetcode_Reminder.git'
        sh 'mvn test'
      }
    }
  }
}