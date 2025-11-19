package zoo;

import animals.species.familys.Animal;

import java.util.List;

public class Zookeeper {
    List<Animal> wellKnownAnimals;

    Zookeeper(List<Animal> wellKnownAnimals) {
        this.wellKnownAnimals = wellKnownAnimals;
    }

    public List<Animal> getWellKnownAnimals() {
        return wellKnownAnimals;
    }
}
