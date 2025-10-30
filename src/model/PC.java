package model;

import java.util.Objects;

public class PC extends Computer{
    private String mainBoard;

    public PC(String productId, String productName, int quantity, String cpuName, String ram, String graphicsCard, double importPrice, double exportPrice, String type, String storage, int status, String mainBoard) {
        super(productId, productName, quantity, cpuName, ram, graphicsCard, importPrice, exportPrice, type, storage, status);
        this.mainBoard = mainBoard;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PC pc = (PC) o;
        return Objects.equals(mainBoard, pc.mainBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mainBoard);
    }

    @Override
    public String toString() {
        return "PC{" +
                "mainBoard='" + mainBoard + '\'' +
                '}';
    }
}
