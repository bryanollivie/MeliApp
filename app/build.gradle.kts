plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")

}

android {
    namespace = "com.bryanollivie.appml"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bryanollivie.appml"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        android.buildFeatures.buildConfig = true
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
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    val androidXCoreVersion = "1.9.0"
    val androidXTestCoreVersion = "1.5.0"
    val jUnitVersion = "4.13.2"
    val androidXTestVersion = "1.5.0"
    val androidXTestExtVersion = "1.1.5"
    val androidXTestExtKotlinRunnerVersion = "1.1.5"
    val robolectricVersion = "4.11.1"
    val mockitoVersion = "3.11.2"
    val mockitoKotlinVersion = "5.2.1"
    val mockkVersion = "1.13.8"

    val hiltVersion = "2.50"
    val okHttpVersion = "4.9.1"
    val roomVersion = "2.6.1"
    val retrofitVersion = "2.9.0"

    implementation("androidx.core:core-ktx:$androidXCoreVersion")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.4")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.4.0")
    implementation("com.google.android.material:material:1.8.0")

    //Test
    testImplementation("junit:junit:$jUnitVersion")
    testImplementation("androidx.test:core:$androidXTestVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("androidx.test.ext:junit-ktx:$androidXTestExtKotlinRunnerVersion")
    testImplementation("androidx.test:core-ktx:$androidXTestCoreVersion")
    testImplementation("org.robolectric:robolectric:$robolectricVersion")
    androidTestImplementation("androidx.test.ext:junit:$androidXTestExtVersion")

    // SwipeRefreshLayout
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    //MemoryLeak
    //implementation("com.squareup.leakcanary:leakcanary-android:2.7")
    //debugImplementation("com.squareup.leakcanary:leakcanary-android:2.7")
    // No-op version for release builds
    //releaseImplementation("com.squareup.leakcanary:leakcanary-android-no-op:2.7")

    //Hilt
    implementation("com.google.dagger:hilt-android:${hiltVersion}")
    ksp("com.google.dagger:hilt-compiler:${hiltVersion}")
    testImplementation("com.google.dagger:hilt-android-testing:${hiltVersion}")
    ksp("com.google.dagger:hilt-android-compiler:${hiltVersion}")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:${hiltVersion}")
    kspAndroidTest("com.google.dagger:hilt-android-compiler:${hiltVersion}")

    //Network
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")

    //Load image
    implementation("com.squareup.picasso:picasso:2.71828")

    //Room
    implementation("androidx.room:room-common:$roomVersion")
    implementation ("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")
    implementation ("androidx.room:room-testing:$roomVersion")


}
