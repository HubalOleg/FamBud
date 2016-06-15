package oleg.hubal.com.fambud.models;

/**
 * Created by User on 13.06.2016.
 */
public class Procedure {

    private String name, age, date;
    private int value;
    private boolean isIncome;

    public Procedure(String name, String age, String date, int value, boolean isIncome) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.value = value;
        this.isIncome = isIncome;
    }

    public void setIsIncome(boolean b) {
        isIncome = b;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDate() {
        return date;
    }

}
