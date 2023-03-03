# [Consumir un servicio SOAP con Spring Boot!!](https://medium.com/@Jhonjairochac/consumir-un-servicio-soap-con-spring-boot-238a9e162674)
Tomado de la página web de medium.

# [Algunos servicios SOAP exponiendo su WSDL](https://www.numpyninja.com/post/save-time-compiled-list-of-free-wsdl-urls)
Se muestra a continuación algunos servicios soap su WSDL para usarlos como ejemplos, por si 
necesitamos alguno de ellos.

Calculator
```
http://www.dneonline.com/calculator.asmx?WSDL
``````

Country Info Service
``````
http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL
``````

Number Conversion
``````
https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL
``````

## Generando las clases Java a partir del Documento WSDL
Una vez agregado las dependencias y haber realizado algunas configuraciones, es momento
de generar las clases java a partir del documento WSDL del servicio SOAP. Para generar
dichas clases simplemente ejecutar el proyecto con maven:

````
.\mvnw clean package
````

# Servicio SOAP Mockeado con SOAP UI
Abrir con SOAP UI y ejecutar el MOCK. 
Se trabajó sobre el método: **GetCityWeatherByZIP**
````
/src/main/resources/soapUI/Weather-soapui-project.xml
````