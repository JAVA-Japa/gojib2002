import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n;
    static double[][] arr;
    static int[] par;

    public static int find(int x){
        if(par[x] == x) return x;
        else return par[x] = find(par[x]);
    }

    public static void union_(int a, int b){
        a = find(a);
        b = find(b);

        par[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<double[]> v = new ArrayList<>();

        n = sc.nextInt();
        arr = new double[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextDouble();
            arr[i][1] = sc.nextDouble();
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                v.add(new double[]{i, j, Math.sqrt((arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0]) + (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]))});
            }
        }

        Collections.sort(v, new Comparator<double[]>(){
            @Override
            public int compare(double[] o1, double[] o2){
                if(o1[2] > o2[2]) return 1;
                else if(o1[2] == o2[2]) return 0;
                else return -1;
            }
        });

        par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;

        double ans = 0;
        for(int i = 0; i < v.size(); i++){
            int a = find((int)v.get(i)[0]);
            int b = find((int)v.get(i)[1]);

            if(a == b) continue;

            union_(a, b);
            ans += v.get(i)[2];
        }

        System.out.print(ans);
    }
}
