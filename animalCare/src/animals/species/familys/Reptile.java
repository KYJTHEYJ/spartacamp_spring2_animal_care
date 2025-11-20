package animals.species.familys;

import zoo.Food;
import zoo.ZooSpecies;
import zoo.Zookeeper;

public class Reptile extends Animal {
    protected Reptile(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat(Food food) {}

    @Override
    public void play(Zookeeper zookeeper) {}

    @Override
    public void showStatus() {}

    @Override
    public ZooSpecies getSpecies() {
        return null;
    }
}
