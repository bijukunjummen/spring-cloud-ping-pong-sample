## Up and running with Sample Spring-Cloud based app

There are two ways to run the entire application:

- On Local Machine
- Using Docker

### On Local Machine
Running it all local is simple, do the following in sequence, in four different terminal windows:

#### Start up Eureka
```sh
cd sample-eureka
../mvnw spring-boot:run
```

#### Start up Config server

```sh
cd sample-config
../mvnw spring-boot:run
```

#### Start up Pong Service
```sh
cd sample-pong
../mvnw spring-boot:run
```

and test with:

```shell
curl -v -X POST \
  -H "Content-type: application/json" \
  -H "Accept: application/json" \
   http://localhost:8082/message \
   -d '{
   "id": "test", 
   "payload": "hello"
}'
```

#### Start up Gateway
```sh
cd sample-gateway
../mvnw spring-boot:run
```

and test with:

```shell
curl -v -X POST \
  -H "Content-type: application/json" \
  -H "Accept: application/json" \
   http://localhost:8082/message \
   -d '{
   "id": "test", 
   "payload": "hello"
}'
```

#### Start up Ping Service
```sh
cd sample-ping
../mvnw spring-boot:run
```

If all the applications have come up cleanly, the endpoint should be available at http://localhost:8080

### On Docker

Running using Docker is even simpler, assuming that docker-compose and docker are installed on your box, just run the following:

#### Build the docker images for the microservices

```sh
mvn clean package docker:build
```

#### Start up Docker containers

```sh
docker-compose up
```

That is it, the endpoint should be available at http://dockerhost:8080