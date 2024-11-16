import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserShop {
    // Método para manejar errores de entrada
    private static void printErrorAndExit(String errorMessage) throws Exception {
        System.out.println(errorMessage);
        throw new Exception("Programa finalizado");
    }

    // Métodos de validación de entrada
    public static Integer checkID(Scanner input) {
        try {
            int id = input.nextInt();
            return (id >= 111 && id <= 999) ? id : null;
        } catch (InputMismatchException e) {
            input.next();
            return null;
        }
    }

    public static Integer checkAge(Scanner input) {
        try {
            int age = input.nextInt();
            return (age >= 14 && age <= 120) ? age : null;
        } catch (InputMismatchException e) {
            input.next();
            return null;
        }
    }

    public static Integer checkKind(Scanner input) {
        try {
            int kind = input.nextInt();
            return (kind >= 0 && kind <= 3) ? kind : null;
        } catch (InputMismatchException e) {
            input.next();
            return null;
        }
    }

    public static Integer checkTotal(Scanner input) {
        try {
            int total = input.nextInt();
            return (total >= 0 && total <= 1000) ? total : null;
        } catch (InputMismatchException e) {
            input.next();
            return null;
        }
    }

    public static Integer checkPhone(Scanner input) {
        try {
            int phone = input.nextInt();
            return (phone >= 111111111 && phone <= 999999999) ? phone : null;
        } catch (InputMismatchException e) {
            input.next();
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Integer id, age, kind, total, phone;
            List<String> kindsOfSell = List.of("libre", "pensionista", "carnet joven", "socio");

            System.out.println("Bienvenido! Debes ingresar todos los datos solicitados");

            System.out.print("Ingresa tu ID del usuario: ");
            id = checkID(scanner);
            if (id == null) {
                printErrorAndExit("Error! ID inválido. Solo se aceptan números naturales de 111 a 999 (incluidos).");
            }

            System.out.print("Ingresa tu edad: ");
            age = checkAge(scanner);
            if (age == null) {
                printErrorAndExit("Error! Edad inválida. Solo se aceptan números naturales de 14 a 120 (incluidos).");
            }

            System.out.println("Ingresa el número correspondiente al tipo de venta:");
            System.out.println("0 - Venta libre\n1 - Pensionista\n2 - Carnet Jove\n3 - Socio");
            kind = checkKind(scanner);
            if (kind == null) {
                printErrorAndExit("Error! Tipo de venta inválido. Solo se aceptan números de 0 a 3 (incluidos).");
            }

            System.out.print("Ingresa el importe de la compra: ");
            total = checkTotal(scanner);
            if (total == null) {
                printErrorAndExit("Error! Importe inválido. Solo se aceptan números de 0 a 1000 (incluidos).");
            }

            System.out.print("Ingresa tu teléfono sin el prefijo: ");
            phone = checkPhone(scanner);
            if (phone == null) {
                printErrorAndExit("Error! Teléfono inválido. Solo se aceptan números de 111111111 a 999999999 (incluidos).");
            }

            // Imprimir resultados
            System.out.println("\nGracias por completar el registro.");
            System.out.println("Tus datos son:");
            System.out.printf("Id: %d, Edad: %d, Tipo: %s, Importe: %d, Teléfono: %d\n",
                    id, age, kindsOfSell.get(kind), total, phone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
