/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];

        int c, k, pt, pb, pl, pr;
        for(int i = 0; i < m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                c = 0; k = 0;
                pt = i > 0 ? i - 1 : i;
                pb = i < m - 1 ? i + 1 : i;
                pl = j > 0 ? j - 1 : j;
                pr = j < n - 1 ? j + 1 : j;
                for(int p = pt; p <= pb; ++p)
                {
                    for(int q=pl; q<=pr; ++q)
                    {
                        k += M[p][q]; ++c;
                    }
                }
                res[i][j] = (k / c);
            }
        }
        return res;
    }
}

