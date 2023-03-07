package model;

public class Student {
    private int id;
    private String name;
    private int point;
    private String location;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int point, String location, int age) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.location = location;
        this.age = age;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int point() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String location() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int age() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
