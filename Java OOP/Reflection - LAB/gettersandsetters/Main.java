

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException
            , IllegalAccessException
            , InvocationTargetException
            , InstantiationException {

        Class reflectionClass = Reflection.class;


        String getterFormat = "%s will return class %s";
        String setterFormat = "%s and will set field of class %s";

        Method[] methods = reflectionClass.getDeclaredMethods();
        Arrays.stream(methods)
                .filter(e -> e.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.println(String.format(getterFormat,e.getName(),e.getReturnType().getName())));

        Arrays.stream(methods)
                .filter(e -> e.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.println(String.format(setterFormat,e.getName(),e.getParameterTypes()[0].getName())));
    }
}
