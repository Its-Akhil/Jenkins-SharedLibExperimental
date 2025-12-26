def call( String credName, String repoName, String tag){
                  withCredentials(
                    [usernamePassword(
                        credentialsId: credName,
                        passwordVariable: 'varForPass',
                        usernameVariable: 'varForUname'
                    )]){
                        sh "docker login -u ${env.varForUname} -p ${env.varForPass}"
                        sh "docker image tag ${repoName}:${tag} ${env.varForUname}/${repoName}:${tag}"
                        sh "docker push ${env.varForUname}/${repoName}:${tag}"
                    }
}
