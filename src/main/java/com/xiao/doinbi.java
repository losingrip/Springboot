package com.xiao;

public class doinbi {
    private String name;
    private String pwd;
    private String number;
    private boolean sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "doinbi{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", number='" + number + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    protected void printsomething(){
        System.out.println("我是你爸爸");
    }
}
