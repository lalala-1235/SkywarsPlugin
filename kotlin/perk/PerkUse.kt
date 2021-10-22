package perk

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class PerkUse {
    companion object {
        fun useBuldozer(p: Player) {
            if(PlayerPerkList.get(p.uniqueId, Perk.BULDOZER) == true) p.addPotionEffect(PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60, 1, true))
        }

        fun useRush(p: Player) {
            if(PlayerPerkList.get(p.uniqueId, Perk.RUSH) == true) p.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 140, 1, true))
        }
    }
}