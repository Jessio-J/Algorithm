package exam.jd.D20190824;

import java.util.Scanner;

public class class1 {
    public static int[] heights = new int[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nperson = new int[n];
        int count = 0;
        int minGroup = 0;
        for (int i = 0; i < n; i++) {
            nperson[i] = sc.nextInt();
            if (nperson[i] > minGroup) {
                minGroup = nperson[i];
            }
        }
        heights[n] = minGroup + 1;
        heights[n - 1] = nperson[n - 1];
        for (int i = n - 2; i > -1; i--) {
            if (nperson[i] < heights[i + 1]) {
                heights[i] = nperson[i];
            } else {
                heights[i] = heights[i + 1];
            }
        }
        int cur = nperson[0];
        for (int i = 0; i < n; ++i) {
            if (nperson[i] > cur) {
                cur = nperson[i];
            }
            if (cur <= heights[i + 1]) {
                count++;
            }
        }
        System.out.print(count);
    }
}