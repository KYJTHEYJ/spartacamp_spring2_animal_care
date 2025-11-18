public class Animal implements Zoo {
    private final String name;
    private final int age;
    private int hungry;
    private int happy;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.hungry = 50;
        this.happy = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHungry() {
        return hungry;
    }

    public int getHappy() {
        return happy;
    }

    public void cry() {
    }

    public void play() {
    }

    public void eat() {
    }

    protected void changeHappy(int happy) {
        this.happy += happy;
        if (this.happy < 0) this.happy = 0;
        if (this.happy > 100) this.happy = 100;
    }

    protected void changeHungry(int hungry) {
        this.hungry += hungry;
        if (this.hungry < 0) this.hungry = 0;
        if (this.hungry > 100) this.hungry = 100;
    }
}
