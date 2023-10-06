node{
    def mvnHome = tool name: 'maven', type: 'maven'
    def mvnCMD = "${mvnHome}/bin/mvn "

    stage('checkout')
    {
        checkout([$class: 'GitSCM',
        branches: [[name: '*/master']],
        extensions: [],
        userRemoteConfigs: [[credentialsId: 'git',url: 'https://github.com/KirtiShekhar/MicroservicesDockerK8sShoppingApplication.git']]])
    }

    stage('Build')
    {
        sh "${mvnCMD} clean install"
    }
}