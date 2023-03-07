package controller;

import model.Student;
import service.IStudent;
import service.StudentDAO;
import service.StudentIplm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    int id = 0;
    StudentDAO studentIplm = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showView(request, response);
                break;
            default:
                listStudent(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "find":
                findStudent(request, response);
                break;
            default:
                listStudent(request, response);
        }
    }

    private void findStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentIplm.findById(id);
        if (student == null) {
            response.sendRedirect("/StudentServlet");
        } else {
            List<Student> studentSearch = new ArrayList<>();
            studentSearch.add(student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            request.setAttribute("students", studentSearch);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentIplm.findById(id);
        if (student == null) {
            response.sendRedirect("list.jsp");
        } else {
            this.studentIplm.deleleStudent(id);
            response.sendRedirect("/StudentServlet");
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentIplm.findById(id);
        if (student == null) {
            try {
                response.sendRedirect("list.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
            request.setAttribute("students", student);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int point = Integer.parseInt(request.getParameter("point"));
        String location = request.getParameter("location");
        int age = Integer.parseInt(request.getParameter("age"));
        Student student = this.studentIplm.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("list.jsp");
            dispatcher.forward(request, response);
        } else {
            student.setName(name);
            student.setPoint(point);
            student.setLocation(location);
            student.setAge(age);
            this.studentIplm.updateStudent(id, student);
            response.sendRedirect("edit.jsp");
        }
    }


    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int point = Integer.parseInt(request.getParameter("point"));
        String location = request.getParameter("location");
        int age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(id, name, point, location, age);
        this.studentIplm.saveStudent(student);
        id++;
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);

    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = this.studentIplm.findAll();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentIplm.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("list.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            dispatcher = request.getRequestDispatcher("view.jsp");
            request.setAttribute("students", student);
            dispatcher.forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentIplm.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("list.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("students", student);
            dispatcher = request.getRequestDispatcher("edit.jsp");
            dispatcher.forward(request, response);
        }
    }

}
