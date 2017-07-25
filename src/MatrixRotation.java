/**
 * Created by oleggio on 7/8/17.
 */
public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = new int[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                arr[i][j] = i + j;
            }
        }
        print(arr);
        rotateClockwise(arr);
        print(arr);
        rotateAntiClockwise(arr);
        print(arr);
    }

    private static void rotateClockwise(int[][] arr) {
        int end = 0;

        for(int layer = 0; layer < arr.length / 2; layer++) {
            end = arr.length - layer - 1;
            
            for(int off = 0; off < arr.length - 2*layer - 1; off++) {
                swap(arr, new Coord(layer, layer + off), new Coord(layer + off, end));
                swap(arr, new Coord(layer, layer + off), new Coord(end, end - off));
                swap(arr, new Coord(layer, layer + off), new Coord(end - off, layer));
            }
        }
    }

    private static void rotateAntiClockwise(int[][] arr) {
        int end = 0;

        for(int layer = 0; layer < arr.length / 2; layer++) {
            end = arr.length - layer - 1;

            for(int off = 0; off < arr.length - 2*layer - 1; off++) {
                swap(arr, new Coord(layer, layer + off), new Coord(end - off, layer));
                swap(arr, new Coord(layer, layer + off), new Coord(end, end - off));
                swap(arr, new Coord(layer, layer + off), new Coord(layer + off, end));
            }
        }
    }


    private static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void swap(int[][] arr, Coord c1, Coord c2) {
        int tempValue = arr[c2.x][c2.y];
        arr[c2.x][c2.y] = arr[c1.x][c1.y];
        arr[c1.x][c1.y] = tempValue;
    }

    public static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
