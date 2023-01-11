/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banksimulation;

import java.util.ArrayList;

/**
 *
 * @author stery
 */
public class SimpleCreditAccount extends CreditAccount {
    private double maxWithdrawal;
    
    public SimpleCreditAccount(Client owner) {
        setMaxWithdrawal(1000.0);
        setRate(1);
        setAccountNumber("" + SimpleCreditAccount.nextAccountNumber++);
        this.owners = new ArrayList<Client>();
        this.addOwner(owner);
        owner.accounts.add(this);
    }

    public double getMaxWithdrawal() {
        return maxWithdrawal;
    }

    public void setMaxWithdrawal(double maxWithdrawal) {
        this.maxWithdrawal = maxWithdrawal;
    }
    
    
  
    @Override
    public void addOwner(Client owner) {
        if (Integer.parseInt(owner.getId()) <= Client.nextId && Integer.parseInt(owner.getId()) >=0 )
            this.owners.add(owner);
    }

    @Override
    public void deposit() {
        
    }

    @Override
    public void withdraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void connectAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mustPayInterest() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void payInterest() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "SimpleCreditAccount{ " + this.getAccountNumber() + '}';
    }
    
    
    
}
