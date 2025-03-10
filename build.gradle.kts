// Uncomment to test the script with Groovy syntax
//buildscript {
//    ext {
//        compose_version = '1.7.7'
//    }
//}
//
//plugins {
//    id 'maven-publish'
//    id 'com.android.application' version '8.8.0' apply false
//    id 'com.android.library' version '8.8.0' apply false
//    id 'org.jetbrains.kotlin.android' version '2.1.10' apply false
//    id 'org.jetbrains.kotlin.jvm' version '2.1.10' apply false
//    id 'org.jetbrains.kotlin.plugin.compose' version '2.1.10' apply false
//    id 'me.tylerbwong.gradle.metalava' version '0.3.3' apply false
//    id 'org.jetbrains.kotlinx.kover' version "0.9.1" apply false
//    id 'io.gitlab.arturbosch.detekt' version "1.22.0" apply true
//}
//
//detekt {
//    ignoredBuildTypes = ["release"]
//}

// --------------------------------------------------------------------------------

// Uncomment to test the script with Kotlin DSL syntax
buildscript {
    extra["compose_version"] = "1.7.7"
}

plugins {
    id("maven-publish")
    id("com.android.application") version "8.8.0" apply false
    id("com.android.library") version "8.8.0" apply false
    id("org.jetbrains.kotlin.android") version "2.1.10" apply false
    id("org.jetbrains.kotlin.jvm") version "2.1.10" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.10" apply false
    id("me.tylerbwong.gradle.metalava") version "0.3.3" apply false
    id("org.jetbrains.kotlinx.kover") version "0.9.1" apply false
    id("io.gitlab.arturbosch.detekt") version "1.22.0" apply true
}

detekt {
    ignoredBuildTypes = listOf("release")
}
