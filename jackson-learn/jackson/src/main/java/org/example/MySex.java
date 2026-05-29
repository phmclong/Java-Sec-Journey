package org.example;

public class MySex implements Sex {
    int sex;

    @Override
    public int getSex() {
        return sex;
    }

    @Override
    public void setSex(int sex) {
        this.sex = sex;
    }
}