import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static ArrayList<int[]> v = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            v.add(new int[]{a, b});
        }

        Collections.sort(v, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < v.size(); i++){
            if(!pq.isEmpty() && pq.peek() <= v.get(i)[0]) pq.poll();

            pq.add(v.get(i)[1]);
        }

        System.out.print(pq.size());
    }
}
