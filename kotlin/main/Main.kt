package main

import commands.ManageQueue
import commands.RefillCommand
import org.bukkit.Bukkit
import org.bukkit.WorldCreator
import org.bukkit.plugin.java.JavaPlugin
import commands.ResetWorld
import listener.PlayerDeath

class Main : JavaPlugin() {
    companion object {
        lateinit var plugin: Main
    }

    override fun onEnable() {
        println("Practice plugin enabled.")
        plugin = this

        getCommand("queue")?.setExecutor(ManageQueue())
        getCommand("refill")?.setExecutor(RefillCommand())

        Bukkit.createWorld(WorldCreator("pvpmap"))

        Bukkit.getPluginManager().registerEvents(PlayerDeath(), this)

        Bukkit.getWorld("pvpmap")?.setAutoSave(false)
    }

    override fun onDisable() {
        println("Practice plugin disabled.")
    }
}