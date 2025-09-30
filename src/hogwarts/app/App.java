package hogwarts.app;

import hogwarts.app.ui.TextUI;
import hogwarts.data.House;
import hogwarts.data.Student;
import hogwarts.data.Teacher;

import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public App() {
    }

    public ArrayList<Student> listOfStudents = new ArrayList<>();

    public void start() {
        System.out.println("System is started");
        loadStudents();
        showMenu();

    }

    private void loadStudents() {
        House h0 = new House("Griffendor");
        House h1 = new House("Slytherin");
        House h2 = new House("Huffelpuff");
        House h3 = new House("Rawenclaw");

        try {
            File file = new File("students.csv");
            System.out.println("Indhold af filen " + file.getName());

            Scanner scan = new Scanner(file);
            String header = scan.nextLine();
            scan.useDelimiter("[;\n]");

            while (scan.hasNext()) {
                String name = scan.next();
                String houseString = scan.next();
                int age = scan.nextInt();

                House house = new House(houseString);
                Student student = new Student(name, house, age);
                listOfStudents.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        /*Student s1 = new Student("Harry Potter", h0, 16);
        Student s2 = new Student("Ronald Weasley", h0, 16);
        Student s3 = new Student("Hermione Granger", h0, 16);
        listOfStudents.add(s1);
        listOfStudents.add(s2);
        listOfStudents.add(s3);*/


    }

    private void showMenu() {
        int choice;
        while (true) {
            choice = TextUI.promptText("""
                    Student Menu
                    ------------
                    1) List all students
                    2) Create new student
                    
                    0) Exit application
                    """);
            if (choice == 1) {
                listAllStudents();
            } else if (choice == 2) {
                createNewStudent();
            } else if (choice == 0) {
                return;
            } else {
                System.out.println("Try the numbers 1,2 or 0");
            }
        }

    }

    private void listAllStudents() {
        System.out.println("There are " + listOfStudents.size() + " students in the system");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        for (Student student : listOfStudents) {
            System.out.printf("%18s - age %d - house: %s\n", student.getName(), student.getAge(), student.getHouse());
        }
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
    }

    private void createNewStudent() {
        String name = TextUI.promptText2("Name of student?");
        int age = TextUI.promptText("Age of student?");
        String houseString = TextUI.promptText2("House of student?");

        House house = new House(houseString);
        Student student = new Student(name, house, age);
        listOfStudents.add(student);




        /*Scanner scan = new Scanner(System.in);
        System.out.println("Name of student: ");//Stille brugeren et spørgsmål
        String name = scan.nextLine();          //Give brugere et sted at placere sit svar og vente på svaret
        System.out.println("Age of student: ");
        int age = Integer.parseInt(scan.nextLine());
        System.out.println("House of student: ");
        String house = scan.nextLine();*/
    }

}
