node {

        stage('Checkout') {
            git url: 'https://github.com/Purushottam10/library-micro-services.git', branch: 'dev'
        }

            dir('lib-server') {

             stage("Compilation and Analysis") {
                parallel 'Compilation': {
                    if (isUnix()) {
                        sh "./mvnw clean install -DskipTests"
                    } else {
                        bat "./mvnw.cmd clean install -DskipTests"
                    }
                }
             }
             stage("Tests and Deployment") {

             }
        }

         dir('library-db') {

             stage("Compilation and Analysis") {
                parallel 'Compilation': {
                    if (isUnix()) {
                        sh "./mvnw clean install -DskipTests"
                    } else {
                        bat "./mvnw.cmd clean install -DskipTests"
                    }
                }
             }
         }

         dir('member-service') {

              stage("Compilation and Analysis") {
                 parallel 'Compilation': {
                     if (isUnix()) {
                         sh "./mvnw clean install -DskipTests"
                     } else {
                         bat "./mvnw.cmd clean install -DskipTests"
                     }
                 }
              }
         }

         dir('user-limit-service') {

              stage("Compilation and Analysis") {
                 parallel 'Compilation': {
                     if (isUnix()) {
                         sh "./mvnw clean install -DskipTests"
                     } else {
                         bat "./mvnw.cmd clean install -DskipTests"
                     }
                 }
              }
         }
}
