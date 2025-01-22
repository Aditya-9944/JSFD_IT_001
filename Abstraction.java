interface Atm{
    // Public Abstract and Default Methods 
    // Final Constants
    double version = 22.34;
    default double showVersion(){
        return version;
    }
    public void withdraw(int amount);
    public void deposit(int amount);
    public void setBalance(int amount);
    public void qrDeposit(int amount);
}
 
 
class HDFCAtm implements Atm{
    private double balance;
 
    public void withdraw(int amount){
        if(balance>=amount){
            balance -= amount;
            System.out.println("Withdrawal of Rs." + amount + " is successful");
        }else{
            System.out.println("Low Balance");
        }
    }
    public void deposit(int amount){
        balance += amount;
        System.out.println("Rs."+amount+" Received Successfully!!");
    }
    public void setBalance(int amount){
        balance = amount;
    }
    public void qrDeposit(int amount){
        balance += amount;
    }
}
 
 
 
class SbiAtm implements Atm{
    private static double balance;
 
    public void withdraw(int amount){
        if(balance>=amount){
            balance -= amount;
            System.out.println("Withdrawal of Rs. " + amount + " is successful");
        }else{
            System.out.println("Insufficient Balance!!");
        }
    }
    public void deposit(int amount){
        balance += amount;
        System.out.println(amount+" deposited Successfully!!");
    }
 
    public void qrDeposit(int amount){
        balance+=amount;
        System.out.println(amount+" deposited Successfully!!");
    }
 
    public void setBalance(int amount){
        balance = amount;
    }
}
 
 
public class Abstraction {
    public static void main(String[] args) {
        
    Atm atm1 = new HDFCAtm();
    atm1.setBalance(200000);
    atm1.withdraw(1000);
 
    Atm atm2 = new SbiAtm();
    atm2.setBalance(200000);
    atm2.withdraw(3000);
    atm2.deposit(4000);
    atm1.qrDeposit(3435);
    atm2.deposit(20000);
    }
}


