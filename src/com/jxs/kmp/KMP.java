package com.jxs.kmp;

public class KMP {

    // next回溯数组的生成
    public static void calNext(char[] chars, int[] next, int len) {

        // next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        next[0] = -1;
        //k初始化为-1，k值为相同字符的数目，0个相同记为-1，1个相同记为0
        int k = -1;
        for (int q = 1; q < len; q++) {
            // 如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
            while (k > -1 && chars[k + 1] != chars[q]) {
                // 往前回溯
                k = next[k];
            }
            if (chars[k + 1] == chars[q]) {
                // 如果相同，k++
                k += 1;
            }
            // 这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
            next[q] = k;
        }
    }

    public static int kmp(char[] strsArray, int sLen, char[] ptr, int pLen) {

        int[] next = new int[pLen];
        //计算next数组
        calNext(ptr,next,pLen);
        int k = -1;
        for (int i = 0; i < sLen; i++) {
            //ptr和strsArray不匹配，且k>-1（表示ptr和strsArray有部分匹配）
            while (k > -1 && ptr[k + 1] != strsArray[i]) {
                // 往前回溯
                k = next[k];
            }
            if (ptr[k + 1] == strsArray[i]) {
                // 说明k移动到ptr的最末端
                k += 1;
            }
            if (k == pLen - 1) {
                // 返回相应的位置
                return i - pLen + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String str = "bacbababadababacambabacaddababacasdsd";
        String subStr = "ababaca";
        char[] strArray = str.toCharArray();
        char[] subStrArray = subStr.toCharArray();
        int a = kmp(strArray, 36, subStrArray, 7);
        System.out.println(a);
    }
}
