package commands

import main.Main
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Stats: CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, alias: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false

        sender.sendMessage("kills: ${Main.kills[sender.uniqueId.toString()]}")

        return true
    }
}