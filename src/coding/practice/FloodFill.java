package coding.practice;

public class FloodFill {

    public static void main(String[] args) {
        final int[][] screen = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 0;
        int y = 0;
        int newColour = 2;
        fillScreen(screen, x, y, newColour, screen[x][y]);
        printScreen(screen);
    }

    private static void printScreen(int[][] screen) {
        for (int[] row : screen) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static void fillScreen(int[][] screen, int x, int y, int newColour, int prevColour) {
        if (x >= 0 && x < screen[0].length &&
            y >= 0 && y < screen[0].length &&
            screen[x][y] != newColour  &&
            screen[x][y] == prevColour) {
            screen[x][y] = newColour;
            fillScreen(screen, x - 1, y, newColour, prevColour);
            fillScreen(screen, x, y - 1, newColour, prevColour);
            fillScreen(screen, x + 1, y, newColour, prevColour);
            fillScreen(screen, x, y + 1, newColour, prevColour);
        }
    }
}
