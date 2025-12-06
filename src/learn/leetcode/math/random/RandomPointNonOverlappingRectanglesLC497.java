package learn.leetcode.math.random;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;
import java.util.random.RandomGenerator;

public class RandomPointNonOverlappingRectanglesLC497 {
    private int totalArea;
    private int[][] rectangles;
    private TreeMap<Integer, Integer> cumulativeAreaByRect;
    private RandomGenerator random;
    
    public RandomPointNonOverlappingRectanglesLC497(int[][] rects) {
        cumulativeAreaByRect = new TreeMap<>();
        cumulativeAreaCalculator(rects);
        random = new Random();
        rectangles = Arrays.stream(rects)
                        .map(int[]::clone).toArray(int[][]::new);
    }

    private void cumulativeAreaCalculator(final int[][] rects) {
        for(int i=0; i<rects.length; i++) {
            int ax = rects[i][0], ay = rects[i][1],
                bx = rects[i][2], by = rects[i][3];
            this.totalArea += (bx-ax+1)*(by-ay+1);
            cumulativeAreaByRect.put(totalArea, i);
        }
    }
    
    public int[] pick() {
        int pointPicked = random.nextInt(totalArea)+1;
        int prevRectCumSum, rectInd;
        try {
            prevRectCumSum = cumulativeAreaByRect.lowerKey(pointPicked);
            rectInd = cumulativeAreaByRect.get(prevRectCumSum)+1;
        } catch (NullPointerException e) {
            prevRectCumSum = 0;
            rectInd = 0;
        }
        int pointNo = pointPicked - prevRectCumSum - 1,
            length = rectangles[rectInd][2] - rectangles[rectInd][0] + 1,
            pointx = rectangles[rectInd][0] + (pointNo%length),
            pointy = rectangles[rectInd][1] + (pointNo/length);
        return new int[]{pointx, pointy};
    }

    public static void main(String[] args) {
        int[][] rectangles = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        RandomPointNonOverlappingRectanglesLC497 randomPointGenerator = new RandomPointNonOverlappingRectanglesLC497(rectangles);
        int[] point;
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
        point = randomPointGenerator.pick();
        System.out.printf("Point picked: [%d, %d] \n",point[0], point[1]);
    }
}
