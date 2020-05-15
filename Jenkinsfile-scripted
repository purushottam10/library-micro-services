node {

        stage('Checkout') {
            git url: 'https://github.com/Purushottam10/library-micro-services.git', branch: 'dev'
        }

        stage("Build") {
              dir('lib-server') {
                parallel 'Compilation': {
                    if (isUnix()) {
                      sudo sh "./mvnw clean install -DskipTests"
                    } else {
                        bat "./mvnw.cmd clean install -DskipTests"
                    }
                }
             }


             dir('library-db') {
                    parallel 'Compilation': {
                        if (isUnix()) {
                          sudo sh "./mvnw clean install -DskipTests"
                        } else {
                            bat "./mvnw.cmd clean install -DskipTests"
                        }
                    }
             }

             dir('member-service') {

                     parallel 'Compilation': {
                         if (isUnix()) {
                           sudo sh "./mvnw clean install -DskipTests"
                         } else {
                             bat "./mvnw.cmd clean install -DskipTests"
                         }
                     }
             }

             dir('user-limit-service') {

                     parallel 'Compilation': {
                         if (isUnix()) {
                            sudo sh "./mvnw clean install -DskipTests"
                         } else {
                             bat "./mvnw.cmd clean install -DskipTests"
                         }
                     }

             }
        }
}
