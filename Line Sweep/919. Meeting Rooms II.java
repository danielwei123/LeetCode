// 919 · Meeting Rooms II

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        // 扫描线 Line Sweep
        Comparator timeComparator = new Comparator<Point>(){
            @Override
            public int compare(Point one, Point two){
                if (one.time == two.time) {
                    return one.type - two.type;
                }
                return one.time - two.time;
            }
        };

        Point[] pointArr = new Point[2 * intervals.size()]; 
        for (int i = 0; i < intervals.size(); i++) {
            pointArr[2 * i] = new Point(intervals.get(i).start, 1);
            pointArr[2 * i + 1] = new Point(intervals.get(i).end, -1);
        }
        Arrays.sort(pointArr, timeComparator);

        int res = 0;
        int curCount = 0;
        int typeSum = 0;
        for (int i = 0; i < pointArr.length; i++) {
            curCount += pointArr[i].type;
            res = Math.max(res, curCount);
        }
        return res;
    }

}

// type: start = 1, end = -1
class Point {
    int time;
    int type;
    Point(int inputTime, int inputType) {
        time = inputTime;
        type = inputType;
    }
}