package br.com.generationbrasil.studentsgen.repository;

import br.com.generationbrasil.studentsgen.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentModel, Integer> {
    
}
