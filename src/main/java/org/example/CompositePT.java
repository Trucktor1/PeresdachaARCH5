package org.example;

import java.util.*;

interface FileSystemItem {
    void show(String indent);
}

class FileItem implements FileSystemItem {
    private String name;
    FileItem(String name) { this.name = name; }

    public void show(String indent) {
        System.out.println(indent + "[Файл] " + name);
    }
}

class FolderItem implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();

    FolderItem(String name) { this.name = name; }

    void add(FileSystemItem item) { children.add(item); }

    public void show(String indent) {
        System.out.println(indent + "[Папка] " + name);
        for (FileSystemItem child : children) {
            child.show(indent + "   ");
        }
    }
}


public class CompositePT {
    public static void main(String[] args) {
        FolderItem root = new FolderItem("root");
        FolderItem src = new FolderItem("src");
        src.add(new FileItem("Main.java"));
        src.add(new FileItem("Utils.java"));

        root.add(src);
        root.add(new FileItem("README.md"));

        root.show("");
    }
}
