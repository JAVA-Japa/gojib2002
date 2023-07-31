import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static ArrayList<int[]> v = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0) {
            v.clear();

            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                v.add(new int[]{a, b});
            }

            Collections.sort(v, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int mn = n + 1;
            int cnt = 0;
            for(int i = 0; i < v.size(); i++){
                if(v.get(i)[1] > mn) continue;

                mn = v.get(i)[1];
                cnt++;
            }

            System.out.println(cnt);
        }
    }
}
