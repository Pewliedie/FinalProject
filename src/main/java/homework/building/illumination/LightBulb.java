package homework.building.illumination;

public class LightBulb {
    private int lx;

    public LightBulb(int lx) {
        this.lx = lx;
    }

    public int getLx() {
        return lx;
    }

    @Override
    public String toString() {
        return "Bulb: " + lx + "lx";
    }
}

