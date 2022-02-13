package com.example.datastructor.algorithm;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GreedyAlgorithm {
    /*
     * 贪心算法:
     * 1)贪婪算法(贪心算法)是指在对问题进行求解时，
     * 在每一步选择中都采取最好或者最优(即最有利)的选择，
     * 从而希望能够导致结果是最好或者最优的算法
     * 2)贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，
     * 但是都是相对近似(接近)最优解的结果
     * 贪心算法举例:电台集合覆盖问题:
     * 假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。 如何选择最少的广播台，让所有的地区都可以接收到信号
     * 目前并没有算法可以快速计算得到准备的值， 使用贪婪算法，则可以得到非常接近的解，并且效率高。
     * 选择策略上，因为需要覆盖全部地区的最小集合:
     * 实现步骤:
     * (1)遍历所有的广播电台, 找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关系）
     * (2)将这个电台加入到一个集合中(比如ArrayList), 想办法把该电台覆盖的地区在下次比较时去掉。
     * (3)重复第1步直到覆盖了全部的地区
     * */
    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts
        //总共存在五个电台频道
        //电台频道1
        HashSet<String> broadcast1 = new HashSet<String>();
        broadcast1.add("北京");
        broadcast1.add("上海");
        broadcast1.add("天津");
        //电台频道2
        HashSet<String> broadcast2 = new HashSet<String>();
        broadcast2.add("广州");
        broadcast2.add("北京");
        broadcast2.add("深圳");
//        broadcast2.add("安徽");
        //电台频道3
        HashSet<String> broadcast3 = new HashSet<String>();
        broadcast3.add("成都");
        broadcast3.add("上海");
        broadcast3.add("杭州");
        //电台频道4
        HashSet<String> broadcast4 = new HashSet<String>();
        broadcast4.add("上海");
        broadcast4.add("天津");
        //电台频道五
        HashSet<String> broadcast5 = new HashSet<String>();
        broadcast5.add("杭州");
        broadcast5.add("大连");
        //将五个频道加入到map中
        broadcasts.put("K1", broadcast1);
        broadcasts.put("K2", broadcast2);
        broadcasts.put("K3", broadcast3);
        broadcasts.put("K4", broadcast4);
        broadcasts.put("K5", broadcast5);

        //定义一个HashSet:allAreas 存放所有的地区
        //利用HashSet的不可重复性村存储的特性
        HashSet<String> allAreas = new HashSet<String>();
        for (Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {
            allAreas.addAll(entry.getValue());
        }

        //创建一个集合ArrayList :用来存放最后选择的最佳的电台频道的集合
        List<String> selects = new ArrayList<>();

        //定义一个临时的集合,用来在遍历的时候存放电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义maxKey保存在一次遍历过程中,能够覆盖最大未覆盖的地区对应的电台的key值
        //如果每次遍历结束,maxKey不为null,则将其加入到selects中
        String maxKey = null;
        while (allAreas.size() != 0) {//若allAreas不为0,则表示还没有覆盖到所有的的区域
            //每次在进行while时,需要先将之前的maxKey重新置空,以免影响后面贪心算法的判断
            maxKey = null;
            //遍历broadcasts,取出对应的key
            for (String key : broadcasts.keySet()) {
                //在每次for循环时,需要将上一轮的tempSet置空
                tempSet.clear();
                //获取当前这个key(电台)能够覆盖的地区
                HashSet<String> ares = broadcasts.get(key);
                //将其全部加入到tempSet中
                tempSet.addAll(ares);
                //求出tempSet和allAreas的交集,交集赋值给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含未覆盖地区的数量,比maxKey指向的集合地区还要多
                //则重新将当前key设置为新的maxKey
                //其中:tempSet.size() > broadcasts.get(maxKey).size()体现了贪心算法的思想
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //一次for循环结束,若此时maxKey不为空,则将其加入到selects中
            if (maxKey != null) {
                selects.add(maxKey);
                //同时将此时maxKey指向的电台的覆盖的地区,从allAreas中去除掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }

        //while循环结束掉以后,则selects集合中保存着最后最优的电台选择策略
        System.out.println("最优的电台选择策略为:" + selects);
    }

}


