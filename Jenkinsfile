node {
   // Mark the code checkout 'stage'....
   stage 'Checkout'
   // Get some code from a GitHub repository
  //   git url: 'git@github.com:kevinearls/Simple.git'

   // Get the maven tool.
   // ** NOTE: This 'M3' maven tool must be configured
   // **       in the global configuration.           
//   def mvnHome = tool 'M3'

   // Mark the code build 'stage'....
   stage 'Build'
   // Run the maven build
  // sh "${mvnHome}/bin/mvn -Dsurefire.rerunFailingTestsCount=2 clean install"

  // Check out the rest of the source from wherever the Jenkinsfile was checked out
    checkout scm

   // Select tool versions
   def M2_HOME = tool 'maven-3.3.9'
   def JAVA_HOME = tool 'jdk8'
   
   // Override EVs which may be set on the node and update the path
   env.JAVA_HOME="${JAVA_HOME}"
   env.M2_HOME="${M2_HOME}"
   env.PATH = "${M2_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"

   // Mark the code build 'stage' and run it.  TODO change --fail-at-end to -Dmaven.test.failure.ignore?
   stage 'Build'
   sh "mvn --show-version --batch-mode --fail-at-end -Dsurefire.rerunFailingTestsCount=2 clean install"

   stage 'Archive Results'
   step([$class: 'JUnitResultArchiver', testResults: '**/target/*-reports/*.xml'])

   stage 'Cleanup'
   deleteDir()





}
