/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banksimulation;

/**
 *
 * @author stery
 */
public class SimpleCreditAccount extends CreditAccount {

    private double maxWithdrawal;

    public SimpleCreditAccount(Client owner) {
        super(owner);
        setMaxWithdrawal(1000.0);
        setInterestPeriod(6);
        setRate(0.01);
    }

    public double getMaxWithdrawal() {
        return maxWithdrawal;
    }

    public void setMaxWithdrawal(double maxWithdrawal) {
        this.maxWithdrawal = maxWithdrawal;
    }

    @Override
    public void withdraw(double amount) throws WithdrawException {
        if (amount > balance || amount > maxWithdrawal) {
            throw new WithdrawException();
        } else {
            balance -= amount;
        }
    }

    @Override
    public void connectAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
