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
