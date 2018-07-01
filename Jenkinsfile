// Scripted Pipeline as Code
node {
  stage('git checkout') {
      git branch: 'ci/cd', url: 'https://github.com/mazma1/postit-devops.git'
  }
         
  stage('install dependencies') {
      sh 'npm install'
  }
          
  stage('test') {
      sh 'npm run test:client'
  }
          
  stage('build') {
      sh 'npm run build:server'
      sh 'npm run build:client'
  }
      
  stage('archive') {
      archiveArtifacts artifacts: '*, app/client/dist/, app/server/dist/, packer/, terraform/, scripts/'
  }

  stage('deploy') {
      withCredentials([string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID'), string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY'), string(credentialsId: 'EssentialsKeyPair', variable: 'EssentialsKeyPair')]) {
          sh 'chmod +x scripts/deploy.sh'
          sh 'scripts/deploy.sh'
      }
  }
}