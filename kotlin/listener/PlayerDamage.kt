package listener

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class PlayerDamage : Listener {
    @EventHandler
    fun playerDmg(e: EntityDamageEvent) {
        if(e.entity.world.name!="pvpmap" || e.entity !is Player) return

        if((e.entity as Player).health - e.damage < 1) e.isCancelled = true
    }
}