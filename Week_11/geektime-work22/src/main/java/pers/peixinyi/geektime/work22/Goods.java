package pers.peixinyi.geektime.work22;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-04-02 16:14
 */

public class Goods {
    private int id;
    private int inventory;

    public Goods(int id, int inventory) {
        this.id = id;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", inventory=" + inventory +
                '}';
    }
}
