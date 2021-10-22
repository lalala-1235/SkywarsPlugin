package listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class InventoryClick : Listener{
    @EventHandler
    fun inventoryClick(e: InventoryClickEvent) {
        if(e.view.title.contains("PERKS")) {
            e.isCancelled = true
        }
    }
}