package refill

import json.GetJSONDataDrop
import json.GetJSONDataMap
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Chest
import org.bukkit.inventory.ItemStack

class Refill {
    companion object {
        fun refill(chests: List<Location>) {
            if(chests.isEmpty()) return

            chests.forEach { chest ->
                val chestloc = Location(chest.world, chest.blockX.toDouble(), chest.blockY.toDouble(),
                    chest.blockZ.toDouble()
                )

                val items = randomItemGen()
                if(chestloc.block.type!=Material.CHEST) chestloc.block.type = Material.CHEST

                if(chestloc.block.type == Material.CHEST) {
                    val ch: Chest = chestloc.block.state as Chest
                    items.forEach { item ->
                        val randomSlot = Random.randomSlot(27)
                        if(ch.blockInventory.getItem(randomSlot)!=null) return@forEach

                        ch.blockInventory.setItem(randomSlot, item)
                    }
                }
            }
        }

        private fun randomItemGen(): List<ItemStack> {
            val itemlist: MutableList<ItemStack> = mutableListOf()

            //pearl
            if(Random.random(GetJSONDataDrop.get("pearl", "percent").toDouble())) itemlist.add(ItemStack(Material.ENDER_PEARL, GetJSONDataDrop.get("pearl", "amount")))

            //gapple
            if(Random.random(GetJSONDataDrop.get("gapple", "percent").toDouble())) itemlist.add(ItemStack(Material.GOLDEN_APPLE, GetJSONDataDrop.get("gapple", "amount")))

            //blocks
            if(Random.random(GetJSONDataDrop.get("blocks","plank","percent").toDouble())) itemlist.add(ItemStack(Material.OAK_PLANKS, GetJSONDataDrop.get("blocks", "plank", "amount")))

            //armor-iron
            if(Random.random(GetJSONDataDrop.get("armor", "iron","percent").toDouble())) {
                if(Random.random(GetJSONDataDrop.get("armor","iron","boots","percent").toDouble())) itemlist.add(ItemStack(Material.IRON_BOOTS))
                if(Random.random(GetJSONDataDrop.get("armor","iron","leggings","percent").toDouble())) itemlist.add(ItemStack(Material.IRON_LEGGINGS))
                if(Random.random(GetJSONDataDrop.get("armor","iron","chestplate","percent").toDouble())) itemlist.add(ItemStack(Material.IRON_CHESTPLATE))
                if(Random.random(GetJSONDataDrop.get("armor","iron","helmet","percent").toDouble())) itemlist.add(ItemStack(Material.IRON_HELMET))
            }

            return itemlist
        }

        private fun randomSlot(ch: Chest): Int {
            var randomSlot = Random.randomSlot(27)
            if(ch.blockInventory.getItem(randomSlot)!=null) {
                randomSlot = this.randomSlot(ch)
            }

            return randomSlot
        }
    }
}

// ???????????? ?????? ??????
// ???, ???, ???, ????????????
// ?????? ?????? armors/weapons?????? iron/diamond ?????? ????????? ??????
// ?????? ??????????????? ?????? pearl??? gapple

// ?????? json ?????? ???
/*
* {
*   pearl: {
*           amount: 1,
*           percent: 15
*           },
*   armor: {
*           iron: {
*                   percent:70,
*                   boots: {
*                           percent:75
*                           }
*                  }
*           }
*
*/