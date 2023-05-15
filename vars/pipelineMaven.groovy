def call(Map conf) {
    node {
        stage('Get source code') {
            checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/spring-projects/spring-petclinic.git']]])
        }
        stage('Build') {
            sh 'mvn package -DskipTests'
        }
        stage('Test') {
            if(conf.initTest == 1) {
                sh 'mvn verify'
            } else {
                echo 'Tests skipped'
            }
        }
        stage('Install') {
            if(conf.initTest == 1) {
                sh 'mvn install -DskipTests'
            } else {
                echo 'Installation skipped'
            }
        }
    }
}

def call(Map conf, String label) {
    node {
        wrap([$class: 'TimestamperBuildWrapper']) {
            stage('Get source code') {
                ansiColor('xterm')
                {
                    echo '\033[32m' + 'Getting source code...'
                }
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/spring-projects/spring-petclinic.git']]])
            }
            stage('Build') {
                ansiColor('xterm')
                {
                    echo '\033[32m' + 'Building source code...'
                }
                sh 'mvn package -DskipTests'
            }
            stage('Test') {
                ansiColor('xterm')
                {
                    echo '\033[32m' + 'Testing...'
                }
                if(initTest == 1) {
                    sh 'mvn verify'
                } else {
                    echo 'Tests skipped'
                }
            }
            stage('Install') {
                ansiColor('xterm')
                {
                    echo '\033[32m' + 'Installing...'
                }
                if(initTest == 1) {
                    sh 'mvn install -DskipTests'
                } else {
                    echo 'Installation skipped'
                }
            }
            stage('Cleanup') {
                ansiColor('xterm')
                {
                    echo '\033[32m' + 'Cleaning up...'
                }
                cleanWs()
            }
        }
    }
}