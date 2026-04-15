# Ludo Project

A smaller version of the classic game Ludo for only two players

## Maven goals

- `mvn clean`
- `mvn compile`
- `mvn test`
- `mvn package`
- `mvn javadoc:javadoc`

## Running the program

To run with Maven:
`mvn exec:java`

To build the jar:
`mvn clean package`

On Windows:
`package.cmd`

On Linux or macOS:
`./package.sh`

To run the packaged jar on Windows:
`java -jar target\ludo-1.0-SNAPSHOT-jar-with-dependencies.jar`

Or:
`runjar.cmd`

On Linux or macOS:
`./runjar.sh`
4. pom.xml er gott


## Documentation
Generate project documentation with:
`mvn site`

Design documentatioin:
[Design documentation](src/site/markdown/design.md)

License:
[LICENSE](LICENSE)

