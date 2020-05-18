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

             
       }
  }
