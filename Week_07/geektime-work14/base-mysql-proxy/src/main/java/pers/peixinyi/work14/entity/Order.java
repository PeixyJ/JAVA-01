package pers.peixinyi.work14.entity;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-05 14:37
 */
public class Order {
    private String id;
    private int userId;

    public Order() {
    }

    public Order(String id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                '}';
    }
}
