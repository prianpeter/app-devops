pipeline {
    agent any

    stages {
        stage('1. Verification Code') {
            steps {
                echo 'Recuperation et verification des fichiers sources...'
                sh 'ls -la'
            }
        }

        stage('2. Build & Tests (Docker)') {
            steps {
                echo 'Construction de l image et passage des tests...'
                sh 'docker build -t app-devops:latest .'
            }
        }

        stage('3. Nettoyage et Validation') {
            steps {
                echo 'Validation de l image generee :'
                sh 'docker images | grep app-devops'
            }
        }
    }
}
