package Interfaces;

import Excepciones.EstudianteNoInscritoEnCursoException;
import Excepciones.EstudianteYaInscritoException;
import Modelos.Curso;
import Modelos.Estudiante;

public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException ;
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException ;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}
