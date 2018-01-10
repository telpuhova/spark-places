package models;


import java.util.ArrayList;

public class Place {
    private String name;
    private String date;
//    private int id;
    private static ArrayList<Place> instances = new ArrayList<Place>();

    public Place(String name) {
        this.name = name;
        instances.add(this);
//        this.id = instances.size();
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ArrayList<Place> getAll() {
        return instances;
    }

    public static void clearAll() {
        instances.clear();
    }
}
