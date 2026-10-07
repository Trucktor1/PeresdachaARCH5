package org.example;

interface Color {
    String fill();
}

class Red implements Color {
    public String fill() { return "красный"; }
}

class Blue implements Color {
    public String fill() { return "синий"; }
}

abstract class Shape {
    protected Color color;
    Shape(Color color) { this.color = color; }
    abstract void draw();
}

class Circle extends Shape {
    Circle(Color color) { super(color); }
    public void draw() {
        System.out.println("Круг залит " + color.fill() + " цветом");
    }
}

class Square extends Shape {
    Square(Color color) { super(color); }
    public void draw() {
        System.out.println("Квадрат залит " + color.fill() + " цветом");
    }
}


public class BridgePT {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        Shape blueSquare = new Square(new Blue());
        redCircle.draw();
        blueSquare.draw();
    }
}
