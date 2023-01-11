/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banksimulation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author stery
 */
public abstract class Account {
    // Για μοναδικό αριθμό ID θα μπορούσα και το εξής:
    //
    // private static ArrayList<Integer> accounNumbers;
    // private int accountNumber; 
    //
    // Και στον constructor να δημιουργώ τυχαίο αριθμό και να ελέγχο αν υπάρχει ή 
    // όχι στη λίστα
    
    protected static int nextAccountNumber;
    
    protected String accountNumber; // μοναδικός αριθμός λογαριασμού
    protected ArrayList<Client> owners;
    protected ArrayList<Transaction> transactions;
    protected double balance;
    protected double rate;
    
    public Account() {
        
    }
    
    // Getters Setters

    public static int getNextAccountNumber() {
        return nextAccountNumber;
    }

    public static void setNextAccountNumber(int nextAccountNumber) {
        Account.nextAccountNumber = nextAccountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    
    
    
    // Behavior methods
    
    public abstract void addOwner(Client owner);
    
    public abstract void deposit() throws DepositException;
    
    public abstract void withdraw() throws WithdrawException;
    
    public abstract void connectAccount();
    
    public abstract void mustPayInterest();
    
    public abstract void payInterest();
    
    public abstract void close() throws CloseAccountException;
}
