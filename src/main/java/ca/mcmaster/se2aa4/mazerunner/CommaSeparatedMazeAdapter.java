package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class CommaSeparatedMazeAdapter implements MazeLoader {
    @Override
    public char[][] loadMaze(String source) throws IOException {
        String[] rows = source.split(",");
        char[][] maze = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            maze[i] = rows[i].trim().toCharArray();
        }
        return maze;
    }
}