def call(){
                  withCredentials(
                    [usernamePassword(
                        credentialsId:'DockerHub',
                        passwordVariable: 'varForPass',
                        usernameVariable: 'varForUname'
                    )]){
                        sh 'docker login -u ${varForUname} -p ${varForPass}'
                        sh 'docker image tag notes-app:latest ${varForUname}/jenkins-notes-app:latest'
                        sh 'docker push ${varForUname}/jenkins-notes-app:latest'
                    }
}
