# spark-streaming-eventhub-sample
A spark streaming sample running in HDInsight spark 2.2 to pull data from eventhubs

###### 1. Prepare Environment
- Install SBT 1.1.5 (https://www.scala-sbt.org/download.html)
	- Windows
		Download MSI file and install directly
	- Linux
		wget https://piccolo.link/sbt-1.1.5.tgz
		tar xzvf sbt-1.1.5.tgz
		cd ./sbt
		vi sbt
		***In the file, type the following content,***
		BT_OPTS="-Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256M"
		java $SBT_OPTS -jar /home/lazhu/sbt/bin/sbt-launch.jar "$@"
		***Save the file and quit***
		chmod a+x sbt
		vi ~/.bashrc
		***In the file, type the following content,***
		export PATH=/home/lazhu/sbt/:$PATH
		***Save the file and quit***
		source ~/.bashrc
- Install git (https://desktop.github.com/)
	- Windows
		Download exe file and install directly
	- Linux
		- Redhat
		  sudo yum install git-core
		- Ubuntu
		  sudo apt-get install git
		
- Install JDK 1.8
	- Windows
		http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
	- Linux
		- Redhat
		  sudo yum install java-1.8.0-openjdk-devel
		- Ubuntu
		  sudo add-apt-repository ppa:openjdk-r/ppa
		  sudo apt-get install openjdk-8-jdk
		

