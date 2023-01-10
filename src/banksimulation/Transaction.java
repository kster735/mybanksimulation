package banksimulation;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author stery
 */
class Transaction {
    // Οι συναλλαγές κάθε λογαριασμού θα πρέπει να αποθηκεύονται σε ένα ενιαίο αρχείο (δηλαδή
    // ένα αρχείο ανά λογαριασμό) το όνομα του οποίου θα περιέχει τον αριθμό του λογαριασμού.
    
//    Calendar cal = Calendar.getInstance();
//        Date dd =new Date();
//        dd.setTime(cal.getTimeInMillis());
//        
//        
    private Calendar date;  // Ίσως το κάνω αντικείμενο Date
    private int transactionId;
    private Client  client; // Συναλλαγές που δε γίνονται από τον πελάτη της τράπεζας
                            // μπορούν να αφήνουν αυτό το πεδίο κενό, π.χ. κατάθεση τόκων
                            // από την τράπεζα ή έμβασμα από ιδιώτη που δεν είναι πελάτης της τράπεζας.
    private double amount;
    private String description;
    private int accountNumber;
//    private String typeOfTransaction;  // e.g. open, close, deposit, withdraw, payInterest etc.
//    private String detailsOfTransaction; // I don't know.
    
    public Transaction(String description, Client client) {
        this.setDate(Calendar.getInstance());
        this.setDescription(description);
        this.setClient(client);
        
    }

    /**
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @return the transactionId
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    
    
}
