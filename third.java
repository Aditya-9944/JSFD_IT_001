import java.util.Scanner;
public class third {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int i =sc.nextInt();
        int j =sc.nextInt();
        int[][] arr =new int[i][j];
        for(int a=0;a<i;a++){
            for(int b=0;b<j;b++){
                arr[a][b]=sc.nextInt();
            }
        }
        for(int a=0;a<i;a++){
            for(int b=0;b<j;b++){
                if(arr[a][b]%2==0){
                    System.out.println(arr[a][b]+" is even");
                    
                }
        }

        }
}
}
