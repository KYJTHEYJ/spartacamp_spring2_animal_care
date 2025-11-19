import abilitys.Cryable;
import animals.species.*;
import animals.species.familys.Animal;
import animals.species.familys.Cat;
import animals.species.familys.Dog;
import zoo.ZooSpecies;

import java.util.*;

// TODO : 종과 하위분류가 추가 되었되면 취급하는 동물과 먹이를 Zoo의 enum 클래스(Food, ZooSpecies) 내부에 추가할 것
public class Zoo {
    //region "공통 변수"
    // 메뉴 선택 리스트
    static List<Integer> menuNumList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    // 동물 종류 선택 리스트
    static HashMap<Integer, String> animalSpeciesNumList = new HashMap<>();
    //endregion

    // region "메뉴 선택"
    // 메뉴 선택 기능
    public static int inputMenuNumberCheck(Scanner sc) {
        int inputMenuNumber;

        while (true) {
            System.out.print("""
                    === 확장된 동물원 관리 시스템 ===
                    1. 동물 등록
                    2. 동물 목록 보기
                    3. 동물과 놀기
                    4. 먹이주기
                    5. 특별 능력 사용
                    6. 동물 상태 확인
                    7. 사육사 관리
                    8. 울음소리 듣기
                    9. 종료
                    """);
            System.out.print("메뉴를 선택하세요 : ");

            try {
                inputMenuNumber = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 메뉴번호를 입력하셔야합니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            if (!menuNumList.contains(inputMenuNumber)) {
                System.out.println("잘못된 메뉴를 선택하셨습니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            sc.nextLine(); // 중간 버퍼 삭제
            return inputMenuNumber;
        }
    }
    // endregion

    // region "동물 입력"
    // 동물 이름 입력 체크
    public static String inputAnimalNameCheck(Scanner sc) {
        String inputAnimalName;

        while (true) {
            System.out.print("동물 이름을 입력하세요 : ");

            try {
                inputAnimalName = sc.nextLine();
            } catch (Exception e) {
                System.out.println("올바른 동물 이름을 입력하셔야합니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            return inputAnimalName;
        }
    }

    // 동물 나이 입력 체크
    public static int inputAnimalAgeCheck(Scanner sc) {
        int inputAnimalAge;

        while (true) {
            System.out.print("동물 나이를 입력하세요 : ");

            try {
                inputAnimalAge = sc.nextInt();
            } catch (Exception e) {
                System.out.println("올바른 동물 나이를 입력하셔야합니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            if (inputAnimalAge <= 0) {
                System.out.println("나이는 1살부터 입력해주세요");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            return inputAnimalAge;
        }
    }

    // 보유가능한 동물 종 입력 및 체크
    public static int inputAnimalSpecies(Scanner sc) {
        animalSpeciesNumList.clear();
        animalSpeciesNumList.put(1, "악어");
        animalSpeciesNumList.put(2, "독수리");
        animalSpeciesNumList.put(3, "코끼리");
        animalSpeciesNumList.put(4, "사자");
        animalSpeciesNumList.put(5, "펭귄");
        animalSpeciesNumList.put(6, "늑대");

        int inputAnimalSpeciesNumber;
        while (true) {
            System.out.println("동물 종류를 선택하세요");
            animalSpeciesNumList.forEach((integer, s)
                    -> System.out.printf("%d. %s\n", integer, s));
            System.out.print("동물 종류 : ");

            try {
                inputAnimalSpeciesNumber = sc.nextInt();
            } catch (Exception e) {
                System.out.println("올바른 동물 종류를 입력하셔야합니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            if (!animalSpeciesNumList.containsKey(inputAnimalSpeciesNumber)) {
                System.out.println("잘못된 동물 종류를 선택하셨습니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            return inputAnimalSpeciesNumber;
        }
    }

    // 등록된 동물과 중복 체크 (이름, 나이, 종 전부 체크)
    public static boolean animalDuplicateCheck(Animal newAnimal, List<Animal> listedAnimalList) {
        for (Animal animal : listedAnimalList) {
            if (animal.getName().equals(newAnimal.getName())
                    && animal.getAge() == newAnimal.getAge()
                    && animal.getSpecies() == newAnimal.getSpecies()) {
                return false;
            }
        }

        return true;
    }

    // 동물 리스트 등록 기능
    public static void inputAnimalList(String animalName, int animalAge, int animalSpecies, List<Animal> listedAnimals) {
        // 동물 등록
        Animal newAnimal = switch (animalSpecies) {
            case 1 -> new Crocodile(animalName, animalAge);
            case 2 -> new Eagle(animalName, animalAge);
            case 3 -> new Elephant(animalName, animalAge);
            case 4 -> new Lion(animalName, animalAge);
            case 5 -> new Penguin(animalName, animalAge);
            case 6 -> new Wolf(animalName, animalAge);
            default -> null;
        };

        // debugging code, 사실상 disable 되어야 함
        if (newAnimal == null) {
            System.out.println("잘못된 동물 종류를 선택하여 등록하셨습니다");
            return;
        }

        if (animalDuplicateCheck(newAnimal, listedAnimals)) {
            listedAnimals.add(newAnimal);
            System.out.printf("%s(%s, %d살) 등록되었습니다\n", animalName, animalSpeciesNumList.get(animalSpecies), animalAge);
        } else {
            System.out.printf("%s 로 등록된 %s가 있습니다\n", animalName, animalSpeciesNumList.get(animalSpecies));
        }
    }
    //endregion

    //region "등록 동물 선택"
    public static Animal selectListedAnimal(List<Animal> listedAnimals, Scanner sc) {
        int selectNumber;

        while (true) {
            int listIndex = 0;
            for (Animal animal : listedAnimals) {
                System.out.println("동물을 번호에 맞게 선택해주세요");
                System.out.printf("""
                                %d. %s (%s, %d살)
                                """
                        , listIndex + 1
                        , animal.getName()
                        , animal.getSpecies().getKrName()
                        , animal.getAge());
                listIndex++;
            }
            System.out.print("선택 : ");

            try {
                selectNumber = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 동물 번호를 입력하셔야합니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            if (selectNumber > listedAnimals.size() || selectNumber == 0 || selectNumber < 0) {
                System.out.println("리스트에 없는 번호입니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            sc.nextLine(); // 중간 버퍼 제거
            break;
        }

        return listedAnimals.get(selectNumber);
    }

    // 울 수 있는 동물들만 보여주기
    public static int selectCryableListedAnimal(List<Animal> listedAnimals, Scanner sc) {
        int selectNumber;
        List<Animal> cryableAnimals = new ArrayList<>();

        while (true) {
            int listIndex = 0;
            for (Animal animal : listedAnimals) {
                if(animal instanceof Cryable) {
                    cryableAnimals.add(animal);
                    System.out.println("동물을 번호에 맞게 선택해주세요");
                    System.out.printf("""
                                    %d. %s (%s, %d살)
                                    """
                            , listIndex + 1
                            , animal.getName()
                            , animal.getSpecies().getKrName()
                            , animal.getAge());
                    listIndex++;
                }
            }
            System.out.print("선택 : ");

            try {
                selectNumber = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 동물 번호를 입력하셔야합니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            if (selectNumber > cryableAnimals.size() || selectNumber == 0 || selectNumber < 0) {
                System.out.println("리스트에 없는 번호입니다");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            sc.nextLine(); // 중간 버퍼 제거
            break;
        }

        return selectNumber;
    }
    //endregion

    //region "동물 울음 듣기"
    public static void listenCry(List<Animal> listedAnimals, Scanner sc) {
        if (listedAnimals.isEmpty()) {
            System.out.println("등록된 동물이 없습니다");
            return;
        }

        System.out.println("울음 소리를 들을 동물을 선택하세요 :");
        Animal selectNumberAnimal = selectListedAnimal(listedAnimals, sc);

        System.out.print(selectNumberAnimal.getName() + " : ");
        selectNumberAnimal.cry();
    }
    //endregion

    //region "놀아주기"
    public static void play(List<Animal> listedAnimals, Scanner sc) {
        if (listedAnimals.isEmpty()) {
            System.out.println("등록된 동물이 없습니다");
            return;
        }

        System.out.println("놀아줄 동물을 선택하세요 :");
        selectListedAnimal(listedAnimals, sc).play();
    }
    //endregion

    //region "먹이주기"
    public static void eat(List<Animal> listedAnimals, Scanner sc) {
        if (listedAnimals.isEmpty()) {
            System.out.println("등록된 동물이 없습니다");
            return;
        }

        System.out.println("먹이를 줄 동물을 선택하세요 :");
        selectListedAnimal(listedAnimals, sc).eat();
    }
    //endregion

    //region "상태 보기"
    public static void showStatus(List<Animal> listedAnimals, Scanner sc) {
        if (listedAnimals.isEmpty()) {
            System.out.println("등록된 동물이 없습니다");
            return;
        }

        System.out.println("상태를 볼 동물을 선택하세요 :");
        selectListedAnimal(listedAnimals, sc).showStatus();
    }
    //endregion

    //region "동물 목록 출력"
    public static void showAnimalList(List<Animal> listedAnimals) {
        if (listedAnimals.isEmpty()) {
            System.out.println("등록된 동물이 없습니다");
            return;
        }

        System.out.println("=== 현재 등록된 동물 목록 ===");
        listedAnimals.forEach(animal ->
                System.out.printf("""
                                이름 : %s 
                                나이 : %d 
                                종류 : %s
                                -----------
                                """,
                        animal.getName(),
                        animal.getAge(),
                        animal.getSpecies().getKrName()
                )
        );
    }
    //endregion

    //region "Main"
    public static void main(String[] args) {
        int selectMenuNumber; // 메뉴 선택 번호
        String animalName; // 등록할 동물 이름
        int animalAge; // 등록할 동물 나이
        int animalSpeciesNumber; // 등록할 동물 종
        List<Animal> inputAnimalList = new ArrayList<>(); // 등록된 동물 리스트

        Scanner sc = new Scanner(System.in);

        while (true) {
            selectMenuNumber = inputMenuNumberCheck(sc);
            switch (selectMenuNumber) {
                // 동물 등록
                case 1 -> {
                    animalName = inputAnimalNameCheck(sc);
                    animalAge = inputAnimalAgeCheck(sc);
                    animalSpeciesNumber = inputAnimalSpecies(sc);
                    inputAnimalList(animalName, animalAge, animalSpeciesNumber, inputAnimalList);
                }

                // 동물 목록 보기
                case 2 -> {
                    showAnimalList(inputAnimalList);
                }

                // 놀아주기
                case 3 -> {
                    play(inputAnimalList, sc);
                }

                // 먹이주기
                case 4 -> {
                    eat(inputAnimalList, sc);
                }

                // 상태 보기
                case 5 -> {
                    showStatus(inputAnimalList, sc);
                }

                // 울음소리 듣기
                case 6 -> {
                    listenCry(inputAnimalList, sc);
                }

                // 종료
                case 7 -> {
                    System.out.println("시스템을 종료합니다");
                    return;
                }
            }
        }
    }
    //endregion
}
