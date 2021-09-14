pipeline
{
	agent any

    environment
    {
    	DOCKER_BUILD_NAME = 'automation-sample-mock-runner'
        DOCKER_RUN_PARAMS = "-v ${WORKSPACE}:/usr/src/project -u jenkins -w /usr/src/project"
    	MAVEN_REPO_SNAPSHOT_ID="snapshots-repo"
    	MAVEN_REPO_SNAPSHOT_NAME="maven-snapshots"
    	MAVEN_REPO_SNAPSHOT_URL="http://nexus.cicd.prod.sky.aws:8080/repository/maven-snapshots/"
    	MAVEN_REPO_RELEASE_ID="releases-repo"
    	MAVEN_REPO_RELEASE_NAME="maven-releases"
    	MAVEN_REPO_RELEASE_URL="http://nexus.cicd.prod.sky.aws:8080/repository/maven-releases/"
    	MAVEN_REPO_PUBLIC_ID="nexus"
    	MAVEN_REPO_PUBLIC_NAME="maven-public"
    	MAVEN_REPO_PUBLIC_URL="http://nexus.cicd.prod.sky.aws:8080/repository/maven-public/"
    
		MAVEN_OPTS="-Dhttps.protocols=TLSv1.2 -Dmaven.repo.local=/home/jenkins/.m2 -Dorg.slf4j.simpleLogger.showDateTime=true -Djava.awt.headless=true"
    	MAVEN_CLI_OPTS="--batch-mode --errors --fail-at-end --show-version -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN -DinstallAtEnd=false -DdeployAtEnd=false -s settings.xml"
	}
    stages 
    {
    	stage ('Init')
    	{
    		steps
    		{
				sh("docker build -t ${DOCKER_BUILD_NAME} ." )
			}
		}
		stage ('Clean')
    	{
    		steps
    		{
    			script
    			{	
    				docker.image("${DOCKER_BUILD_NAME}").inside(DOCKER_RUN_PARAMS) 
    				{	sh "cd /usr/src/project"
						sh "echo pwd"
        				sh 'mvn  clean'
        			}
        		}        
			}    
		}

    }
}