@Library('my-shared-library') _

pipeline {
    agent any
    stages {
        stage('Demo') {
            steps {
                pipelineMaven name: 'git'
            }
        }
    }
}