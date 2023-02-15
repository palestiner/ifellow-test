## Usage

**Java 17 required**

Run Main class in Intellij IDEA

or build jar:

- Create dir jar `mkdir jar`
- Compile java files `javac ./src/*.java`
- Move compiled java files to jar dir `mv ./src/*.class' ./jar/`
- Go to jar dir `cd jar`
- Create the jar file `jar cfe ifellow-test.jar Main *.class`

and run the jar file in jar dir  `java -jar ifellow-test.jar`
or from project dir `java -jar ./jar/ifellow-test.jar`
