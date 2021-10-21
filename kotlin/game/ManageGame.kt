package game

import json.GetChestLocation
import json.GetJSONDataMap
import main.Main.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import refill.Refill
import world.ResetWorld

class ManageGame {
    companion object {
        fun start(playerlist: List<Player>) {
            for(i:Int in playerlist.indices) {
                if(playerlist.isEmpty()) return

                val spawnLocX = GetJSONDataMap.get("spawn", i, 0).toDouble()
                val spawnLocY = GetJSONDataMap.get("spawn", i, 1).toDouble()
                val spawnLocZ = GetJSONDataMap.get("spawn", i, 2).toDouble()

                playerlist[i].teleport(Location(Bukkit.getWorld("pvpmap"), spawnLocX, spawnLocY, spawnLocZ))

                playerlist.forEach {
                    it.setGameMode(GameMode.SURVIVAL)
                }

                Refill.refill(GetChestLocation.get(Bukkit.getWorld("pvpmap")!!))
            }
        }

        fun end(playerlist: List<Player>, playerwon: Player) {
            playerwon.sendMessage("VICTORY!")

            val runnable = object: BukkitRunnable() {
                override fun run() {
                    playerlist.forEach {
                        it.setGameMode(GameMode.ADVENTURE)
                        it.inventory.clear()

                        it.setHealth(20.0)
                        it.setFoodLevel(20)

                        it.teleport(Bukkit.getWorld("world")!!.spawnLocation)
                    }
                    ResetWorld.reset(Bukkit.getWorld("pvpmap")!!, plugin)
                }
            }
            runnable.runTaskLater(plugin, 3000)

        }
    }
}