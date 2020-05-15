def version, mvnCmd = "mvn -s templates/cicd-settings-nexus3.xml"
  pipeline
  {
   agent any
    tools {
	maven 'maven' 
}
        stages{
          stage('Build App') {
            steps{
              dir('lib-server'){
                  script {
                      def pom = readMavenPom file: 'pom.xml'
                      version = pom.version
                    sh "mvn clean install -DskipTests=true"
                  }
              }

                dir('library-db'){
                   script {
                       def pom = readMavenPom file: 'pom.xml'
                       version = pom.version
                     sh "mvn clean install -DskipTests=true"
                   }
                }

                 dir('member-service'){
                   script {
                       def pom = readMavenPom file: 'pom.xml'
                       version = pom.version
                     sh "mvn clean install -DskipTests=true"
                   }
                }

                 dir('user-limit-service'){
                    script {
                        def pom = readMavenPom file: 'pom.xml'
                        version = pom.version
                      sh "mvn clean install -DskipTests=true"
                    }
                  }
            }
          }

        }
    }
