package com.deitel.ch17;
 
public class AccountRecord{

    private int account; 
    private String firstName; 
    private String lastName; 
    private double balance;
    
    // construtor sem argumentos chama outro construtor com valores padrão
        public AccountRecord(){
            this( 0, "", "", 0.0 );
        } 
    
    //inicializa um registo 
        public AccountRecord( int acct, String first, String last, double bal ) {
            setAccount( acct ); 
            setFirstName( first );
            setLastName(last);
            setBalance(bal);
        }
    //configura o numero da conta 
        public void setAccount ( int acct){
            account = acct;
        } 
        public int getAccount(){   
            return account;
        } 

    // configura o nome
        public void setFirstName(String first){ 
            firstName = first;
        } 
    // obtém o primeiro nome
        public String getFirstName() {
            return firstName; 
        }
    // configura o sobrenome
        public void setLastName(String last){ 
            lastName = last;
        } 
    // obtém o ultimo nome 
        public String getLastName(){ 
            return lastName;
        }   
    // configura saldo 
        public void setBalance (double bal){
            balance = bal;
        } 
    // obtém saldo 
        public double getBalance() {
            return balance;
        }
}
