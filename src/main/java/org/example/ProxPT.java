package org.example;

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Загрузка " + filename + " с диска...");
    }

    public void display() {
        System.out.println("Отображение " + filename);
    }
}

class ImageProxy implements Image {
    private String filename;
    private RealImage realImage;

    ImageProxy(String filename) { this.filename = filename; }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxPT {
    public static void main(String[] args) {
        Image image = new ImageProxy("photo.jpg");
        System.out.println("Объект создан, но изображение не загружено");
        image.display();
        image.display();
    }
}
