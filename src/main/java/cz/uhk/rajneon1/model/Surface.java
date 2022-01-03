package cz.uhk.rajneon1.model;

/**
 * Created by Intel on 16.04.2018.
 */
public class Surface {

    private Point first, second, third, forth;
    private float minX, minY, minZ, maxX, maxY, maxZ, r, g, b;

    // first point -> left down
    // second point -> left up
    // third point -> right down
    // forth point -> right up

    public Surface(Point first, Point second, Point third, Point forth, float r, float g, float b) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.forth = forth;

        this.r = r;
        this.g = g;
        this.b = b;

        minX = getMinX();
        minY = getMinY();
        minZ = getMinZ();
        maxX = getMaxX();
        maxY = getMaxY();
        maxZ = getMaxZ();
    }

    public boolean isColliding(Snowflake snowflake) {
        return (snowflake.getX() >= minX && snowflake.getX() <= maxX) &&
                (snowflake.getY() >= minY && snowflake.getY() <= maxY) &&
                (snowflake.getZ() >= minZ && snowflake.getZ() <= maxZ);
    }
    
    private float getMinX() {
        return Math.min(first.getX(), Math.min(second.getX(), Math.min(third.getX(), forth.getX())));
    }

    private float getMinY() {
        return Math.min(first.getY(), Math.min(second.getY(), Math.min(third.getY(), forth.getY())));
    }

    private float getMinZ() {
        return Math.min(first.getZ(), Math.min(second.getZ(), Math.min(third.getZ(), forth.getZ())));
    }

    private float getMaxX() {
        return Math.max(first.getX(), Math.max(second.getX(), Math.max(third.getX(), forth.getX())));
    }

    private float getMaxY() {
        return Math.max(first.getY(), Math.max(second.getY(), Math.max(third.getY(), forth.getY())));
    }

    private float getMaxZ() {
        return Math.max(first.getZ(), Math.max(second.getZ(), Math.max(third.getZ(), forth.getZ())));
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    public Point getThird() {
        return third;
    }

    public Point getForth() {
        return forth;
    }

    public float getR() {
        return r;
    }

    public float getG() {
        return g;
    }

    public float getB() {
        return b;
    }
}
