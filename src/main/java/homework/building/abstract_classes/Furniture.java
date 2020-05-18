package homework.building.abstract_classes;

public abstract class Furniture {
    private String nameOfFurniture;
    private int areaOfFurniture;

    public Furniture(String nameOfFurniture, int areaOfFurniture) {
        this.nameOfFurniture = nameOfFurniture;
        this.areaOfFurniture = areaOfFurniture;
    }

    public int getAreaOfFurniture() {
        return areaOfFurniture;
    }

    public String getNameOfFurniture() {
        return nameOfFurniture;
    }

    public void setNameOfFurniture(String nameOfFurniture) {
        this.nameOfFurniture = nameOfFurniture;
    }

    @Override
    public String toString() {
        return nameOfFurniture +
                ": area of furniture: " + areaOfFurniture +
                "m^2";
    }
}

