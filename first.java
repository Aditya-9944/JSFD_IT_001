import java.util.Scanner;
public class first{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        
        if(n%2==0){
            for(int i=0;i<100;i++){
                if(i%3==0){
                    System.out.println("Frizz");
            }
                if(i%5==0){
                    System.out.println("Buzz");
            }
                if(i%3==0 && i%5==0){
                    System.out.println("Frizz buzz");
            }
        }
    }
        else{
            System.out.println("Please enter an even number");
    }
   
    }
}