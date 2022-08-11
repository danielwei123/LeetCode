// 973. K Closest Points to Origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, new Comparator<Point>(){
            @Override
            public int compare(Point one, Point two) {
                if (getDistance(one) == getDistance(two)) {
                    return 0;
                }
                return getDistance(one) > getDistance(two) ? -1 : 1;
            }
        });
            
        for (int i = 0; i < points.length; i++) {
            Point cur = new Point(points[i][0], points[i][1]);
            if (maxHeap.size() < k) {
                maxHeap.offer(cur);            
            } else if(getDistance(cur) < getDistance(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.offer(cur);            
            }
        }
        
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Point cur = maxHeap.poll();          
            res[index][0] = cur.x;
            res[index][1] = cur.y;
            index++;
        }
        
        return res;
    }
    
    private double getDistance(Point p) {
        if (p == null) return 0;
        return Math.sqrt(p.x * p.x + p.y * p.y);
    }
}

class Point {
    int x;
    int y; 
    Point(int cordX, int cordY) {
        x = cordX;
        y = cordY;
    }
}