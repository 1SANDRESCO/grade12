/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit02;

/**
 *
 * @author 1SANDRESCO
 */
public class AccountClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Account acc1 = new Account();
        
        acc1.setAccountNumber(18853726);
        acc1.setBankNumber(220);
        acc1.setHolderFirstName("Alex");
        acc1.setHolderLastName("Lai");
        acc1.setBalance(450.34);
        acc1.setActive(true);
        
        System.out.println(acc1.toString());
    }
    
}
