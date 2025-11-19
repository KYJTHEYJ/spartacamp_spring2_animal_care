package zoo;

// 동물원에서 관리하는 동물들
public enum ZooSpecies {
    CROCODILE("악어")
    , EAGLE("독수리")
    , ELEPHANT("코끼리")
    , LION("사자")
    , PENGUIN("펭귄")
    , WOLF("늑대");

    final String krName;

    ZooSpecies(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }
}
