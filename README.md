# Getting Started

This application serves as an Earthquake API. In its basic version, it provides an overview page displaying earthquakes from the last 24 hours.

The API leverages the service provided by [USGS Earthquake Hazards Program](https://earthquake.usgs.gov/fdsnws/event/1/).

## Building and running the application

You can build and run the application using Maven and Java 17.

To build the application, execute the following command:

```shell
mvn install
```

To run the application, execute it in your IDE or run the following command:

```shell
mvn spring-boot:run
```

The application will be available at http://localhost:8080.

## GET /earthquakes

Returns all earthquakes for the last 24 hours.

```json
{
  "metadata": {
    "generated": "1731489640000",
    "url": "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&endtime=20241113&starttime=20241112",
    "title": "USGS Earthquakes",
    "status": 200,
    "api": "1.14.1",
    "count": 1
  },
  "features": [
    {
      "properties": {
        "title": "M 1.1 - 3 km  of The Geysers, CA",
        "place": "3 km  of The Geysers, CA",
        "mag": 1.07,
        "time": 1731455575540,
        "updated": 1731457037351
      }
    }
  ]
}
```

### Reference Documentation

For further reference, please consider the following sections:

* [USGS Earthquake API](https://earthquake.usgs.gov/fdsnws/event/1/?ref=public-apis)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.5/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html)

