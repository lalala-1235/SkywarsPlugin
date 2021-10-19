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
                        var randomSlot = Random.randomSlot(27)
                        if(ch.blockInventory.getItem(randomSlot)!=null) randomSlot = Random.randomSlot(27)


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

// 들어가야 하는 목록
// 검, 갑, 펄, 황금사과
// 검과 갑은 armors/weapons안에 iron/diamond 안에 데이터 있음
// 펄과 황금사과는 각각 pearl과 gapple

// 대충 json 생긴 꼴
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