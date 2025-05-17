public static void validarEdad(int edad) throws EdadInvalidaException {
    if (edad < 0) {
        throw new EdadInvalidaException("la edad no puede ser negativa");
    }
    if (edad > 120) {
        throw new EdadInvalidaException("la edad no puede ser mayor a 120");
    }
}


public static void validarEmail(String email) throws EmailInvalidoException {
    if (email == null || email.isEmpty()) {
        throw new EmailInvalidoException("el email no puede estar vacío");
    }
    
    String regexEmail = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    if (!email.matches(regexEmail)) {
        throw new EmailInvalidoException("El formato del email es incorrecto");
    }
}

public class ValidadorDatos {

    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException("la edad no puede ser negativa");
        }
        if (edad > 120) {
            throw new EdadInvalidaException("la edad no puede ser mayor a 120");
        }
    }

    
    public static void validarEmail(String email) throws EmailInvalidoException {
        if (email == null || email.isEmpty()) {
            throw new EmailInvalidoException("el email no puede estar vacío");
        }
        
        String regexEmail = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(regexEmail)) {
            throw new EmailInvalidoException("El formato del email es incorrecto");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("nombre de usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("su contraseña: ");
            String contrasena = scanner.nextLine();
            

            System.out.print("su edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            

            System.out.print("su email: ");
            String email = scanner.nextLine();
            

            System.out.println("el usuario se registro correctamente");

        } catch () {
            
        } catch () {
           
        } finally {
            scanner.close();
        }
    }
}