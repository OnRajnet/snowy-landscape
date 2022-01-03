package cz.uhk.rajneon1.model.landscape_components;

import cz.uhk.rajneon1.model.Point;
import cz.uhk.rajneon1.model.Surface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intel on 22.04.2018.
 */
public class House implements LandscapeComponent {

    private List<Surface> surfaces = new ArrayList<>();

    public House() {
        createWalls();
        createRoof();
    }

    private void createWalls() {
        surfaces.add(new Surface(
                new Point(-200, -200, 50),
                new Point(-200, -150, 50),
                new Point(-200, -200, 0),
                new Point(-200, -150, 0),
                0.352f, 0.098f, 0.027f
        ));
        surfaces.add(new Surface(
                new Point(-200, -200, 50),
                new Point(-100, -200, 50),
                new Point(-200, -200, 0),
                new Point(-100, -200, 0),
                0.352f, 0.098f, 0.027f
        ));
        surfaces.add(new Surface(
                new Point(-200, -150, 50),
                new Point(-100, -150, 50),
                new Point(-200, -150, 0),
                new Point(-100, -150, 0),
                0.352f, 0.098f, 0.027f
        ));
        surfaces.add(new Surface(
                new Point(-100, -200, 50),
                new Point(-100, -150, 50),
                new Point(-100, -200, 0),
                new Point(-100, -150, 0),
                0.352f, 0.098f, 0.027f
        ));
    }

    private void createRoof() {
        surfaces.add(new Surface(
                new Point(-200, -200, 50),
                new Point(-200, -150, 50),
                new Point(-150, -175, 80),
                new Point(-150, -175, 80),
                1f,0 , 0
        ));
        surfaces.add(new Surface(
                new Point(-200, -200, 50),
                new Point(-100, -200, 50),
                new Point(-150, -175, 80),
                new Point(-150, -175, 80),
                1f,0 , 0
        ));
        surfaces.add(new Surface(
                new Point(-200, -150, 50),
                new Point(-100, -150, 50),
                new Point(-150, -175, 80),
                new Point(-150, -175, 80),
                1f,0 , 0
        ));
        surfaces.add(new Surface(
                new Point(-100, -200, 50),
                new Point(-100, -150, 50),
                new Point(-150, -175, 80),
                new Point(-150, -175, 80),
                1f,0 , 0
        ));
    }


    @Override
    public List<Surface> getSurfaces() {
        return surfaces;
    }
}
