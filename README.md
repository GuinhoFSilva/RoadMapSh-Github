# GitHub User Activity CLI (Java + Spring Boot)
A simple CLI application to fetch and display recent GitHub user activity using the GitHub API, built with Java and Spring Boot.
## Prerequisites
- Java 17+ installed  
- Maven installed (or use the Maven wrapper `mvnw` / `mvnw.cmd`)  
- Internet connection  
## How to Build and Run
1. Clone the repository and navigate to the project root folder:
```bash
git clone https://github.com/GuinhoFSilva/RoadMapSh-Github.git
cd github
````
The `github` folder is the project root and contains the `pom.xml` file.
2. Build the project with Maven. This will download dependencies, compile the project, run tests, and package the app:
```bash
# On Windows
mvnw.cmd clean package
# On macOS/Linux
./mvnw clean package
```
3. Run the application JAR. Navigate to the `target` folder where the packaged JAR is located:
```bash
cd target
java -jar github-0.0.1-SNAPSHOT.jar
```
4. Enter GitHub username when prompted:
```
>> GitHub username: torvalds
Loading data from GitHub, please wait...
CreateEvent: 2
PushEvent: 28
Pushed 3 commits in torvalds/1590A
Pushed 25 commits in torvalds/linux
```
## Notes
* The app fetches user activity from: `https://api.github.com/users/<username>/events`
* Requires internet connection to work
* You can enhance the project by adding filters, caching, or improved formatting
## Troubleshooting
* If `mvnw` / `mvnw.cmd` is not working, make sure Maven is installed and added to your system PATH
* Ensure Java 17+ is installed and configured properly
* Run `mvnw.cmd clean` (Windows) or `./mvnw clean` (macOS/Linux) to clean the project if needed
