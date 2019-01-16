package pe.chalk.bukkit.pos

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class Main: JavaPlugin(), Listener {
    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    private fun format(x: Int): String {
        return "${ChatColor.BOLD}${ChatColor.AQUA}$x${ChatColor.RESET}"
    }

    @EventHandler
    public fun onPlayer(e: AsyncPlayerChatEvent) {
        if (e.isCancelled) return

        val loc = e.player.location
        val pos = "${format(loc.blockX)}, ${format(loc.blockY)}, ${format(loc.blockZ)}"

        e.message = e.message.replace("<pos>", pos).replace("<ㅔㅐㄴ>", pos)
    }
}