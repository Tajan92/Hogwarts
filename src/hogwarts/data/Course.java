package hogwarts.data;

import java.util.ArrayList;

public class Course {
    private String name;
    private Teacher teacher = new Teacher();
    private ArrayList<String> students = new ArrayList<>();

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<String> getStudents() {
        return students;
    }
    public void addStudent(String name){
        students.add(name);
    }

    public void removeStudents(String name) {
       students.remove(name);
    }
}
