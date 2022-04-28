# demo services

## ActiveMQ
ActiveMQ 서비스 클래식 버전
```
docker run --name activemq --publish 61616:61616 --publish 8161:8161 --publish 5672:5672 -d rmohr/activemq:5.15.9-alpine

# web-console: admin/admin
```

## DynamoDB local
DynamoDB 로컬 서비스 
```
docker run --name dynamodb -p 8000:8000 -d amazon/dynamodb-local 
```