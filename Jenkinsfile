library 'dsl'

pipeline {
    agent none
    stages {
        stage('Demo') {
            agent { label 'kube-agent' }
            steps {
                pipelineMaven([initTests: '0', initInstall: '0'], 'test')
            }
        }
    }
}