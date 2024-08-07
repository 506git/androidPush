pipeline{
  agent any
  tools {
      jdk 'jdk8'
      gradle 'Gradle 8.3'
  }


  options {
    disableConcurrentBuilds(abortPrevious: true) // 실행중인 빌드를 중단하고 새 빌드 시작
  }

   environment {
      JAVA_HOME = tool name: 'jdk8', type: 'jdk'
      GRADLE_HOME = tool name: 'Gradle 8.3', type: 'gradle'
      PATH = "${env.JAVA_HOME}/bin:${env.GRADLE_HOME}/bin:${env.PATH}"
     // PATH = "${env.GRADLE_HOME}/bin:${env.PATH}"
  }

  stages {
    stage("Cleanup Workspace"){
      steps {
        script {
          sh """rm -rf ./ltg-aos_${env.GIT_BRANCH}"""
        }
      }
    }
    stage("Code Checkout") {
      steps{
          git branch: env.GIT_BRANCH,
          credentialsId: 'github_access_token',
          url: 'https://github.com/506git/androidPush.git'
      }
    }
    stage("Build"){
      steps{
         sh '''
            gradle build
          '''
      }
    }
  }
}