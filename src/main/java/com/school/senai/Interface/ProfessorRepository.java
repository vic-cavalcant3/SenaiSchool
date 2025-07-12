package com.school.senai.Interface;
import com.school.senai.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <Professor, Long > {

}
