/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banksimulation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import xmltools.XMLObjectsParse;

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
    public void connectAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean mustPayInterest(int currentDate) {
        int openingDate = this.transactions.get(0).getDate();
        return ((currentDate - openingDate) >= interestPeriod * 30) ? true : false;
    }

    @Override
    public void payInterest(int currentDate) {
        
        double meanDailyBalanceNominator = 0, meanDailyBalance = 0, runningBalance = transactions.get(0).getAmount();
        
        int period=0;
        
        for (Transaction t : transactions) {
            if (transactions.indexOf(t)!= 0 && t.getAmount() != 0) {
                period = t.getDate() - transactions.get(transactions.indexOf(t)-1).getDate();
                meanDailyBalanceNominator += period * runningBalance;
                runningBalance += t.getAmount();
            }
        }
        
        period = currentDate - transactions.get(transactions.size()-1).getDate();
        meanDailyBalanceNominator += period * runningBalance;
        
        meanDailyBalance = meanDailyBalanceNominator / ( getInterestPeriod() * 30 );
        double interest = meanDailyBalance * getRate() * ( getInterestPeriod() * 30 ) / 360 ; 
        deposit(interest);
        transactions.add(new Transaction(currentDate, null, getAccountNumber(), interest, "Πληρωμή τόκων"));

        String transactionFileName = "account_" + getAccountNumber() + "_transactions" + ".xml";

        try {
            XMLObjectsParse.writeObjectsToXML(new File(transactionFileName), transactions);
        } catch (IOException ex) {
            Logger.getLogger(BankSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void close() throws CloseAccountException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the interestPeriod
     */
    public int getInterestPeriod() {
        return interestPeriod;
    }

    /**
     * @param interestPeriod the interestPeriod to set
     */
    public void setInterestPeriod(int interestPeriod) {
        this.interestPeriod = interestPeriod;
    }

}
