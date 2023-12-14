plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    id("com.google.gms.google-services")
    kotlin("kapt")

}

android {
    namespace = "com.example.temanbicara"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.temanbicara"
        minSdk = 24
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
//    buildFeatures {
//        viewBinding = true
//    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.0-alpha02")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("androidx.core:core-ktx:1.13.0-alpha02")
    implementation("androidx.core:core-ktx:1.13.0-alpha02")
    implementation("androidx.core:core-ktx:1.13.0-alpha02")
    implementation("androidx.core:core-ktx:1.13.0-alpha02")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Kotlin Components
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //Navigation Component
    val nav_version = "2.7.5"
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")

    //Room Components
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")

    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.6.2")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.1")

    implementation ("com.android.volley:volley:1.2.1")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.google.code.gson:gson:2.8.8")

}

