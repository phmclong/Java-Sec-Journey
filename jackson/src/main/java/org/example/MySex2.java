package org.example;

public class MySex2 implements Sex {
    int sex;

    public MySex2() {
        System.out.println("Constructor của MySex");
    }

    @Override
    public int getSex() {
        System.out.println("MySex.getSex");
        return sex;
    }

    @Override
    public void setSex(int sex) {
        System.out.println("MySex.setSex");
        this.sex = sex;
    }
}
