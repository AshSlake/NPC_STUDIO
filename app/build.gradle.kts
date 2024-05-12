plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.npc_studio"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.npc_studio"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildToolsVersion = "34.0.0"
    ndkVersion = "27.0.11718014 rc1"
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.filament.android)
    implementation(libs.firebase.database)
    implementation(libs.firebase.firestore)
    implementation(libs.generativelanguage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.google.ai.generativelanguage:generativelanguage:1.0.0-beta02")
    implementation("com.google.cloud:google-cloud-generativelanguage:1.0.0-beta02")
    implementation("com.google.ai.client.generativeai:generativeai:0.5.0")
    implementation("com.google.guava:guava:31.0.1-android")
    implementation("org.reactivestreams:reactive-streams:1.0.4")
}