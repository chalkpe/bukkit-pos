package pe.chalk.bukkit.pos

import org.bstats.bukkit.Metrics
import org.bukkit.event.EventHandler
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

@Suppress("unused")
class Main: JavaPlugin(), Listener {
    private val regex = "<(pos|ㅔㅐㄴ|좌표)>".toRegex(RegexOption.IGNORE_CASE)

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
        Metrics(this, 17524)
    }

    @EventHandler
    @Suppress("RedundantVisibilityModifier")
    public fun onPlayer(e: AsyncPlayerChatEvent) {
        if (e.isCancelled) return

        val block = e.player.location.block
        val biome = getBiomeName(block.biome)
        val xyz = "${format(block.x)}, ${format(block.y)}, ${format(block.z)}"

        e.message = e.message.replace(regex, "$biome ($xyz)")
    }
}