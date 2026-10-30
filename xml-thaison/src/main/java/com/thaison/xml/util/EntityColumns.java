package com.thaison.xml.util;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** Reads the {@code @Column} fields declared on an entity, in declaration order. */
public final class EntityColumns {

    private EntityColumns() {
    }

    public static List<Field> of(Class<?> entityClass, Set<String> excludedFieldNames) {
        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .filter(f -> !excludedFieldNames.contains(f.getName()))
                .peek(f -> f.setAccessible(true))
                .collect(Collectors.toList());
    }

    public static String label(Field field) {
        return field.getAnnotation(Column.class).name();
    }

    public static Object value(Field field, Object entity) {
        try {
            return entity == null ? null : field.get(entity);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
