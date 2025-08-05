pipeline {
    agent any

    tools {
        maven 'Maven 3.8.5'      // 🔁 Use the exact name from Jenkins > Global Tool Config
        jdk 'JDK11'              // 🔁 Match name from Jenkins > Global Tool Config
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
                deploy adapters: [tomcat8(credentialsId: 'tomcat-cred-id',   // 🔁 Your Jenkins credentials ID
                                          path: '', 
                                          url: 'http://localhost:8080')], 
                       war: "target/${env.WAR_NAME}"
            }
        }
    }
}
