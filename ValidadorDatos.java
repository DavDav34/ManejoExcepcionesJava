import java.util.Scanner;

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
            System.out.print("nombre de usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("su contraseña: ");
            String contrasena = scanner.nextLine();
            validarContrasena(contrasena);

            System.out.print("su edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            validarEdad(edad);

            System.out.print("su email: ");
            String email = scanner.nextLine();
            validarEmail(email);

            System.out.println("el usuario se registro correctamente");

        } catch (ContrasenaInseguraException | EdadInvalidaException | EmailInvalidoException e) {
            System.err.println("error en el campo '" + e.getCampo() + "': " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("la  edad debe ser un numero entero valido");
        } finally {
            scanner.close();
        }
    }
}