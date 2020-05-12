node {
     stage('Build'){

     git url: 'https://github.com/Purushottam10/library-micro-services'

         withMaven(maven: 'maven-3',mavenSettingsConfig: 'my-maven-settings'){
         sh "mvn clean verify install"
         }

     }

     stage('Deploy'){
         steps {
            sh 'make publish'
         }
     }
}
