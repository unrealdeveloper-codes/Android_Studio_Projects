import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.anshul.photoalbum"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.anshul.photoalbum"
        minSdk = 24
        //noinspection OldTargetApi
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    val roomVersion = "2.7.1"
    val lifecycleVersion = "2.9.0"

    implementation("androidx.room:room-runtime:$roomVersion")

    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    ksp("androidx.room:room-compiler:$roomVersion")

    implementation("androidx.room:room-ktx:$roomVersion")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    // Anotations Processor
    implementation ("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")

    // Core KTX for Bitmap.scale() and other AndroidX extensions
    implementation ("androidx.core:core-ktx:1.10.1")
    // (Or via your version catalog: implementation(libs.androidx.core.ktx))

    // If you want kotlin.io.encoding.Base64 (Kotlin ≥1.9)
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}