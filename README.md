# spring-activemq-demo
spring-activemq-demo

## Prerequisite
```
git clone https://github.com/chiwoo-samples/spring-activemq-demo.git

cd spring-activemq-demo
git config --local user.name <your_name>
git config --local user.email <your_email>
```

## Build

```
./gradlew clean build --exclude-task test
```

## Test

```
./gradlew build test --tests "demo.example.app.producer.HelloProducerTest.testSendMsg"
```

## Run

```
./gradlew build bootRun --exclude-task test 
```

## Docker
```
docker-compose -f docker/docker-compose.yaml up -d

docker-compose -f docker/docker-compose.yaml down
  
```