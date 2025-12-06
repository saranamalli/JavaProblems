package learn.leetcode.graphs;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinDaysDisconnectIsland1568 {
    /**
     * Deductions: 
     * 1. Ans is always 0, 1, 2 not more than 2.
     * You can always find a leaf which is 1 or 2 side connected.
     * 2. First check whether ur grid is already disconnected => 0, else try removing one by one and check 
     *       else return 2. 2 should be the answer.
     * 3. To check disconnections, count all ones and cound dfs from 1 land.
     */
    public static int minDays(int[][] grid) {
        final int TOTAL_LAND = countLand(grid), 
            GRID_LENGTH = grid[0].length, GRID_WIDTH = grid.length;
        
        // Check if grid is already disconnected:
        int[] initialLandIndex = getALandIndex(grid, GRID_WIDTH, GRID_LENGTH);
        if(initialLandIndex == null) return 0;
        
        int[][] gridClone = Arrays.stream(grid)
                                .map(int[]::clone).toArray(int[][]::new);
        int dfsLandCount = countLandOfAIsland(gridClone, initialLandIndex);
        if(dfsLandCount < TOTAL_LAND) return 0;

        // Check if we can disconnect grid by removing just 1 land:
        for(int i=0; i<GRID_WIDTH; i++) {
            for(int j=0; j<GRID_LENGTH; j++) {
                gridClone = Arrays.stream(grid)
                                .map(int[]::clone).toArray(int[][]::new);
                if(gridClone[i][j] == 1) {
                    System.out.printf("For 1 land: i= %d, j= %d \n",i, j);
                    gridClone[i][j] = 0;
                    initialLandIndex = getALandIndex(gridClone, GRID_WIDTH, GRID_LENGTH);
                    if(initialLandIndex == null) return 0;
                    dfsLandCount = countLandOfAIsland(gridClone, initialLandIndex);
                    if(dfsLandCount+1 < TOTAL_LAND) return 1;
                    gridClone[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public static int countLandOfAIsland(final int[][] grid, int[] initialLandIndex) {
        int iniI = initialLandIndex[0], iniJ = initialLandIndex[1];
        final int GRID_LENGTH = grid[0].length, GRID_WIDTH = grid.length;
        if(grid[iniI][iniJ] == 0) return 0;
        grid[iniI][iniJ] = 0;       // to prevent counting this land twice
        int[] indexAbove = {iniI-1, iniJ};
        int[] indexBelow = {iniI+1, iniJ};
        int[] indexLeft = {iniI, iniJ-1};
        int[] indexRight = {iniI, iniJ+1};
        return 1 + 
            (iniI-1 >= 0 ? countLandOfAIsland(grid, indexAbove) : 0) + 
            (iniI+1 < GRID_WIDTH ? countLandOfAIsland(grid, indexBelow) : 0) +
            (iniJ-1 >= 0 ? countLandOfAIsland(grid, indexLeft) : 0) +
            (iniJ+1 < GRID_LENGTH ? countLandOfAIsland(grid, indexRight) : 0);
    }

    public static int[] getALandIndex(final int[][] grid, final int GRID_WIDTH, final int GRID_LENGTH) {
        // Find a land index to start DFS
        for(int i=0; i<GRID_WIDTH; i++) {
            for(int j=0; j<GRID_LENGTH; j++) {
                if(grid[i][j] == 1) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

    public static int countLand(final int[][] grid) {
        return Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();
    }

    public static void main(String[] args) {
        // int[][] grid = {
        //     {0,1,1,0},
        //     {0,1,1,0},
        //     {0,0,0,0}
        // };

        // int[][] grid = {{0,1,1,0}};

        // int[][] grid = {
        //     {1,1,0,1,1},
        //     {1,1,1,1,1},
        //     {1,1,0,1,1},
        //     {1,1,0,1,1}
        // };

        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println("Mindays required: " + minDays(grid));

    }
}
