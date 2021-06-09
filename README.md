# How to start

### DB
To Use MongoDB, install MongoDB server.
Or install Docker then run the following script
 
```
docker run --name registerApi -p 27017:27017 -e MONGO_INITDB_ROOT_PASSWORD=pwd -e MONGO_INITDB_ROOT_USERNAME=root mongo
```



## Application
The application is generated using [Spring Initializr](https://start.spring.io/) and uses [Java SE 8 version]

Add to your maven settings the following profile



The REST end points can be reached at [http://localhost:8090/api/docs/index.html](http://localhost:8090/api/docs/index.html) 

For more informations let's Documentation.docx