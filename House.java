package JavaPVT.HW_17_1;

public class House {
    public int numberHouse;
    private int countApartment;
    private int countPeople;
    private String nameHouse;

    public House(int numberHouse, int countApartment, int countPeople, String nameHouse) {
        this.numberHouse = numberHouse;
        this.countApartment = countApartment;
        this.countPeople = countPeople;
        this.nameHouse = nameHouse;
    }

    @Override
    public String toString() {
        return "House{" +
                "numberHouse=" + numberHouse +
                ", countApartment=" + countApartment +
                ", countPeople=" + countPeople +
                ", nameHouse='" + nameHouse + '\'' +
                '}';
    }

    public String getNameHouse() {
        return nameHouse;
    }

    private void addCountPeopleOnce() {
        countPeople++;
    }

    private void setHouse(int countApartment, int countPeople) {
        this.countApartment = countApartment;
        this.countPeople = countPeople;
    }

}
