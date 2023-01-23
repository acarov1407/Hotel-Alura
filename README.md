
![menu-img](https://user-images.githubusercontent.com/118088808/213954737-6026ae96-8f54-4c92-8089-28e28715e285.png)
## :page_with_curl: Descripción
Este proyecto consiste en un aplicativo tipo CRUD que se encarga de controlar las 
reservaciones de un hotel, guardando tanto la información de la reserva como la del huesped
que la realiza, para posteriormente poder mostrarla en una tabla en la cual se podrá 
actualizar o eliminar dicha información según sea el caso.

## :computer: El proyecto funcionando
Aqui podrás ver una demostración del proyecto en funcionamiento: <br>
:movie_camera: <a target=_blank> https://clipchamp.com/watch/tZ6lcWGB4kn </a>
## :wrench: Funcionalidades 
- ### Autenticación de usuario
La aplicación cuenta con un sistema de autenticación para que solo los usuarios autorizados del hotel puedan hacer uso de este aplicativo.
La autenticación se hace por medio de la base de datos, usando "Advanced Encryption Standard (AES)" para el manejo de las contraseñas, 
con el fin de mantener una muy buena seguridad en las cuentas de los usuarios.

![image](https://user-images.githubusercontent.com/118088808/213957523-f286fdc2-ca40-4301-8f59-227229d16bb0.png)

- ### Interfaz Principal
Por medio de la interfaz principal el usuario podrá navegar por el aplicativo ya sea para registrar una reserva o para ver las reservas ya existentes.

![image](https://user-images.githubusercontent.com/118088808/213963021-34bdf730-2b39-4e68-bc0d-c1582a68eeec.png)

- ### Registro de la reserva
El usuario podrá registrar una reserva ingresando datos tales como:
- Fecha de check-In : La cual esta lógicamente validada para que solo se puedan ingresar fechas iguales o posteriores a la actual.
- Fecha de check-Out: Validada para que por lo menos tenga un día de distancia con respecto a la fecha de check-In.
- Metodo de pago: El usuario elegirá de una lista el método de pago que prefiera el huesped.

Además la aplicación generará en tiempo real el precio de la reservación dependiendo de la cantidad de días de la reserva para poder informar al huesped
del valor de su reservación y continuar con el registro. En caso de continuar con el registro se generará un "ID de reserva" totalmente único que será 
mostrado al usuario en el registro del huesped.

![image](https://user-images.githubusercontent.com/118088808/214120920-998d6f30-e844-4a21-a22c-06be7f1bf396.png)

- ### Registro del huesped
Una vez guardados los datos de la reserva, el usuario podrá registrar la información del huesped. Cada uno de los campos del formulario estan lógicamente 
validados para garantizar la integridad de los datos. En caso de que todo este correcto el usuario podrá finalizar todo el registro y tanto la reserva como 
los datos del huesped quedarán guardados en la base de datos.

![image](https://user-images.githubusercontent.com/118088808/214123125-2036e665-adee-4ff4-8707-4fe186266a74.png)

- ### Sistema de Búsqueda
Se divide en dos pestañas: Reservas y Huespedes.
En la pestaña de reservas el usuario podrá:
- Listar todas las reservas hechas.
- Filtrar las reservas por el nombre y/o apellido del huesped que la realizó.
- Editar o eliminar una reserva.

![image](https://user-images.githubusercontent.com/118088808/214128289-4196f423-1293-43da-9488-49aaa7ba4328.png)


En la pestaña de huespedes el usuario podrá:
- Listar todos los huespedes que realizarón una reserva.
- Filtrar los huespedes por su nombre y/o apellido.
- Editar la informacion de un huesped.
Un huesped solo se elimina de la base de datos cuando se elimina previamente su reserva.

![image](https://user-images.githubusercontent.com/118088808/214128332-df4faff5-db77-4d1c-b652-946768a3aa84.png)






