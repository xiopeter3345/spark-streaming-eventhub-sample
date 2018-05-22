# spark-streaming-eventhub-sample
A spark streaming sample running in HDInsight spark 2.2 to pull data from eventhubs

###### 1. Prepare Environment
- Create Spark 2.2 HDInsight cluster

	Add the following script action:
	https://raw.githubusercontent.com/xiopeter3345/spark-streaming-eventhub-sample/master/install-eventhubs-jars.sh
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
		
		java $SBT_OPTS -jar /home/sshuser/sbt/bin/sbt-launch.jar "$@"
		
		***Save the file and quit***
		
		chmod a+x sbt
		
		vi ~/.bashrc
		
		***In the file, type the following content,***
		
		export PATH=/home/sshuser/sbt/:$PATH
		
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

###### 2. Compile and Run the sample

- Compile

	ssh to head node and execute the following commands to download the program and compile:
	
	git clone https://github.com/xiopeter3345/spark-streaming-eventhub-sample.git
	cd spark-streaming-eventhub-sample
	sbt clean
	sbt compile
	sbt package
	
	The generated jar file will be generated to ./target/scala-2.11
- Run the program

	cd ./target/scala-2.11
	
	spark-submit --master yarn-cluster --class com.microsoft.css.lazhu.App --num-executors 1 --executor-memory 1G --executor-cores 1 --driver-memory 1G spark-streaming_2.11-1.0.jar
	
- Event Hub sender
	CDRecord.cs and Program.cs are C# sample code to send JSON format to event hub. Please make sure connection string is correctly set.