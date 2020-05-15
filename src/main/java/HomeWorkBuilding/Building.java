package HomeWorkBuilding;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Building {
    private String buildingName;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    Logger logger = LogManager.getLogger();

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
}


