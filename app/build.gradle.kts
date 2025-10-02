plugins {
    id("com.android.application")
    // id("org.jetbrains.kotlin.android") // Uncomment if using Kotlin code
}

android {
    namespace = "vn.hcmunre.lab05_1"
    compileSdk = 36

    defaultConfig {
        applicationId = "vn.hcmunre.lab05_1"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation("androidx.viewpager2:viewpager2:1.1.0") // No alias in catalog, keep as is
}
