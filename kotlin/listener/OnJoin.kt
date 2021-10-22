package listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import perk.Perk
import perk.PlayerPerkList

class OnJoin: Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val p = e.player
        val uuid = p.uniqueId

        PlayerPerkList.setPerk(uuid, Perk.BULDOZER, true)
        PlayerPerkList.setPerk(uuid, Perk.RUSH, true)
    }
}