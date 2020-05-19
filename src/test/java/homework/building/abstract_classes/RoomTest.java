package homework.building.abstract_classes;

import homework.building.exceptions.IlluminanceTooMuchException;
import homework.building.exceptions.SpaceUsageTooMuchException;
import homework.building.illumination.LightBulb;
import homework.building.implemintations.Chair;
import homework.building.implemintations.OfficeRoom;
import homework.building.implemintations.Table;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.*;

public class RoomTest {

    private Room room;

    @BeforeClass
    void initRoom(){
        room = new OfficeRoom("TestRoom",50,4);
        room.addInterior(new Table("test table",8));
    }

    @org.testng.annotations.Test(expectedExceptions = IlluminanceTooMuchException.class)
    public void testAddLightBulb() {
        room.addLightBulb(new LightBulb(2000));
    }

    @org.testng.annotations.Test(expectedExceptions = SpaceUsageTooMuchException.class)
    public void testAddInterior() {
        room.addInterior(new Chair("test chair",50));
    }

    @org.testng.annotations.Test
    public void testCalculatePercentOfFreeSpace() {
        double result = Math.round(room.calculatePercentOfFreeSpace());
        assertEquals(result,77);
    }
}