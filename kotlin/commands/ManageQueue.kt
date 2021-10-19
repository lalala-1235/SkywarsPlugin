package commands

import game.ManageGame
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import queue.PlayerList

class ManageQueue : CommandExecutor{
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false
        if(args.isEmpty()) {
            sender.sendMessage("주어진 설정이 없습니다! join 이나 leave를 입력하세요!")
        }
        when {
            args[0] == "join" -> {
                PlayerList.addPlayer(sender)
                sender.sendMessage("joined queue!")
                if(PlayerList.length()==2) {
                    ManageGame.start(PlayerList.getAll())
                    PlayerList.reset()
                }

            }

            args[0] == "leave" -> {
                PlayerList.removePlayer(sender)
                sender.sendMessage("left queue!")
            }

            else -> {
                sender.sendMessage("join, leave 중 하나를 입력해주세요.")
                return false
            }
        }

        return true
    }

}