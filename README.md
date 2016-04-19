#TicTacToe in Java

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



