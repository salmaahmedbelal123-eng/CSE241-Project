package models.users;

import java.time.LocalDate;

public abstract class User {

    private String username;
    private String password;
    private LocalDate dateOfBirth;

    public User(String username, String password, String dateOfBirth) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = LocalDate.parse(dateOfBirth); // Format: YYYY-MM-DD
    }


    // Getters & Setters
    public String getUsername() {return username;}
    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        this.username = username;
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        this.password = password;
    }

    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = LocalDate.parse(dateOfBirth);}


    // Common method for all users
    public boolean checkUsername(String username) {
        return this.username.equals(username);
    }
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return String.format("Username: %s, Date of Birth: %s", username, dateOfBirth);
    }
}

