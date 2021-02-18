import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    class Point {
        int index, sum;
        public Point(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Point> points = new ArrayList<>();
        for(int index1 = 0; index1 < mat.length; index1++) {
            int count = 0;
            for (int index2 = 0; index2 < mat[index1].length; index2++) {
                if (mat[index1][index2] == 1) {
                    count++;
                }
            }
            points.add(new Point(index1, count));
        }

        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.sum == o2.sum)
                    return o1.index - o2.index;
                else
                    return o1.sum - o2.sum;
            }
        });
        int[] arr = new int[k];
        for (int index = 0; index < k; index++) {
            arr[index] = points.get(index).index;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res = new Solution().kWeakestRows(
                new int[][]{
                        {1,1,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1}
                },
                3
        );
        for (Integer a: res)
            System.out.print(a +" ");
    }
}