package greedyalgos;

public class GasStationProblem {
    public static void main(String[] args) {
        int[] gas =  {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int dest = gas.length;
        int totalgas = 0;
        int totalcost = 0;


        int start = 0;
        int tank = 0;
        int defficency = 0;
        for (int i = 0; i <dest; i++) {
            tank += gas[i]-cost[i];

            if(tank < 0){
                defficency += tank;
                tank = 0;
                start = i+1;
            }
        }
        return tank >= Math.abs(defficency)?start:-1;
    }
}


