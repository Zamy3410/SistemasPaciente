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
                case 2:
                    System.out.println("Registrar paciente EPS");
                    System.out.println("Nombre: ");
                    String nombreE = sc.nextLine();
                    System.out.println("Documento: ");
                    String documentoE = sc.nextLine();
                    System.out.println("Costo de la consulta: ");
                    double costoE = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Nombre de la EPS: ");
                    String nombreEPS = sc.nextLine();

                    Paciente pe = new PacienteEPS(nombreE, documentoE, costoE, nombreEPS);
                    lstPacientes.add(pe);
                    System.out.println("Paciente registrado correctamente.");
                    break;

                case 3:
                    System.out.println("Registrar paciente VIP");
                    System.out.println("Nombre: ");
                    String nombreV = sc.nextLine();
                    System.out.println("Documento: ");
                    String documentoV = sc.nextLine();
                    System.out.println("Costo de la consulta: ");
                    double costoV = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Años de fidelidad: ");
                    int anios = sc.nextInt();
                    sc.nextLine();

                    Paciente pv = new PacienteVIP(nombreV, documentoV, costoV, anios);
                    lstPacientes.add(pv);
                    System.out.println("Paciente registrado correctamente.");
                    break;

                case 4:
                    System.out.println("Buscar paciente por documento");
                    System.out.println("Ingrese el documento: ");
                    String docBuscar = sc.nextLine();

                    boolean encontrado = false;
                    for (Paciente p : lstPacientes) {
                        if (p.getDocumento().equalsIgnoreCase(docBuscar)) {
                            p.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Todos los pacientes:");
                    if (lstPacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        for (Paciente p : lstPacientes) {
                            p.mostrarInfo();
                            System.out.println("Costo final: " + p.calcularCostoFinal());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Mostrar pacientes por tipo:");
                    System.out.println("1. Pacientes particulares");
                    System.out.println("2. Pacientes EPS");
                    System.out.println("3. Pacientes VIP");
                    int opTipo = sc.nextInt();
                    sc.nextLine();

                    boolean hayTipo = false;
                    for (Paciente p : lstPacientes) {
                        if (opTipo == 1 && p instanceof PacienteParticular) {
                            p.mostrarInfo();
                            hayTipo = true;
                        } else if (opTipo == 2 && p instanceof PacienteEPS) {
                            p.mostrarInfo();
                            hayTipo = true;
                        } else if (opTipo == 3 && p instanceof PacienteVIP) {
                            p.mostrarInfo();
                            hayTipo = true;
                        }
                    }

                    if (!hayTipo) {
                        System.out.println("No hay pacientes de ese tipo.");
                    }
                    break;

                case 7:
                    System.out.println("Calcular costo de consulta");
                    System.out.println("Ingrese el documento: ");
                    String docCosto = sc.nextLine();

                    boolean encontradoCosto = false;
                    for (Paciente p : lstPacientes) {
                        if (p.getDocumento().equalsIgnoreCase(docCosto)) {
                            double costoFinal = p.calcularCostoFinal();
                            p.mostrarDatos(costoFinal);
                            encontradoCosto = true;
                            break;
                        }
                    }

                    if (!encontradoCosto) {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 8:
                    System.out.println("Pacientes con consulta costosa:");
                    boolean hayCostosa = false;

                    for (Paciente p : lstPacientes) {
                        if (p.esConsultaCostosa()) {
                            p.mostrarInfo();
                            hayCostosa = true;
                        }
                    }

                    if (!hayCostosa) {
                        System.out.println("No hay pacientes con consulta costosa.");
                    }
                    break;

                case 9:
                    System.out.println("Paciente que más pagó:");
                    if (lstPacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        Paciente masPago = lstPacientes.get(0);
                        double mayorCosto = masPago.calcularCostoFinal();

                        for (Paciente p : lstPacientes) {
                            double costoActual = p.calcularCostoFinal();
                            if (costoActual > mayorCosto) {
                                mayorCosto = costoActual;
                                masPago = p;
                            }
                        }

                        masPago.mostrarDatos(mayorCosto);
                    }
                    break;

                case 10:
                    System.out.println("Saliendo del sistema...");
                    op = 10;
                    break;

                default:
                    System.out.println("Opción no válida xdxdxd.");
                    break;

            }

        }while (op != 10);

    }
}