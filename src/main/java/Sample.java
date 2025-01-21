import streams.DealingWithStreams;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
       fizzBuzz(15);

    }
    public static void fizzBuzz(int n) {
        // Write your code here
        for(int i=1; i<=n; i++){
            if(i% 5==0 || i% 3==0){
                if(i%3==0 && i%5==0){
                    System.out.println("FizzBuzz");
                }else{
                    if(i%3==0){
                        System.out.println("Fizz");
                    }else if(i%5==0){
                        System.out.println("Buzz");
                    }
                }

            }
            else{
                System.out.println(i);
            }
        }
    }

}