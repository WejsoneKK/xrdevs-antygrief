package eu.wejsonekk.xrdevs.antygrief

import eu.wejsonekk.xrdevs.antygrief.config.PluginConfig
import eu.wejsonekk.xrdevs.antygrief.listener.BlockListener
import eu.wejsonekk.xrdevs.antygrief.util.ChatUtil
import org.bukkit.Material
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File


class AntyGriefPlugin : JavaPlugin() {
    lateinit var config: PluginConfig
    override fun onEnable() {
        saveDefaultConfig()
        loadConfig()

        logger.info("Konfiguracja została załadowana: ${config.blacklistedBlocks}")
        ChatUtil.sendMessage(server.consoleSender, "&aPomyślnie załadowało konfiguracje pluginu ${config.blacklistedBlocks}")


        server.pluginManager.registerEvents(BlockListener(this), this)
        ChatUtil.sendMessage(server.consoleSender, "&aPlugin AntyGrief został załadowany!")

    }


    override fun onDisable() {
        ChatUtil.sendMessage(server.consoleSender, "&aPlugin AntyGrief został wyłączony!")
    }
    private fun loadConfig() {
        val configFile = File(dataFolder, "config.yml")
        val yamlConfig: FileConfiguration = YamlConfiguration.loadConfiguration(configFile)

        val blacklistedBlocks = yamlConfig.getStringList("blacklistedBlocks").map { Material.valueOf(it) }
        val removalTimes = yamlConfig.getConfigurationSection("removalTimes")?.getKeys(false)?.associateWith {
            yamlConfig.getLong("removalTimes.$it")
        }?.mapKeys { Material.valueOf(it.key) } ?: emptyMap()

        config = PluginConfig().apply {
            this.blacklistedBlocks = blacklistedBlocks
            this.removalTimes = removalTimes
        }
    }

}

//        liteCommands?.unregister()

