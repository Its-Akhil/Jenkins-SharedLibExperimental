def call(String credName, String repoName, String tag) {
    withCredentials([
        usernamePassword(
            credentialsId: credName,
            passwordVariable: 'varForPass',
            usernameVariable: 'varForUname'
        )
    ]) {
        sh 'echo $varForPass | docker login -u $varForUname --password-stdin'
        sh "docker image tag ${repoName}:${tag} $varForUname/${repoName}:${tag}"
        sh "docker push $varForUname/${repoName}:${tag}"
    }
}
