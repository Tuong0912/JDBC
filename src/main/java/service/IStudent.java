package service;

import model.Student;

import java.util.List;

public interface IStudent {
    List<Student> findAll();

    void saveStudent(Student student);

    Student findById(int id);

    void updateStudent(int id, Student student);

    void deleleStudent(int id);
}
