package com.lilhui.leecode;

import java.util.Arrays;

/**
 *
 * 238.除自身以外数组的乘积
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/09/01 22:35
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int beforeSum=1;
        int afterSum=1;
        for(int i=0,j=n-1;i<n;i++,j--){
            ans[i]*=beforeSum;
            ans[j]*=afterSum;
            beforeSum*=nums[i];
            afterSum*=nums[j];
        }
        return ans;
    }
}
