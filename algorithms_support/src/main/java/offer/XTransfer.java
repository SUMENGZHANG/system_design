package offer;

import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.Array;
import java.util.*;

public class XTransfer {

    // 给定一个数组，找出三个数相加为0的所有不重复的集合
    public static void main(String[] args) {
        List<List<Integer>> list  = new ArrayList<>();

        int []arr = {1,2,3,4,5,-1,-2,-3};
        // sort
        Arrays.sort(arr);
        int len = arr.length;
        for(int i = 0;i<len;i++){
            int target = -arr[i];
            List<Integer> curList = new ArrayList<>();
            // binary
            int left = i+1;
            int right = len-1;
            while(left<right){
                if(arr[left]+arr[right]==target){
                    curList.add(arr[left]);
                    curList.add(arr[right]);
                    curList.add(arr[i]);
                    list.add(curList);
                    left++;
                    right--;
                }else if(arr[left]+arr[right]<target){
                    left++;
                }else if(arr[left]+arr[right]>target){
                    right++;
                }
            }
        }
        // list为所得
        int size  = list.size();

        for(int i = 0;i<size;i++){
            List<Integer> curList = list.get(i);
            for(int j = 0;j<curList.size();j++) {
                System.out.print(curList.get(j));
            }

        }

    }
}
