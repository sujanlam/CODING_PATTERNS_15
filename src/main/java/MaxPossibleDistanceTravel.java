import java.util.ArrayList;
import java.util.List;

public class MaxPossibleDistanceTravel {
    public int maxStepsDistnace(int[] board) {
        int n = board.length;
        List<Integer> pieces = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();

        int count = 0;
        for(int i=0; i<n; i++){
            if (board[i] == 1){
                pieces.add(i);
            }else {
                empty.add(i);
            }
        }
        System.out.println(pieces);
        System.out.println(empty);
        int total_distance = 0;
        int i = 0;
        while (i<pieces.size() && i<empty.size()){
            total_distance += Math.abs(pieces.get(i)-empty.get(i));
            i++;
        }
        return total_distance;
    }

    public int maxStepsOptimized(int[] board) {
        int n = board.length;

        // Track the positions of all pieces (1s)
        List<Integer> pieces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (board[i] == 1) {
                pieces.add(i);
            }
        }

        // Determine the target positions for contiguous placement of 1s
        int count = pieces.size();
        int start = (n - count) / 2; // Center placement
        int totalDistance = 0;

        for (int i = 0; i < count; i++) {
            totalDistance += Math.abs(pieces.get(i) - (start + i));
        }

        return totalDistance;
    }


    public static void main(String[] args) {
        MaxPossibleDistanceTravel sol = new MaxPossibleDistanceTravel();

        int[] board1 = {0,1, 1, 1, 0,0,0, 1,0};
        int[] board2 = {1, 1, 0,0,1};
        System.out.println(sol.maxStepsDistnace(board1)); // Output: 6
        System.out.println(sol.maxStepsDistnace(board2)); // Output: 4
        System.out.println(sol.maxStepsOptimized(board1)); // Output: 6
        System.out.println(sol.maxStepsOptimized(board2)); // Output: 4
    }
}
