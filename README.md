# java-ssm-momento-demo

To run demo
```console
mvn clean install
mvn package
MOMENTO_AUTH_TOKEN=**** java -jar target/java-ssm-momento-demo-0.0.1-SNAPSHOT.jar
```

In another terminal window
```console
curl localhost:8088/hello
```