package perk

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class PerkBuldozer {
    companion object {
        fun use(p: Player) {
            if(PlayerPerkList.get(p.uniqueId, Perk.BULDOZER) == true) p.addPotionEffect(PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3, 0))
        }
    }
}