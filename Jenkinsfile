pipeline {
    agent any

    stages {
        stage ('checkout') {
            steps {
                checkout scm
                sh 'pwd'
                sh 'ls -alF'
            }
        }
        stage ('build') {
            steps {
                withEnv(["JAVA_HOME=${ tool 'jdk8' }", "PATH+MAVEN=${tool 'maven-3.5.2'}/bin:${env.JAVA_HOME}/bin"]) {
                    sh 'mvn --show-version --batch-mode --fail-at-end -Dsurefire.rerunFailingTestsCount=2 clean install'
                }
            }
        }
        stage ('archive results') {
            steps {
                step([$class: 'JUnitResultArchiver', testResults: '**/target/*-reports/*.xml'])
            }
        }
        stage ('Cleanup') {
            steps {
                deleteDir()
            }
        }
    }
}
