/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package LMS;

import java.time.LocalDate;

public class Assignment {
    private String id;
    private String title;
    private AssignmentType type;
    private LocalDate dueDate;

    public Assignment(String id, String title, AssignmentType type, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.dueDate = dueDate;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public AssignmentType getType() { return type; }
    public void setType(AssignmentType type) { this.type = type; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    // Display info
    public void displayInfo() {
        System.out.println("Assignment ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Type: " + type);
        System.out.println("Due Date: " + dueDate);
    }
}

    

