package cz.uhk.rajneon1.model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Intel on 16.04.2018.
 */
public class Snowflake {

    private Point point;

    public Snowflake(float minX, float minY, float maxX, float maxY) {
        point = new Point(
                (float) ThreadLocalRandom.current().nextDouble(minX, maxX),
                (float) ThreadLocalRandom.current().nextDouble(minY, maxY),
                500
        );
    }

    public void fall() {
        point.setZ(point.getZ() - 1);
    }

    public float getX() {
        return point.getX();
    }

    public float getY() {
        return point.getY();
    }

    public float getZ() {
        return point.getZ();
    }
}
