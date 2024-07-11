package eu.wejsonekk.xrdevs.antygrief.listener

import eu.wejsonekk.xrdevs.antygrief.AntyGriefPlugin
import eu.wejsonekk.xrdevs.antygrief.util.ChatUtil
import eu.wejsonekk.xrdevs.antygrief.util.DurationUtil
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.scheduler.BukkitRunnable

class BlockListener(private val plugin: AntyGriefPlugin) : Listener {

    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent){
        val block = event.block
        val material = event.block.type

        if (plugin.config.blacklistedBlocks.contains(material)) {
            val removalTime = plugin.config.removalTimes[material] ?: plugin.config.defaultRemovalTime

            object : BukkitRunnable() {
                override fun run() {
                    block.type = Material.AIR
                }
            }.runTaskLater(plugin, removalTime * 20)

            // Informuje gracza o usunięciu bloku
            val formattedDuration = DurationUtil.formatDuration(removalTime)
            ChatUtil.sendMessage(event.player, "&cTen blok zostanie usunięty za $formattedDuration.")
        }

    }
}