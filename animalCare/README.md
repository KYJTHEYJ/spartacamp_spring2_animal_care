반려동물 관리 시스템 -> 1단계
<p>기수 : 스프링 2기</p>
<p>이름 : 김영재</p>

---
1단계 README
---

- 구현점<br>
각 기능별 구현을 위해 먼저 Animal, Dog, Cat, Zoo 클래스, 인터페이스를 선언하였음
  - Animal은 동물의 기본 속성인 이름, 나이, 배고픔, 행복도의 변수를 가지고, Zoo를 구현하도록 구성됨
  - Dog, Cat은 Animal을 상속 받아 동물로써 등록되도록 상위 클래스 생성자를 받게 해두었고 종 별 기능을 수행하도록 구성
  - Zoo는 동물원 관리의 기능인 먹기, 울기, 상태보기 기능을 구현하도록 선언
  - 자세한 구현은 코드를 확인하는 것이 좋음..


- 메뉴 선택 기능<br></br>
<img width="283" height="227" alt="image" src="https://github.com/user-attachments/assets/ed75eec9-f9be-4ce9-b957-d9aa1b108e18" />
  - Main 클래스 실행시 7개의 메뉴 선택 가능 (1~7)

---
- 동물 등록 기능<br></br>
<img width="312" height="392" alt="image" src="https://github.com/user-attachments/assets/dc886946-6ebb-4663-a57a-fa8999cd8538" />
  - 순서에 맞게 이름, 나이를 입력 후 등록할 종의 번호를 입력하면 등록됨
<br></br>

- 등록된 동물 목록 조회 기능<br></br>
<img width="241" height="333" alt="image" src="https://github.com/user-attachments/assets/68f4c000-ec8f-4540-a39d-5fa57a557914" />


- 놀아주기 기능<br></br>
<img width="293" height="432" alt="image" src="https://github.com/user-attachments/assets/811b4a9e-d63b-4307-a1c5-1a932aca03a9" />
  - 안내에 따라 번호를 입력하면 놀아주기 기능 수행<br></br>

- 먹이주기 기능<br></br>
<img width="256" height="383" alt="image" src="https://github.com/user-attachments/assets/b6f4691f-d755-47bc-88c5-19fdb54cb87e" />
  - 안내에 따라 번호를 입력하면 먹이주기 기능 수행<br></br>


- 상태보기 기능<br></br>
<img width="252" height="388" alt="image" src="https://github.com/user-attachments/assets/5cab2875-2302-46ef-bbf3-112111c7bae6" />
  - 안내에 따라 번호를 입력하면 상태보기 기능 수행<br></br>

- 울음소리 듣기 기능<br></br>
<img width="267" height="335" alt="image" src="https://github.com/user-attachments/assets/6b53cc9d-c09c-4962-8068-628037ef775d" />
  - 안내에 따라 번호를 입력하면 울음소리 듣기 기능 수행<br></br>

- 잘못 번호를 입력하거나 올바르지 않은 경우를 입력시 등 오류에 관한 예외처리<br></br>
<img width="277" height="289" alt="image" src="https://github.com/user-attachments/assets/6936a471-73d4-46fe-b799-b4d835cdc8ba" />
<img width="208" height="123" alt="image" src="https://github.com/user-attachments/assets/808525fe-3408-4b07-844b-1e70a08af1c5" />



