package animals.species.familys;

import zoo.ZooSpecies;

public class Dog extends Animal {
    protected Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat(String food) {}

    @Override
    public void play() {}

    @Override
    public void showStatus() {}

    @Override
    public ZooSpecies getSpecies() {
        return null;
    }
}
