package com.sammidev;

import java.util.*;

public class CollectionsExample {

    public static List<String> createList = Arrays.asList("sam","adit","dandi","ayatullah");
    public static Map<Integer, String> createMap() {
        Map<Integer, String> maps = new HashMap<>();
        maps.put(1,"sam");
        maps.put(2,"sammi");
        maps.put(3,"dev");
        return maps;
    }
    public static Map<Set<String>, String> createEmail() {
        Map<Set<String>, String> emailsAccount = new HashMap<>();
        emailsAccount.put(Set.of("sammidev"), "278asdgisa7");
        emailsAccount.put(Set.of("sammidev2"), "3278asdgisa7");
    return emailsAccount;
    }

    public static void print(Integer key, String val) {
        System.out.println(key + " -> " + val);
    }
    public static void printEmails(Set<String> key, String val) {
        System.out.println(key + " -> " + val);
    }

    public static void main(String[] args) {

        List<String> list = createList;
        list.forEach(System.out::println);

        Map<Integer, String> map = createMap();
        map.forEach(CollectionsExample::print);

        Map<Set<String>, String> c = createEmail();
        c.forEach(CollectionsExample::printEmails);
    }
}