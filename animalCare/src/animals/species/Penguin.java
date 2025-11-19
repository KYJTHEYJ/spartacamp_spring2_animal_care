package animals.species;

import abilitys.Swimmable;
import animals.species.familys.Bird;
import zoo.ZooSpecies;

public class Penguin extends Bird implements Swimmable {
    private final String favoriteFood = "fish";

    public Penguin(String name, int age) {
        super(name, age);
    }

    public int getHappy() {
        return happy;
    }

    public int getHungry() {
        return hungry;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    @Override
    public ZooSpecies getSpecies() {
        return ZooSpecies.PENGUIN;
    }

    @Override
    public void swim() {
        System.out.println("펭귄이 잠수하고 수영을 해요!");
    }

    @Override
    public void eat(String food) {
        int hungry = -10;

        if (this.hungry == 0) {
            System.out.printf("%s 는 배고프지 않아요!\n", name);
            return;
        }

        changeHungry(hungry);

        if (favoriteFood.equals(food)) {
            System.out.printf("%s 가 좋아하는 먹이를 먹고 좋아해요!\n", name);
        }

        System.out.printf("""
                        %s 가 먹이를 다 먹었어요!
                        배고픔이 %d 줄었어요!
                        현재 배고픔 수치 : %d
                        """
                , name
                , hungry * -1
                , this.hungry
        );
    }

    @Override
    public void play() {
        int happy = 10;

        if (this.hungry >= 100) {
            System.out.printf("%s 는 배가 고파 놀 수 없어요!\n", name);
        }

        changeHappy(happy);
        changeHungry(happy);

        System.out.printf("""
                        %s 랑 놀았어요!
                        행복도가 %d 늘었어요!
                        배고픔이 %d 늘었어요!
                        현재 행복도 : %d
                        현재 배고픔 : %d
                        """
                , name
                , happy
                , happy
                , this.happy
                , this.hungry
        );
    }

    @Override
    public void showStatus() {
        System.out.printf("""
                        %s 의 상태에요!
                        나이 : %d
                        현재 행복도 : %d
                        현재 배고픔 : %d
                        """
                , name
                , age
                , happy
                , hungry
        );
    }
}
