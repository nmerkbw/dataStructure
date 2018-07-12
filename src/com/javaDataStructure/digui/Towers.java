package com.javaDataStructure.digui;

import org.junit.Test;

public class Towers {

    /**
     * 算法可以简单分为三个步骤：
     * （1）把n-1个盘子由A 移到 B；
     * （2）把第n个盘子由 A移到 C；
     * （3）把n-1个盘子由B 移到 C；
     *
     * 移到的步数必定为奇数步：
     * （1）中间的一步是把最大的一个盘子由A移到C上去；
     * （2）中间一步之上可以看成把A上n-1个盘子通过借助辅助塔（C塔）移到了B上，
     * （3）中间一步之下可以看成把B上n-1个盘子通过借助辅助塔（A塔）移到了C上；
     * */
    public void doTowers(int topN, char from, char temp, char to) {

        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, temp);// from(A)-->temp(B),借助C将A上1~n-1的圆盘移动到B
            move(topN, from, to);// 将A上编号为n的圆盘移动到C上
            doTowers(topN - 1, temp, from, to);// temp(B)-->to(C)，借助A将B上1~n-1的圆盘移动到C
        }
    }

    private void move(int topN, char from, char to) {

        System.out.println("Disk " + topN + " from " + from + " to " + to);
    }

    @Test
    public void test() {

        doTowers(3, 'A', 'B', 'C');
    }
}
