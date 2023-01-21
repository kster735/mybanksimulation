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
public abstract class CreditAccount extends Account {
    private int interestPeriod; // in months
    
    public CreditAccount(Client owner) {
        setAccountNumber("" + SimpleCreditAccount.nextAccountNumber++);
        this.owners = new ArrayList<Client>();
        this.addOwner(owner);
        owner.accounts.add(this);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws WithdrawException {
        if (amount > balance)
            throw new WithdrawException();
        else
            balance -= amount;
    }

    @Override
    public void connectAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mustPayInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void payInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws CloseAccountException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
