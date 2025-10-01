package hogwarts.data;

public class House {

    public static House Gryffindor = new House("Gryffindor");
    public static House Slytherin = new House("Slytherin");
    public static House Hufflepuff = new House("Hufflepuff");
    public static House Rawenclaw = new House("Rawenclaw");

    public static House findByName(String houseName){
      houseName = houseName.toUpperCase();
      switch(houseName){
            case "SLYTHERIN": return House.Slytherin;
            case "GRYFFINDOR": return House.Gryffindor;
            case "HUFFLEPUFF": return House.Hufflepuff;
            case "RAWENCLAW": return House.Rawenclaw;
            default: return House.Slytherin;
        }
    }
    private String name;

    private House(String name) {
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
