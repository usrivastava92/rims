package com.app.hibernate.config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;

public class HibernateUtil {

    public static byte[] hibernateCollectionPackage = "org.hibernate.collection".getBytes();

    private static final Set<Class<?>> IGNORED_TYPES = getIgnoredTypes();


    public static void initializeObject(Object o, String insidePackageName) {
        Set<Object> seenObjects = new HashSet<Object>();
        initializeObject(o, seenObjects, insidePackageName.getBytes());
        seenObjects = null;
    }

    private static void initializeObject(Object o, Set<Object> seenObjects, byte[] insidePackageName) {

        seenObjects.add(o);
        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            String methodName = method.getName();

            // check Getters exclusively
            if (methodName.length() < 3 || !"get".equals(methodName.substring(0, 3))) {
                continue;
            }

            // Getters without parameters
            if (method.getParameterTypes().length > 0) {
                continue;
            }

            int modifiers = method.getModifiers();

            // Getters that are public
            if (!Modifier.isPublic(modifiers)) {
                continue;
            }

            // but not static
            if (Modifier.isStatic(modifiers)) {
                continue;
            }

            try {

                // Check result of the Getter
                Object r = method.invoke(o);

                if (r == null) {
                    continue;
                }

                // prevent cycles
                if (seenObjects.contains(r)) {
                    continue;
                }

                // ignore simple types, arrays und anonymous classes
                if (!isIgnoredType(r.getClass()) && !r.getClass().isPrimitive() && !r.getClass().isArray() && !r.getClass().isAnonymousClass()) {

                    // ignore classes out of the given package and out of the hibernate collection
                    // package
                    if (!isClassInPackage(r.getClass(), insidePackageName) && !isClassInPackage(r.getClass(), hibernateCollectionPackage)) {
                        continue;
                    }

                    // initialize child object
                    Hibernate.initialize(r);

                    // traverse over the child object
                    initializeObject(r, seenObjects, insidePackageName);
                }

            } catch (InvocationTargetException e) {
                e.printStackTrace();
                return;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            }
        }

    }

    private static boolean isIgnoredType(Class<?> clazz) {
        return IGNORED_TYPES.contains(clazz);
    }

    private static Set<Class<?>> getIgnoredTypes() {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        ret.add(String.class);
        ret.add(Class.class);
        ret.add(Package.class);
        return ret;
    }

    private static Boolean isClassInPackage(Class<?> clazz, byte[] insidePackageName) {

        Package p = clazz.getPackage();
        if (p == null)
            return null;

        byte[] packageName = p.getName().getBytes();

        int lenP = packageName.length;
        int lenI = insidePackageName.length;

        if (lenP < lenI)
            return false;

        for (int i = 0; i < lenI; i++) {
            if (packageName[i] != insidePackageName[i])
                return false;
        }

        return true;
    }
}