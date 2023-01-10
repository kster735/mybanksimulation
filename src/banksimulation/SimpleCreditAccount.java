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

    public SimpleCreditAccount(Client owner) {
        this.accountNumber = "" + SimpleCreditAccount.nextAccountNumber++;
        this.owners = new ArrayList<Client>();
        this.addOwner(owner);
    }
    
    
    @Override
    public void addOwner(Client owner) {
        if (Integer.parseInt(owner.getId()) <= Client.nextId)
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
    
}
