/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banksimulation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author stery
 */
public class Client {
    protected static int nextId=1;
    
    protected String id;
    protected String name;
    protected ArrayList<Account> accounts;
    
////////////////////////////////////////////////////////
// Στατικές μέθοδοι για τον έλεγχο της κλάσσης Client
    public static void main(String[] args) {
        ArrayList<Client> clients = generateRandomClients(50);
        showClients(clients);
    }

    
    public static ArrayList<Client> generateRandomClients(int n){
        ArrayList<Client> clients = new ArrayList<Client>();
        for (int i = 0; i < n; i++) {
            clients.add(new Client(Client.generateNextId(), Client.randomName( (new Random(Client.generateSeed()).nextInt(6))+5 ) ) );
        }
        return clients;
    }
    
    public static void showClients(ArrayList<Client> clients){
        for (Client client : clients){
            System.out.println(client.toString());
        }
    }
    
    public static String generateNextId(){
        return "" + Client.nextId++; 
    }
    
    public static String randomName(int length){
        String randomName="";
//      int length = rnd.nextInt(6) + 5;
        
        for (int i=0; i<length; i++){
            char randomChar = (char)('α' + new Random().nextInt(26));
            randomName += randomChar;
            if (i==0) {
                randomName.toUpperCase();
            }
        }
        return randomName;
    }
    
    public static long generateSeed(){
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }
 //   Τέλος στατικών μεθόδων
 /////////////////////////////////////////////////////////  
    
 // Constructors
    
    public Client() {
        setId(Client.generateNextId());
        accounts = new ArrayList<Account>();
    }

    public Client(String name){
        setId(Client.generateNextId());
        setName(name);
        accounts = new ArrayList<Account>();
    }
    
    public Client(String id, String name) {
        setId(id);
        setName(name);
        accounts = new ArrayList<Account>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        String clientRecord = "<" + this.getId() + ">\n";
        clientRecord += "   <Name>" + this.getName() + "</Name>\n"; 
        
        for (Account account: this.accounts) {
            clientRecord += "   <Account>" + account.getAccountNumber() + "</Account>\n";
        }
        
        clientRecord += "</" + this.getId() + ">";
        return clientRecord;
    }
    
}
