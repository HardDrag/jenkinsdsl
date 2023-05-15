 libraries {
     lib('dsl')
 }

pipeline {
    agent
    stages {
        stage('Demo') {
            agent { label 'kube-agent' }
            steps {
                pipelineMaven name: 'git'
            }
        }
    }
}