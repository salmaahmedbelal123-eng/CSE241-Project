/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

     package LMS;

import java.util.ArrayList;
import java.util.List;

public class AssignmentManager implements CrudOperations<Assignment> {

    private List<Assignment> assignments = new ArrayList<>();

    @Override
    public void add(Assignment item) {
        assignments.add(item);
        System.out.println("Assignment added successfully!");
    }

    @Override
    public Assignment getById(int index) {
        if (index >= 0 && index < assignments.size()) {
            return assignments.get(index);
        }
        System.out.println("Assignment not found!");
        return null;
    }

    @Override
    public List<Assignment> getAll() {
        return assignments;
    }

    @Override
    public void update(Assignment updatedItem) {
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getId().equals(updatedItem.getId())) {
                assignments.set(i, updatedItem);
                System.out.println("Assignment updated successfully!");
                return;
            }
        }
        System.out.println("Assignment not found!");
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < assignments.size()) {
            assignments.remove(index);
            System.out.println("Assignment deleted successfully!");
        } else {
            System.out.println("Assignment not found!");
        }
    }
}


