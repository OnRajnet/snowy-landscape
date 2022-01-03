package cz.uhk.rajneon1.model.landscape_components;

import cz.uhk.rajneon1.model.Point;
import cz.uhk.rajneon1.model.Surface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intel on 16.04.2018.
 */
public class Ground implements LandscapeComponent {

    private List<Surface> surfaces = new ArrayList<>();

    public Ground(float minX, float minY, float maxX, float maxY) {
        surfaces.add(new Surface(
                new Point(minX, minY, 0),
                new Point(minX, maxY, 0),
                new Point(maxX, minY, 0),
                new Point(maxX, maxY, 0),
                0.086f, 0.352f, 0.027f
        ));
    }

    @Override
    public List<Surface> getSurfaces() {
        return surfaces;
    }
}
