package com.stone.asm.part1;


import org.objectweb.asm.*;

import java.io.IOException;

import static groovyjarjarasm.asm.Opcodes.ASM6;
import static org.objectweb.asm.Opcodes.*;

/**
 * 打印类的各个信息
 *
 * @author stone
 * @version 1.0
 * @date 2020/9/2 17:31
 */
public class ClassPrinter extends ClassVisitor {
    public ClassPrinter() {
        super(ASM6);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        System.out.println(name + " extentds " + superName + "{");
    }

    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
    }

    @Override
    public void visitOuterClass(String owner, String name, String descriptor) {
        super.visitOuterClass(owner, name, descriptor);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        return super.visitAnnotation(descriptor, visible);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        super.visitAttribute(attribute);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        super.visitInnerClass(name, outerName, innerName, access);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println("    " + descriptor + " " + name);
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("    " + name + " " + descriptor);
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        System.out.println("}");
    }

    public static void main(String[] args) {
        try {
            // step1: create ClassVisitor
            ClassPrinter cp = new ClassPrinter();
            // step2: create ClassReader
            ClassReader cr = new ClassReader("java.lang.Runnable");
            // step3:  visitor visit the JVMS ClassFile structure
            cr.accept(cp,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
