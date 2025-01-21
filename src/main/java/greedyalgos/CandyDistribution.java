package greedyalgos;

import utilities.PrintData;

public class CandyDistribution {
    public static void main(String[] args) {
        int[] ratings = {4,3,2,4,5,1};
        System.out.println(findTotalCandies(ratings));
    }

    private static int findTotalCandies(int[] ratings) {
        int n = ratings.length;
        if(n == 0 || n == 1 ){
            return n;
        }
        int totalCandies = 0;
        int[] candides = new int[n];
        //Loop over ratings and assign at least 1 candy to all ratings
        //If the ratings on the right > then make sure they get 1 more than left
        //Assign 1 to the left since they have no left neighbor to compare
        candides[0] = 1;
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]){
                candides[i] = candides[i-1]+1;
            }else{
                candides[i]=1;
            }
        }
        //Loop over ratings from the end
        //If the ratings on the left > then make sure they get at least 1 more than right
        totalCandies += candides[n-1];
        for (int i = n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]){
                candides[i] = Math.max(candides[i], candides[i+1]+1);
            }
            totalCandies += candides[i];
        }
        return totalCandies;
    }
}
