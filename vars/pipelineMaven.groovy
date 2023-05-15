def call(Map conf) {
    node('master') {
        stage('Get source code') {
            git url: "https://github.com/spring-projects/spring-petclinic.git"
        }
        stage('Build') {
            sh 'mvn package -DskipTests'
        }
        stage('Test') {
            sh 'mvn verify'
        }
        stage('Install') {
            sh 'mvn install -DskipTests'
        }
    }
}