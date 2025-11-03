pipeline {
  agent any
  tools {
    maven 'Maven3'
  }
  stages {
    stage('Build with Maven') {
      steps {
        echo 'Building Spring Boot app...'
        sh 'mvn clean package -DskipTests'
      }
    }
    stage('Build Docker Image') {
      steps {
        sh 'docker build -t springboot-demo .'
      }
    }
    stage('Run Docker Container') {
      steps {
        sh 'docker stop springboot-demo || true'
        sh 'docker rm springboot-demo || true'
        sh 'docker run -d --name springboot-demo -p 8080:8080 springboot-demo'
      }
    }
  }
  post {
    failure {
      echo '❌ Build failed!'
    }
    success {
      echo '✅ Build successful!'
    }
  }
}
