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

    val retrofitVersion = "2.9.0"
    val okHttpVersion = "4.9.1"
    val room_version = "2.6.1"
    val hilt_version = "2.50"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    
    //Hilt
    implementation("com.google.dagger:hilt-android:${hilt_version}")
    ksp("com.google.dagger:hilt-compiler:${hilt_version}")
    // Para testes de instrumentação
    androidTestImplementation("com.google.dagger:hilt-android-testing:${hilt_version}")
    kspAndroidTest("com.google.dagger:hilt-compiler:${hilt_version}")
    // Para testes unitários locais

    testImplementation("com.google.dagger:hilt-android-testing:${hilt_version}")
    kspTest("com.google.dagger:hilt-compiler:${hilt_version}")
    //testImplementation 'com.google.dagger:hilt-android-testing:2.37'
    //kaptTest 'com.google.dagger:hilt-android-compiler:2.37'
    testImplementation("org.mockito:mockito-core:3.11.2")

    //Network
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")

    //Load image
    implementation("com.squareup.picasso:picasso:2.71828")

    //Lifecycle scope
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.4")

    //MVVM
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.4.0")

    //Room
    implementation("androidx.room:room-common:$room_version")
    implementation ("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    ksp("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")
    implementation ("androidx.room:room-testing:$room_version")


}
