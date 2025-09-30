package hogwarts.data;

public class House {
    private String name;

    public House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
