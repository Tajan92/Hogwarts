package hogwarts.data;

public class Student {
    private String id;
    private String name;
    private House house;
    private int age;

    public Student(String name, House house, int age) {
        this.name = name;
        this.house = house;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
