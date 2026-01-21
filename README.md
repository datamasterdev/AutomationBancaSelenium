# Automation Framework - Banca Altoro Mutual

Este proyecto es un framework de automatización profesional diseñado para validar el flujo de inicio de sesión en la plataforma bancaria **Altoro Mutual**. Está construido siguiendo las mejores prácticas de la industria, como el patrón de diseño **Page Object Model (POM)**.

## 🚀 Tecnologías Utilizadas
* **Lenguaje:** Java 11/17
* **Gestor de Dependencias:** Maven
* **Automatización Web:** Selenium WebDriver
* **Framework de Pruebas:** TestNG
* **Patrón de Diseño:** Page Object Model (POM)
* **Control de Versiones:** Git & GitHub

## 📂 Estructura del Proyecto
* `src/main/java/pages`: Contiene los objetos de página (Locators y Acciones).
* `src/test/java/tests`: Contiene los scripts de prueba.
* `src/test/java/utils`: Clases de soporte como el lector de configuraciones.
* `src/test/resources`: Archivos de propiedades y datos externos.

## 🛠️ Configuración y Ejecución
1. Clonar el repositorio.
2. Asegurarse de tener instalado **JDK** y **Maven**.
3. Configurar las credenciales en `src/test/resources/config.properties`.
4. Ejecutar los tests desde IntelliJ (clic derecho en `LoginTest`) o mediante Maven:
   ```bash
   mvn test
## 👤 Autor
JESUS GIL VARGAS - Junior Automation Engineer