![En desarollo](https://img.shields.io/badge/Estado-EN%20DESAROLLO-green)
![Java](https://img.shields.io/badge/Java-21-blue?style=flat)
![Maven](https://img.shields.io/badge/MVN-4.0.0-blue)
![Static Badge](https://img.shields.io/badge/Spring-3.2.2-blue?style=flat&logo=spring)

# Aplicación de precios
El proyecto se centra en el desarrollo de una plataforma similar a un foro, donde los usuarios puedan compartir y buscar precios favorables de productos que han encontrado en diferentes lugares. Al ingresar a la aplicación, los usuarios pueden ver un listado de los precios publicados. A partir de este listado, es posible buscar publicaciones relacionadas con un producto o lugar específico.

# Motivación
Debido a la situación económica y el bajo control de precios la gente empieza a recorrer distintos lugares con el fin de encontrar los productos que busca al mejor precio posible. En pueblos y ciudades chicas se suelen crear grupos de Facebook o Whatsapp donde se comparte precios entre las personas con el fin de ayudarse entre todos. Si bien suele funcionar se puede volver tedioso tanto para los administradores como para los usuarios. La idea de la aplicación es centralizar todas las publicaciones en un solo lugar y dar la posibilidad de aplicar filtros de búsqueda y poder valorar las publicaciones para corroborar la veracidad de las mismas.     

# Surgimiento
La idea del proyecto surge de aplicar lo aprendido a lo largo de un curso que realice sobre desarrollo de API’s con Spring Boot y poder utilizarlo como portafolio. Si bien de momento es solo el backend la idea es hacer el desarollo completo y que sea una app funcional.

# Tecnologías y características
Algunas de las tecnologías y patrones aplicados a lo largo del proyecto fueron las siguientes:
- Java 21 + Spring Boot + Maven
- Base de datos mysql con Wampserver64
- Manejo de relaciones con Spring Data JPA (ORM)
- Arquitectura multicapas (model, controler, service, repository, etc)
- Patrón DTO para respuestas personalizadas y validaciones
- Inyección de dependencias e inversión de control
- Manejo de excepciones con códigos HTTP y mensajes personalizados
- Lombock para creación de getters, setters y constructores

Para ver cuestiones más especificas sobre el desarollo como el diagrama de clases y los endpoints cree un documento de word llamado [documentacion](https://github.com/gabi3724/Foro-de-precios/blob/main/implementacion.docx) que se encuentra en este mismo repositorio

# Pasos siguientes
Como la idea es crear una aplicación funcional aún faltan partes importantes como las que se mencionan a continuación:
- Desarrollo de frontend utilizando algun framework como react o angular.
- Autenticacion de usuarios con sus respectivos roles utilizando jwt o algo similar.
- Realizar los test correspondientes

