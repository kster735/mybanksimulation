package banksimulation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import xmltools.XMLObjectsParse;

/**
 *
 * @author steryios
 */
public class BankSimulation {

//    public static ArrayList<Client> clients;
//    public static ArrayList<Account> accounts;
    public static Bank bank;
    
    public static int simDay=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bank = new Bank();
        
//        clients = new ArrayList<>();
//        accounts = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            menu();
            run = actionSelect(sc.nextInt());
        }
    }

    public static void menu() {
        System.out.println("****************************************");
        System.out.println("Λειτουργία Τράπεζας -- Ημέρα " + simDay);
        System.out.println("****************************************");
        System.out.println(" 1. Δημιουργία πελάτη"); //
        System.out.println(" 2. Άνοιγμα λογαριασμού"); 
        System.out.println(" 3. Διαχείριση κατόχων λογαριασμού"); 
        System.out.println(" 4. Κατάθεση"); 
        System.out.println(" 5. Ανάληψη"); //
        System.out.println(" 6. Σύνδεση λογαριασμού ταμιευτηρίου σε προθεσμίας");
        System.out.println(" 7. Κλείσιμο λογαριασμού");
        System.out.println(" 8. Προβολή πελατών"); //
        System.out.println(" 9. Προβολή λογαριασμών"); //
        System.out.println("10. Έξοδος"); //
        System.out.println("11. Χειροκίνητη Αύξηση ημερών"); //
        System.out.println("**************************");
        System.out.println(""); 
    }

    public static boolean actionSelect(int choice) {
        boolean run = true;
        switch (choice) {
            case 1:
                // Δημιουργία πελάτη αλλά και λογαριασμού
                actionRegisterNewClient();
                break;
            case 2:
                // Άνοιγμα λογαριασμού
                // Εδώ θα μπορώ να ανοίξω νέο λογαριασμό που θα πρέπει να τον
                // αναθέσω σε έναν υπάρχων πελάτη.
                actionOpenAccount();
                break;
            case 3:
                // Διαχείριση κατόχων λογαριασμού
                // Εδώ δηλαδή θα μπορώ να 
                // 1. Προσθέσω υπάρχων κάτοχο σε υπάρχων λογαριασμό
                // 2. Να αφαιρέσω κάτοχο από λογαριασμό
            case 4:
                // Κατάθεση
                actionDeposit();
                break;
            case 5:
                // Ανάληψη
                actionWithdraw();
                break;
            case 6:
                // Σύνδεση λογαριασμού ταμιευτηρίου σε προθεσμίας
                break;
            case 7:
                break;
            case 8:
                // Προβολή πελατών
                showClients();
                break;
            case 9:
                // Προβολή λογαριασμών
                showAccounts();
                break;
            case 10:
                // Προβολή λογαριασμών
                System.out.println("Έξοδος!");
                run = false;
                break;
            case 11:
                advanceDaysManually();
                break;
            default:
                System.out.println("Not valid input");
        }
        System.out.println("Πατήστε <Enter> για συνέχεια... ");
        new Scanner(System.in).nextLine();
        return run;
    }

    public static void actionRegisterNewClient() {
        System.out.println("Εγγραφή πελάτη.");
        System.out.print("Όνομα: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Client owner = new Client(name);

        
        double amount=0.0;
        boolean amountIsValid = false;
        while (!amountIsValid) {
            System.out.println("Άνοιγμα λογαριασμού για τον πελάτη: " + owner.toString());
            System.out.print("Αρχικό ποσό κατάθεσης: ");
            try {
                amount = Double.parseDouble(sc.nextLine());
                amountIsValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("NumberFormatException: " + ex.getMessage());
            }
        }
        
        Account account = new SimpleCreditAccount(owner);
        account.setBalance(amount);
        Transaction newClientTransaction = new Transaction(simDay, owner, account.getAccountNumber(), amount, "Νέος πελάτης, άνοιγμα λογαριασμού και κατάθεση... ");
        account.transactions.add(newClientTransaction);
        
        
        bank.getClients().add(owner);
        bank.getAccounts().add(account); 

        String transactionFileName = "account_" + account.getAccountNumber() + "_transactions"+ ".xml";
       
        try {
            XMLObjectsParse.writeObjectsToXML(new File(transactionFileName), account.transactions);
        } catch (IOException ex) {
            Logger.getLogger(BankSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }

    public static void showClients() {
        for (Client client : bank.getClients()) {
            System.out.println(client.toString());
        }
    }

    public static void showAccounts() {
        for (Account account : bank.getAccounts()) {
            System.out.println(account.toString());
        }
    }
    
    public static void actionOpenAccount(){
        System.out.println("");
    }

    public static void actionDeposit() {
        Client client = null; 
        Account account = null; 
        Scanner sc = new Scanner(System.in);
        
           
        // Ποιος πελάτης θα κάνει κατάθεση
        System.out.println("---- Κατάθεση ----");
        
        client = findClient();
        
        if ( client == null) {
            System.out.println("Ο καταθέτης δεν είναι πελάτης της τράπεζας");
        }
        
        // Λογαριασμός στον οποίο θα γίνει η κατάθεση
        
        account = findAccount();
        
      
        if (account == null) {
            System.out.println("Ο συγκεκριμένος λογαριασμός δεν υπάρχει");
            return;
        }
        
        
        // Διαδιακασία κατάθεσης
        
        double amount=0.0;
        boolean amountIsValid = false;
        while (!amountIsValid) {
            System.out.print("Ποσό κατάθεσης: ");
            String strAmount = sc.nextLine();
            try {
                amount = Double.parseDouble(strAmount);
                amountIsValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("NumberFormatException: " + ex.getMessage());
            }
        }
        
        try {
            account.deposit(amount);
            Transaction deposit = new Transaction(simDay, client, account.getAccountNumber(), amount, "Κατάθεση... ");
            account.transactions.add(deposit);
        } catch (DepositException ep) {
            System.out.println(ep.getMessage());
        }
        
        
        
        
        String transactionFileName = "account_" + account.getAccountNumber() + "_transactions"+ ".xml";
       
        try {
            XMLObjectsParse.writeObjectsToXML(new File(transactionFileName), account.transactions);
        } catch (IOException ex) {
            Logger.getLogger(BankSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void actionWithdraw() {
        Client client = null; 
        Account account = null; 
        Scanner sc = new Scanner(System.in);
        
           
        // Ποιος πελάτης θα κάνει ανάληψη
        System.out.println("---- Ανάληψη ----");
        
        client = findClient();
        
        if ( client == null) {
            System.out.println("Δεν είστε πελάτης της τράπεζας");
            return;
        }
        
        
        // Λογαριασμός από τον  οποίο θα γίνει η ανάληψη
        
        account = findAccount();
      
        if (account == null) {
            System.out.println("Ο συγκεκριμένος λογαριασμός δεν υπάρχει");
            return;
        }
        
        if (!account.owners.contains(client)) {
            System.out.println("Δεν έχετε δικαίωμα συναλλαγών στο συγκεκριμένο λογαριασμό.");
            return;
        }
        
        // Διαδιακασία κατάθεσης
        
        double amount=0.0;
        boolean amountIsValid = false;
        while (!amountIsValid) {
            System.out.print("Ποσό ανάληψης: ");
            String strAmount = sc.nextLine();
            try {
                amount = Double.parseDouble(strAmount);
                amountIsValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("NumberFormatException: " + ex.getMessage());
            }
        }
        
        try {
            account.withdraw(amount);
            Transaction withdraw = new Transaction(simDay, client, account.getAccountNumber(), amount * (-1.0), "Ανάληψη... ");
            account.transactions.add(withdraw);
        } catch (WithdrawException ep) {
            System.out.println(ep.getMessage());
        }
        
        
        String transactionFileName = "account_" + account.getAccountNumber() + "_transactions"+ ".xml";
       
        try {
            XMLObjectsParse.writeObjectsToXML(new File(transactionFileName), account.transactions);
        } catch (IOException ex) {
            Logger.getLogger(BankSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void advanceDaysManually() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Πόσες μέρες θέλετε να προχωρήσετε την προσομοίωση; ");
        int x = sc.nextInt();
        simDay += x;
        
        checkInterests();
    }
    
    public static void checkInterests() {
        for (Account a: bank.getAccounts()) {
            if (a.mustPayInterest(simDay)) {
                a.payInterest(simDay); 
                System.out.println("Payed Interest!");
            }
        }
    }

    public static Client findClient() {
        Client client = null;
        Scanner sc = new Scanner(System.in);
        System.out.print(" -Ποιος πελάτης κάνει τη συναλλαγή; ");
        String inputClientID = sc.nextLine(); // Ίσως αργότερα χρειαστεί validation
        
        for (Client c: bank.getClients()) {
            if (inputClientID.equals(c.getId())) {
                client = c;
                break;
            }
        }
        
        return client;
    }
    
    public static Account findAccount() {
        Account account = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Δώστε αριθμό λογαριασμού για τη συναλλαγή: ");
        String inputAccountNumber = sc.nextLine();
        
        for (Account a: bank.getAccounts()) {
            if (inputAccountNumber.equals(a.getAccountNumber())) {
                account = a;
                System.out.println(account.accountNumber);
                break;
            }
        }
        
        return account;
    }
}
