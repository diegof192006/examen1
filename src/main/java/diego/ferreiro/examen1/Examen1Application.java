package diego.ferreiro.examen1;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import diego.ferreiro.Entities.Estudiante;
import diego.ferreiro.Repository.IAsignaturaRepository;
import diego.ferreiro.Repository.IEstudianteRepository;
import diego.ferreiro.Repository.IMatriculaRepository;

@SpringBootApplication
public class Examen1Application implements CommandLineRunner {

    private final IEstudianteRepository estudianteRepo;
    private final IAsignaturaRepository asignaturaRepo;
    private final IMatriculaRepository matriculaRepo;

    public Examen1Application(IEstudianteRepository estudianteRepo,
            IAsignaturaRepository asignaturaRepo,
            IMatriculaRepository matriculaRepo) {
        this.estudianteRepo = estudianteRepo;
        this.asignaturaRepo = asignaturaRepo;
        this.matriculaRepo = matriculaRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Examen1Application.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("===== BLOQUE 1: MÉTODOS BASE =====");
        System.out.println("Estudiantes: " + estudianteRepo.count() + " (esperado 3)");
        System.out.println("Asignaturas: " + asignaturaRepo.count() + " (esperado 3)");
        System.out.println("Matrículas: " + matriculaRepo.count() + " (esperado 5)");

        System.out.println("-- Estudiantes con su expediente (findAll) --");
        for (Estudiante e : estudianteRepo.findAll()) {
            System.out.println(e.getNombre() + " " + e.getApellidos()
                    + " -> expediente " + e.getExpediente().getNumeroExpediente()
                    + " (apertura " + e.getExpediente().getFechaApertura()
                    + ", nota acceso " + e.getExpediente().getNotaMediaAcceso() + ")");
        }

        System.out.println("-- Estudiante con id 1 (findById) --");
        Optional<Estudiante> uno = estudianteRepo.findById(1L);
        if (uno.isPresent()) {
            System.out.println(uno.get().getNombre() + " -> expediente "
                    + uno.get().getExpediente().getNumeroExpediente());
        } else {
            System.out.println("No existe el estudiante con id 1");
        }
    }
}
