plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "{{ cookiecutter.package_name }}"
    compileSdk = {{ cookiecutter.compileSdk }}

    defaultConfig {
        applicationId = "{{ cookiecutter.package_name }}"
        minSdk = {{ cookiecutter.minSdk }}
        targetSdk = {{ cookiecutter.targetSdk }}
        versionCode = {{ cookiecutter.versionCode }}
        versionName = "{{ cookiecutter.versionName }}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:{{ cookiecutter.__androidx_core_core_ktx_version }}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:{{ cookiecutter.__androidx_lifecycle_lifecycle_runtime_ktx_version }}")
    implementation("androidx.activity:activity-compose:{{ cookiecutter.__androidx_activity_activity_compose_version }}")
    implementation(platform("androidx.compose:compose-bom:{{ cookiecutter.__androidx_compose_compose_bom_version }}"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:{{ cookiecutter.__junit_junit_version }}")
    androidTestImplementation("androidx.test.ext:junit:{{ cookiecutter.__androidx_test_ext_version }}")
    androidTestImplementation("androidx.test.espresso:espresso-core:{{ cookiecutter.__androidx_test_espresso_espresso_core_version }}")
    androidTestImplementation(platform("androidx.compose:compose-bom:{{ cookiecutter.__androidx_compose_compose_bom_version }}"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}