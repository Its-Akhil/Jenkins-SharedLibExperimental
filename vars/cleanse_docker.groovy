def call(){
                sh "docker ps -aq | xargs -r docker stop"
                sh "docker ps -aq | xargs -r docker rm -f"
                sh "docker image prune -af"
                sh "docker volume prune -f"
                sh "docker network prune -f"
                sh "docker builder prune -af"
}
