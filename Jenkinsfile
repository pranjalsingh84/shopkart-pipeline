pipeline {
    agent any

    tools {
        maven 'maven-3.9.11'      // ✅ Match exactly with Jenkins > Global Tool Config
        jdk 'jdk21'               // ✅ Match exactly with Jenkins > Global Tool Config
    }

    environment {
        WAR_NAME = "shopkart-pipeline.war"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/pranjalsingh84/shopkart-pipeline.git', branch: 'main'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Archive WAR') {
            steps {
                archiveArtifacts artifacts: "target/${env.WAR_NAME}", fingerprint: true
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                deploy adapters: [tomcat8(
                    credentialsId: 'tomcat-cred-id',
                    path: '', 
                    url: 'http://localhost:8080')],
                war: "target/${env.WAR_NAME}"
            }
        }
    }
}
