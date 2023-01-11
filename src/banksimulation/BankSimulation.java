package banksimulation;

import java.util.ArrayList;
import java.util.Calendar;
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
    
    public static boolean action(int choice){
        boolean run = true;
        switch (choice) {
            case 1:
                // Δημιουργία πελάτη αλλά και λογαριασμού
                actionRegisterNewClient();
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
    
    public static void actionRegisterNewClient(){
        System.out.println("Εγγραφή πελάτη.");
        System.out.print("Όνομα: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Client owner = new Client(name);
        
        System.out.println("Άνοιγμα λογαριασμού για τον πελάτη: " +  owner.toString() );
        System.out.print("Αρχικό ποσό κατάθεσης: ");
        double amount = sc.nextDouble();
        
        Account account = new SimpleCreditAccount(owner);
        account.setBalance(amount);
        clients.add(owner);
        accounts.add(account);
    }
    
    public static void showClients() {
        for (Client client: clients)
            System.out.println(client.toString());
    }
    
    public static void showAccounts() {
        for (Account account: accounts)
            System.out.println(account.toString());
    }
    
}
