package com.deitel.ch17;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException; 
import java.util.NoSuchElementException; 
import java.util.Scanner;

public class CreateTextFile{
    private Formatter output; // objeto utilizado para enviar texto para arquivo

    // permite ao usuário abrir o arquivo
    public void openFile(){
        try{
            output = new Formatter( "clients.txt" ); // abre o arquivo
        } 
        catch (SecurityException securityException){
            
            System.err.println("You do not have write access to this file.");
             System.exit(1); // termina o programa
        }
        catch (FileNotFoundException fileNotFoundException){
        System.err.println("Error opening or creating file." ); System.exit(1); // termina o programa
        }  
    }
    // adiciona registros ao arquivo 
    public void addRecords(){
        // objeto a ser gravado no arquivo 
        AccountRecord record = new AccountRecord();
        try (
            Scanner input = new Scanner(System.in)) {
            System.out.printf("%s\n%s\n%s\n %s\n\n","To terminate input, type the end-of-file indicator ","when you are prompted to enter input.",
            "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter", "On Windows type <ctrl> z then press Enter" );

            System.out.printf("%s\n %s","Enter account number (>0), first name, last name and balance.","?");
   
            while (input.hasNext()){ // faz um loop até o indicador de fim de arquivo
            
            try{ // gera saída dos valores para o arquivo

                // recupera os dados para saída 
                record.setAccount (input.nextInt()); // lê o número de conta 
                record.setFirstName(input.next() ); // lê o primeiro nome 
                record.setLastName(input.next()); // lê o sobrenome 
                record.setBalance(input.nextDouble() ); // lê o saldo
                
                if (record.getAccount() > 0){    
              // grava um novo registro
              output.format("%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance() );
                } 
                else{
                    System.out.println("Account number must be greater than 0." );
                } 
            } 
                 catch (FormatterClosedException formatterClosedException) {
                    System.err.println("Error writing to file.");
                return;
            } 
            catch (NoSuchElementException elementException){ 
                System.err.println("Invalid input. Please try again." ); 
                input.nextLine(); // descarta a entrada para que o usuário possa tentar novamente
            } 
            System.out.printf("%s %s\n%s", "Enter account number (>0),", "first name, last name and balance.", "?");
            }
        } 
    } 
    // fecha o arquivo
        public void closeFile(){
            if (output != null) output.close();
    }
}