package org.ajoberstar.semver.vcs.gradle

import org.ajoberstar.grgit.Grgit
import org.ajoberstar.semver.vcs.grgit.GrgitVcs
import org.gradle.api.Plugin
import org.gradle.api.Project

class GrgitVcsPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.pluginManager.apply(SemverVcsPlugin)
        project.extensions.getByType(SemverExtension).with {
            Grgit git = Grgit.open(dir: project.rootDir)
            vcs = new GrgitVcs(git)
        }
    }
}
