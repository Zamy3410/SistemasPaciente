public class PacienteVIP extends Paciente{
    private int aniosfidelidad;

    public PacienteVIP(){

    }

    public PacienteVIP(String nombre, String documento, double costoConsulta, int aniosfidelidad) {
        super(nombre, documento, costoConsulta);
        this.aniosfidelidad = aniosfidelidad;
    }

    public int getAniosfidelidad() {
        return aniosfidelidad;
    }

    public void setAniosfidelidad(int aniosfidelidad) {
        this.aniosfidelidad = aniosfidelidad;
    }

    public double calcualrCostoFinal(){
        double total;

        if (aniosfidelidad >= 10){
            total = aplicarDescuento(0.40);
        } else if (aniosfidelidad >= 5) {
            total = aplicarDescuento(0.30);
        } else {
            total = aplicarDescuento(0.20);
        }
        if (total > 300000){
            total = 300000;
        }
        return total;
    }

    public void mostarInfo(){
        System.out.println("==============");
        System.out.println("Tipo: paciente VIP");
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Años de fidelidad: " + aniosfidelidad);
        System.out.println("Costo de la consulta: " + costoConsulta);
        System.out.println("==============");

    }

    @Override
    public String toString() {
        return "PacienteVIP{" +
                "aniosfidelidad=" + aniosfidelidad +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", costoConsulta=" + costoConsulta +
                '}';
    }
}
