package com.national_naming;

public class Naming {
    private int id;
    private String name;
    private int year;
    private String gender;
    private int count;

    public Naming(int id, String name, int year, String gender, int count) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.count = count;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //For test (toString)

    @Override
    public String toString() {
        return "Naming{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", gender='" + gender + '\'' +
                ", count=" + count +
                '}';
    }
}
