import java.util.Scanner;
public class six {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        for(int i=0;i<n/2;i++){ 
           if(s.charAt(i)==s.charAt(n-i-1)){
            System.out.println("Is a palindrom");

           }else{
            System.out.println("Not a palindrome");
           }

        }

        }

    }
