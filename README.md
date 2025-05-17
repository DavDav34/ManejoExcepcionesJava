# ManejoExcepcionesJava

Este proyecto en Java es un programa para validar datos de registro de usuarios, asegurando que la información ingresada cumpla con ciertas reglas de formato y seguridad. Utiliza excepciones personalizadas para manejar errores específicos de validación.

## Descripción general

El programa solicita al usuario que ingrese:

- Nombre de usuario
- Contraseña
- Edad
- Email

Luego valida cada dato con reglas específicas y muestra mensajes claros si algún dato es inválido. Si todos los datos son correctos, confirma el registro exitoso.

## Estructura del código

### Clases de excepciones personalizadas

- **ValidacionException**  
  Clase base para todas las excepciones de validación. Contiene un mensaje de error y el nombre del campo que causó la excepción.

- **EdadInvalidaException**  
  Hereda de `ValidacionException`. Se lanza cuando la edad ingresada es negativa o mayor a 120.

- **EmailInvalidoException**  
  Hereda de `ValidacionException`. Se lanza cuando el email está vacío o no cumple con el formato esperado.

- **ContrasenaInseguraException**  
  Hereda de `ValidacionException`. Se lanza cuando la contraseña no cumple con los requisitos mínimos de seguridad.

### Clase principal: `ValidadorDatos`

Contiene métodos estáticos para validar cada campo y el método `main` para la interacción con el usuario.

#### Métodos

- `validarEdad(int edad)`  
  Valida que la edad sea un número entre 0 y 120. Lanza `EdadInvalidaException` si no cumple.

- `validarEmail(String email)`  
  Valida que el email no esté vacío y tenga un formato válido (ejemplo: usuario@dominio.com). Lanza `EmailInvalidoException` si no cumple.

- `validarContrasena(String contrasena)`  
  Valida que la contraseña tenga al menos 8 caracteres, contenga al menos una letra mayúscula, una letra minúscula, un número y un carácter especial. Lanza `ContrasenaInseguraException` si no cumple.

- `main(String[] args)`  
  Punto de entrada del programa. Solicita los datos al usuario, llama a las funciones de validación y maneja las excepciones mostrando mensajes claros. Finalmente, cierra el recurso `Scanner`.

## Cómo usar el programa

1. Compilar:

   ```
   javac ValidadorDatos.java
   ```

2. Ejecutar:

   ```
   java ValidadorDatos
   ```

3. Seguir las instrucciones en consola para ingresar los datos.

## Ejemplo de ejecución

```
nombre de usuario: juanperez
su contraseña: MiPassw0rd!
su edad: 25
su email: juan.perez@email.com
el usuario se registro correctamente
```

Si algún dato es inválido, el programa mostrará un mensaje de error indicando el campo y el motivo.

## Informe de Errores de Contraseña

Este apartado resume los errores encontrados en la validación de contraseñas para tres usuarios diferentes, basados en casos reales.

### Caso 1  
**Nombre de usuario:** Davigos  
**Contraseña ingresada:** 211131212  
**Error:** La contraseña debe contener al menos una letra mayúscula.  
**Observación:** La contraseña contiene solo números, no cumple con el requisito de tener al menos una letra mayúscula.

### Caso 2  
**Nombre de usuario:** Abad  
**Contraseña ingresada:** 211312ac  
**Error:** La contraseña debe contener al menos una letra mayúscula.  
**Observación:** Aunque contiene letras, todas son minúsculas. Se requiere al menos una letra en mayúscula.

### Caso 3  
**Nombre de usuario:** Nat  
**Contraseña ingresada:** 211312  
**Error:** La contraseña debe tener al menos 8 caracteres.  
**Observación:** La contraseña contiene solo 6 caracteres, por lo tanto, no cumple con la longitud mínima requerida.

## Recomendaciones Generales

Para que una contraseña sea válida, debe cumplir con los siguientes requisitos:

- Tener al menos 8 caracteres.
- Contener al menos una letra mayúscula.
- Incluir números o letras según las políticas de seguridad adicionales.