pipeline
{
	agent any

    environment
    {
    	DOCKER_BUILD_NAME = 'automation-sample-mock-runner'
        DOCKER_RUN_PARAMS = "-v ${WORKSPACE}:/usr/src/project  -w /usr/src/project -e MAVEN_CONFIG=/home/jenkins/.m2"
    	MAVEN_OPTS="-Dhttps.protocols=TLSv1.2 -Dmaven.repo.local=$CI_PROJECT_DIR/.m2/repository -Dorg.slf4j.simpleLogger.showDateTime=true -Djava.awt.headless=true"
    	MAVEN_CLI_OPTS="--batch-mode --errors --fail-at-end --show-version -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN -DinstallAtEnd=false -DdeployAtEnd=false"
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
    				{	
    				echo "Building configuration: ${params.BranchName}"
					echo "Building configuration: " + params.BranchName
        				sh 'mvn $MAVEN_CLI_OPTS $MAVEN_OPTS clean'
        			}
        		}        
			}    
		}

    }
}