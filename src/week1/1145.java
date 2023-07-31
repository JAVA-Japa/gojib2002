import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int cnt;

        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
        }

        //각 수가 100 이하 => 정답은 100만 이하.
        //1이 몇개로 나눠지는지, 2가 몇개로 나눠지는지, ... i가 몇개로 나눠지는지 세보고 3개 이상이 되면 그게 정답.
        for(int i = 1; i <= 1000000; i++){
            cnt = 0;
            for(int j = 0; j < 5; j++){
                if(i % arr[j] == 0) cnt++;
            }

            if(cnt >= 3){
                System.out.print(i);
                break;
            }
        }
    }
}
