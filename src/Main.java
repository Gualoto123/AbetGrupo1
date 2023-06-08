import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Farmacia farmacia = new Farmacia();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            System.out.println("------- MENÚ -------");
            System.out.println("1. Agregar Medicina al Inventario");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Agregar Receta Médica");
            System.out.println("4. Despachar Receta Médica");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la medicina: ");
                    String nombreMedicina = scanner.next();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidadMedicina = scanner.nextInt();
                    Medicina medicina = new Medicina(nombreMedicina, cantidadMedicina);
                    farmacia.agregarMedicina(medicina);
                    break;

                case 2:
                    farmacia.mostrarInventario();
                    break;


                case 3:
                    System.out.print("Ingrese el nombre de la medicina recetada: ");
                    String nombreReceta = scanner.next();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidadReceta = scanner.nextInt();
                    System.out.print("Ingrese el nombre y apellido del paciente: ");
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    String nombrePaciente = scanner.nextLine();
                    System.out.print("Ingrese el número de cédula del paciente: ");
                    String cedulaPaciente = scanner.next();
                    MedicinaRecetada receta = new MedicinaRecetada(nombreReceta, cantidadReceta, nombrePaciente);
                    receta.setCedula(cedulaPaciente);
                    farmacia.agregarReceta(receta);
                    break;

                case 4:
                    farmacia.mostrarRecetas();
                    System.out.print("Ingrese el número de receta a despachar: ");
                    int numeroReceta = scanner.nextInt();
                    MedicinaRecetada recetaDespachar = farmacia.recetas.get(numeroReceta - 1);
                    farmacia.despacharReceta(recetaDespachar);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

            System.out.println();

            if (opcion == 5) {
                break;
            }
        }

        scanner.close();
    }
}




