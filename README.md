# Price Calculation Api
Rate limiting and timeout handling demo project.
To launch the service you will need Java 8 and Redis v3.2.8

The project consists of two main components (microservices),
* PriceCalculationService - The REST API, that calculates prices and returns response. Implemented with SpringBoot v1.2.5 
* GatewayService - The point of interaction between clients and the API. It filters client requests by rate limiting and timeout handling. Implemented with SpringBoot v1.2.5 and Redis v3.2.8

Configurations are implemented by java properties files. Actually they can be changed when needed to any format.
All the configuration files are located inside GatewayService component, under ```src/main/resources``` directory.

* datasource.properties - used for redis configurations
```
redis.host=localhost # redis server host
redis.port=6379 # redis server port
```
* service.properties - used for the service configurations
```
rate-limit-per-client=2 # rate limit for a client in seconds (individual for each client)
timeout=11 # calculation timout overal (not just a socket or connection timeout, but hard timeout that encompasses overall time)
price-calculation-service-url=http://localhost:8092/getPrice # host of the api service (price calculation service in our case)

```
The services are dockerized using spring boot docker plugin. The see path to docker files or change the configs see POM of the components.
