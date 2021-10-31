package listener

import main.Main
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

        val count = Main.db.select("kills", "count", "uuid='${uuid}'")

        if(count.next()) {
                Main.kills[uuid.toString()] = count.getInt("count")
            } else {
                Main.db.insert("kills", "'$uuid', 0")
                Main.kills[uuid.toString()] = 0
            }

        PlayerPerkList.setPerk(uuid, Perk.BULDOZER, true)
        PlayerPerkList.setPerk(uuid, Perk.RUSH, true)
    }
}