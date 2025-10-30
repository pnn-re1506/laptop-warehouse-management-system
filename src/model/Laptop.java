package model;

import java.util.Objects;

public class Laptop extends Computer {
    private double screenSize;



    public Laptop(String productId, String productName, int quantity, String cpuName, String ram, String graphicsCard, double importPrice, double exportPrice, String type, String storage, int status, double screenSize) {
        super(productId, productName, quantity, cpuName, ram, graphicsCard, importPrice, exportPrice, type, storage, status);
        this.screenSize = screenSize;
    }


    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(screenSize, laptop.screenSize) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenSize);
    }

    @Override
    public String toString() {
        return "Laptop{" +"screenSize=" + screenSize +
                '}';
    }
}
