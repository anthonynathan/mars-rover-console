# mars-rover-console

This is a console application which moves rovers over a fictitious plateau on Mars based on user inputs.

#### Note the following
- The application will instruct you as to what input is required at each stage.
- The application will inform you if your input is invalid.
- The application will not allow a rover to move into or pass through a position currently occupied by another rover.
- The application will also not allow the rover to move beyond the boundaries of the plateau.
- Type `exit` to exit the application.

## Getting Started

#### 1. Install Java 8 JDK
If you don't already have Java 8 JDK installed, grab it from <https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>.

#### 2. Clone This Repository
On <https://github.com/anthonynathan/mars-rover-console>, click the green "Clone or Download" button at the top right of the page.

#### 3. Run the Test Cases
In a command prompt or Terminal window, navigate to the directory containing this repository's files. Then, type the following, and press enter:

***Linux***
```
gradlew test
```

***Windows***
```
gradlew.bat test
```
The test will generate an HTML report which can be found at:

>build/reports/tests/test/index.html

#### 4. Build the Code
In a command prompt or Terminal window, navigate to the directory containing this repository's files. Then, type the following, and press enter:

***Linux***
```
gradlew build
```

***Windows***
```
gradlew.bat build
```
The following compiled JAR file will be produced

>build/libs/mars-rover-console-1.0.0-SNAPSHOT.jar

***Alternatively*** the following pre-built JAR file is included in the repository:

>jar/mars-rover-console-1.0.0-SNAPSHOT.jar

### 5. Run the Application
In a command prompt or Terminal window, navigate to the directory containing the JAR file. Then, type the following, and press enter:

```
java -jar mars-rover-console-1.0.0-SNAPSHOT.jar
```
