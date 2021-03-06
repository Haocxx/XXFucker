package com.haocxx.xxfucker.traversal

import com.haocxx.xxfucker.ClueManager
import com.haocxx.xxfucker.ConfigManager
import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Created by Haocxx
 * on 2021-1-18
 */
class XXFuckerTraversalClassVisitor extends ClassVisitor {

    private String mClassName

    // case is a fucker class
    private boolean mIsFuckerClass

    XXFuckerTraversalClassVisitor(ClassVisitor cv) {
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
        if (desc == "Lcom/haocxx/xxfucker/annotation/Fucker;") {
            mIsFuckerClass = true
            return super.visitAnnotation(desc, visible)
        } else {
            return super.visitAnnotation(desc, visible)
        }
    }

    @Override
    MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (((Opcodes.ACC_STATIC & access) == Opcodes.ACC_STATIC) && mIsFuckerClass) {
            return new FuckerMethodVisitor(name, super.visitMethod(access, name, desc, signature, exceptions))
        } else {
            return super.visitMethod(access, name, desc, signature, exceptions)
        }
    }

    private class FuckerMethodVisitor extends MethodVisitor {
        private String mMethodName
        private String mBitchName

        FuckerMethodVisitor(String methodName, MethodVisitor mv) {
            super(ConfigManager.ASM_API_VERSION, mv)
            mMethodName = methodName
        }

        @Override
        AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            if (desc == "Lcom/haocxx/xxfucker/annotation/Semen;") {
                return new SemenAnnotationVisitor(super.visitAnnotation(desc, visible))
            } else {
                return super.visitAnnotation(desc, visible)
            }
        }

        @Override
        void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
            super.visitLocalVariable(name, desc, signature, start, end, index)
            // this is a weird method, params is regarding as local variable, I can`t believe it
            // I have to compare names with {visitParameter} to find out true params
            List<ClueManager.SemenModel> semenList = ClueManager.mBitchNameToSemenMap.get(mBitchName)
            if (semenList != null) {
                for (ClueManager.SemenModel semenModel : semenList) {
                    if (mClassName == semenModel.className && mMethodName == semenModel.methodName) {
                        if (!semenModel.paramDescList.contains(desc)) {
                            semenModel.paramDescList.add(desc)
                        }
                    }
                }
            }
        }

        private class SemenAnnotationVisitor extends AnnotationVisitor {

            SemenAnnotationVisitor(AnnotationVisitor av) {
                super(ConfigManager.ASM_API_VERSION, av)
            }

            @Override
            void visit(String name, Object value) {
                if (name == "bitchName") {
                    String bitchName = (String) value
                    mBitchName = bitchName
                    List<ClueManager.SemenModel> semenList = ClueManager.mBitchNameToSemenMap.get(bitchName)
                    if (semenList == null) {
                        semenList = new ArrayList<>()
                        ClueManager.mBitchNameToSemenMap.put(bitchName, semenList)
                    }
                    ClueManager.SemenModel semenModel = new ClueManager.SemenModel()
                    semenModel.className = mClassName
                    semenModel.methodName = mMethodName
                    semenList.add(semenModel)
                }
                super.visit(name, value)
            }
        }
    }
}