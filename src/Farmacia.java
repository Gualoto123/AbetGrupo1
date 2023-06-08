import java.util.ArrayList;

public class Farmacia {
    private ArrayList<Medicina> inventario;
    ArrayList<MedicinaRecetada> recetas;

    public Farmacia() {
        inventario = new ArrayList<>();
        recetas = new ArrayList<>();
    }

    public void agregarMedicina(Medicina medicina) {
        inventario.add(medicina);
    }

    public void agregarReceta(MedicinaRecetada receta) {
        recetas.add(receta);
    }

    public void despacharReceta(MedicinaRecetada receta) {
        for (Medicina medicina : inventario) {
            if (medicina.getNombre().equals(receta.getNombre())) {
                int cantidadActual = medicina.getCantidad();
                if (cantidadActual >= receta.getCantidad()) {
                    medicina.setCantidad(cantidadActual - receta.getCantidad());
                    System.out.println("Se despachó la receta de " + receta.getPaciente() + ".");
                } else {
                    System.out.println("No hay suficiente " + medicina.getNombre() + " en inventario.");
                }
                return;
            }
        }
        System.out.println("La medicina de la receta no está disponible en inventario.");
    }

    public void mostrarInventario() {
        System.out.println("Inventario de Medicinas:");
        for (Medicina medicina : inventario) {
            System.out.println(medicina.getNombre() + " - Cantidad: " + medicina.getCantidad());
        }
    }

    public void mostrarRecetas() {
        System.out.println("Recetas Médicas:");
        for (MedicinaRecetada receta : recetas) {
            System.out.println("Paciente: " + receta.getPaciente() + " - Medicina: " + receta.getNombre() +
                    " - Cantidad: " + receta.getCantidad());
        }
    }
}
