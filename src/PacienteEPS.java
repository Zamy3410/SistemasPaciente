public class PacienteEPS extends Paciente{
    private String nombreEPS;

    public PacienteEPS(){

    }

    public PacienteEPS(String nombre, String documento, double costoConsulta, String nombreEPS) {
        super(nombre, documento, costoConsulta);
        this.nombreEPS = nombreEPS;
    }

    public String getNombreEPS() {
        return nombreEPS;
    }

    public void setNombreEPS(String nombreEPS) {
        this.nombreEPS = nombreEPS;
    }

    @Override
    public double calcularCostoFinal(){
        double porcentaje;
        if (costoConsulta >= 300000){
            porcentaje = 0.25;
        } else if (costoConsulta >= 80000) {
            porcentaje = 0.20;
        } else {
            porcentaje = 0.30;
        }
         double copago = costoConsulta * porcentaje;
        if (esConsultaCostosa()){
            copago = copago - (copago * 0.5);
        }
        return copago;
    }

    public void mostrarInfo(){
        System.out.println("==============");
        System.out.println("Tipo: Paciente EPS");
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("EPS: " + nombreEPS);
        System.out.println("Costo de la consulta: " + costoConsulta);
        System.out.println("==============");

    }

    @Override
    public String toString() {
        return "PacienteEPS{" +
                "nombreEPS='" + nombreEPS + '\'' +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", costoConsulta=" + costoConsulta +
                '}';
    }
}
