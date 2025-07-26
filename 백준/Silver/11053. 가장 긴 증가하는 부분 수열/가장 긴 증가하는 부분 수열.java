import jdk.jfr.ContentType;

import java.util.Scanner;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N;
    static int arr [];
    static Integer result [];
    static int count = 0;
    static int index=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        result = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<N;i++){
            check(i);
        }

        int max = result[0];
        for(int i=0;i<N;i++){
            max = Math.max(max,result[i]);
        }

        System.out.println(max);
    }

    public static int check(int num){
        if(result[num] == null){
            result[num] = 1;

            for(int i = num -1; i>=0;i--){
                if(arr[i] < arr[num]){
                    result[num] = Math.max(result[num], check(i) + 1);
                }
            }
        }
        return result[num];
    }
}