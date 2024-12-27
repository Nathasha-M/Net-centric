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
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Images') {
            steps {
                sh 'docker-compose build'
            }
        }
        stage('Run Docker Containers') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
    post {
        always {
            echo 'Pipeline completed successfully!'
        }
    }
}
