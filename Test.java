import java.util.ArrayList;
import java.util.List;

public class Test{
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> list;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>(k);
        dfs(k, 1, n);
        return ans;
    }

    private static void dfs(int k, int i, int target){
        if(k<0 || target < 0) return;
        if(k == 0 && target == 0) 
            ans.add(new ArrayList<>(list));
        
        for(int j = i; j <= 9; j++){
            list.add(j);
            dfs(k-1, j+1, target-j);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        combinationSum3(3, 9);
    }
}
