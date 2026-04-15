# Ludo Project

A smaller version of the classic game Ludo for only two players

## Architecture

- `vidmot/` contains the user interface
- `vinnsla/` contains the game logic


## Installation and Run

- This project is a Maven project.

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
