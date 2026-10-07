package org.example;

class CPU {
    void start() { System.out.println("CPU запущен"); }
}

class Memory {
    void load() { System.out.println("Память загружена"); }
}

class HardDrive {
    void read() { System.out.println("Чтение с диска"); }
}

class ComputerFacade {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hdd = new HardDrive();

    void start() {
        System.out.println("Запуск компьютера");
        cpu.start();
        memory.load();
        hdd.read();
        System.out.println("Компьютер готов");
    }
}

public class FacadePT {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
