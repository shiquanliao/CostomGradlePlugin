package com.stone.plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        println "====++++++++++++ I finished my first custom gradle plugin, This feeling is great. +++++++++++===="

        target.afterEvaluate {
            println " hi ${extension.name}"
        }

        def demoTransform = new DemoTransform()
        def baseExtension = target.extensions.getByType(BaseExtension)
        baseExtension.registerTransform(demoTransform)

    }


}
