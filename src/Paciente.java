public class Paciente {
    protected String nombre;
    protected String documento;
    protected double costoConsulta;

    public Paciente() {
    }

    public Paciente(String nombre, String documento, double costoConsulta) {
        this.nombre = nombre;
        this.documento = documento;
        this.costoConsulta = costoConsulta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public double getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(double costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", costoConsulta=" + costoConsulta +
                '}';
    }

    //metodos
    public double calcularCostoFinal(){
        return costoConsulta;
    }
    public double aplicarDescuento(double porcentaje){
        double descuento = costoConsulta * porcentaje;
        costoConsulta = costoConsulta - descuento;
        return costoConsulta;
    }

    public double aplicarRecargo(double porcentaje){
        double recargo = costoConsulta * porcentaje;
        costoConsulta = costoConsulta + recargo;
        return costoConsulta;
    }
    public boolean esConsultaCostosa(){
        return costoConsulta > 300000;
    }

    public void msotrarDatos(double costofinal){
        System.out.println("==============");
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Costo de la consulta: " + costoConsulta);
        System.out.println("Costo final: " + costofinal);
        System.out.println("==============");
    }



}
