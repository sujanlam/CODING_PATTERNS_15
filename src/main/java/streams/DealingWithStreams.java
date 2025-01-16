package streams;

import java.util.Arrays;
import java.util.List;

public class DealingWithStreams {
    public static void main(String[] args) {
        filterDivideNSumUp();
    }

    //Given a list filter evens, divide all by 2 and sum them up
    public static void filterDivideNSumUp() {
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
        int sum1 = list.stream().filter(a -> a % 2 == 0).map(a -> a / 2).reduce(0, Integer::sum);
        System.out.println(sum1);
    }
}
