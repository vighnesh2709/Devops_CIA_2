pipeline {
  agent any
  tools {
    maven 'Maven3'
  }

  environment {
    PROJECT_ID = 'springboot-ci-cd-477112'
    REGION = 'asia-south1'
    REPO = 'springboot-repo'
    IMAGE = 'springboot-demo'
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
        sh 'docker build -t $IMAGE .'
      }
    }

    stage('Push to Artifact Registry') {
      steps {
        sh '''
        gcloud auth activate-service-account --key-file=/var/jenkins_home/jenkins-key.json
        gcloud auth configure-docker $REGION-docker.pkg.dev --quiet
        docker tag $IMAGE $REGION-docker.pkg.dev/$PROJECT_ID/$REPO/$IMAGE:latest
        docker push $REGION-docker.pkg.dev/$PROJECT_ID/$REPO/$IMAGE:latest
        '''
      }
    }

    stage('Deploy to Cloud Run') {
      steps {
        sh '''
        gcloud run deploy $IMAGE \
          --image=$REGION-docker.pkg.dev/$PROJECT_ID/$REPO/$IMAGE:latest \
          --platform=managed \
          --region=$REGION \
          --allow-unauthenticated
        '''
      }
    }
  }

  post {
    success {
      echo '✅ Deployed to Cloud Run successfully!'
    }
    failure {
      echo '❌ Build or deploy failed.'
    }
  }
}
