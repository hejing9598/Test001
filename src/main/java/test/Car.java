package test;

import lombok.Data;

/**
 * Created by Qing on 2019/8/20.
 */
@Data
public class Car {

    private String name;
    private int money;
    private String color;

    public Car() {
        super();
    }

    public Car(String name, int money, String color) {
        this.name = name;
        this.money = money;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", color='" + color + '\'' +
                '}';
    }
}
