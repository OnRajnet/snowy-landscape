package cz.uhk.rajneon1.model.landscape;

import cz.uhk.rajneon1.model.Snowflake;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intel on 16.04.2018.
 */
public class Snowstorm {

    private List<Snowflake> snowflakes = new ArrayList<>();
    private float minX, minY, maxX, maxY;

    public Snowstorm(float w, float h) {
        minX = - w /2;
        minY = - h / 2;
        maxX = w / 2;
        maxY = h / 2;

    }

    public void generateNewSnowflake() {
        snowflakes.add(new Snowflake(minX, minY, maxX, maxY));
    }

    public List<Snowflake> getSnowflakes() {
        return snowflakes;
    }
}
