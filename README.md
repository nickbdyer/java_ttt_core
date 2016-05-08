#TicTacToe in Java

[![Code Climate](https://codeclimate.com/github/nickbdyer/java_ttt/badges/gpa.svg)](https://codeclimate.com/github/nickbdyer/java_ttt) [![Test Coverage](https://codeclimate.com/github/nickbdyer/java_ttt/badges/coverage.svg)](https://codeclimate.com/github/nickbdyer/java_ttt/coverage)

###Clone

```shell
$ cd <folder where you want to store the project>

$ git clone https://github.com/nickbdyer/java_ttt.git

$ cd java_ttt/
```

This project has a Gradle Wrapper embedded, so you can run the project and tests without having Gradle on your path.

###Compile
```shell
$ ./gradlew build
```

###Run Program
```shell
$ java -jar build/libs/java_ttt.jar
```
Or
```shell
$ ./gradlew --console plain run
```

###Test Program
To see the results in the command line:
```shell
$ ./gradlew cleanTest test
```
Or in your browser:
```shell
$ open reports/tests/index.html
```



