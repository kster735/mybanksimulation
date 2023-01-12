package banksimulation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author steryios
 */
public class BankSimulation {

    public static ArrayList<Client> clients;
    public static ArrayList<Account> accounts;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clients = new ArrayList<>();
        accounts = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            menu();
            run = action(sc.nextInt());
        }
    }

    public static void menu() {
        System.out.println("**************************");
        System.out.println("Λειτουργία Τράπεζας");
        System.out.println("**************************");
        System.out.println(" 1. Δημιουργία πελάτη");
        System.out.println(" 2. Άνοιγμα λογαριασμού");
        System.out.println(" 3. Διαχείριση κατόχων λογαριασμού");
        System.out.println(" 4. Κατάθεση");
        System.out.println(" 5. Ανάληψη");
        System.out.println(" 6. Σύνδεση λογαριασμού ταμιευτηρίου σε προθεσμίας");
        System.out.println(" 7. Κλείσιμο λογαριασμού");
        System.out.println(" 8. Προβολή πελατών");
        System.out.println(" 9. Προβολή λογαριασμών");
        System.out.println("10. Έξοδος");
        System.out.println("**************************");
        System.out.println("");

//        Calendar c = Calendar.getInstance();
//        
//        System.out.println(c.getTime());
//        
//        c.add(Calendar.DAY_OF_MONTH, 3);
//        
//        System.out.println(c.getTime());
    }

    public static boolean action(int choice) {
        boolean run = true;
        switch (choice) {
            case 1:
                // Δημιουργία πελάτη αλλά και λογαριασμού
                actionRegisterNewClient();
                break;
            case 2:
                // Άνοιγμα λογαριασμού
                
                break;
            case 3:
                // Διαχείριση κατόχων λογαριασμού
            case 4:
                // Κατάθεση
                actionDeposit();
                break;
            case 5:
                // Ανάληψη
                break;
            case 6:
                // Σύνδεση λογαριασμού ταμιευτηρίου σε προθεσμίας
                break;
            case 7:
                break;
            case 8:
                // Προβολή πελατών
                showClients();
                new Scanner(System.in).next();
                break;
            case 9:
                // Προβολή λογαριασμών
                showAccounts();
                break;
            case 10:
                // Προβολή λογαριασμών
                run = false;
                break;
            default:
                System.out.println("Not valid input");
        }
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
        clients.add(owner);
        accounts.add(account);
    }

    public static void showClients() {
        for (Client client : clients) {
            System.out.println(client.toString());
        }
    }

    public static void showAccounts() {
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }
    
    public static void actionDeposit() {
        Client client; //new Client();
        Account account; //new SimpleCreditAccount(client);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("---- Deposit  ----");
        System.out.print("  - Client?  ");
        
        String inputClientID = sc.nextLine();
        ArrayList<String> clientIDs = new ArrayList<>();
        for (Client c : clients) {
            clientIDs.add(c.id);
        }
        
        int index=0;
        if ( (index = clientIDs.indexOf(inputClientID)) != -1)
            return;
       
        client = clients.get(index);
      
         // Εδώ με κάποιο τρόπο πρέπει να ρωτάω σε ποιο λογαριασμό θέλει να κάνει 
         // κατάθεση. Πρώτα ίσως πρέπει να του δείξω όλους τους διαθέσιμους λογαριασμούς
        
//        
//        try {
//            account.deposit(100);
//        } catch (DepositException ep) {
//            System.out.println(ep.getMessage());
//        }
    }

}
