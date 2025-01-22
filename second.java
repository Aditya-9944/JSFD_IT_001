import java.util.Scanner;
public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int i=2;
        boolean isPrime = true;
        while(i<Math.sqrt(n)){
            if(n%i==0){
                isPrime = false;
                break;
            }
            i++;
        }
        if(isPrime){
            System.out.println("The number is prime");
        }else{
            System.out.println("The number is not prime");
        }
    }
    
}
