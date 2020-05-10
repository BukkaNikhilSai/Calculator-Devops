pipeline {
	environment {
    registry = "bukkanikhilsai/calculator-mini"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Clean Target Files') {
      steps {
        sh 'mvn clean'
      }
    }

    stage('Building Class Files') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('Testing Stage') {
      steps {
        sh 'mvn test'
      }
    }

		stage('DockerHub') {
      stages{
        stage('DockerHub Build Image') {
          steps{
            script {
              dockerImage = docker.build registry + ":$BUILD_NUMBER"
            }
          }
        }
        stage('DockerHub Push Image') {
          steps{
            script {
              docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
								pushLatestBuild = "docker push "+registry
								sh pushLatestBuild
              }
            }
          }
        }
      }
    }
		stage('Rundeck Deploy') {
      agent any
      steps {
        script {
          step([$class: "RundeckNotifier",
          rundeckInstance: "Rundeck",
          options: """
            BUILD_VERSION=$BUILD_NUMBER
          """,
          jobId: "06105e49-e69b-4993-bb02-695840cea2ee"])
        }
      }
    }
  }
}
