<<<<<<< HEAD
pipeline {
    agent any
    stages {
        stage('Clone Repo') {
            steps {
                git url: 'https://github.com/pavanatyam/LEGAL-AWARNESS', credentialsId: 'github-creds-2'
            }
        }
        stage('Build Image') {
            steps {
                sh 'docker build -t law-awareness .'
            }
        }
        stage('Run Container') {
            steps {
                sh '''
                docker rm -f law-awareness-container || true
                docker run -d -p 8080:80 --name law-awareness-container law-awareness
                '''
            }
        }
    }
}
=======
pipeline {
    agent any

    environment {
        IMAGE_NAME = 'law-awareness'
        CONTAINER_NAME = 'law-awareness-container'
    }

    stages {
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Stop & Remove Old Container') {
            steps {
                bat 'docker stop %CONTAINER_NAME% || exit 0'
                bat 'docker rm %CONTAINER_NAME% || exit 0'
            }
        }

        stage('Run New Container') {
            steps {
                bat 'docker run -d -p 8080:80 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }
    }

    post {
        always {
            echo 'Build complete.'
        }
    }
}
>>>>>>> 91a3133 (Add Jenkinsfile for automated CI/CD)
