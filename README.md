#!/bin/bash

# Compile the Java source files
javac *.java

# Create a JAR file
jar cfe PokerApp.jar PokerApp *.class

# Run the application
java -jar PokerApp.jar
