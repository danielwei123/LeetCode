// 217. Largest Set Of Points With Positive Slope

/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int largest(Point[] points) {
    // Write your solution here.
    // Sort points by x ascending and y descending
    Arrays.sort(points, new MyComparator());
    
    int res = 0;
    int[] longest = new int[points.length];

    for (int i = 0; i < longest.length; i++) {
      for (int j = 0; j < i; j++) {
        if (points[j].y < points[i].y) {
          longest[i] = Math.max(longest[i], longest[j]); 
        }
      }
      longest[i]++;
      res = Math.max(res, longest[i]);
    }
    return res == 1 ? 0 : res;

  }

  static class MyComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
      return p1.x != p2.x ? p1.x - p2.x : p2.y - p1.y;
    }
  }
}