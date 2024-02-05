package io.moviesondemand.projects;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Conversion {

    private Helpers helpers;

    public Conversion() {
        this.helpers = new Helpers();
    }

    public String objectToJson(Object instance, int indentSize) throws IllegalAccessException {
        List<Field> fields =
                helpers.getFieldsAndInheritedFields(new ArrayList<Field>(), instance.getClass());

        StringBuilder sb = new StringBuilder();

        sb.append(helpers.indent(indentSize));
        sb.append("{");
        sb.append("\n");

        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);

            field.setAccessible(true);
            int modifiers = field.getModifiers();

            if ((field.isSynthetic()) ||
                    ((Modifier.isStatic(modifiers)) || Modifier.isTransient(modifiers))) {
                continue;
            }

            sb.append(helpers.indent(indentSize + 1));
            sb.append(helpers.formatStringValue(field.getName()));
            sb.append(": ");

            if (field.getType().isPrimitive()) {
                sb.append(helpers.formatPrimitiveValue(field.get(instance), field.getType()));
            } else if (field.getType().equals(String.class)) {
                sb.append(helpers.formatStringValue(field.get(instance).toString()));
            } else if (field.getType().isArray()) {
                sb.append(helpers.arrayToJson(field.get(instance), indentSize + 1));
            } else {
                sb.append(objectToJson(field.get(instance), indentSize + 1));
            }

            if (i != fields.size() - 1) {
                sb.append(",");
            }

            sb.append("\n");
        }

        sb.append(helpers.indent(indentSize));
        sb.append("}");
        return sb.toString();
    }
}
