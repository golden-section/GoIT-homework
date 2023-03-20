package module10.task3;

public class Word {
    private final String value;
    private final int quantity;

    public Word(String value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public String getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return value + " " + quantity;
    }
}
