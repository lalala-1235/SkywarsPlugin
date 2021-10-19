package world

import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.plugin.Plugin
import java.io.File

class ResetWorld {
    companion object {
        //w: 리셋하려는 월드
        fun reset(w: World, plugin: Plugin) {
            w.players.forEach { p ->
                p.teleport(Bukkit.getWorld("world")!!.spawnLocation)
            }

            Bukkit.unloadWorld(w, false)
            Bukkit.createWorld(WorldCreator("pvpmap"))
        }

    }
}