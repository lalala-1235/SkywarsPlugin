package commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import java.util.*
import kotlin.collections.ArrayList

class Perks : CommandExecutor{
    override fun onCommand(sender: CommandSender, cmd: Command, alias: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false
        openPerksGUI(sender)

        return true
    }

    private fun openPerksGUI(p: Player) {
        var inv = Bukkit.createInventory(null, 9, "PERKS")
        inv = init(inv, generateItem())

        p.openInventory(inv)
    }

    private fun init(inv: Inventory, items: List<ItemStack>): Inventory {
        items.forEachIndexed { index, item ->
            inv.setItem(index, item)
        }

        return inv
    }

    private fun generateItem(): List<ItemStack> {
        val items = mutableListOf<ItemStack>()
        items.add(createGuiItem(Material.IRON_SWORD, "불도저", chatColor("&c플레이어를 죽일 시 발동"), chatColor("&f힘 1을 3초간 얻습니다.")))
        items.add(createGuiItem(Material.FEATHER, "러시", chatColor("&b게임 시작 시 발동"), chatColor("&f신속 1을 7초간 얻습니다.")))

        return items
    }

    private fun createGuiItem(material: Material, name: String, vararg lore: String): ItemStack {
        val item = ItemStack(material, 1)
        val meta = item.itemMeta

        meta?.setDisplayName(name)

        meta?.lore = lore.toList()

        item.itemMeta = meta

        return item
    }

    private fun chatColor(msg: String): String {
        return ChatColor.translateAlternateColorCodes('&', msg)
    }

}
