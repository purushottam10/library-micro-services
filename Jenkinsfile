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
                              sh "mvn clean install -DskipTests=true"
                         }
                      }

                      dir('library-db'){
                         script {
                             sh "mvn clean install -DskipTests=true"
                         }
                      }

                      dir('member-service'){
                         script {
                             sh "mvn clean install -DskipTests=true"
                         }
                      }

                      dir('user-limit-service'){
                          script {
                              sh "mvn clean install -DskipTests=true"
                          }
                      }
                  }

              }

              stage('deploy'){

                  steps{
                      sh 'cp /var/lib/jenkins/workspace/lib-server /home/puru/Downloads/server/apache-tomcat-8.5.55/webapps/lib-server'

                      sh 'cp /var/lib/jenkins/workspace/library-db /home/puru/Downloads/server/apache-tomcat-8.5.55/webapps/library-db'

                      sh 'cp /var/lib/jenkins/workspace/member-service /home/puru/Downloads/server/apache-tomcat-8.5.55/webapps/member-service'

                      sh 'cp /var/lib/jenkins/workspace/user-limit-service /home/puru/Downloads/server/apache-tomcat-8.5.55/webapps/user-limit-service'
                  }
              }
           }
     }
  }
