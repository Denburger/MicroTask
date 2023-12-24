import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        subarraySum(nums, k);
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // добавляем первый элемент ноль

        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i]; // summ = summ + i элемент переданного массива
            if (map.containsKey(sum - k)) {
                answer += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return answer; // вовзращаем количество подмассивов, элементы которых в сумме равны k
    }
}
