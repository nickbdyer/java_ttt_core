#TicTacToe in Java

###Clone

```shell
$ cd <folder where you want to store the project>

$ git clone https://github.com/nickbdyer/java_ttt.git

$ cd java_ttt/
```

###Compile
```shell
$ javac -cp .:vendor/junit-4.12.jar:vendor/hamcrest-core-1.3.jar src/com/company/*.java test/com/company/*.java
```

###Run Program
```shell
$ java com.company.Main
```

###Test Program
```shell
$ cd test/
$ java -cp .:../vendor/junit-4.12.jar:../vendor/hamcrest-core-1.3.jar:../src org.junit.runner.JUnitCore com.company.BoardTest;
$ java -cp .:../vendor/junit-4.12.jar:../vendor/hamcrest-core-1.3.jar:../src org.junit.runner.JUnitCore com.company.DisplayTest;
$ java -cp .:../vendor/junit-4.12.jar:../vendor/hamcrest-core-1.3.jar:../src org.junit.runner.JUnitCore com.company.GameTest;
```



