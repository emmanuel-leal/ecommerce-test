## How did you ensure your microservice scales with rising demand?
Para asegurarnos de que nuestro microservicio pueda escalar con la creciente demanda, 
se implementarian estrategias de escalado automático en nuestra plataforma de alojamiento, como Kubernetes. 
Además, se ha diseñado el sistema siguiendo los principios de arquitectura basada en microservicios, 
lo que nos permite escalar servicios individualmente según sea necesario. 
Utilizamos métricas y alarmas para supervisar el rendimiento y la carga del sistema en tiempo real y,
cuando se alcanzan ciertos umbrales, se activa automáticamente la creación de nuevas instancias del microservicio.

## Which strategies were adopted or contemplated for enduring maintainability?
Para garantizar la sostenibilidad a largo plazo, podriamos seguir las siguientes estrategias:
* Implementación de pruebas unitarias y pruebas de integración para detectar problemas rápidamente.
* Uso de prácticas de revisión de código y estándares de codificación claros.
* Documentación de la arquitectura, el código y los flujos de datos.
* Actualizaciones regulares de dependencias y corrección de vulnerabilidades de seguridad.
* Implementación de ciclos de vida de desarrollo y despliegue continuos (CI/CD) para facilitar actualizaciones y correcciones sin problemas.

## Narrate a challenging technical decision made during this assignment and defend it.
Uno de los desafíos técnicos fue decidir entre el uso de Amazon MQ y otras soluciones de mensajería. 
Se elgió Amazon MQ debido a su capacidad para proporcionar colas de mensajes altamente disponibles 
y gestionadas. Esta decisión garantiza una comunicación confiable entre microservicios y la escalabilidad 
necesaria para manejar cargas de trabajo cambiantes. 
Además, Amazon MQ se integra bien con otras ofertas de AWS, lo que simplifica la administración y el monitoreo.

También fué un desafío la decisión de utilizar el patron CQRS, éste  es un patrón complejo y no me quedaba claro
cómo implementarlo de manera efectiva. Sin embargo, después de una analizarlo, lo decidí.

Estos son algunos de los beneficios de usar CQRS:

* Rendimiento mejorado: CQRS puede mejorar el rendimiento de los microservicios al separar las operaciones de lectura y escritura. 
Esto permite utilizar diferentes técnicas de optimización para cada tipo de operación.
* Mayor escalabilidad: CQRS puede hacer que los microservicios sean más escalables al permitir el uso de diferentes bases de datos 
de lectura y escritura. Esto puede resultar útil para microservicios que tienen un alto tráfico de lectura o de escritura.
* Complejidad reducida: CQRS puede reducir la complejidad de los microservicios al separar las operaciones de lectura y escritura.
Esto puede hacer que los microservicios sean más fáciles de comprender, mantener y ampliar.

## As a senior developer, how would you guarantee code quality and best practices within a more extensive team framework?
Como desarrollador senior, aseguraría la calidad del código y las mejores prácticas mediante:

* Establecer estándares de codificación y directrices arquitectónicas claras.
* Implementación de revisiones de código regulares.
* Fomentar la escritura de pruebas unitarias y pruebas de integración.
* Dar mentoría de miembros del equipo.

## Describe your approach to guiding a junior developer in comprehending and building on this microservice.
Al guiar a un desarrollador junior en la comprensión y construcción de este microservicio, seguiría una estrategia de mentoría, que incluiría:

* Explicar la arquitectura general y los patrones utilizados.
* Proporcionar ejemplos de código .
* Fomentar la práctica de escribir pruebas unitarias.
* Ofrecer sesiones para hacer preguntas y discutir desafíos técnicos (1:1)

## How would you explain the importance of a particular technical decision to a non-technical stakeholder or team member?
Para explicar la importancia de una decisión técnica a un miembro del equipo no técnico o a un interesado, utilizaría un enfoque sencillo y relacionado con resultados comerciales. Por ejemplo, comenzaría explicando el problema que resuelve la decisión. Luego, le explicaría las diferentes opciones que se consideraron y por qué la opción elegida fue la mejor. Finalmente, explicaría los beneficios de la opción elegida de una manera que la persona no técnica pueda entender.

Por ejemplo, si estuviera explicando la importancia de usar el patrón CQRS, comenzaría explicando que el patrón CQRS separa las operaciones de lectura y escritura. Esto puede mejorar el rendimiento, la escalabilidad y la mantenibilidad. Luego explicaría las diferentes opciones que se consideraron, como usar una única base de datos para operaciones de lectura y escritura o usar una base de datos separada para operaciones de lectura y escritura. Luego explicaría por qué el patrón CQRS era la mejor opción, como el hecho de que puede mejorar el rendimiento y la escalabilidad. Finalmente, me gustaría explicar los beneficios del patrón CQRS de una manera que la persona no técnica pueda entender, como el hecho de que puede hacer que el sistema sea más rápido y escalable.


## Here’s a basic Dockerfile for a Java application: Can you provide some modifications or comments to enhance or describe the Dockerfile?

    # usar la imagen oficial de OpenJDK 11
    FROM openjdk:11

    # Identificador de la version de la applicacion
    LABEL version=1.0.0
    
    # Copiar el jar compilado al directorio /usr/src/ directory
    COPY ./target/my-app.jar /usr/src/
    
    # Establecer el directorio de trabajo en /usr/app
    WORKDIR /usr/app
    
    # Definir el comando para ejecutar la aplicación Java cuando se inicia el contenedor
    CMD ["java", "-jar", "my-app.jar"]
    
    # comprobación de salud para el contenedor que utiliza curl para hacer una solicitud a http://localhost:8080/health cada 10 segundos. Si la solicitud falla o no se completa en 5 segundos, se considera que el contenedor no es saludable después de 3 intentos fallidos.
    HEALTHCHECK CMD ["curl", "-f", "http://localhost:8080/health"] INTERVAL=10s TIMEOUT=5s RETRIES=3


## In Kubernetes, it’s vital not to hardcode sensitive data within applications or configurations. Describe how you would manage and retrieve sensitive information, such as database passwords or API keys, in a Kubernetes environment without hardcoding them into your application?
Para gestionar y recuperar información sensible, como contraseñas de bases de datos o claves de API, en un entorno de Kubernetes sin codificarlas en la aplicación, podemos utilizar Secretos de Kubernetes y Variables de Entorno.
