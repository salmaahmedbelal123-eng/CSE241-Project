package models;

import java.util.ArrayList;
import java.util.List;

import interfaces.CrudOperations;
import interfaces.displayable;

public class Course implements CrudOperations<Course>, displayable {
    private CategoryType type;
    private double price;
    protected String id;
    protected String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
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
    public Course getById(String id) {
        for(Course course:courses){
        if(course.getId().equals(id)){
            
        }
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
  public void delete(String id) {
    int index = -1; // نبدأ بـ -1 عشان نعرف لو ملقيناش الكورس
    for (int i = 0; i < courses.size(); i++) {
        if (courses.get(i).getId().equals(id)) {
            index = i;
            break; // وقفنا أول ما لقينا الكورس
        }
    }
    if (index != -1) {
        courses.remove(index);
        System.out.println("Course deleted successfully!");
    } else {
        System.out.println("Invalid course id!");
    }
  }
}