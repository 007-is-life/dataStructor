package com.example.datastructor.test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;

public class Test2 {
    private static String apply(String x) {
        return x + "字符串";
    }

    @Test
    public void test() {
        Stack<String> stack = new Stack<>();
        stack.push("刘一");
        stack.push("陈二");
        stack.push("张三");
        stack.push("李四");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.search("刘一"));
//        System.out.println(stack.pop());
    }

    @Test
    public void test2() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("刘一");
        hashSet.add("陈二");
//        new TreeSet<>();
//        new SortedSet<>();
//        new Deque<>();
//        new ArrayDeque<>();
//        new PriorityQueue<>();
    }

    private Integer b = null;
    private Integer c;
    @Test
    public void test3() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Iterator<Integer> iterator = stack.iterator();

        if (iterator.hasNext()) {
            iterator.remove();
        }
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

    }

    @Test
    public void test4() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        Iterator<Integer> iterator = a.iterator();
    }

    @Test
    public void test5() {
        String[][] arr = {{".Q..","...Q"},{".Q..","Q..."}};
        System.out.println(Arrays.deepToString(arr));
        int[][] a = {{1,2,3},{1,2,3}};
        System.out.println(Arrays.deepToString(a));
//        System.out.println(Arrays.toString(a));
        int[] b = {1, 2, 3, 4};
//        System.out.println(Arrays.toString(b));
        System.out.println(new String(Arrays.toString(b)));
        int[] c = new int[3];
        Arrays.fill(c, 1);
        System.out.println(Arrays.toString(c));
        String[] d = new String[3];
        Arrays.fill(d,"abc");
        System.out.println(Arrays.toString(d));

    }

    @Test
    public void test6() {
        ArrayList<String> board = new ArrayList<>();
        char[] row = new char[4];
        Arrays.fill(row, '.');
        row[2] = 'Q';
//        System.out.println(Arrays.toString(row));
//        System.out.println(row);
        board.add(new String(row));
        board.add(new String(row));
        System.out.println(board);
        System.out.println(new String(row));
        ArrayList<String> board2 = new ArrayList<>();
        board2.add(String.valueOf(board));
        board2.add(String.valueOf(board));
        System.out.println(board2);
        System.out.println(String.valueOf(board));
    }


    @Test
    public void test7() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random()*10));
        }
        list.stream().filter(x -> x > 2)
                .map(x -> x * 10)
                .forEach(x -> System.out.printf("%d ", x));
    }

    @Test
    public void test8() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"--普通方法");
            }
        };
        Runnable runnable1 = () -> System.out.println(Thread.currentThread().getName() + "--lambda");
        Runnable runnable2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };
        runnable.run();
        runnable1.run();
        runnable2.run();
    }

    @Test
    public void test9() {
        Consumer<String> consumer = (x) -> System.out.println("shi name is" + x);
        Consumer<String> consumer1 = System.out::println;
        consumer.accept("xixi");
        consumer1.accept("张三");

        Supplier<String> supplier = () -> String.valueOf(10/2);
        Supplier<String> supplier2 = () -> {
            return String.valueOf(10 / 2);
        };
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return String.valueOf(10 / 3);
            }
        };
        System.out.println(supplier1.get());
        System.out.println(supplier.get());

//        Comparator<Integer> comparator = Integer::compareTo;
//        System.out.println(comparator.compare(2, 3));

        ToIntFunction<String> function = (x) -> {
            System.out.println(x);
            return Integer.parseInt(x);
        };
        System.out.println(function.applyAsInt("123"));

        Function<Integer,Integer> function1 = (x) -> {
            if (x == 2) {
                return x * 10;
            } else {
                return 1;
            }
        };

        System.out.println(function1.apply(2));

        Predicate<Integer> predicate = x -> x>2;
        System.out.println(predicate.test(3));
    }

    @Test
    public void test10() {
        IntConsumer intConsumer = System.out::println;
        intConsumer.accept(10);

        ObjDoubleConsumer<String> objDoubleConsumer = (x,y) -> {
            if (x.equals(String.valueOf(y))) {
                System.out.println(1);
            }
        };
        objDoubleConsumer.accept("12",12);

        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println(binaryOperator.apply(1, 2));

        UnaryOperator<String> unaryOperator = Test2::apply;
        System.out.println(unaryOperator.apply("abc"));

        Comparator<Integer> comparator = Integer::compareTo;
        System.out.println(comparator.compare(1, 2));
    }

    @Test
    public void test11() {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("第" + i + "个值", new Random().nextInt(10));
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);
        Collection<Integer> values = map.values();
        System.out.println(values);
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
    }

    @Test
    public void test12() {
        int[] arr = {11, 55, 44, 20, 45, 16};
        Arrays.stream(arr).sorted().forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        Arrays.stream(arr).skip(2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        Arrays.stream(arr).distinct().forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        Arrays.stream(arr).limit(2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        Arrays.stream(arr).skip(2).filter(x -> x > 40).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        final int[] sum = {0};
        Arrays.stream(arr).map(x -> sum[0] += x);

    }
}
