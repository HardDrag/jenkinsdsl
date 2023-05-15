def call(Map conf) {
    node {
        stage('Get source code') {
            checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/spring-projects/spring-petclinic.git']]])
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