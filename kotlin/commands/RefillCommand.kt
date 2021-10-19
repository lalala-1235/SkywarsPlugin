package commands

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import refill.Refill

class RefillCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, alias: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false

        Refill.refill(listOf(Location(sender.world, 0.0, 5.0, 0.0)))

        return true
    }

}