import java.util.*;
/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前K个高频元素
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i) + 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        // lambda表达式比匿名内部类会更慢
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for(int i : map.keySet()){  
            if(queue.size() < k)
                queue.add(i);
            else if(map.get(i) > map.get(queue.peek())){
                queue.remove();
                queue.add(i);
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){
            list.addFirst(queue.remove().e);
        }
        return list;
    }
}

