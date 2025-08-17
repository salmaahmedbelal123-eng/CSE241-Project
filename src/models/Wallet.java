package models;

public class Wallet {
    private double balance;

    Wallet(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount <= 0) {
            System.out.println("please enter a real amount");
        }
        else{
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getbalance(){
        return balance;
    }
    
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Wallet balance: %.2f", balance);
    }
}
