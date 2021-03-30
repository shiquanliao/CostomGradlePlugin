package com.stone.asm.part1;


import org.apache.tools.ant.taskdefs.Classloader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.*;

/**
 * TODO
 *
 * @author stone
 * @version 1.0
 * @date 2020/9/7 10:17
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineClass(String name, byte[] b){
        return defineClass(name, b, 0, b.length);
    }

    public static byte[] testGenerateClass(){
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable", null, "java/lang/Object",
                new String[] { "pkg/Mesurable" });
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        return cw.toByteArray();
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.defineClass("pkg.Comparable", testGenerateClass());

    }
}
