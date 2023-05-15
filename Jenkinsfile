 libraries {
     lib('dsl')
 }

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