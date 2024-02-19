
plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.jetbrainsCompose)
  alias(libs.plugins.sqlDelight)
  alias(libs.plugins.kotlinxSerialization)
}

kotlin {
  androidTarget {
    compilations.all {
      kotlinOptions {
        jvmTarget = "17"
      }
    }
  }
  jvmToolchain(17)
  listOf(
    iosX64(),
    iosArm64(),
    iosSimulatorArm64()
  ).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "Shared"
      isStatic = true
    }
  }

  sourceSets {

    commonMain.dependencies {
      // put your Multiplatform dependencies here
      implementation(libs.kotlinx.coroutines.core)
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.ktor.core)
      implementation(libs.ktor.logging)
      implementation(libs.ktor.contentNegotiation)
      implementation(libs.ktor.serialization)
      implementation(libs.sqlDelight.common)
      implementation(libs.sqlDelight.common)
      implementation(libs.koin.core)

      implementation(compose.runtime)

      implementation(libs.moko.mvvm.core)
      implementation(libs.moko.mvvm.compose)
    }
    commonTest.dependencies {
      implementation(libs.kotlinx.coroutines.test)
      implementation(libs.koin.test)
    }
    androidMain.dependencies {
      implementation(libs.kotlinx.coroutines.android)
      implementation(libs.ktor.android)
      implementation(libs.sqlDelight.android)
      implementation(libs.koin.android)
    }
  }
}
android {
  namespace = "org.example.project.shared"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.android.compose.compiler.get()
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
    }
  }
  buildFeatures {
    buildConfig = true
  }
}

sqldelight {
  databases {
    create("LocalDb") {
      packageName.set("myAppLocaldb.db")
      srcDirs("src/commonMain/kotlin")
    }
  }
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions {
    freeCompilerArgs += "-Xexpect-actual-classes"
  }
}