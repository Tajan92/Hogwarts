package hogwarts.app;

import hogwarts.app.ui.TextUI;
import hogwarts.data.House;
import hogwarts.data.MenuUI;
import hogwarts.data.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    MenuUI menu = new MenuUI();

    public App() {
    }

    public ArrayList<Student> listOfStudents = new ArrayList<>();

    public void start() {
        System.out.println("System is started");
        loadStudents();
        showMenu();
        saveStudents();
    }

    private void saveStudents() {
        try {
            System.out.println("Saving students");
            File file = new File("students.csv");
            PrintStream output = new PrintStream(file);
            output.println("name;house;age");
            for (Student student : listOfStudents) {
                output.printf("%s;%s;%d\n", student.getName(), student.getHouse(), student.getAge());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadStudents() {


        try {
            File file = new File("students.csv");
            System.out.println("Indhold af filen " + file.getName());

            Scanner scan = new Scanner(file);
            String header = scan.nextLine();
            scan.useDelimiter("[;\n]");

            while (scan.hasNext()) {
                String name = scan.next();
                String house = scan.next();
                int age = scan.nextInt();

                Student student = new Student(name, House.findByName(house), age);
                listOfStudents.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void editStudent() {
        int choice;
        Student selectedStudent = null;

        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("Select student from list");
        menuOptions.add("Search for student by name");

        choice = menu.promptMenuChoice("Edit student", menuOptions, false);

        switch (choice) {
            case 1:
                selectedStudent = selectStudentFromList();
                System.out.println("Press Enter for default");
                break;
            case 2:
                selectedStudent = selectStudentBySearch();
                System.out.println("Press Enter for default");
                break;
        }
        if (selectedStudent==null){
            System.out.println("Try again!");
            editStudent();
        }
        String name = TextUI.promptText("Name ", "("+selectedStudent.getName()+"): ");
        String house = TextUI.promptText("House: ", "("+selectedStudent.getHouse().getName()+"): ");
        int age = TextUI.promptNumeric("Age: ", selectedStudent.getAge());

       //Student student = new Student(name, House.findByName(house), age);
        Student student = new Student(name, House.findByName(house), age);
        listOfStudents.set(listOfStudents.indexOf(selectedStudent), student);
        backOrExit();
    }

    private void deleteStudent() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("Select student from list");
        menuOptions.add("Search for student by name");
        int choice;

        choice = menu.promptMenuChoice("Delete student", menuOptions, false);

        switch (choice) {
            case 1:
                selectStudentFromList();
                listOfStudents.remove(selectStudentFromList());
                break;
            case 2:
                selectStudentBySearch();
                listOfStudents.remove(selectStudentBySearch());
                break;
        }
        backOrExit();
    }

    private Student selectStudentFromList() {
        ArrayList<String> studentOptions = new ArrayList<>();

        for (Student student : listOfStudents) {
            studentOptions.add(student.getName());
        }

        MenuUI menu = new MenuUI();
        int choice = menu.promptMenuChoice("Select student", studentOptions, false);

        return listOfStudents.get(choice - 1);

    }

    private Student selectStudentBySearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a name to search for: ");
        String searchFor = scanner.nextLine();

        for (Student student : listOfStudents) {

            if (student.getName().toLowerCase().contains(searchFor.toLowerCase())) {
                return student;
            }
        }
        System.out.println("No student with that name");
        return null;


    }

    private void showMenu() {
        int choice;
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("List all students");
        menuOptions.add("Create new student");
        menuOptions.add("Edit existing student");
        menuOptions.add("Delete student");
        menuOptions.add("Exit application");

        MenuUI menu = new MenuUI();
        //while (true) {
        choice = menu.promptMenuChoice("Student Menu", menuOptions, true);

        switch (choice) {
            case 0:
                return;
            case 1:
                listAllStudents();
                break;
            case 2:
                createNewStudent();
                break;
            case 3:
                editStudent();
                break;
            case 4:
                deleteStudent();
                break;
        }
        backOrExit();

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

        backOrExit();
    }

    private void createNewStudent() {
        String name = TextUI.promptText("Name of student?");
        int age = TextUI.promptNumeric("Age of student?");
        // String houseString = TextUI.promptText2("House of student?");
        String houseID = TextUI.promptText("House of student?");
        //House house = null;

        Student student = new Student(name, House.findByName(houseID), age);
        listOfStudents.add(student);

        backOrExit();
    }

    public void backOrExit() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("Back to Student Menu");
        menuOptions.add("Exit");

        int choice = menu.promptMenuChoice("Enter a number:", menuOptions, true);
        switch (choice) {
            case 1:
                showMenu();
                break;
            case 0:
                saveStudents();
                return;
        }

    }
}


