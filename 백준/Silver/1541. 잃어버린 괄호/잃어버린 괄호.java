import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        
        String str = br.readLine();
        
        String[] split = str.split("-");
        
        for(String s : split){
            int sum = 0;
            String[] temp = s.split("\\+");
            for(String midsum : temp){
                sum += Integer.parseInt(midsum);
            }
            list.add(sum);
        }
        result = list.get(0);
        for(int i = 1; i<list.size(); i++){
            result -= list.get(i);
        }
        System.out.println(result);
    }

}