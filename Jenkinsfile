pipeline {
    agent any

    stages {
        stage('1. Verification Code') {
            steps {
                sh 'ls -la'
            }
        }

        stage('2. Build & Tests') {
            steps {
                sh 'docker build -t app-devops:latest .'
            }
        }

        stage('3. Deploiement Conteneur') {
            steps {
                sh '''
                    docker stop app-prod || true
                    docker rm app-prod || true
                    docker run -d --name app-prod --restart always -p 3000:3000 app-devops:latest
                '''
            }
        }

        stage('4. Smoke Test (Verification en direct)') {
            steps {
                sh '''
                    sleep 3
                    # Verification directe a l interieur du conteneur sans souci de reseau
                    docker exec app-prod wget -qO- http://127.0.0.1:3000/healthz
                '''
            }
        }
    }
}
