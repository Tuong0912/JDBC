package service;

import DAO.ConnectionDAO;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudent {
    private final String INSERT_STUDENT = "insert into student(name,point,location,age)values (?,?,?,?)";
    private final String DELETE_STUDENT = "delete from student where id=?;";
    private final String FIND_BY_ID = "select * from student where id=?;";
    private final String UPDATE_BY_ID = "update student set name=?,point=?,location=?,age=? where id=?;";

    @Override
    public List<Student> findAll() {
        Connection connection = ConnectionDAO.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from student");
                List<Student> students = new ArrayList<>();
                while (resultSet.next()) {
                    students.add(new Student(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("point"),
                            resultSet.getString("location"),
                            resultSet.getInt("age")));
                }
                return students;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        Connection connection = ConnectionDAO.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, student.name());
            preparedStatement.setInt(2, student.point());
            preparedStatement.setString(3, student.location());
            preparedStatement.setInt(4, student.age());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        Connection connection = ConnectionDAO.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("point"),
                        resultSet.getString("location"),
                        resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public void updateStudent(int id, Student student) {
        Connection connection = ConnectionDAO.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID);
            statement.setString(1, student.name());
            statement.setInt(2,student.point());
            statement.setString(3, student.location());
            statement.setInt(4, student.age());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleleStudent(int id) {
        Connection connection = ConnectionDAO.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);
            statement.setInt(1, id);
            int row = statement.executeUpdate();
            System.out.println("Delete " + row);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
