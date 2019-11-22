

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException
            , IllegalAccessException
            , InvocationTargetException
            , InstantiationException {

        Class reflectionClass = Reflection.class;
        Arrays.stream(reflectionClass.getDeclaredFields())
                .filter(e -> !Modifier.isPrivate(e.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(e -> System.out.println(e.getName() + " must be private!"));

        Method[] methods = reflectionClass.getDeclaredMethods();
        Field[] fields = reflectionClass.getFields();

        Arrays.stream(methods)
                .filter(e -> e.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(e -> !Modifier.isPublic(e.getModifiers()))
                .forEach(e -> System.out.println(e.getName() + " have to be public!"));

        Arrays.stream(methods)
                .filter(e -> e.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(e -> !Modifier.isPrivate(e.getModifiers()))
                .forEach(e -> System.out.println(e.getName() + " have to be private!"));
    }
}
