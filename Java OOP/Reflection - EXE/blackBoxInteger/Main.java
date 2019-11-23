package javaoopexe.blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException
            , NoSuchMethodException
            , IllegalAccessException
            , InvocationTargetException
            , InstantiationException
            , NoSuchFieldException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class peshoClass = BlackBoxInt.class;


        Constructor constructor = peshoClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();
        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();

        Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);


        String input;
        while (!"END".equals(input = reader.readLine())){
            String[] data = input.split("_");
            String command = data[0];
            int value = Integer.parseInt(data[1]);

            invokeMethod(methods,command,value,blackBoxInt);

            System.out.println(field.getInt(blackBoxInt));

        }

    }

    static void invokeMethod(Method[] methods, String command, int value, BlackBoxInt blackBoxInt) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            if (method.getName().equals(command)){
                method.setAccessible(true);
                method.invoke(blackBoxInt,value);
                break;

            }
        }
    }

}
