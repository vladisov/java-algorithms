package dev.algos.snatch.interview_problems.graph;


import java.util.HashSet;
import java.util.Set;

// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}

public class RobotCleaner {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        exploreAndClean(new int[]{0, 0}, robot, new HashSet<>(), 0);
    }

    void exploreAndClean(int[] pos, Robot robot, Set<String> visited, int direction) {
        robot.clean();
        String key = pos[0] + "," + pos[1];
        visited.add(key);
        for (int turn = 0; turn < 4; turn++) {
            int[] newPos = getPosition(pos, direction);
            String adjKey = newPos[0] + "," + newPos[1];
            if (!visited.contains(adjKey) && robot.move()) {
                exploreAndClean(newPos, robot, visited, direction);
            }
            robot.turnRight();
            direction = (direction + 1) % 4;
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private int[] getPosition(int[] pos, int direction) {
        return new int[]{pos[0] + dirs[direction][0], pos[1] + dirs[direction][1]};
    }
}
