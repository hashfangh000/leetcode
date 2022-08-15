package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/qiu-12n-lcof/
 * @author: fanghao
 * @create: 2022/8/13
 **/
public class Offer_64sumNums {
    int n;
    int ans = 0;
    public int sumNums(int n) {
        this.n = n;
       backtrack(1);
       return ans;
    }

    private void backtrack(int cur) {
        if (cur <= n){
            ans += cur;
        }else {
            return;
        }
        backtrack(cur + 1);

    }

    int a = 0;
    public void test(){
        f();
        System.out.println(a);
    }

    private void f() {
        a += 1;
    }

    public static void main(String[] args) {
        Offer_64sumNums solution = new Offer_64sumNums();
        System.out.println(solution.sumNums(5));
        solution.test();
    }
}
