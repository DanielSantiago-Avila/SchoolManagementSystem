import Excepciones.EstudianteNoInscritoEnCursoException;
import Excepciones.EstudianteYaInscritoException;
import Modelos.Curso;
import Modelos.Estudiante;
import Modelos.GestorAcademico;

public class Main {
    public static void main(String[] args) {
        try {
            GestorAcademico gestor = new GestorAcademico();

            // Crear estudiantes
            Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", "01/01/2000", Estudiante.Estado.MATRICULADO);
            Estudiante estudiante2 = new Estudiante(2, "Maria", "Gomez", "02/02/2001", Estudiante.Estado.MATRICULADO);

            // Crear cursos
            Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas básicas", 3, "1.0");
            Curso curso2 = new Curso(2, "Historia", "Curso de historia mundial", 4, "1.0");

            // Matricular estudiantes
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);

            // Agregar cursos
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);

            // Inscribir estudiantes en cursos
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            gestor.inscribirEstudianteCurso(estudiante2, curso2.getId());

            // Intentar inscribir nuevamente al estudiante1 en curso1 (debería lanzar excepción)
            try {
                gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            } catch (EstudianteYaInscritoException e) {
                System.out.println(e.getMessage());
            }

            // Desinscribir estudiante de curso
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());

            // Intentar desinscribir nuevamente al estudiante1 de curso1 (debería lanzar excepción)
            try {
                gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
            } catch (EstudianteNoInscritoEnCursoException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("operaciones realizadas con exito.");
        } catch (EstudianteYaInscritoException | EstudianteNoInscritoEnCursoException e) {
            e.printStackTrace();
        }
    }
}