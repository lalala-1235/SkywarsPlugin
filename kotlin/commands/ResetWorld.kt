package commands

import main.Main.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ResetWorld: CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, alias: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false

        world.ResetWorld.reset(Bukkit.getWorld("pvpmap")!!, plugin)

        return true
    }

}