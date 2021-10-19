package json

import org.bukkit.Location
import org.bukkit.World

class GetChestLocation {
    companion object {
        fun get(w: World): MutableList<Location> {
            val chests = mutableListOf<Location>()
            for(i: Int in 0 until GetJSONDataMap.getNumbers("locations")) {
                val x: Double = GetJSONDataMap.get("locations", i, 0).toDouble()
                val y: Double = GetJSONDataMap.get("locations", i, 1).toDouble()
                val z: Double = GetJSONDataMap.get("locations", i, 2).toDouble()

                chests.add(Location(w, x, y, z))
            }
            return chests
        }
    }
}