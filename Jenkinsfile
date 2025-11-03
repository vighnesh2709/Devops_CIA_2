pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Jenkins automatically does this if you use "Pipeline from SCM"
                // But it's safe to keep — it won't hurt anything.
                git branch: 'main', url: 'https://github.com/vighnesh2709/Devops_CIA_2'
            }
        }

        stage('Build with Maven') {
            steps {
                echo "Building Spring Boot app..."
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                sh 'docker build -t springboot-demo .'
            }
        }

        stage('Run Docker Container') {
            steps {
                echo "Running Docker container..."
                sh '''
                    docker stop springboot-demo || true
                    docker rm springboot-demo || true
                    docker run -d --name springboot-demo -p 8080:8080 springboot-demo
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Build and deployment successful!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
