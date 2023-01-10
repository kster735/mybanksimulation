package banksimulation;

/**
 *
 * @author stery
 */
public class WithdrawException extends Exception {
//    Αν δε μπορεί να γίνει μία ανάληψη
//    Ίσως για τα reserve accounts? 
//    ή επειδή δεν υπάρχει αρκετό υπόλοιπο
//    ή για capital controls που μπορεί να εφαρμόσω ως bonus εργασία.
    
    /**
     * Throw general deposit exception message.
     * @return 
     */
    public String getMessage(){
        return "Δε μπορεί να γίνει ανάληψη σε αυτόν τον λογαριασμό αυτή τη στιγμή";
    }
    
    /**
     * // Pass a specific message about this deposit exception
     * @param msg
     * @return 
     */
    public String getMessage(String msg){
        return "Δε μπορεί να γίνει κατάθεση σε αυτόν τον λογαριασμό αυτή τη στιγμή" + msg;
    }
}
