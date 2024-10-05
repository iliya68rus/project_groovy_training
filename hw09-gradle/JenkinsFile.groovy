pipeline {
    agent any

    environment {
        MODULES = getModules()
    }

    stages {
        stage('PrintSysTime') {
            steps {
                echo "branch name: ${branch}"
                script {
                    def now = java.time.LocalDateTime.now()
                    def time = now.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"))
                    echo "time: ${time}"
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    println "modules = ${env.MODULES}"
                }
            }
        }
    }
}

def getModules() {
    ['hw01-gradle', 'hw02-gradle', 'hw03-gradle']
}