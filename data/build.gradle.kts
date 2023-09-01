plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
}


android {
    namespace = "com.testwork.domain"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
