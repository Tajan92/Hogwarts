package hogwarts.data;

public class Teacher {
    String name;
    House house = new House();

    public Teacher(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public House getHouse() {
        return house;
    }
}
