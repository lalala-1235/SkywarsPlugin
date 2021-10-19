package listener

import game.ManageGame
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class PlayerDeath: Listener {
    @EventHandler
    fun playerDeath(e: EntityDamageEvent) {
        if(e.entity !is Player || e.entity.world.name!="pvpmap") return

        val p: Player = e.entity as Player

        if(p.health - e.getDamage() < 1) e.setCancelled(true)
        else return

        p.setGameMode(GameMode.SPECTATOR)

        var count = 0
        p.world.players.forEach { player ->
            if(player.gameMode==GameMode.SURVIVAL) count++
        }

        if(count==1) ManageGame.end(p.world.players)
    }
}