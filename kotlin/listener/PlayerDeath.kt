package listener

import game.ManageGame
import main.Main
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import perk.PerkUse

class PlayerDeath: Listener {
    @EventHandler
    fun playerDeath(e: PlayerDeathEvent) {
        if(e.entity.world.name!="pvpmap") return

        val p: Player = e.entity

        if(p.killer is Player) {
            PerkUse.useBuldozer(checkNotNull(p.killer))
            Main.kills[p.killer?.uniqueId.toString()] = Main.kills[p.killer?.uniqueId.toString()]!! + 1
        }

        p.gameMode = GameMode.SPECTATOR

        p.teleport(Location(p.world, 0.0, 30.0, 0.0))

        var count = 0
        val survived = mutableListOf<Player>()

        p.world.players.forEach { player ->
            if(player.gameMode==GameMode.SURVIVAL) {
                count++
                survived.add(player)
            }
        }

        if(count==1) ManageGame.end(p.world.players, survived[0])
    }

}