# FlowControl
Netbeans java project GUI for interfacing with Arduino microcontroller for the purposes of confrolling  pneumatic device. 

Jar files are found in the /dist folder. Last compliled on Ubuntu 22.04. Not tested on Windows or Mac.  

### Required libs:
librxtxRaw-2.2pre1

To install on linux
```
sudo apt-get install -y librxtx-java
```

Before running the FlowControl.cfg file needs to be set to the path of the Arduino port. On linux (ubuntu) this is usually /dev/ttyACM0 or /dev/tty/ACM1. 

To run from command line on linux. From the /dist folder
```
java -Djava.library.path=/usr/lib/jni/ -jar FlowControl.jar
```
where /usr/lib/jni is the path to the rxtx lib files. 

You may need to run the above java command a few times to connect to the Arduino. Usually a connection is established by the second run of the java command. 


