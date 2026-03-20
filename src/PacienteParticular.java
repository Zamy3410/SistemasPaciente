public class PacienteParticular extends Paciente{
    public PacienteParticular(){

    }

    public PacienteParticular(String nombre, String documento, double costoConsulta) {
        super(nombre, documento, costoConsulta);
    }
    @Override
    public double calcularCostoFinal(){
        double total;
        if (costoConsulta >= 400000){
            total = aplicarDescuento(0.15);
        } else if (costoConsulta >= 200000){
            total = aplicarDescuento(0.10);
        } else if (costoConsulta <= 50000){
            total = aplicarRecargo(0.5);
        } else {
            total = costoConsulta;
        }
        return total;
    }


    public void mostrarInfo(){
        System.out.println("==============");
        System.out.println("Tipo: paciente particular");
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Costo de la consulta: " + costoConsulta);
        System.out.println("==============");
    }

    @Override
    public String toString() {
        return "PacienteParticular{" +
                "costoConsulta=" + costoConsulta +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }


}
