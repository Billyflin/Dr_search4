import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Agenda {

    public DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final LocalDate date;
    private String pacienteBusqueda;
    private String especialistaBusqueda;
    private final Paciente paciente;
    private final Especialista especialista;
    private final LocalTime hour;
//    LocalTime time1 = LocalTime.of(11, 00, 00);


    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public Agenda(LocalDate date, Paciente paciente, Especialista especialista, LocalTime hour) {
        this.date = date;
        this.paciente = paciente;
        this.especialista = especialista;
        this.hour = hour;
    }

    public Agenda(String date, String paciente, String especialista, String hora){
        this.date = LocalDate.parse(date);
        this.paciente = comapararPaciente(paciente);
        this.especialista = compararEspecialista(especialista);
        this.hour = LocalTime.parse(hora);
    }

    private Especialista compararEspecialista(String especialista) {
        for (Especialista p:
                Especialista.especialistas) {
            if (p.getNombre().equals(especialista)){
                return p;
            }
        }
        return null;
    }

    private Paciente comapararPaciente(String paciente) {
        for (Paciente p:
             Paciente.pacientes) {
            if (p.getNombre().equals(paciente)){
                return p;
            }
        }
        return null;
    }


    private void show() {
        System.out.println("------------------");
        System.out.println("Especialista: "+especialista.getNombre());
        System.out.println("Nombre: "+ paciente.getNombre()+" "+paciente.getApellido());
        System.out.println("Rut: "+paciente.getRut());
        System.out.println("Fecha: "+date.format(formato));
        System.out.println("Hora: "+ hour);
        System.out.println("------------------");
    }


    @Override
    public String toString() {
        return  date.format(formato) + "," + paciente.getNombre()+" "+ paciente.getApellido() + "," + especialista.getNombre() + "," + hour;
    }
}
