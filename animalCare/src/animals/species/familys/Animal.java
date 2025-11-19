package animals.species.familys;

import zoo.ZooSpecies;

public abstract class Animal {
    protected final String name;
    protected final int age;
    protected int happy = 50;
    protected int hungry = 0;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void changeHappy(int happy) {
        this.happy += happy;
        if (this.happy < 0) this.happy = 0;
        if (this.happy > 100) this.happy = 100;
    }

    public void changeHungry(int hungry) {
        this.hungry += hungry;
        if (this.hungry < 0) this.hungry = 0;
        if (this.hungry > 100) this.hungry = 100;
    }

    public abstract void eat(String food);
    public abstract void play();
    public abstract void showStatus();
    public abstract ZooSpecies getSpecies();
}
