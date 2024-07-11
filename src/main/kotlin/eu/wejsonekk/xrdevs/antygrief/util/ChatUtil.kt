package eu.wejsonekk.xrdevs.antygrief.util

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ChatUtil {

    private const val PREFIX = "[AntyGrief]"

    fun sendMessage(sender: CommandSender, message: String) {
        sender.sendMessage(format(message))
    }

    fun sendMessage(player: Player, message: String) {
        player.sendMessage(format(message))
    }

    private fun format(message: String): String {
        return ChatColor.translateAlternateColorCodes('&', "$PREFIX $message")
    }
}