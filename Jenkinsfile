node {
  def image
        stage ('Checkout from SCM') {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '', url: 'https://github.com/srikarkc/myfirstapp.git']]])      
        }
   
        stage ('Build') {
            def mvnHome = tool name: 'maven', type: 'maven'
            def mvnCMD = "${mvnHome}/bin/mvn "
            sh "${mvnCMD} clean package"           
        }
       
       
        stage ('Docker Build') {
            docker.build('013593650453.dkr.ecr.us-east-1.amazonaws.com/angi-test:latest')
        }
        
        stage ('Docker Push to ECR')
            docker.withRegistry('https://013593650453.dkr.ecr.us-east-1.amazonaws.com/angi-test', 'ecr:us-east-1:aws-credentials'){
            docker.image('013593650453.dkr.ecr.us-east-1.amazonaws.com/angi-test:latest').push('latest')
        }
  
        stage ('K8S Deploy'){
                    sh 'kubectl apply -f spring-boot.yaml'
        } 
}
