def call(Map conf) {
    node {
        stage('Build') {
            sh 'mvn package -DskipTests'
        }
        stage('Test') {
            if(conf.initTests == '1') {
                sh 'mvn verify'
                junit 'target/surefire-reports/*.xml'
            } else {
                echo 'Tests skipped'
            }
        }
        stage('Install') {
            if(conf.initInstall == '1') {
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
                if(conf.initTests == '1') {
                    sh 'mvn verify'
                    junit 'target/surefire-reports/*.xml'
                } else {
                    echo 'Tests skipped'
                }
            }
            stage('Install') {
                ansiColor('xterm')
                {
                    echo '\033[32m' + 'Installing...'
                }
                if(conf.initInstall == '1') {
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