// 149. Max Points on a Line

class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        if (points.length == 1) {
            return 1;
        }
        
        int n = points.length;
        HashMap<double[], HashSet<int[]>> map = new HashMap<>(); 
        for (int i = 0; i < n - 1; i++) {
          for (int j = i + 1; j < n; j++) {
            if (points[i][0] == points[j][0] && points[i][1] != points[j][1]) {
              double[] p = new double[]{points[i][0], Integer.MAX_VALUE};
              HashSet<int[]> tmp = new HashSet<>();
              for (double[] k : map.keySet()) {
                  if (k[0] == points[i][0] && k[1] == Integer.MAX_VALUE) {
                    tmp = map.get(k);
                    p = k;
                  }
              }
              tmp.add(points[i]);
              tmp.add(points[j]);
              map.put(p, tmp);
            } else {
              double a = (double)(points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
              double b = a * points[i][0] - points[i][1];
              double[] p = new double[]{a, b};
              HashSet<int[]> tmp = new HashSet<>();
              for (double[] k : map.keySet()) {
                  if (k[0] == a && k[1] == b) {
                    tmp = map.get(k);
                    p = k;
                  }
              }

              tmp.add(points[i]);
              tmp.add(points[j]);
              map.put(p, tmp);
            }
          }
        }

        int res = 0;
        for (HashSet<int[]> set : map.values()) {
          res = Math.max(res, set.size());
        }
        return res;
    }

}