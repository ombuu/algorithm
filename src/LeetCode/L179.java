package LeetCode;

public class L179 {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        String ab = a + "" + b;
        System.out.println("ab = " + ab);
        int[] nums = {0, 0};
        System.out.println(largestNumber(nums));


    }

    public static String largestNumber(int[] nums) {
        // 이중 for문 돌리면서 두 수를 조합해서 앞자리부터 정렬한다.
        // ik < ki 이면  k와 i를 바꾼다.
        // 밑에서 쓰니깐 초기화 안해도 된다.
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                String ik = nums[i] + "" + nums[k];
                String ki = nums[k] + "" + nums[i];

                //Integer 로 하면 NumberFormatException
                if (Long.parseLong(ik) < Long.parseLong(ki)) {
                    int tmp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = tmp;
                }
            }
            res.append(nums[i]);
        }

        // res가 0으로 시작하면 출력이 0으로 나와야한다.
        // 00 . 000. 0000 -> 0
        if (res.charAt(0) == '0')
            return "0";

        return res.toString();
    }
}
