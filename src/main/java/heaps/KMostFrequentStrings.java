package heaps;

import java.util.*;

public class KMostFrequentStrings {
    public static void main(String[] args) {
        int k = 2;
        String[] words = {"go", "go", "coding", "byte", "byte", "go", "interview"};
        List<String> res = getFrequencyKMost(words, k);
        System.out.println(res);
    }

    private static List<String> getFrequencyKMost(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> countFreq = new HashMap<>();

        for(String word: words){
            countFreq.put(word, countFreq.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) ->
                !Objects.equals(a.getValue(), b.getValue()) ? a.getValue() - b.getValue()
                :a.getKey().compareTo(b.getKey()));
        for(Map.Entry<String, Integer> entry: countFreq.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()){
            res.add(minHeap.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
