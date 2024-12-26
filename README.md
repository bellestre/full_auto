# Automatización de WebApp OrangeHrm con PlayWright y Java

## Introducción
Configure PlayWright, Java para automatizar los casos de prueba para los módulos de la aplicación Orange Hrm y escriba scripts de prueba a partir de escenarios de casos de prueba.
Ejecute los scripts y genere informes.
Web App: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

## Escenarios de prueba del proyecto
1. Inicie sesión como administrador en (https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
2. Cree un caso de prueba fallido para iniciar sesión
4. Vaya al menú PIM y cree un nuevo empleado. Confirme si se creó un empleado correctamente y que aparece en la lista.
## Pre requisito
- JDK 21
- Configurar vairables de entorno

## Configuración
- Instalar JDK 21
- Clonar este repositorio de GitHub
- Abrir en IntelliJ IDEA
- Antes de ejecutar el proyecto desde testng.xml, debe cambiar los datos para el nuevo usuario en el metodo generateUser de la clase "Utils" (userName, firstName, lastName).
- Ejecutar el proyecto desde testng.xml para el caso de prueba "crear nuevo empleado". (Click derecho > run)
- Ejecutar desde testng2.xml para los casos de prueba "Login exitoso" y "Login Fallido".

## Herramientas y Frameworks usados
- Playwright
- Java
- Maven
- TestNg
- Patron POM

## Casos de prueba
Para la generación de casos de prueba se utilizó la técnica de tabla de decisión, para combinar las variables de entrada y obtener las posibles salidas.
No se empleó tecnicas como Analisis de particiones o valores limites, ya que no existen datos númericos durante el flujo de las pruebas.
1. Scenario: Validar que el usuario inicie sesion de manera exitosa con credenciales validas.
- Given el usuario se encuentre en el login de la AppWeb OrangeHRM
- And ingrese usuario y contraseña validos
- When el usuario pulse el boton Login
- Then el usuario debe iniciar sesion exitosamente y vizualizar el Home.
2. Scenario: Validar que el usuario no inicie sesion con credenciales no validas.
- Given el usuario se encuentre en el login de la AppWeb OrangeHRM
- And ingrese usuario y contraseña incorrectas
- When el usuario pulse el boton Login
- Then el usuario debe vizualizar un mensaje de credenciales invalidas.
3. Scenario Validar que el usuario Admin cree un nuevo empleado.
- Given el usuario administrador se encuentre logueado en la AppWeb OrangeHRM
- And pulse en el menu la opcion PIM (gestion del personal)
- And pulse el boton agregar
- And ingrese loa datos completos del nuevo empleado 
- When pulse el boton guardar
- Then el usuario debe registrar exitosamente y vizualizar los detalles del nuevo empleado. 