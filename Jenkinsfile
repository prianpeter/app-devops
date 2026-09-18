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
                    # Arreter et supprimer l ancien conteneur s il existe deja
                    docker stop app-prod || true
                    docker rm app-prod || true

                    # Lancer la nouvelle version en arriere-plan
                    docker run -d --name app-prod --restart always -p 3000:3000 app-devops:latest
                '''
            }
        }

        stage('4. Smoke Test (Verification en direct)') {
            steps {
                sh '''
                    # Attendre 2 secondes que l API demarre
                    sleep 2

                    # Tester si la sonde healthz repond bien 200 OK
                    curl -f http://localhost:3000/healthz
                '''
            }
        }
    }
}
