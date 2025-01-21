package greedyalgos;

public class JumpProblem {
    public static void main(String[] args) {
        int[] jumps = {9, 0, 7, 0, 4, 2, 0, 5};
        System.out.println(canIJump(jumps));
    }

    private static boolean canIJump(int[] jumps) {
        if (jumps[0] == 0) {
            return false;
        }
        int n = jumps.length-1;
        int dest = n;
        for (int i = n - 1; i >= 0; i--) {
            if (i + jumps[i] >= dest) {
                dest = i;
            }
        }

        return dest == 0 ? true : false;
    }
}
