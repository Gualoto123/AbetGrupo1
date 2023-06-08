
    public class MedicinaRecetada extends Medicina {
        private String paciente;
        private String cedula;

        public MedicinaRecetada(String nombre, int cantidad, String paciente) {
            super(nombre, cantidad);
            this.paciente = paciente;
        }

        public String getPaciente() {
            return paciente;
        }

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }
    }






