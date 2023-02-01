package org.zeral.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    /**
     * 二分查找
     * 通过 lo 和 hi 区间中的中间值和待查找的值比较确定二分区间，并相应缩小范围，直到找到待查找的值
     *
     * @param key 要查找的值
     * @param a 排序好的数组
     * @return 查找到的数据索引
     */
    public static int binarySearch(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        // 直到二分到相同位置元素结束
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1; // 防止两数相加类型溢出，右移位相当于除2，但是避免符号位变化
            // 不支持右移的语言可以换如下写法
            // int mid = lo + (hi - lo) / 2;

            int midVal = a[mid];

            if (key < midVal) hi = mid - 1;
            else if (key > midVal) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    @Test
    public void test() {
        Assertions.assertEquals( 2, binarySearch(1, new int[]{-1, 0, 1, 2, 3}));
        Assertions.assertEquals(2, Arrays.binarySearch(new int[]{-1, 0, 1, 2, 3}, 1));
    }

}
