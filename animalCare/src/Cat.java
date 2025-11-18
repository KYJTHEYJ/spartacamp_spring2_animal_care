public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void cry() {
        System.out.println("미야옹!");
    }

    public void eat() {
        int hugry = -20;

        if (getHungry() == 0) {
            System.out.printf("%s 는 배고프지 않아졌어요!\n", getName());
            return;
        }

        changeHungry(hugry);

        System.out.printf("""
                        %s 가 밥을 먹었어요!
                        배고픔이 %d 줄었어요!
                        현재 배고픔 수치 : %d
                        """
                , getName()
                , hugry * -1
                , getHungry());
    }

    @Override
    public void play() {
        int happy = 20;

        if(getHungry() >= 100) {
            System.out.printf("%s 는 배가 고파 놀 수 없어요!\n", getName());
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
                , getName()
                , happy
                , happy
                , getHappy()
                , getHungry()
        );
    }
}
