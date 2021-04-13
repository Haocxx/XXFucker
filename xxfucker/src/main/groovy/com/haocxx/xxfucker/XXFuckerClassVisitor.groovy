package com.haocxx.xxfucker

import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Created by Haocxx
 * on 2021-1-18
 */
class XXFuckerClassVisitor extends ClassVisitor {

    private String mClassName

    // case is a bitch class
    private boolean mIsBitchClass
    private String mBitchName

    XXFuckerClassVisitor(ClassVisitor cv) {
        super(ConfigManager.ASM_API_VERSION, cv)
    }

    @Override
    void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        // save current visit class name
        this.mClassName = name

        super.visit(version, access, name, signature, superName, interfaces)
    }

    @Override
    AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (desc == "Lcom/haocxx/xxfucker/annotation/Bitch;") {
            mIsBitchClass = true
            return new BitchAnnotationVisitor(super.visitAnnotation(desc, visible))
        } else {
            return super.visitAnnotation(desc, visible)
        }
    }

    @Override
    MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (((Opcodes.ACC_STATIC & access) == Opcodes.ACC_STATIC) && mIsBitchClass) {
            return new BitchMethodVisitor(super.visitMethod(access, name, desc, signature, exceptions))
        } else {
            return super.visitMethod(access, name, desc, signature, exceptions)
        }
    }

    private class BitchAnnotationVisitor extends AnnotationVisitor {

        BitchAnnotationVisitor(AnnotationVisitor av) {
            super(ConfigManager.ASM_API_VERSION, av)
        }

        @Override
        void visit(String name, Object value) {
            if (name == "name") {
                mBitchName = (String) value
            }
            super.visit(name, value)
        }
    }

    private class BitchMethodVisitor extends MethodVisitor {
        private hasFucked
        private boolean mIsVaginaMethod

        BitchMethodVisitor(MethodVisitor mv) {
            super(ConfigManager.ASM_API_VERSION, mv)
        }

        @Override
        void visitCode() {
            // avoid duplicate fuck
            if (hasFucked) {
                return
            }
            hasFucked = true
            // final to do is call the method, actually with params, fucking perfect
            List<ClueManager.SemenModel> semenModels = ClueManager.mBitchNameToSemenMap.get(mBitchName)
            if (semenModels != null) {
                for (ClueManager.SemenModel model : semenModels) {
                    // do real fuck
                    StringBuilder desc = new StringBuilder()
                    for (int i = 0; i < model.paramDescList.size(); i++) {
                        String paramDesc = model.paramDescList.get(i)
                        int opcode
                        // switch param class type, to choose corresponding operation code
                        switch (paramDesc) {
                            case "I":
                                // means it`s int param
                                opcode = Opcodes.ILOAD
                                break
                            case "L":
                                // means it`s long param
                                opcode = Opcodes.LLOAD
                                break
                            case "F":
                                // means it`s float param
                                opcode = Opcodes.FLOAD
                                break
                            case "D":
                                // means it`s double param
                                opcode = Opcodes.DLOAD
                                break
                            default:
                                // means it`s any other kind of param
                                if (paramDesc.startsWith("L")) {
                                    opcode = Opcodes.ALOAD
                                } else {
                                    opcode = Opcodes.ILOAD
                                }
                        }
                        visitVarInsn(opcode, i)
                        desc.append(paramDesc)
                    }
                    String className = model.className
                    String methodName = model.methodName
                    visitMethodInsn(Opcodes.INVOKESTATIC, className, methodName, "(" + desc.toString() + ")V", false)
                }
            }
            super.visitCode()
        }

        @Override
        AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            if (desc == "Lcom/haocxx/xxfucker/annotation/Vagina;") {
                mIsVaginaMethod = true
            }
            return super.visitAnnotation(desc, visible)
        }
    }
}