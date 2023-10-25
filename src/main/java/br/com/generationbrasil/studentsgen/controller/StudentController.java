package br.com.generationbrasil.studentsgen.controller;

import java.util.List;

import br.com.generationbrasil.studentsgen.repository.IStudentRepository;
import br.com.generationbrasil.studentsgen.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@RequestMapping("/")
@OpenAPIDefinition(info = @Info(title = "Students Gen",
        description = "Cadastra um aluno e suas respectivas notas semestrais. " +
                "Deve-se preencher todos os campos.",
        version = "1.0"
))
public class StudentController {

    @Autowired
    private IStudentRepository studentRepository;

    @PostMapping("students/")
    public ResponseEntity create(@RequestBody StudentModel studentModel) {

        var task = this.studentRepository.save(studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/students/")
    public ResponseEntity<?> getAllStudents() {

        var students = this.studentRepository.findAll();

        if (students.isEmpty()) {
            return new ResponseEntity<String>("Nenhum aluno encotrado no sistema.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<StudentModel>>(students, HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity listById(@PathVariable Integer id) {

        var student = this.studentRepository.findById(id).orElse(null);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encotrado no sistema.");
        }
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("students/{id}")
    public ResponseEntity update(@RequestBody StudentModel studentModel, @PathVariable Integer id) {

        var student = this.studentRepository.findById(id).orElse(null);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encotrado no sistema.");
        }

        student.setAge(studentModel.getAge());
        student.setName(studentModel.getName());
        student.setTeachersName(studentModel.getTeachersName());
        student.setFirstSemesterGrade(studentModel.getFirstSemesterGrade());
        student.setSecondSemesterGrade(studentModel.getSecondSemesterGrade());
        student.setClassroomNumber(studentModel.getClassroomNumber());
        StudentModel studentUpdated = this.studentRepository.save(student);

        return ResponseEntity.ok().body(studentUpdated);
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {

        var student = this.studentRepository.findById(id).orElse(null);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encotrado no sistema.");
        }

        this.studentRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Aluno deletado com sucesso.");

    }
}
