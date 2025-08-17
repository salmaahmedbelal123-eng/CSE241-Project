package models.users;

public class Instructor extends User {
    
    private String specialization;


    public Instructor(String username, String password, String dateOfBirth, String specialization) {
        super(username, password, dateOfBirth);
        this.specialization = specialization;
    }

    // Getters and Setters
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}