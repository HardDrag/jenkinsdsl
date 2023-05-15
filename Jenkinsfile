library 'dsl@master'

pipeline {
    agent none
    stages {
        stage('Demo') {
            agent { label 'java-agent' }
            steps {
                pipelineMaven name: 'git'
            }
        }
    }
}