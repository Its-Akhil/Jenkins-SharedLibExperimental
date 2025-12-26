def call(){
                sh "touch .dockerignore"
                sh 'echo CMD \'["gunicorn", "notesapp.wsgi:application", "--bind", "0.0.0.0:8000", "--workers=3"]\' >> Dockerfile'
                // sh "cat Dockerfile"
                sh "docker buildx build --quiet -t notes-app:latest ."
}
