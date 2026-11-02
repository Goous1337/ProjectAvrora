package utils;

import java.util.Random;

public class RandomDataGenerator {

    // Для генерации случайных чисел
    private static final Random RANDOM = new Random();

    // Наборы данных для имен, фамилий, департаментов
    private static final String[] FIRST_NAMES = {"Ivan", "Alex", "Maria", "John", "Elena", "Dmitry", "Anna", "Max"};
    private static final String[] LAST_NAMES = {"Ivanov", "Smirnov", "Johnson", "Petrova", "Sidorov", "Kuznetsova", "Lee"};
    private static final String[] DEPARTMENTS = {"QA", "Development", "DevOps", "HR", "Sales", "Marketing", "Support"};

    // Утилитарный класс — нельзя создать экземпляр
    private RandomDataGenerator() {}

    // 1. Генерация имени
    public static String getFirstName() {
        return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    }

    // 2. Генерация фамилии
    public static String getLastName() {
        return LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
    }

    // 3. Генерация email (на основе имени и времени, чтобы был уникальным)
    public static String getEmail() {
        return getFirstName().toLowerCase() + "_" + System.currentTimeMillis() + "@test.com";
    }

    // 4. Генерация возраста (от 18 до 130 включительно)
    public static int getAge() {
        return RANDOM.nextInt(130 - 18 + 1) + 18;
    }

    // 5. Генерация зарплаты (например, от 30000 до 200000)
    public static int getSalary() {
        return RANDOM.nextInt(200000 - 30000 + 1) + 30000;
    }

    // 6. Генерация названия департамента
    public static String getDepartment() {
        return DEPARTMENTS[RANDOM.nextInt(DEPARTMENTS.length)];
    }

    // 7. (Опционально) Генерация уникального userName для API
    public static String getUniqueUsername() {
        return "user_" + System.currentTimeMillis();
    }


}
