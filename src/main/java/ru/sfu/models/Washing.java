package ru.sfu.models;


/**
 * Класс стиральной машины
 * Поля:
 * id (int): идентификатор стиральной машины.
 * weight (int): вес стиральной машины.
 * clothingCapacity (int): вместимость вещей в стиральной машине.
 * manufacturingCompany (String): компания-производитель.
 * model (String): модель стиральной машины.
 * ProducingCountry (String): страна-производитель.
 */
public class Washing {
    private int id;
    private int weight;
    private int clothingCapacity;

    private String manufacturingCompany;
    private String model;
    private String ProducingCountry;

    /**
     * Конструктор со всеми параметрами.
     */
    public Washing(int id, int weight, int clothingCapacity, String manufacturingCompany, String model, String producingCountry) {
        this.id = id;
        this.weight = weight;
        this.clothingCapacity = clothingCapacity;
        this.manufacturingCompany = manufacturingCompany;
        this.model = model;
        this.ProducingCountry = producingCountry;
    }

    /**
     * Конструктор по умолчанию.
     */
    public Washing() {

    }

    /**
     * Метод получения айди стиральной машины.
     * return: id (int).
     */
    public int getId() {
        return id;
    }

    /**
     * Метод присваивания id стиральной машины.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод получения веса стиральной машины.
     * return: weight (int).
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Метод присваивания веса стиральной машины.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Метод получения вместимости вещей в стиральной машины.
     * return: clothingCapacity (int).
     */
    public int getClothingCapacity() {
        return clothingCapacity;
    }

    /**
     * Метод присваивания вместимости одежды в стиральной машины.
     */
    public void setClothingCapacity(int clothingCapacity) {
        this.clothingCapacity = clothingCapacity;
    }

    /**
     * Метод получения компании-производителя стиральной машины.
     * return: manufacturingCompany (String).
     */
    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    /**
     * Метод присваивания компании-производителя стиральной машины.
     */
    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    /**
     * Метод получения модели стиральной машины.
     * return: model (String).
     */
    public String getModel() {
        return model;
    }

    /**
     * Метод присваивания модели стиральной машины.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Метод получения страны-производителя стиральной машины.
     * return: ProducingCountry (String).
     */
    public String getProducingCountry() {
        return ProducingCountry;
    }

    /**
     * Метод присваивания страны-производителя стиральной машины.
     */
    public void setProducingCountry(String producingCountry) {
        ProducingCountry = producingCountry;
    }

    @Override
    public String toString() {
        return "WashingMachine{" +
                "id=" + id +
                ", weight=" + weight +
                ", clothingCapacity=" + clothingCapacity +
                ", manufacturingCompany='" + manufacturingCompany + '\'' +
                ", model='" + model + '\'' +
                ", ProducingCountry='" + ProducingCountry + '\'' +
                '}';
    }
}
