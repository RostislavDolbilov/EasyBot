### Test EasyBot application
## Building and Running
### Java version
- Java 11
### Development environment
- IntelliJ IDEA
### Additional info
- PostgreSQL
- Docker

### Build
If you have Maven installed, you can run the app using `mvn clean install`
Or maven: clean, install from development environment (IntelliJ IDEA)

### Run Parameters
You must have Docker installed in your PC: https://www.docker.com/  
After building app, must go to terminal from development environment (IntelliJ IDEA)  
and launch command `docker-compose up`.

## Contributing

http://localhost:8090/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

Save product body example:

        {
            "productType": "LAPTOP",
            "seriesNumber": "AU57HZ",
            "manufacturer": "Acer",
            "quantity": 0,
            "settings": {
                "diagonal": "16 inch",
                "formFactor": null,
                "memoryCapacity": null
            }
        }

Update product body example:


        {
            "id": 3,
            "productType": "LAPTOP",
            "seriesNumber": "AU57HZ",
            "manufacturer": "Acer",
            "quantity": 0,
            "settings": {
                "id": 3,
                "diagonal": "16 inch",
                "formFactor": null,
                "memoryCapacity": null
            }
        }