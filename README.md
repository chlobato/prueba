# Prueba tecnica - Calculadora 

Se crea una calculadora micro-servicio (API) utilizando Spring-boot y Maven, también contiene librerías externas como ["tracer"]. Al ser una libreria externa se debe configurar en el [maven-install-plugin]. Antes de utilizar el proyect, sera necesario ejecutar el comando `mvn clean install`.
Tiene funcionalidades basicas como restar, sumar. Y también esta preparado para futuras implementaciones como multiplicar, dividir, etc... .

## Otras dependencias usadas  

| Dependencia | versión | descripción |
| - | - | - |
| lombok | | Permite tener getters, setters, contructores |
| mockserver-junit-jupiter | 5.13.2 | Hacer test con jUnit 5 y Mockito |
| sprindoc-openapi-ui | 1.6.12 | Para documentar la API |

## Requisitos previos
- Disponer de la ultima versión de Maven instalada.
- Tener JAVA instalado en el sistema.

## Como utilizar

1. Descargar el repositorio de github
2. Ejecutar una verificación de Maven
3. Instalación limpia de Maven
4. Ejecutar el JAR de la carpeta /target/prueba-tecnica.jar

Para ello debe abrir una consola y ejecutar los siguientes comandos:

```
git clone https://github.com/chlobato/prueba
cd prueba
mvn validate
mvn verify
mvn clean install
```

A estas alturas debería haberse generado una carpeta `/target` con el JAR definitivo del programa `prueba-tecnica.jar`. Para ejecutarlo:

`java -jar target/prueba-tecnica.jar`

Con estos pasos deberiamos tener a nuestra disposición una API REST escuchando en `http://localhost:8080/api/calculadora/calculo`

Si has tenido algun error con la ejecución de las instrucciones anteriores, en el proyecto ya hay un JAR definitivo compilado con todas las dependencias, si quieres probar el proyecto directamente puedes (1) clonar el proyecto en local y (2) ejecutar el JAR precompilado [prueba-tecnica.jar](https://github.com/chlobato/prueba/tree/master/target/prueba-tecnica.jar).

```
git clone https://github.com/chlobato/prueba
java -jar prueba/target/prueba-tecnica.jar
```

## API REST
Si has seguido correctamente los pasos anteriores, deberias tener el puerto 8080 abierto y escuchando peticiones de tipo REST, aunque en este caso solo hay de tipo GET.

Los parámetros que se le deben pasar por URL, son los siguientes `primero` el primer numero de la operación,
`segundo` el segundo numero de la operación y `operador` sera una cadena de texto describiendo la el tipo de signo a usar en la operación(valores aceptados `suma`, `resta`).

Ejemplo 
`GET http://localhost:8080/api/calculadora/calculo?primero=8&segundo=9&operador=- 

El resultado será un valor numerico con decimales (15 - 10 = 5):

Lo que se debe mostrar en pantalla sería este resultado -> `5.0`

## Swagger

A parte de la API REST tambien tenemos una interfaz llamada swagger que provee documentacion e infomación sobre la API en la siguiente url.

`GET http://localhost:8080/api/swagger-ui/index.html#/

## Ejecutar tests

Si has clonado e instalado todas las dependencias de maven en local, para ejecutar los [tests](https://github.com/chlobato/prueba/tree/master/src/test/java/com/example/prueba) debes ejecutar el comando `mvn clean test`.
