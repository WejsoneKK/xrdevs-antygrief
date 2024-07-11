plugins {
    kotlin("jvm") version "1.8.10"
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "eu.wejsonekk.xrdevs.antygrief"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    gradleKotlinDsl()
    maven { url = uri("https://repo.panda-lang.org/releases") }
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    maven("https://repo.eternalcode.pl/releases/")
    maven("https://papermc.io/repo/repository/maven-public/")

}

dependencies {

    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT") // testowane i śmiga


    implementation("net.kyori:adventure-platform-bukkit:4.2.0")  // -- nie jest mi to potrzebne ale zostawiłem ;-;
    implementation("net.kyori:adventure-text-minimessage:4.12.0") // -- to tak samo

}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }

    shadowJar {
        archiveFileName.set("xrdevs-antygrief-plugin-${version}.jar")

        relocate("eu.okaeri", "eu.wejsonekk.xrdevs.antygrief.libs.eu.okaeri")
        relocate("dev.rollczi.litecommands", "eu.wejsonekk.xrdevs.antygrief.libs.rollczi")
        relocate("net.kyori", "eu.wejsonekk.xrdevs.antygrief.libs.net.kyori")
        relocate("org.panda-lang", "eu.wejsonekk.xrdevs.antygrief.libs.panda")
        relocate("panda.utilities", "eu.wejsonekk.xrdevs.antygrief.libs.panda")
        relocate("panda.std", "eu.wejsonekk.xrdevs.antygrief.libs.net.panda")
        relocate("com.github.benmanes.caffeine", "eu.wejsonekk.xrdevs.antygrief.libs.caffeine")
        relocate("org.mongodb", "eu.wejsonekk.xrdevs.antygrief.libs.mongodb")

        relocate("org.bson", "eu.wejsonekk.xrdevs.antygrief.libs.org.bson")
        minimize()
        mergeServiceFiles()

    }
}