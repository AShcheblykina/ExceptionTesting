public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.manufacturer = vendor;
    }

    public String getVendor() {
        return manufacturer;
    }
}
