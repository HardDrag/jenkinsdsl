@Library('dsl') _

pipeline {
    agent none
    stages {
        stage('Demo') {
            agent { label 'kube-agent' }
            steps {
                pipelineMaven name: 'git'
            }
        }
    }
}