@file:Suppress("DEPRECATION")

package eu.wejsonekk.xrdevs.antygrief.config

import org.bukkit.Material


class PluginConfig {
    var blacklistedBlocks: List<Material> = listOf()
    var removalTimes: Map<Material, Long> = mapOf()
    var defaultRemovalTime: Long = 60L  // Dodajemy domyślny czas usuwania
}