package homework.building.abstract_classes;

import homework.building.illumination.LightBulb;
import homework.building.interfaces.Interior;
import homework.building.interfaces.Lighting;
import homework.building.exceptions.IlluminanceTooMuchException;
import homework.building.exceptions.SpaceUsageTooMuchException;

import java.util.ArrayList;

public abstract class Room implements Lighting, Interior {
    protected ArrayList<Furniture> furniture = new ArrayList<Furniture>();
    protected ArrayList<LightBulb> lightBulbs = new ArrayList<LightBulb>();

    private String roomName;
    private double area;
    private int windows;
    private int sumOfLux;
    private double sumOfAreaFurniture;
    private final double AREA_PERCENTAGE;

    public Room(String roomName, int area, int windows) {
        this.roomName = roomName;
        this.area = area;
        this.windows = windows;
        this.sumOfLux = windows * 700;
        AREA_PERCENTAGE = area * 0.7;
    }

    public void addLightBulb(LightBulb lightBulb) {
        if (sumOfLux + lightBulb.getLx() > 4000) {
            throw new IlluminanceTooMuchException(" Room:" + getRoomName() +
                    " lk cannot be greater than 4000 lx, current lx:" + sumOfLux);
        }
        this.lightBulbs.add(lightBulb);
        sumOfLux += lightBulb.getLx();
    }


    public void addInterior(Furniture furniture) {
        if (sumOfAreaFurniture + furniture.getAreaOfFurniture() > AREA_PERCENTAGE) {
            throw new SpaceUsageTooMuchException(
                    " Room:" + getRoomName() +
                            " area of all furniture cannot exceed 70% of the room area, current available space "
                            + ((AREA_PERCENTAGE) - sumOfAreaFurniture) + " m^2");
        }
        this.furniture.add(furniture);
        sumOfAreaFurniture += furniture.getAreaOfFurniture();
    }

    //calculate the percentage of free space
    double calculatePercentOfFreeSpace() {
        return ((AREA_PERCENTAGE - sumOfAreaFurniture) / AREA_PERCENTAGE) * 100;
    }

    public String getRoomName() {
        return roomName;
    }

    public double getArea() {
        return area;
    }

    public int getWindows() {
        return windows;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return String.format(" Room: %s%n" +
                        "Illumination: %dlx, Windows: %d, LightBulbs: %s%n" +
                        "Area: %.1f m^2%n" +
                        "Furniture: %s, free: %.1f %%", roomName, sumOfLux, windows, lightBulbs.isEmpty() ? "no Light bulbs" : lightBulbs,
                area, furniture.isEmpty() ? "no furniture" : furniture, calculatePercentOfFreeSpace());
    }
}
