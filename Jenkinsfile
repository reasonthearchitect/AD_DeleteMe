node {
    stage 'Checkout'
    git url: 'https://github.com/reasonthearchitect/AD_DeleteMe.git'

    stage 'Build'
    sh "./gradlew clean build sonarqube"

    stage 'BuildRunDocker'
    //sh 'docker kill deleteme'
    //sh 'docker rm deleteme'
    sh 'docker build -t reasonthearchitect/deleteme .'
    sh 'docker run -d --name deleteme -p 8844:8844 reasonthearchitect/deleteme'
}