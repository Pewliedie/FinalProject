package HomeWorkBuilding;

public class Furniture {
    private String nameOfFurniture;
    private int areaOfFurniture;

    public Furniture(String nameOfFurniture, int areaOfFurniture) {
        this.nameOfFurniture = nameOfFurniture;
        this.areaOfFurniture = areaOfFurniture;
    }

    public int getAreaOfFurniture() {
        return areaOfFurniture;
    }

    @Override
    public String toString() {
        return nameOfFurniture +
                ": area of furniture: " + areaOfFurniture +
                "m^2";
    }
}

interface Interior {
    void addInterior(Furniture furniture);
}

