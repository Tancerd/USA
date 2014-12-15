#!/bin/sh

/home/mkowalik/apache-tomcat-8.0.15/bin/shutdown.sh 
ant undeploy deploy
/home/mkowalik/apache-tomcat-8.0.15/bin/startup.sh 
