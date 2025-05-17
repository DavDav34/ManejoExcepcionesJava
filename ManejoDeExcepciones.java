public class ValidadorDatos {

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