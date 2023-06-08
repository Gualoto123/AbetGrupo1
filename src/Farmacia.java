import java.util.ArrayList;

public class Farmacia {
    private ArrayList<Medicina> inventario;
    private ArrayList<MedicinaRecetada> recetas;

    public Farmacia() {
        inventario = new ArrayList<>();
        recetas = new ArrayList<>();
    }

    public void agregarMedicina(String nombre, int cantidad) {
        for (Medicina medicina : inventario) {
            if (medicina.getNombre().equals(nombre)) {
                int cantidadActual = medicina.getCantidad();
                medicina.setCantidad(cantidadActual + cantidad);
                System.out.println("Se actualizó la cantidad de " + medicina.getNombre() + " en el inventario.");
                return;
            }
        }
        Medicina medicina = new Medicina(nombre, cantidad);
        inventario.add(medicina);
        System.out.println("Se agregó " + medicina.getNombre() + " al inventario.");
    }

    public void agregarReceta(MedicinaRecetada receta) {
        recetas.add(receta);
        System.out.println("Se agregó una receta médica al sistema.");
    }

    public void despacharReceta(int numeroReceta) {
        if (numeroReceta >= 1 && numeroReceta <= recetas.size()) {
            MedicinaRecetada recetaDespachar = recetas.get(numeroReceta - 1);
            for (Medicina medicina : inventario) {
                if (medicina.getNombre().equals(recetaDespachar.getNombre())) {
                    int cantidadActual = medicina.getCantidad();
                    if (cantidadActual >= recetaDespachar.getCantidad()) {
                        medicina.setCantidad(cantidadActual - recetaDespachar.getCantidad());
                        System.out.println("Se despachó la receta de " + recetaDespachar.getPaciente() + ".");
                    } else {
                        System.out.println("No hay suficiente " + medicina.getNombre() + " en inventario.");
                    }
                    return;
                }
            }
            System.out.println("La medicina de la receta no está disponible en inventario.");
        } else {
            System.out.println("El número de receta es inválido.");
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario de Medicinas:");
        for (Medicina medicina : inventario) {
            System.out.println(medicina.getNombre() + " - Cantidad: " + medicina.getCantidad());
        }
    }

    public void mostrarRecetas() {
        System.out.println("Recetas Médicas:");
        for (int i = 0; i < recetas.size(); i++) {
            MedicinaRecetada receta = recetas.get(i);
            System.out.println("Receta #" + (i + 1) + " - Paciente: " + receta.getPaciente() +
                    " - Medicina: " + receta.getNombre() + " - Cantidad: " + receta.getCantidad());
        }
    }
}

