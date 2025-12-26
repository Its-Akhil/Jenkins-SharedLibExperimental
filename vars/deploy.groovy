def call(){
      echo 'Deploying'
      sh "docker run -d -p 8000:8000 jenkins-notes-app:latest"
}
