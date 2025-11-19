package zoo;

// 동물원에서 취급하는 먹이들
public enum Food {
    MEAT("육류")
    , FISH("어패류")
    , PLANT("식물류");

    final String krName;

    Food(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }
}
