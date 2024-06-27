package Modelos;

import Excepciones.EstudianteNoInscritoEnCursoException;
import Excepciones.EstudianteYaInscritoException;
import Interfaces.ServiciosAcademicosI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorAcademico implements ServiciosAcademicosI{
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;
    private HashMap<Integer, List<Integer>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException {
        for (Estudiante e : estudiantes) {
            if (e.getId() == estudiante.getId()) {
                throw new EstudianteYaInscritoException("El estudiante ya está matriculado.");
            }
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        for (Curso c : cursos) {
            if (c.getId() == curso.getId()) {
                return;
            }
        }
        cursos.add(curso);
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (!inscripciones.containsKey(idCurso)) {
            inscripciones.put(idCurso, new ArrayList<>());
        }
        List<Integer> inscritos = inscripciones.get(idCurso);
        if (inscritos.contains(estudiante.getId())) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        } else {
            inscritos.add(estudiante.getId());
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        if (inscripciones.containsKey(idCurso)) {
            List<Integer> inscritos = inscripciones.get(idCurso);
            if (inscritos.contains(idEstudiante)) {
                inscritos.remove(Integer.valueOf(idEstudiante));
            } else {
                throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
            }
        } else {
            throw new EstudianteNoInscritoEnCursoException("El curso no existe.");
        }
    }

    // Getters y Setters para listas y mapa
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public HashMap<Integer, List<Integer>> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(HashMap<Integer, List<Integer>> inscripciones) {
        this.inscripciones = inscripciones;
    }
}
