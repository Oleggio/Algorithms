import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

class ZeroMatrix {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }


        int[] filledRows = new int[6];
        int[] filledColumns = new int[6];
        for (int i = 0; i <= arr.length; i++) {
            //Add filled check

            for (int j = 0; j <= arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    for (int k = 0; k <= arr[i].length; k++) {
                        arr[i][k] = 0;
                    }
                    for (int l = 0; j <= arr.length; l++) {
                        arr[l][j] = 0;
                    }
                    //filled.add(i,j);
                    break;
                }
            }
        }

    }
}