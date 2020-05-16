package HomeWorkBuilding;

import HomeWorkBuilding.buildingExceptions.IlluminanceTooMuchException;
import HomeWorkBuilding.buildingExceptions.SpaceUsageTooMuchException;

import java.util.ArrayList;

public class Room implements Lighting, Interior {
    private ArrayList<Furniture> furniture = new ArrayList<Furniture>();
    private ArrayList<LightBulb> lightBulbs = new ArrayList<LightBulb>();

    private String roomName;
    private double area;
    private int windows;
    private int sumOfLux;
    private int sumOfAreaFurniture;

    public Room(String roomName, int area, int windows) {
        this.roomName = roomName;
        this.area = area;
        this.windows = windows;
        this.sumOfLux = windows * 700;
    }

    public void addLightBulb(LightBulb lightBulb) throws IlluminanceTooMuchException {
        if (sumOfLux + lightBulb.getLx() > 4000) {
            throw new IlluminanceTooMuchException(" Room:" + getRoomName() + " lk cannot be greater than 4000 lx, current lx:" + sumOfLux);
        }
        this.lightBulbs.add(lightBulb);
        sumOfLux += lightBulb.getLx();
    }

    public void addInterior(Furniture furniture) {
        if (sumOfAreaFurniture + furniture.getAreaOfFurniture() > area * 0.7) {
            throw new SpaceUsageTooMuchException(
                    "area of all furniture cannot exceed 70% of the room area, current available space "
                            + ((area * 0.7) - sumOfAreaFurniture) + " m^2");
        }
        this.furniture.add(furniture);
        sumOfAreaFurniture += furniture.getAreaOfFurniture();
    }

    public String getRoomName() {
        return roomName;
    }

    double countPercentOfFreeSpace() {
        final double perc_70 = area * 0.7;
        return ((perc_70 - sumOfAreaFurniture) / perc_70) * 100;
    }

    @Override
    public String toString() {
        return String.format("Room: %s%n" +
                        "Illumination: %dlx, Windows: %d, LightBulbs: %s%n" +
                        "Area: %.1f m^2%n" +
                        "Furniture: %s, free: %.1f %%", roomName, sumOfLux, windows, lightBulbs, area,
                furniture.isEmpty() ? "no furniture" : furniture, countPercentOfFreeSpace());
    }
}
