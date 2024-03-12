# Proyecto-Final

---

## Cocheras

El propósito principal de la aplicación es el de facilitar la gestión de cocheras privadas, teniendo como objetivos secundarios llevar un control del flujo diario de vehículos y la creación de estadísticas para optimizar el rendimiento de las mismas.

---

### 🔶 Cátedra 🔶

Lenguaje de Programación **JAVA**.

*Universidad Tecnológica Nacional Facultad Regional Rosario.*

### 🔶 Integrantes 🔶

* *Franco Giannassi* [🔗](https://github.com/francoGiannassi)
* *Martín Oliva* [🔗](https://github.com/olivamartin)
* *Vittorio Retrivi* [🔗](https://github.com/motiontx)

### 🔶 Setup 🔶

* Crear una nueva conexión en MySQL Workbench.
* Ejecutar el script `db-utils/cochera_script.sql` para generar la base de datos.
* Importar el proyecto en Eclipse.
* Crear un servidor Tomcat v8.0 en Eclipse y linkear el proyecto al mismo.
  * Window / Show View / [Other..] / Server / Servers
* Ir a `Run/Run Configurations../Environment` y agregar las siguientes variables de entorno:
  * `DB_HOST`
  * `DB_PORT`
  * `DB_NAME`
  * `DB_USER`
  * `DB_PASS`
* Ejecutar el proyecto en el servidor Tomcat. (Click derecho sobre el proyecto / Run As / Run on Server)