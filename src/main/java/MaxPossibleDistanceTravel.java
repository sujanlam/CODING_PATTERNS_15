public class MaxPossibleDistanceTravel {
    public int solution(int[] board) {
        int n = board.length;
        int[] positions = new int[n];
        int count = 0;

        // Store the indices of all '1's (game pieces)
        for (int i = 0; i < n; i++) {
            if (board[i] == 1) {
                positions[count++] = i;
            }
        }

        // Calculate the optimal destination positions
        int[] targetPositions = new int[count];
        int start = 0; // Start with the first empty slot
        int interval = (n - count) / count; // Calculate the ideal interval between pieces
        for (int i = 0; i < count; i++) {
            targetPositions[i] = start;
            start += interval;
        }

        // Calculate the total distance traveled
        int totalDistance = 0;
        for (int i = 0; i < count; i++) {
            totalDistance += Math.abs(targetPositions[i] - positions[i]);
        }

        return totalDistance;
    }


    public static void main(String[] args) {
        MaxPossibleDistanceTravel sol = new MaxPossibleDistanceTravel();

        // Test cases
        int[] board1 = {1, 1, 0, 0, 1};
        System.out.println(sol.solution(board1)); // Output: 4

        int[] board2 = {0, 1};
        System.out.println(sol.solution(board2)); // Output: 1

        int[] board3 = {0, 0, 0};
        System.out.println(sol.solution(board3)); // Output: 0
    }
}
