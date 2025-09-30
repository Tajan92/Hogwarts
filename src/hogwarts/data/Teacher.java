package hogwarts.data;

public class Teacher {
    private String name;
    private House house;

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
