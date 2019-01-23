package general.java.criteriaqueue.test;

import general.java.criteriaqueue.Criteria;

public class Candy implements Criteria {

    private String color;

    public Candy(String color) {
        this.color = color;
    }

    @Override
    public String getCriteria() {
        return color;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "color='" + color + '\'' +
                '}';
    }
}
