package HomeWorkBuilding;


import HomeWorkBuilding.buildingExceptions.IlluminanceTooMuchException;
import HomeWorkBuilding.buildingExceptions.SpaceUsageTooMuchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "C:\\Users\\Wladyslaw\\IdeaProjects\\FinalProject\\src\\main\\resources\\log4j2.xml");
        Logger logger = LogManager.getLogger();

        Building building1 = new Building("Office building");

        Room room1 = new Room("Office room", 50, 4);
        Room room2 = new Room("Hall", 100, 5);
        Room room3 = new Room("Room#3", 50, 4);

        building1.addRoom(room1);
        building1.addRoom(room2);

        try {
            building1.getRoomByName("Office room").addLightBulb(new LightBulb(400));
            building1.getRoomByName("Office room").addLightBulb(new LightBulb(100));
            building1.getRoomByName("Office room").addInterior(new Furniture("Office Table", 3));
            building1.getRoomByName("Office room").addInterior(new Furniture("Giant Chair", 10));

            building1.getRoomByName("Hall").addLightBulb(new LightBulb(400));
            building1.getRoomByName("Hall").addLightBulb(new LightBulb(100));
            building1.getRoomByName("Hall").addInterior(new Furniture("small Table", 2));
            building1.getRoomByName("Hall").addInterior(new Furniture("small Chair", 5));
        } catch (IlluminanceTooMuchException e) {
            logger.error(e.getMessage());
        }catch (SpaceUsageTooMuchException e){
            logger.error(e.getMessage());
        }

        building1.describe();
    }
}
