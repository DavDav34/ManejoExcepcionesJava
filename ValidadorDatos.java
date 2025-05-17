import java.util.Scanner;

// Clase base para las excepciones de validación
class ValidacionException extends Exception {
    private String campo;

    public ValidacionException(String mensaje, String campo) {
        super(mensaje);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }
}

// Excepción para edad inválida
class EdadInvalidaException extends ValidacionException {
    public EdadInvalidaException(String mensaje) {
        super(mensaje, "edad");
    }
}

// Excepción para email inválido
class EmailInvalidoException extends ValidacionException {
    public EmailInvalidoException(String mensaje) {
        super(mensaje, "email");
    }
}

// Excepción para contraseña insegura
class ContrasenaInseguraException extends ValidacionException {
    public ContrasenaInseguraException(String mensaje) {
        super(mensaje, "contrasena");
    }
}

public class ValidadorDatos {

    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException("La edad no puede ser negativa");
        }
        if (edad > 120) {
            throw new EdadInvalidaException("La edad no puede ser mayor a 120");
        }
    }

    public static void validarEmail(String email) throws EmailInvalidoException {
        if (email == null || email.isEmpty()) {
            throw new EmailInvalidoException("El email no puede estar vacío");
        }
        String regexEmail = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(regexEmail)) {
            throw new EmailInvalidoException("El formato del email es incorrecto");
        }
    }

    public static void validarContrasena(String contrasena) throws ContrasenaInseguraException {
        if (contrasena == null || contrasena.length() < 8) {
            throw new ContrasenaInseguraException("La contraseña debe tener al menos 8 caracteres.");
        }
        String regexMayuscula = ".*[A-Z].*";
        String regexMinuscula = ".*[a-z].*";
        String regexNumero = ".*\\d.*";
        String regexEspecial = ".*[!@#$%^&()_+\\-=[\\]{};':\"\\\\|,.<>/?].*";

        if (!contrasena.matches(regexMayuscula)) {
            throw new ContrasenaInseguraException("La contraseña debe contener al menos una letra mayúscula");
        }
        if (!contrasena.matches(regexMinuscula)) {
            throw new ContrasenaInseguraException("La contraseña debe contener al menos una letra minúscula");
        }
        if (!contrasena.matches(regexNumero)) {
            throw new ContrasenaInseguraException("La contraseña debe contener al menos un número");
        }
        if (!contrasena.matches(regexEspecial)) {
            throw new ContrasenaInseguraException("La contraseña debe contener al menos un caracter especial");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nombre de usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Su contraseña: ");
            String contrasena = scanner.nextLine();
            validarContrasena(contrasena);

            System.out.print("Su edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            validarEdad(edad);

            System.out.print("Su email: ");
            String email = scanner.nextLine();
            validarEmail(email);

            System.out.println("El usuario se registró correctamente");

        } catch (ContrasenaInseguraException e) {
            System.out.println("Error en la contraseña: " + e.getMessage());
        } catch (EdadInvalidaException e) {
            System.out.println("Error en la edad: " + e.getMessage());
        } catch (EmailInvalidoException e) {
            System.out.println("Error en el email: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("La edad debe ser un número válido.");
        } finally {
            scanner.close();
        }
    }
}