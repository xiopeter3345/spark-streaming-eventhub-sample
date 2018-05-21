#! /bin/bash

hdiVersion=$(ls -l /usr/hdp | grep -E ^[0-9])

sudo wget -O /usr/hdp/$hdiVersion/spark2/azure-eventhubs-1.0.1.jar -q https://repo1.maven.org/maven2/com/microsoft/azure/azure-eventhubs/1.0.1/azure-eventhubs-1.0.1.jar
sudo wget -O /usr/hdp/$hdiVersion/spark2/azure-eventhubs-spark_2.11-2.2.0.jar -q https://repo1.maven.org/maven2/com/microsoft/azure/azure-eventhubs-spark_2.11/2.2.0/azure-eventhubs-spark_2.11-2.2.0.jar
sudo wget -O /usr/hdp/$hdiVersion/spark2/proton-j-0.25.0.jar -q https://repo1.maven.org/maven2/org/apache/qpid/proton-j/0.25.0/proton-j-0.25.0.jar