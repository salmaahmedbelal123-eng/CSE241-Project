package managers;


import data.Database;
import models.users.Admin;
import models.users.Instructor;
import models.users.Student;
import models.users.User;


public class AuthenticationManager {

    public boolean registerStudent(Student student) {
        if (isUsernameTaken(student.getUsername())) {
            System.out.println("Username already taken.");
            return false;
        }
        Database.students.add(student);
        return true;
    }

    public boolean registerInstructor(Instructor instructor) {
        if (isUsernameTaken(instructor.getUsername())) {
            System.out.println("Username already taken.");
            return false;
        }
        Database.instructors.add(instructor);
        return true;
    }

    public boolean registerAdmin(Admin admin) {
        if (isUsernameTaken(admin.getUsername())) {
            System.out.println("Username already taken.");
            return false;
        }
        Database.admins.add(admin);
        return true;
    }


    
    public static User login(String username, String password) {
        for (Admin admin : Database.admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        for (Instructor instructor : Database.instructors) {
            if (instructor.getUsername().equals(username) && instructor.getPassword().equals(password)) {
                return instructor;
            }
        }
        for (Student student : Database.students) {
            if (student.getUsername().equals(username) && student.getPassword().equals(password)) {
                return student;
            }
        }
        return null; // invalid credentials
    }

    private boolean isUsernameTaken(String username) {
        return Database.admins.stream().anyMatch(u -> u.getUsername().equals(username)) ||
               Database.instructors.stream().anyMatch(u -> u.getUsername().equals(username)) ||
               Database.students.stream().anyMatch(u -> u.getUsername().equals(username));
    }
}

