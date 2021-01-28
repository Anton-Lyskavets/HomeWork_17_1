package JavaPVT.HW_17_1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        House house = new House(33, 100, 200, "BigHouse");

        getFieldsMethods(house);
        getValueFields(house);
        induceMethods(house);

        getValueFields(house);


    }

    public static void getFieldsMethods(House house) {
        System.out.println("Поля: ");
        Field[] fields = house.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("\n" + "Методы:");
        Method[] methods = house.getClass().getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    public static void getValueFields(House house) {
        System.out.println("\n" + "Поля и значения: ");
        Field[] fieldsValue = house.getClass().getDeclaredFields();
        for (Field field : fieldsValue) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + " = " + field.get(house));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void induceMethods(House house) {//+1человек у меня иногда делает сразу, а потом перезаписывает, а иногда после остальных методов
        System.out.print("\n" + "Вызываем методы и получаем,");
        Method[] methods = house.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            try {
                switch (method.getName()) {
                    case "setHouse":
                        method.invoke(house, 10, 10);
                        break;
                    case "getNameHouse":
                        System.out.println("\n" + "имя дома: " + house.getNameHouse());
                        break;
                    case "addCountPeopleOnce":
                    case "toString":
                        method.invoke(house);
                        break;
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
