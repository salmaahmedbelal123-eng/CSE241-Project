///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */

package LMS;

import java.util.ArrayList;
import java.util.List;

public class Course implements CrudOperations<Course>, displayInfo {
    private CategoryType type;
    private double price;
    protected String id;
    protected String name;

    
    private static List<Course> courses = new ArrayList<>();

    public Course() {}

    public Course(String id, String name, CategoryType type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

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
        courses.add(item);
        System.out.println("Course added successfully!");
    }

    @Override
    public Course getById(int id) {
        // البحث بالـ index وليس بالـ String ID
        if (id >= 0 && id < courses.size()) {
            return courses.get(id);
        }
        System.out.println("Course not found!");
        return null;
    }

    public Course getByStringId(String courseId) {
        for (Course c : courses) {
            if (c.id.equals(courseId)) {
                return c;
            }
        }
        System.out.println("Course not found!");
        return null;
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public void update(Course item) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).id.equals(item.id)) {
                courses.set(i, item);
                System.out.println("Course updated successfully!");
                return;
            }
        }
        System.out.println("Course not found for update!");
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < courses.size()) {
            courses.remove(index);
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Invalid course index!");
        }
    }

    public void deleteByStringId(String courseId) {
        courses.removeIf(c -> c.id.equals(courseId));
        System.out.println("Course deleted if existed!");
    }
}
