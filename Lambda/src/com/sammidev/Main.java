package com.sammidev;
import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // consumer -> void
        Consumer<String> consumer = value -> System.out.println(value.toUpperCase());
        Consumer<Object> consumer2 = System.out::println;
        consumer.accept("sammidev");
        consumer2.accept(true);

        // BiConsumer -> void
        BiConsumer<Integer,Integer> adding   = (a, b) -> System.out.println(a+b);
        BiConsumer<Integer,Integer> multiply = (a, b) -> System.out.println(a*b);
        BiConsumer<Integer,Integer> modulo   = (a, b) -> System.out.println(a%b);

        // BinaryOperator -> depending on the argument (!void)
        BinaryOperator<String> binaryOperator = (s, s2) -> s.toUpperCase() + " " + s2.toUpperCase();
        System.out.println(binaryOperator.apply("Sammi","Aldhi Yanto"));

        // Function -> depending on the argument (!void)
        Function<String, Integer> function = String::length;
        Function<String, Integer> function2 = String::hashCode;
        Function<Boolean, Integer> function3 = value -> 1;

        Integer length = function.apply("sammidev");
        Integer hashcode = function2.apply("sammidev");
        Integer status2 = function3.apply(true);
        System.out.println(length);
        System.out.println(hashcode);
        System.out.println(status2);

        // BiFunction
        // @param 1 -> input
        // @param 2 -> input
        // @param 3 -> output
        BiFunction<String,String,String> fullname = (o, o2) -> o + " " +  o2;

        // Predicate -> return Boolean
        Predicate<Integer> predicate = value -> value == 4;
        Predicate<String> predicate2 = StringUtil::isLowerCase;
        System.out.println(predicate.test(4));
        System.out.println(predicate2.test("sammidev"));

        // Predicate with double arguments
        BiPredicate<String, String> authentication = (s, s2)
                -> s.equalsIgnoreCase("sammidev") && s2.equalsIgnoreCase("sammidev");

        // Supplier -> depending on the argument (!void)
        Supplier<String> supplier = () -> "Sammi ganteng";
        System.out.println(supplier.get());

        StringUtil stringUtil = new StringUtil();
        Predicate<String> predicate1 = stringUtil::isUpperCase;
        System.out.println(predicate1.test("SAMMIDEV"));

        Function<String,String> function1 = String::toLowerCase;
        Function<String,String> function21 = String::toLowerCase;

        List<String> names = Arrays.asList("sammmidev","Dev","Sammi");
        names.forEach(System.out::println);
        names.removeIf(s -> s.length() > 5);

        Map<Integer,String> maps = new HashMap<>();
        maps.put(1,"sammidev");
        maps.put(2,"sammidev2");
        maps.put(3,"sammide3");
        maps.forEach((key,val) -> System.out.println(key + " : " + val));

        // LAZY
        testScore(100, Main::getName);

        // OPTIONAL
        sayHello("sammidev");
        sayHello(null);
    }

    private static void sayHello(String name) {
        String upperName = Optional.ofNullable(name)
                .map(value -> value.toUpperCase())
                .orElseGet(() -> "");
        System.out.println(upperName);
    }

    static void testScore(Integer score, Supplier<String> name) {
        if (score > 80) System.out.println("SELAMAT " + name.get() + " ANDA LULUS");
        else System.out.println("ULANG TAHUN DEPAN YA");
    }
    static String getName() {
        System.out.println("Getname() dipanggil");
        return "Sammidev";
    }
}

class StringUtil {
    static boolean isLowerCase(String value) {
        for (char i : value.toCharArray()) {
            if (!Character.isLowerCase(i)) return false;
        }
        return true;
     }

    // for non static context
    Predicate<String> predicate3 = this::isUpperCase;
    boolean isUpperCase(String value) {
        for (char i : value.toCharArray()) {
            if (!Character.isUpperCase(i)) return false;
        }
        return true;
    }
}