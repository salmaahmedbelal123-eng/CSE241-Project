package models;

import java.util.ArrayList;
import java.util.List;

import interfaces.CrudOperations;
import interfaces.displayable;

import data.Database;

public class Course implements CrudOperations<Course>, displayable {
    private CategoryType type;
    private double price;
    protected String id;
    protected String name;
    // private static List<Course> courses = new ArrayList<>();

    public Course() {}

    public Course(String id, String name, CategoryType type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Getters & Setters
    public CategoryType getType() {return type;}
    public void setType(CategoryType type) {this.type = type;}
    
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    @Override
    public void displayInfo() {
        System.out.println("Course ID: " + id);
        System.out.println("Course Name: " + name);
        System.out.println("Category: " + type);
        System.out.println("Price: $" + price);
        System.out.println("----------------------------");
    }

    @Override
    public void add(Course item) {
        Database.courses.add(item);
        System.out.println("Course added successfully!");
    }

    @Override
    public Course getById(int id) {
        // البحث بالـ index وليس بالـ String ID
        if (id >= 0 && id < Database.courses.size()) {
            return Database.courses.get(id);
        }
        System.out.println("Course not found!");
        return null;
    }

    public Course getByStringId(String courseId) {
        for (Course c : Database.courses) {
            if (c.id.equals(courseId)) {
                return c;
            }
        }
        System.out.println("Course not found!");
        return null;
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<>(Database.courses);
    }

    @Override
    public void update(Course item) {
        for (int i = 0; i < Database.courses.size(); i++) {
            if (Database.courses.get(i).id.equals(item.id)) {
                Database.courses.set(i, item);
                System.out.println("Course updated successfully!");
                return;
            }
        }
        System.out.println("Course not found for update!");
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < Database.courses.size()) {
            Database.courses.remove(index);
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Invalid course index!");
        }
    }

    public void deleteByStringId(String courseId) {
        Database.courses.removeIf(c -> c.id.equals(courseId));
        System.out.println("Course deleted if existed!");
    }
}
