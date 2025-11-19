package zoo;

// 동물원에서 관리하는 동물들의 강
public enum ZooClass {
    BIRD("조류")
    , MAMMAL("포유류");

    final String krName;

    ZooClass(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }
}
