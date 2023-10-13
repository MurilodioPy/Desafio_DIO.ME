package lancamento;

/**
 *
 * @author murilodio
 */
public class lancamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Iphone telefone = new Iphone(); 
        telefone.makeCall("34 9 9999-9999");
        telefone.endCall();
        
        telefone.play();
        
        
        telefone.openURL("www.google.com");
    }
    
}
