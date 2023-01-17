package banksimulation;

import java.util.ArrayList;

/**
 *
 * @author stery
 */
public class Bank {
    private ArrayList<Client> clients;

    public Bank() {
        clients = new ArrayList<Client>();
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
        // Εδώ λογικά θα πρέπει  να διαβάζει το αρχείο με τους πελάτες
        // και να δημιουργεί την κλάση κάθε φορά που ξεκινά το πρόγραμμα.
        //
        // Εναλλακτικά μήπως θα μπορούσε να γεμίζει με δεδομένα κάθε φορά 
        // που δημιουργείται ένας νέος πελάτης;
        // 
        // Προς το παρόν πιο εύκολο ίσως και πιο σωστό το πρώτο.
        //
        // Επίσης με observer pattern θα μπορούσαμε να ενημερώνουμε αυτήν
        // την κλάση κάθε φορά που θα είχαμε κάποια αλλαγή;
        this.clients = clients;
    }

    @Override
    public String toString() {
        String result="";
        for (Client c: clients){
            result += c.toString();
        }
        return result;
    }
    
    
}
