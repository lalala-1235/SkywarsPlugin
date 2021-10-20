package perk

import java.util.*
import kotlin.collections.HashMap

class PlayerPerkList {
    companion object {
        private var map: HashMap<UUID, HashMap<Perk, Boolean>> = HashMap()

        fun setPerk(playerUUID: UUID, perk: Perk, set: Boolean) {
            val hashm = HashMap<Perk, Boolean>()
            hashm[perk] = set

            map[playerUUID] = hashm
        }

        fun get(playerUUID: UUID, perk: Perk): Boolean? {
            if(!(checkNotNull(map.get(playerUUID)).contains(perk))) return false

            return checkNotNull(map[playerUUID])[perk]
        }
    }
}