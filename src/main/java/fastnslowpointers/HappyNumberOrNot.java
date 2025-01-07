package fastnslowpointers;

public class HappyNumberOrNot {

    public static void main(String[] args) {
        System.out.println(isHappyNumber(123));
        System.out.println(isHappyNumber(23));
    }

    /**
     * Checks to see if the number is happy or not
     * @param num
     * @return if the number is happy
     */
    public static boolean isHappyNumber(int num) {
        int slow = num;
        int fast = num;

        while (true) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));

            if (fast == 1) {
                return true;
            } else if (fast == slow) {
                return false;
            }
        }
    }

    private static int getNextNum(int num) { //123
        int nextNum = 0;
        while (num > 0) {
            int digit = num % 10; //3 //2 //1
            num /= 10; //12 //1
            nextNum += Math.pow(digit, 2);
        }
        return nextNum;
    }
}
