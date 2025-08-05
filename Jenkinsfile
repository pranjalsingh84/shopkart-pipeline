pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'
        jdk 'JDK11'
    }

    environment {
        DEPLOY_PATH = "/path/to/tomcat/webapps"  // Optional
    }

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/pranjalsingh84/shopkart-pipeline.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Copying WAR file to Tomcat (optional)"
                // sh 'cp target/*.war $DEPLOY_PATH'
            }
        }
    }

    post {
        success {
            echo "✅ Build, Test, and Deploy successful!"
        }
        failure {
            echo "❌ Pipeline failed!"
        }
    }
}
