def call( String credName, String repoName, String tag){
                  withCredentials(
                    [usernamePassword(
                        credentialsId: "${credName}",
                        passwordVariable: 'varForPass',
                        usernameVariable: 'varForUname'
                    )]){
                        sh "docker login -u ${varForUname} -p ${varForPass}"
                        sh "docker image tag ${repoName}:${tag} ${varForUname}/${repoName}:${tag}"
                        sh "docker push ${varForUname}/${repoName}:${tag}"
                    }
}
