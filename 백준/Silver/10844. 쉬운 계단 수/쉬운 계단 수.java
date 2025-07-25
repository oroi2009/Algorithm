import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Long[][] num;
    static int n;
    final static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        num = new Long[n+1][10];

        for(int i = 0; i < 10; i++){
            num[1][i] = 1L;
        }

        long result = 0;

        for(int i = 1; i <= 9; i++){
            result += recur(n,i);
        }
        System.out.println(result%mod);
    }

    static long recur(int digit, int val){
        if(digit == 1) return num[digit][val];

        if(num[digit][val] == null){
            if(val == 0) num[digit][val] = recur(digit -1 , 1);

            else if (val == 9) num[digit][val] = recur(digit -1, 8);

            else num[digit][val] = recur(digit -1, val -1)+recur(digit-1,val+1);
        }
        return num[digit][val] % mod;
    }
}