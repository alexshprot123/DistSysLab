package lab.entity;

public class Item {
    private int id;
    private String name;
    private String rare;
    private int cost;
    private int count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
