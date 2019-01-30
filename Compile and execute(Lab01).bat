@echo off
javac -d target/classes src/main/java/ua/edu/chmnu/fks/oop/Lab01/*.java
java -cp target/classes ua.edu.chmnu.fks.oop.Lab01.Lab01
cd target/classes/
jar -cfe ua/edu/chmnu/fks/oop/Lab01/Lab01.jar ua.edu.chmnu.fks.oop.Lab01.Lab01 ua/edu/chmnu/fks/oop/Lab01/Lab01.class
java -jar ua/edu/chmnu/fks/oop/Lab01/Lab01.jar
pause