package com.george.hot100;

public class maxArea_11 {
    public static void main(String[] args) {

        int[] arr = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea_001(arr));
        System.out.println(maxArea_002(arr));
    }

    public static int maxArea_001(int[] height) {

        if (height.length == 0) return 0;
        if (height.length == 1) return height[0];

        int max = 0;

        for (int right = 0; right < height.length; right++) {
            for (int left = right + 1; left < height.length; left++) {
                int high = Math.min(height[right], height[left]);
                int wide = left - right;
                if ( high * wide >= max){
                    max = high * wide;
                }
                //System.out.println("right" + " = " + right + " left" + " = " + left + " wide" + " = " + wide + " max " + " = " + max);
            }
        }
        return max;
    }


    public static int maxArea_002(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = (Math.min(height[left], height[right])) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return ans;
    }

}
