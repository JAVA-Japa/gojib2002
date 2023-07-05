import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;

    // x라는 수가 모든 조건을 만족하는지 체크하는 함수.
    public static boolean check(int x){
        int[] num1 = new int[3];
        int[] num2 = new int[3];
        int s, b;

        //일단 324가 있으면 3, 2, 4로 분리.
        num1[0] = x / 100;
        num1[1] = (x / 10) % 10;
        num1[2] = x % 10;

        //130 같이 0이 있거나, 131같이 중복된 수가 있으면 x 자체가 잘못된 수.
        if(num1[0] == 0 || num1[1] == 0 || num1[2] == 0) return false;
        if(num1[0] == num1[1] || num1[0] == num1[2] || num1[1] == num1[2]) return false;

        //x가 n개의 조건을 모두 만족하는지 확인.
        for(int i = 0; i < n; i++){
            num2[0] = arr[i][0] / 100;
            num2[1] = (arr[i][0] / 10) % 10;
            num2[2] = arr[i][0] % 10;

            //x랑 arr[i][0]의 스트라이크, 볼 수를 s, b에 구하는 과정.
            //만약 324, 356이면 3, 2, 4 각각을 3, 5, 6과 비교해보며 같은 수가 같은 자리에 있으면 스트라이크++, 같은 수가 다른 자리에 있으면 볼++을 진행.
            s = 0;
            b = 0;
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(num1[j] == num2[k]){
                        if(j == k) s++;
                        else b++;
                    }
                }
            }

            //x와 arr[i][0]의 스트라이크, 볼 수가 arr[i][1], arr[i][2]와 일치해야 조건 만족.
            if(s != arr[i][1] || b != arr[i][2]) return false;
        }

        //모든 조건을 만족하면 return true.
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int cnt = 0;

        arr = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //숫자야구 게임에서 나올 수 있는 모든 조합(123 ~ 987)을 보며 이게 조건을 모두 만족하는지 체크.
        for(int i = 123; i <= 987; i++){
            if(check(i)) cnt++;
        }

        System.out.print(cnt);
    }
}
