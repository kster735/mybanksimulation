package banksimulation;

/**
 *
 * @author stery
 */
public class CloseAccountException extends Exception {
//    Αν δε μπορεί να γίνει μία ανάληψη
//    Ίσως για τα reserve accounts? 
    
    /**
     * Throw general close account exception message.
     * @return 
     */
    public String getMessage(){
        return "Δε μπορεί να γίνει κλείσιμο αυτού του λογαριασμού αυτή τη στιγμή";
    }
    
    /**
     * // Pass a specific message about this close account exception
     * @param msg
     * @return 
     */
    public String getMessage(String msg){
        return "Δε μπορεί να γίνει κλείσιμο αυτού του λογαριασμού αυτή τη στιγμή" + msg;
    }
}
