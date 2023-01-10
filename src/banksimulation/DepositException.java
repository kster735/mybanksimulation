package banksimulation;

/**
 *
 * @author stery
 */
public class DepositException extends Exception {
    // Αν δε μπορεί να γίνει μία κατάθεση (Δεν ξέρω για ποιο λόγο )
//    Ίσως για τα reserve accounts?
    
    /**
     * Throw general deposit exception message.
     * @return 
     */
    public String getMessage(){
        return "Δε μπορεί να γίνει κατάθεση σε αυτόν τον λογαριασμό αυτή τη στιγμή";
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
