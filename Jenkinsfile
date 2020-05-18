def version, mvnCmd = "mvn -s templates/cicd-settings-nexus3.xml"
  pipeline
  {
   agent any
        tools {
        maven 'maven'
        }
        stages{

        stage('usernamePassword') {
              steps {
                script {
                  withCredentials([
                    usernamePassword(credentialsId: 'server',
                      usernameVariable: 'manager',
                      passwordVariable: 's3cret')
                  ])
                }
              }
            }

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

          stage('deploy'){
           steps {
               dir('lib-server'){
                   deploy adapters: [tomcat9(credentialsId 'server', path: '/', url: "https://localhost:8089/lib-server")], onFailure: false, war: 'target/*.war'
               }
                dir('library-dbr'){
                  deploy adapters: [tomcat9(credentialsId 'server', path: '/', url: "https://localhost:8089/library-db")], onFailure: false, war: 'target/*.war'
                }
                dir('member-service'){
                  deploy adapters: [tomcat9(credentialsId 'server', path: '/', url: "https://localhost:8089/member-service")], onFailure: false, war: 'target/*.war'
                }
                dir('user-limit-service'){
                  deploy adapters: [tomcat9(credentialsId 'server', path: '/', url: "https://localhost:8089/user-limit-service")], onFailure: false, war: 'target/*.war'
                }
           }

          }

        }
   }
