package com.haocxx.xxfucker.traversal

import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.gradle.internal.pipeline.TransformManager

/**
 * Created by Haocxx
 * on 2021-1-15
 */
class XXFuckerTraversalTransform extends Transform {

    @Override
    String getName() {
        return "XXFuckerTraversalTransform"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }
}