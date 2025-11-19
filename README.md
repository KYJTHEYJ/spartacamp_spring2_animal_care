<h1>동물 관리 프로그램</h1>

- 기수 : 스프링 2기
- 이름 : 김영재
---

<h2>클래스 관계도 -> 1단계</h2>

```mermaid
classDiagram
direction BT
class Animal {
  + Animal(String, int) 
  - String name
  - int age
  - int happy
  - int hungry
  # changeHappy(int) void
  + getHappy() int
  + getName() String
  # changeHungry(int) void
  + play() void
  + eat() void
  + cry() void
  + showStatus() void
  + getAge() int
  + getHungry() int
}
class Cat {
  + Cat(String, int) 
  + cry() void
  + eat() void
  + showStatus() void
  + play() void
}
class Dog {
  + Dog(String, int) 
  + play() void
  + eat() void
  + showStatus() void
  + cry() void
}
class Zoo {
  + Zoo() 
  ~ HashMap~Integer, String~ animalSpeciesNumList
  ~ List~Integer~ menuNumList
  + inputAnimalSpecies(Scanner) int
  + main(String[]) void
  + inputMenuNumberCheck(Scanner) int
  + showStatus(List~Animal~, Scanner) void
  + inputAnimalAgeCheck(Scanner) int
  + inputAnimalList(String, int, int, List~Animal~) void
  + eat(List~Animal~, Scanner) void
  + listenCry(List~Animal~, Scanner) void
  + showAnimalList(List~Animal~) void
  + animalDuplicateCheck(Animal, List~Animal~) boolean
  + inputAnimalNameCheck(Scanner) String
  + play(List~Animal~, Scanner) void
  + selectListedAnimal(List~Animal~, Scanner) int
}

Cat  -->  Animal 
Dog  -->  Animal 
```
---

<h2>기타</h2>
- 각 레벨 별 README는 내부에 위치
