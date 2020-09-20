package lab.collection;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SpaceMarineGenerator {

    public static SpaceMarine generate() {
        SpaceMarine spaceMarine = null;
        try {
            Scanner scanner = new Scanner(System.in);
            String name;
            do {
                System.out.println("Введите имя SpaceMarin:");
                name = scanner.nextLine();
            } while (name.isEmpty());
            Double x = null;
            do {
                System.out.println("Введите координату X:");
                try {
                    x = Double.valueOf(scanner.nextLine());
                    if (x <= -449) {
                        System.out.println("Число должно быть больше -449");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                }
            } while (x == null || x <= -449);
            float y;
            while (true) {
                System.out.println("Введите координату Y:");
                try {
                    y = Float.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                    continue;
                }
                break;
            }
            Float health = null;
            while (true) {
                System.out.println("Введите поле health (для ввода null используйте пустую строку):");
                try {
                    String string = scanner.nextLine();
                    if (string.isEmpty()) break;
                    health = Float.valueOf(string);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                    continue;
                }
                break;
            }
            AstartesCategory category = null;
            while (true) {
                System.out.println("Введите поле Astarte's Category (для ввода null используйте пустую строку).");
                System.out.println("Доступные варианты:");
                for (AstartesCategory category1 : AstartesCategory.values()) System.out.println(category1.toString());
                try {
                    String string = scanner.nextLine();
                    if (string.isEmpty()) break;
                    category = AstartesCategory.valueOf(string);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ввода ввода");
                    continue;
                }
                break;
            }
            Weapon weapon;
            while (true) {
                System.out.println("Введите поле Weapon Type");
                System.out.println("Доступные варианты:");
                for (Weapon weapon1 : Weapon.values()) System.out.println(weapon1.toString());
                try {
                    String string = scanner.nextLine();
                    weapon = Weapon.valueOf(string);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка ввода");
                    continue;
                }
                break;
            }
            MeleeWeapon meleeWeapon = null;
            while (true) {
                System.out.println("Введите поле Melee Weapon (для ввода null используйте пустую строку).");
                System.out.println("Доступные варианты:");
                for (MeleeWeapon meleeWeapon1 : MeleeWeapon.values()) System.out.println(meleeWeapon1.toString());
                try {
                    String string = scanner.nextLine();
                    if (string.isEmpty()) break;
                    meleeWeapon = MeleeWeapon.valueOf(string);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ввода ввода");
                    continue;
                }
                break;
            }
            String chapterName = "";
            do {
                System.out.println("Введите имя Chapter:");
                chapterName = scanner.nextLine();
            } while (chapterName.isEmpty());

            Long marinesCount = null;
            do {
                System.out.println("Введите поле MarinesCount:");
                try {
                    marinesCount = Long.valueOf(scanner.nextLine());
                    if (marinesCount <= 0 || marinesCount > 1000) {
                        System.out.println("Значение поля должно быть больше 0, Максимальное значение поля: 1000");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                }
            } while (marinesCount == null || marinesCount <= 0 || marinesCount > 1000);
            String world = "";
            do {
                System.out.println("Введите поле world:");
                world = scanner.nextLine();
            } while (world.isEmpty());

            Coordinates coordinates = new Coordinates(x, y);
            Chapter chapter = new Chapter(chapterName, marinesCount, world);
            spaceMarine = new SpaceMarine(0, name, coordinates, LocalDateTime.now(), health, category, weapon, meleeWeapon, chapter);
        } catch (NoSuchElementException e) {
            System.out.println("Ввод был завершён...");
        }
        return spaceMarine;
    }

    public static SpaceMarine generate(SpaceMarine spaceMarine) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (spaceMarine.getName() == null) {
                String name;
                do {
                    System.out.println("Введите имя SpaceMarin:");
                    name = scanner.nextLine();
                } while (name.isEmpty());
                spaceMarine.setName(name);
            }
            if (spaceMarine.getCoordinates() == null || spaceMarine.getCoordinates().getX() == null ||
                    spaceMarine.getCoordinates().getY() == null || spaceMarine.getCoordinates().getX() <= -499) {
                Double x = null;
                do {
                    System.out.println("Введите координату X:");
                    try {
                        x = Double.valueOf(scanner.nextLine());
                        if (x <= -449) {
                            System.out.println("Число должно быть больше -449");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа");
                    }
                } while (x == null || x <= -449);
                float y;
                while (true) {
                    System.out.println("Введите координату Y:");
                    try {
                        y = Float.valueOf(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа");
                        continue;
                    }
                    break;
                }
                spaceMarine.setCoordinates(new Coordinates(x, y));
            }
            if (spaceMarine.getHealth() != null && spaceMarine.getHealth() <= 0) {
                Float health = null;
                while (true) {
                    System.out.println("Введите поле health (для ввода null используйте пустую строку):");
                    try {
                        String string = scanner.nextLine();
                        if (string.isEmpty()) break;
                        health = Float.valueOf(string);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа");
                        continue;
                    }
                    break;
                }
                spaceMarine.setHealth(health);
            }
            if (spaceMarine.getWeaponType() == null) {
                Weapon weapon;
                while (true) {
                    System.out.println("Введите поле Weapon Type");
                    System.out.println("Доступные варианты:");
                    for (Weapon weapon1 : Weapon.values()) System.out.println(weapon1.toString());
                    try {
                        String string = scanner.nextLine();
                        weapon = Weapon.valueOf(string);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка ввода");
                        continue;
                    }
                    break;
                }
                spaceMarine.setWeaponType(weapon);
            }
            if (spaceMarine.getChapter() == null)
                spaceMarine.setChapter(new Chapter());
            if (spaceMarine.getChapter().getName() == null || spaceMarine.getChapter().getName().isEmpty()) {
                String chapterName = "";
                do {
                    System.out.println("Введите имя Chapter:");
                    chapterName = scanner.nextLine();
                } while (chapterName.isEmpty());
                spaceMarine.getChapter().setName(chapterName);
            }
            if (spaceMarine.getChapter().getMarinesCount() == null || spaceMarine.getChapter().getMarinesCount() > 1000 ||
                    spaceMarine.getChapter().getMarinesCount() <= 0) {
                Long marinesCount = null;
                do {
                    System.out.println("Введите поле MarinesCount:");
                    try {
                        marinesCount = Long.valueOf(scanner.nextLine());
                        if (marinesCount <= 0 || marinesCount > 1000) {
                            System.out.println("Значение поля должно быть больше 0, Максимальное значение поля: 1000");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа");
                    }
                } while (marinesCount == null || marinesCount <= 0 || marinesCount > 1000);
                spaceMarine.getChapter().setMarinesCount(marinesCount);
            }
            if (spaceMarine.getChapter().getWorld() == null || spaceMarine.getChapter().getWorld().isEmpty()) {
                String world = "";
                do {
                    System.out.println("Введите поле world:");
                    world = scanner.nextLine();
                } while (world.isEmpty());
                spaceMarine.getChapter().setWorld(world);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Ввод был завершён...");
        }
        return spaceMarine;
    }

    public static boolean checkSpaceMarine(SpaceMarine spaceMarine) {
        boolean status = true;
        if (spaceMarine.getName() == null || spaceMarine.getName().isEmpty()) {
            System.out.println("SpaceMarine Name не может быть null или пустым");
            status = false;
        }
        if (spaceMarine.getCoordinates() == null || spaceMarine.getCoordinates().getX() == null ||
                spaceMarine.getCoordinates().getY() == null || spaceMarine.getCoordinates().getX() <= -499) {
            System.out.println("SpaceMarine Coordinates не может быть null, x > -499");
            status = false;
        }
        if (spaceMarine.getHealth() != null && spaceMarine.getHealth() <= 0) {
            System.out.println("SpaceMarine Health не может быть null, Health > 0");
            status = false;
        }
        if (spaceMarine.getWeaponType() == null) {
            System.out.println("SpaceMarine WeaponType не может быть null");
            status = false;
        }
        if (spaceMarine.getChapter() == null) {
            System.out.println("SpaceMarine Chapter не может быть null");
            status = false;
        } else {
            if (spaceMarine.getChapter().getName() == null || spaceMarine.getChapter().getName().isEmpty()) {
                System.out.println("SpaceMarine Chapter's Name не может быть null или пустым");
                status = false;
            }
            if (spaceMarine.getChapter().getMarinesCount() == null || spaceMarine.getChapter().getMarinesCount() > 1000 ||
                    spaceMarine.getChapter().getMarinesCount() <= 0) {
                System.out.println("SpaceMarine Chapter's MarinesCount не может быть null, 0 < MarinesCount <=1000");
                status = false;
            }
            if (spaceMarine.getChapter().getWorld() == null || spaceMarine.getChapter().getWorld().isEmpty()) {
                System.out.println("SpaceMarine Chapter's World не может быть null или пустым");
                status = false;
            }
        }
        return status;
    }

}
