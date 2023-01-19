package banksimulation;

import java.util.ArrayList;

/**
 *
 * @author stery
 */
public class Bank {
    private ArrayList<Client> clients;
    private ArrayList<Account> accounts;

    public Bank() {
        setClients(new ArrayList<Client>());
        setAccounts(new ArrayList<Account>());
    }

    
    
    public Bank(ArrayList<Client> clients, ArrayList<Account> accounts) {
        this.clients = clients;
        this.accounts = accounts;
    }
    
    /**
     * @return the clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return the accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    
    
}
