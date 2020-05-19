package homework.building.abstract_classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public abstract class Building {
    private String buildingName;
    protected ArrayList<Room> rooms = new ArrayList<Room>();

    private final Logger logger = LogManager.getLogger();

    public Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomByName(String roomName) {
        for (Room room : rooms) {
            if (room.getRoomName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }

    public void describe() {
        logger.info(this.buildingName + ":");
        for (Room r : rooms) {
            logger.info(r);
        }
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}


