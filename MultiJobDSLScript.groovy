
for(i in 1..2) {

    mavenJob('AWSJob'+i) {
        triggers {
            //scm('H/15 * * * *')
            upstream('MultiJobs','UNSTABLE')
        }

        preBuildSteps {
            shell("echo '***Run Shell before Maven execution *****'")
            shell("chmod 777 /home/ubuntu/workspace/AWSJob"+i+"/drivers/chromedriver_88")
            shell("Xvfb -ac :99 -screen 0 1280x1024x16 & export DISPLAY=:99")
        }


        goals('clean test -Dmaven.clean.failOnError=false -Dsurefire.suiteXmlFiles=testng.xml')
        label('dynamic_slave')
        rootPOM('pom.xml')
        scm {
            git {
                remote {
                    github('devx359/JenkinsTest')
                }
                branches('master')
            }
        }


    }
}