# shape-match


***Still a work in progress. 

You have 1:30 min. to match as many shapes as you can. The shapes are presented in left and right window. 
If you guess right you will move to the next level where you have to match more shapes. 


### Required software

scala 2.10

sbt 0.13.2

<h3>To create .jar and run the game</h3>

```
sbt assembly && java -jar target/scala-2.10/shape-match.jar
````

To run the game from within sbt:

```
sbt> run Main
```
