def call(){
                sh "touch .dockerignore"
                sh "whoami"
                sh "cat Dockerfile"
                sh 'echo CMD \'["gunicorn", "notesapp.wsgi:application", "--bind", "0.0.0.0:8000", "--workers=3"]\' >> Dockerfile'
                sh "cat Dockerfile"
                sh "docker buildx build -t notes-app:latest ."
}
