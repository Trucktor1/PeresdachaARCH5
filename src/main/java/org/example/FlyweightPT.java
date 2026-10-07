package org.example;

import java.util.*;

class TreeType {
    private String name;
    private String color;
    private String texture;

    TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    void draw(int x, int y) {
        System.out.println("Дерево " + name + " (" + color + ") на (" + x + "," + y + ")");
    }
}

class TreeFactory {
    private static Map<String, TreeType> cache = new HashMap<>();

    static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;
        return cache.computeIfAbsent(key, k -> new TreeType(name, color, texture));
    }
}

class Tree {
    private int x, y;
    private TreeType type;

    Tree(int x, int y, TreeType type) {
        this.x = x; this.y = y; this.type = type;
    }

    void draw() { type.draw(x, y); }
}

public class FlyweightPT {
    public static void main(String[] args) {
        TreeType oak = TreeFactory.getTreeType("Дуб", "Зелёный", "Кора1");
        TreeType oak2 = TreeFactory.getTreeType("Дуб", "Зелёный", "Кора1");
        System.out.println("Один и тот же объект? " + (oak == oak2));

        new Tree(10, 20, oak).draw();
        new Tree(30, 40, oak2).draw();
    }
}
