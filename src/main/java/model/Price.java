package model;

public class Price {

    private float price;
    private String currency;

    Price(float price, String currency){
        this.price = price;
        this.currency = currency;
    }

    public String getPrice(){
        return currency + " " + price;
    }
    
}
