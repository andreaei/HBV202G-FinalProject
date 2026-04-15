# Ludo Project

A smaller version of the classic game Ludo for only two players


## Running the program

To compile and run with maven:
`mvn exec:java`
`mvn exec:java`

To build the jar:
`mvn clean package`

To run the packaged jar:
`java -jar target\ludo-1.0-SNAPSHOT-jar-with-dependencies.jar`


## Documentation
Generate project documentation with:
`mvn site`

Design documentatioin:
[Design documentation](src/site/markdown/design.md)

License:
[LICENSE](LICENSE)

To build the project:

```powershell
package.cmd
```
- This runs "mvn clean package"

To run the project>

```powershell
runjar.cmd
```
- This runs "java -jar target\ludo-1.0-SNAPSHOT-jar-with-dependencies.jar"

The Maven Assembly Plugin is used to create a fat jar that includes all dependencies.


## Maven goals

- `mvn clean`
- `mvn compile`
- `mvn test`
- `mvn package`
- `mvn javadoc:javadoc`


## Documentaion
