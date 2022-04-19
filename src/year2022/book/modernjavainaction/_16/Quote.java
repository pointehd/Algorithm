package year2022.book.modernjavainaction._16;

public class Quote {
    private final String productName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String productName, double price, Discount.Code code) {
        this.productName = productName;
        this.price = price;
        this.discountCode = code;
    }
    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
