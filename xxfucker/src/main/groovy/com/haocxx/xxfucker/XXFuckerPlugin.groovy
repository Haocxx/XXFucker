package com.haocxx.xxfucker

import com.android.build.gradle.AppExtension
import com.haocxx.xxfucker.traversal.XXFuckerTraversalTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Haocxx
 * on 2021-1-15
 */
class XXFuckerPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        // registerTransform
        def android = project.extensions.getByType(AppExtension)
        android.registerTransform(new XXFuckerTraversalTransform())
        android.registerTransform(new XXFuckerTransform())
    }
}