import java.util.Scanner;
public class fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int bsum=0;
        int dsum=0;
        for(int i=0;i<n;i++){

                bsum+=arr[i][i];
                System.out.print(bsum+" ");
            }
            System.out.println();
        
        for(int i=0;i<n;i++){
                dsum+=arr[i][n-i-1];
    
        }
        System.out.print(bsum+" ");
        System.out.print(dsum+" ");
        if(bsum==dsum){
            System.out.println("Is a Magic square");
        }
        else{
            System.out.println("Is not a Magic square");
        }

    }
}
