# Edit this environment variables file to set custom options
#
# Notes:
#
# * Tomcat accepts these environment variables: 
#   JAVA_OPTS are used during START/STOP/RUN
#   CATALINA_OPTS are used during START/RUN
#   CATALINA_HOME defined Tomcat home directory shared by all instances.
#   CATALINA_BASE defined Tomcat instance specify base directory. If not 
#       defined, it default to CATALINA_HOME.
#   JAVA_HOME defined JDK home or JRE_HOME defined JRE home.
# 
# * If none of the above env varaibles are set, Tomcat will default to 
#   any stored user environment varilables that have been set.
#
# * This script is sourced by catalina.sh when it placed inside: 
#   $CATALINA_BASE/bin (instance specify setup) or $CATALINA_HOME/bin
# ------------------------------------------------------------
 
# Are we using JAVA_HOME=JDK or JRE_HOME=JRE? Not both 
JAVA_HOME="/opt/java" 	# path to JDK (not JRE)
#JRE_HOME="/path/to/jre"		# path to JRE (not JDK)

# Define Tomcat home path 
CATALINA_HOME="/opt/tomcat"
# Define tomcat instance specify path. If it's not set it defaults to CATALINA_HOME
#CATALINA_BASE="/opt/instances/tc6035-example1"
# Define tomcat running pidfile path
#CATALINA_PID="$CATALINA_BASE/logs/tomcat.pid"

# Define JVM options 
# Uncomment to enable or add your other java options
#HEADLESS_MODE="-Djava.awt.headless=true"
#DEBUG_OPTS="-XX:+PrintGCTimeStamps -XX:+PrintGCDetails"
#PERM_OPTS="-XX:PermSize=128m -XX:MaxPermSize=512m"
HEAP_OPTS="-Xms32g -Xmx96g"
#BIT_MODE="-d32"         # Set -d32 bits or -d64 bits mode
JVM_MODE="-server"      # Set -client or -server mode
#
# For remote jmx monitoring via authenication you will need to setup users access and 
# password in $CATALINA_BASE/conf/jmxremote.{access,password} files. 
#
# Example: 
#	conf/jmxremote.access
#		john	readwrite
#		kymeng	readonly
#	conf/jmxremote.password
#		john	johnpasswd
#		kymeng	kymengpasswd
# Make sure both jmxremote.{access,passsword} files only readable/writeable (600) by the owner, and
# jxmremote.port must be unique for each server instances.
#
#
#JMXREMOTE_OPTS="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=8991 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=true -Djava.rmi.server.hostname=localhost -Dcom.sun.management.jmxremote.password.file=$CATALINA_BASE/conf/jmxremote.password -Dcom.sun.management.jmxremote.access.file=$CATALINA_BASE/conf/jmxremote.access"

# Just add any JVM options you need or remove any JVM options you don't need from
# JAVA_OPTS and/or CATALINA_OPTS 
#JAVA_OPTS="$JVM_MODE $HEADLESS_MODE $PERM_OPTS $HEAP_OPTS $DEBUG_OPTS"
#CATALINA_OPTS="-Dcom.sun.management.jmxremote -Duser.timezone=America/Sao_Paulo -Duser.language=pt -Duser.country=BR"

#JAVA_OPTS="-javaagent:/opt/tomcat/wily/Agent.jar -Dcom.wily.introscope.agentProfile=/opt/tomcat/wily/core/config/IntroscopeAgent.profile"
CATALINA_OPTS="-Dcom.sun.management.jmxremote -Duser.timezone=America/Sao_Paulo -Duser.language=pt -Duser.country=BR -javaagent:/opt/tomcat/wily/Agent.jar -DagentProfile=/opt/tomcat/wily/core/config/IntroscopeAgent.profile"

