package com.haocxx.xxfucker

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes

/**
 * Created by Haocxx
 * on 2021-1-18
 */
class XXFuckerClassVisitor extends ClassVisitor {

    private String mClassName

    XXFuckerClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv)
    }

    @Override
    void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        // save current visit class name
        this.mClassName = name

        super.visit(version, access, name, signature, superName, interfaces)
    }
}