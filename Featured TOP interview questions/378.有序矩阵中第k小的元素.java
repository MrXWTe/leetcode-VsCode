import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第K小的元素
 *
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (55.78%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    5.9K
 * Total Submissions: 10.6K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * 
 * 示例:
 * 
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * 返回 13。
 * 
 * 
 * 说明: 
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n^2 。
 * 
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = 
            new PriorityQueue<>((o1, o2)->(o2 - o1));
        
        int n = matrix.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(queue.size() < k){
                    queue.add(matrix[i][j]);
                }else{
                    if(matrix[i][j]<queue.peek()){
                        queue.poll();
                        queue.add(matrix[i][j]);
                    }
                }
            }
        }
        return queue.peek();
    }
}

