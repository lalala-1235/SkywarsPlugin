package queue

import org.bukkit.entity.Player

class PlayerList {
    companion object {
        private val players = mutableListOf<Player>()
        fun addPlayer(p: Player) {
            if(players.contains(p)) return
            players.add(p)
        }

        fun removePlayer(p: Player) {
            if(players.contains(p)) {
                players.remove(p)
            } else p.sendMessage("cannot find " + p.name + " in queue!")
        }

        fun reset() {
            players.clear()
        }

        fun length(): Int {
            return players.size
        }

        fun getAll(): List<Player> {
            return players
        }

    }
}
