class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (String key : wordCount.keySet()) {
            Pair p = new Pair(key, wordCount.get(key));
            if (pq.size() < k) {
                pq.offer(p);
            } else if (pq.peek().compareTo(p) < 0) {
                pq.poll();
                pq.offer(p);
            }
        }
        
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }
        
        reverseList(res);
        
        return res;
    }
    
    public void reverseList(List<String> list) {
        int lo = 0;
        int hi = list.size() - 1;
        
        while (lo < hi) {
            String temp = list.get(lo);
            list.set(lo, list.get(hi));
            list.set(hi, temp);
            lo++;
            hi--;
        }
    }
    
    class Pair implements Comparable<Pair> {
        String word;
        int count;
        
        public Pair(String w, int c) {
            word = w;
            count = c;
        }
        
        public int compareTo(Pair p) {
            if (this.count != p.count) {
                return this.count - p.count;
            } else {
                return p.word.compareTo(this.word);
            }
        }
    }
}