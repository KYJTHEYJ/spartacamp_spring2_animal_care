package animals.species;

import abilitys.Cryable;
import abilitys.Flyable;
import animals.species.familys.Bird;
import zoo.Food;
import zoo.ZooClass;
import zoo.ZooSpecies;
import zoo.Zookeeper;

import java.util.ArrayList;
import java.util.List;

public class Eagle extends Bird implements Flyable, Cryable {
    private final Food favoriteFood = Food.MEAT;
    private final List<Food> hateFood = new ArrayList<>(List.of(Food.PLANT));

    public Eagle(String name, int age) {
        super(name, age);
    }

    public int getHappy() {
        return happy;
    }

    public int getHungry() {
        return hungry;
    }

    public String getFavoriteFood() {
        return favoriteFood.getKrName();
    }

    @Override
    public ZooSpecies getSpecies() {
        return ZooSpecies.EAGLE;
    }

    @Override
    public void fly() {
        System.out.println("독수리의 빠른 비행을 보여요!");
    }

    @Override
    public void cry() {
        System.out.println("끼악!");
    }

    @Override
    public void eat(Food food) {
        int hungry = -10;

        if (this.hungry == 0) {
            System.out.printf("%s 는 배고프지 않아요!\n", name);
            return;
        }

        if(hateFood.contains(food)) {
            System.out.printf("%s 는 %s 를 먹지 못해요!\n", name, food.getKrName());
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
    public void play(Zookeeper zookeeper) {
        int happy = 10;

        if (this.hungry >= 100) {
            System.out.printf("%s 는 배가 고파 놀 수 없어요!\n", name);
            return;
        }

        if(zookeeper.getWellKnownClass().contains(ZooClass.BIRD)
                || zookeeper.getWellKnownSpecies().contains(ZooSpecies.EAGLE)) {
            happy = happy * 2;
            System.out.printf("%s 님과 함께라 더 즐거워요!\n", zookeeper.getName());
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
