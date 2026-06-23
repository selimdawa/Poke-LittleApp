plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.littleapp.poke"
    compileSdk {
       version = release(37)
    }

    defaultConfig {
        applicationId = "com.littleapp.poke"
        minSdk = 24
        targetSdk = 37
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.preference.ktx)           //Shared Preference
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //Layout
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)
    //LifeCycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    //Retrofit & Gson
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //Coroutines
    implementation(libs.kotlinx.coroutines.core)
    //Other's
    implementation(libs.picasso)                //Picasso
    implementation(libs.lottie)                 //LottieFiles
    implementation(libs.shimmer)                //shimmer
    implementation(libs.timber)                 //Timber Log
}