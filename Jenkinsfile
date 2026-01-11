pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh 'gradle test'
                sh 'gradle jacocoTestReport'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                    cucumber 'build/reports/cucumber/report.json'
                }
            }
        }

        stage('Code Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'gradle sonar'
                }
            }
        }

        stage('Code Quality') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Build') {
            steps {
                sh 'gradle assemble'
                sh 'gradle javadoc'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'build/libs/*.jar, build/docs/javadoc/**', fingerprint: true
                }
            }
        }

        stage('Deploy') {
            steps {
                sh 'gradle publish'
            }
        }
    }

    post {
        success {
            echo 'Deployment successful'
            // slackSend color: 'good', message: "Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} successful"
            // mail to: 'dev-team@example.com', subject: "Build Success", body: "Build ${env.BUILD_NUMBER} succeeded."
        }
        failure {
            echo 'Pipeline failed'
            // slackSend color: 'danger', message: "Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} failed"
            // mail to: 'dev-team@example.com', subject: "Build Failed", body: "Build ${env.BUILD_NUMBER} failed."
        }
    }
}
