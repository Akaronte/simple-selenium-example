# Simple selenium maven

mvn dependency:sources 

mvn dependency:copy-dependencies -DoutputDirectory=${project.build.directory}/lib

mvn package

java -jar ./target/selenium-1.0-SNAPSHOT.jar