pipeline {
  agent any
  stages {
    stage('hello') {
      steps {
        echo 'hello'
      }
    }

    stage('Build') {
      when {
        branch "main"
      }
      steps {
        sh 'mvn clean package'
      }
    }

    stage('Test') {
      when {
        branch "main"
      }
      steps {
        sh 'mvn test'
      }
    }
    
  }
}