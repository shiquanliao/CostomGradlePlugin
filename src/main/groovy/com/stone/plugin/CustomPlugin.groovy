package com.stone.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "==== I finished my first custom gradle plugin, This feeling is great. ===="
    }
}
