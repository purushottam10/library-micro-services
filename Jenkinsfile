node {

        stage('Checkout') {
            git url: 'https://github.com/Purushottam10/library-micro-services.git', branch: 'dev'
        }

            dir('lib-server') {
             stage("Build") {
                parallel 'Compilation': {
                    if (isUnix()) {
                      sudo "./mvnw clean install -DskipTests"
                    } else {
                         "./mvnw.cmd clean install -DskipTests"
                    }
                }
             }
        }

         dir('library-db') {
             stage("Build") {
                parallel 'Compilation': {
                    if (isUnix()) {
                      sudo "./mvnw clean install -DskipTests"
                    } else {
                        "./mvnw.cmd clean install -DskipTests"
                    }
                }
             }
         }

         dir('member-service') {
              stage("Build") {
                 parallel 'Compilation': {
                     if (isUnix()) {
                       sudo ./mvnw clean install -DskipTests"
                     } else {
                         "./mvnw.cmd clean install -DskipTests"
                     }
                 }
              }
         }

         dir('user-limit-service') {
              stage("Build") {
                 parallel 'Compilation': {
                     if (isUnix()) {
                        sudo "./mvnw clean install -DskipTests"
                     } else {
                         bat "./mvnw.cmd clean install -DskipTests"
                     }
                 }
              }
         }
}
