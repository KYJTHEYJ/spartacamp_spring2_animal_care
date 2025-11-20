package zoo;

import java.util.List;

public class Zookeeper {
    String name;
    List<ZooClass> wellKnownClass;
    List<ZooSpecies> wellKnownSpecies;

    Zookeeper(String name, List<ZooClass> wellKnownClass, List<ZooSpecies> wellKnownSpecies) {
        this.name = name;
        this.wellKnownClass = wellKnownClass;
        this.wellKnownSpecies = wellKnownSpecies;
    }

    public String getName() {
        return name;
    }

    public List<ZooClass> getWellKnownClass() {
        return wellKnownClass;
    }

    public List<ZooSpecies> getWellKnownSpecies() {
        return wellKnownSpecies;
    }
}
