package javaoopexe.shoppingspree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product){

        this.setMoney(getMoney() - product.getCost());
        this.products.add(product);

    }

    public  boolean canBeBought(Product product){
        if (getMoney() - product.getCost() >= 0){
            return true;
        }
        return false;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        List<String> names = new LinkedList<>();
        for (Product product : this.products) {
            names.add(product.getName());
        }

        if (names.isEmpty()){
            return String.format("%s - Nothing bought",getName());
        }
        return String.format("%s - %s",getName(),String.join(", ",names));
    }
}
