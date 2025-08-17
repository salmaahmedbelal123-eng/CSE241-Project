package models.users;

public class Admin extends User {

        private String role;
        private int workingHours;

        public Admin(String username, String password, String dateOfBirth, String role, int workingHours) {
                super(username, password, dateOfBirth);
                this.role = role;
                this.workingHours = workingHours;
        }

        // Setters & Getters

        public String getRole() {return role;}
        public void setRole(String role) {this.role = role;}

        public int getWorkingHours() {return workingHours;}
        public void setWorkingHours(int workingHours) {this.workingHours = workingHours;}

}
