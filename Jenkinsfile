pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Nathasha-M/Net-centric.git'
            }
        }
        stage('Build Backend') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Build Docker Images') {
            steps {
                bat 'docker-compose build'
            }
        }
        stage('Run Docker Containers') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
    post {
        always {
            echo 'Pipeline completed successfully!'
        }
    }
}

