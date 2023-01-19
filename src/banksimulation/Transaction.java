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
    private static int transactionIdCounter=0;

    private int transactionId;
    private int date;  // Ίσως το κάνω αντικείμενο Date
    private Client  client; // Συναλλαγές που δε γίνονται από τον πελάτη της τράπεζας
                            // μπορούν να αφήνουν αυτό το πεδίο κενό, π.χ. κατάθεση τόκων
                            // από την τράπεζα ή έμβασμα από ιδιώτη που δεν είναι πελάτης της τράπεζας.
    private double amount; // ίσως και αυτό κενό αν πρόκειται για άνοιγμα ή κλείσιμο λογαριασμού.
    private String description;
    private String accountNumber;

    public Transaction() {
        this.nextTransactionId();
        client = new Client();
    }

    public Transaction(int date ,Client client, String accountNumber, double amount, String description) {
        this.transactionId = transactionId;
        this.date = date;
        this.client = client;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.description = description;
    }

    public Transaction(int transactionId, int date ,Client client, String accountNumber, double amount, String description) {
        this.transactionId = transactionId;
        this.date = date;
        this.client = client;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.description = description;
    }
    
    
    /**
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(int date) {
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
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void nextTransactionId(){
        setTransactionId(Transaction.transactionIdCounter++);
    }

    @Override
    public String toString() {
        String transactionRecord = "<" + this.transactionId + ">\n";
        transactionRecord += "  <Date>" + this.date + "</Date>\n";       
        transactionRecord += "  <Client>" + this.client + "</Client>\n";
        transactionRecord += "  <AccountNumber>" + this.accountNumber + "</AccountNumber>\n";
        transactionRecord += "  <Amount>" + this.amount + "</Amount>\n";
        transactionRecord += "  <Description>" + this.amount + "</Description>\n";
        transactionRecord += "</" + this.transactionId + ">";
        return transactionRecord;
    }

    
}
