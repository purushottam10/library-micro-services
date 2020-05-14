node {

        stage('Checkout') {
            git url: 'https://github.com/Purushottam10/library-micro-services.git', credentialsId: 'github-piomin', branch: 'dev'
        }
 
        stage('Build') {
            sh 'mvn clean install'
 
            def pom = readMavenPom file:'lib-server/pom.xml'
            print pom.version
            env.version = pom.version
        }
 
        stage('Image') {
            dir ('discovery-service') {
                def app = docker.build "localhost:1111/discovery-service:${env.version}"
                app.push()
            }
        }
 
        stage ('Run') {
            docker.image("localhost:1111/discovery-service:${env.version}").run('-p 1111:1111 -h discovery --name discovery')
        }
 
        stage ('Final') {
            build job: 'account-service-pipeline', wait: false
        }      
 
    }
 
}