import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Paciente> lstPacientes = new ArrayList<>();

        int op = -1;
        do {
            System.out.println("====sistema clinico====");
            System.out.println("1. Registar paciente particular");
            System.out.println("2. Registrar paciente EPS");
            System.out.println("3. Registrar paceinte VIP");
            System.out.println("4. Buscar paciente por documento");
            System.out.println("5. Mostrar todos los pacientes");
            System.out.println("6. Mostrar pacientes por tipo");
            System.out.println("7. Calcular costo de consulta del paciente");
            System.out.println("8. Mostrar pacientes con consulta costosa");
            System.out.println("9. Mostrar el paciente que más pago");
            System.out.println("10. Salir");

            op = Integer.parseInt(sc.nextLine());
            sc.nextLine();

            switch (op){
                case 1:
                    System.out.println("Registrar paciente particular");
                    System.out.println("Nombre: ");
                    String nombreP = sc.nextLine();
                    System.out.println("Documento: ");
                    String documentoP = sc.nextLine();
                    System.out.println("Costo de la consulta: ");
                    double costoP = sc.nextDouble();
                    sc.nextLine();

                    Paciente pp = new PacienteParticular(nombreP, documentoP, costoP);
                    lstPacientes.add(pp);
                    System.out.println("Paciente registrado correctamente.");
                    break;
            }
        }

    }
}