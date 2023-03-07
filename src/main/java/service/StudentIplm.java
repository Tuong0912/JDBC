package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentIplm implements IStudent {
    List<Student> students = new ArrayList<>();

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void saveStudent(Student student) {
        students.add(student);
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id() == id) {
                return students.get(i);
            }
        }
        return null;
    }



    @Override
    public void updateStudent(int id, Student student) {
        students.set(id, student);

    }

    @Override
    public void deleleStudent(int id) {
        students.remove(id);
    }
}
