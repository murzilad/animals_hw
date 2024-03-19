package animals;

import animals.utils.Validation;

import java.util.Scanner;

public abstract class Animal {

    private String name;
    private int age;
    private float weight;
    private String color;
    private Scanner scanner = null;
    private Validation validation = new Validation();

    public Animal(Scanner scanner) {
        this.scanner = scanner;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }


    public void setName() {
        String name = "";
        while (true) {
            System.out.println("Введите имя животного");
            name = scanner.next().trim();
            if (validation.isChars(name)) {
                break;
            }
            System.out.println("Неверное имя животного");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge() {

        String age = "";
        while (true) {
            System.out.printf("Введите возраст животного\n");
            age = scanner.next().trim();
            if (validation.isNumber(age) && Integer.parseInt(age) > 0 && age.length() <= 6) { //валидация + проверка на отриц значение и ограничение на ввод не больше 6 символов
                break;
            }
            System.out.println("Введен неверный возраст животного");
        }
        this.age = Integer.parseInt(age);
    }

    public int getAge() {
        return age;
    }

    public void setWeight() {

        String weight = "";
        while (true) {
            System.out.printf("Введите вес животного\n");
            weight = scanner.next().trim();
            if (validation.isNumber(weight) && Float.parseFloat(weight) > 0 && weight.length() <= 6) { //валидация + проверка на отриц значение и ограничение на ввод не больше 6 символов
                break;
            }
            System.out.println("Введен неверный вес животного");
        }

        this.weight = Float.parseFloat(weight);
    }

    public float getWeight() {
        return weight;
    }

    public void setColor() {

        String color = "";
        while (true) {
            System.out.printf("Введите цвет животного\n");
            color = scanner.next().trim();
            if (validation.isChars(color)) {
                break;
            }
            System.out.println("Введен несуществующий цвет животного");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %.2f кг, мой цвет - %s", name, age, getPadej(age), weight, color);
    }

    public String getPadej(int age) {

        int remainder = age % 10;

        if (age >= 11 && age <= 14) {
            return "лет";
        }

        if (remainder == 1 && age < 110) {
            return "год";
        }
        if (remainder >= 5) {
            return "лет";
        }
        if (remainder >= 2) {
            return "года";
        }
        return "лет";

    }
}
