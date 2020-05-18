package homework.building.main_activity;


import homework.building.abstract_classes.Building;
import homework.building.abstract_classes.Room;
import homework.building.exceptions.IlluminanceTooMuchException;
import homework.building.exceptions.SpaceUsageTooMuchException;
import homework.building.implemintations.*;
import homework.building.illumination.LightBulb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "C:\\Users\\Wladyslaw\\IdeaProjects\\FinalProject\\src\\main\\resources\\log4j2.xml");
        Logger logger = LogManager.getLogger();

        Building building1 = new OfficeBuilding("Office building");

        Room room1 = new OfficeRoom("Office room #1", 50, 4);
        Room room2 = new Hall("Hall #1", 100, 5);

        building1.addRoom(room1);
        building1.addRoom(room2);

        try {
            building1.getRoomByName("Office room #1").addLightBulb(new LightBulb(400));
            building1.getRoomByName("Office room #1").addLightBulb(new LightBulb(100));
            building1.getRoomByName("Office room #1").addInterior(new Table("Office Table", 3));
            building1.getRoomByName("Office room #1").addInterior(new Chair("Office Chair", 5));

            building1.getRoomByName("Hall #1").addLightBulb(new LightBulb(400));
            building1.getRoomByName("Hall #1").addLightBulb(new LightBulb(100));
            building1.getRoomByName("Hall #1").addInterior(new Table("Giant Table", 20));
            building1.getRoomByName("Hall #1").addInterior(new Chair("Long Chair", 10));
        } catch (IlluminanceTooMuchException e) {
            logger.error(building1.getBuildingName() + ":" + e.getMessage());
        } catch (SpaceUsageTooMuchException e) {
            logger.error(building1.getBuildingName() + ":" + e.getMessage());
        } catch (NullPointerException e) {
            logger.error(building1.getBuildingName() + ": There is no such room");
        }

        building1.describe();
    }
}
