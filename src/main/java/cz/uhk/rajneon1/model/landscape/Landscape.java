package cz.uhk.rajneon1.model.landscape;

import cz.uhk.rajneon1.model.landscape_components.Ground;
import cz.uhk.rajneon1.model.landscape_components.House;
import cz.uhk.rajneon1.model.landscape_components.LandscapeComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intel on 16.04.2018.
 */
public class Landscape {

    private List<LandscapeComponent> components = new ArrayList<>();

    public Landscape(float w, float h) {
        createComponents(w, h);
    }

    private void createComponents(float w, float h) {
        components.add(new Ground(- w / 2, - h / 2, w / 2, h / 2));
        components.add(new House());
    }

    public List<LandscapeComponent> getComponents() {
        return components;
    }

}
