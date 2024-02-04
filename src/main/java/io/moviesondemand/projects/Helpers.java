package io.moviesondemand.projects;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Helpers {

    public Helpers() {}

    public String formatPrimitiveValue(Object instance, Class<?> type) {
        if (type.equals(boolean.class)
            || type.equals(int.class)
            || type.equals(short.class)
            || type.equals(long.class)) {
            return instance.toString();
        } else if (type.equals(double.class) || type.equals(float.class)) {
            return String.format("%.02f", instance);
        }

        throw new RuntimeException(String.format("Type : %s is not supported", type.getName()));
    }

    public String formatStringValue(String inputValue) {
        return String.format("\"%s\"", inputValue);
    }

    public String indent(int indentSize) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indentSize; i++) {
            sb.append("\t");
        }

        return sb.toString();
    }

    public String arrayToJson(Object arrayObject, int indentSize) {
        StringBuilder sb = new StringBuilder();

        int length = Array.getLength(arrayObject);
        Class<?> componentType = arrayObject.getClass().getComponentType();

        sb.append("[");
        sb.append("\n");

        for (int i = 0; i < length; i++) {
            Object o = Array.get(arrayObject, i);

            if (componentType.isPrimitive()) {
                sb.append(indent(indentSize + 1));
                sb.append(formatPrimitiveValue(o, componentType));
            } else if (componentType.equals(String.class)) {
                sb.append(indent(indentSize + 1));
                sb.append(formatStringValue(o.toString()));
            }

            if (i != (length - 1)) {
                sb.append(", ");
            }
            sb.append("\n");
        }

        sb.append(indent(indentSize));
        sb.append("]");
        return sb.toString();
    }

    public List<Field> getFieldsAndInheritedFields(List<Field> fields, Class<?> clazz) {
        if (clazz.getSuperclass() != null) {
            getFieldsAndInheritedFields(fields, clazz.getSuperclass());
        }

        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        return fields;
    }
}
