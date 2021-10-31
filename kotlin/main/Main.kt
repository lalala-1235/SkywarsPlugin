package main

import commands.ManageQueue
import commands.Perks
import commands.RefillCommand
import commands.Stats
import org.bukkit.Bukkit
import org.bukkit.WorldCreator
import org.bukkit.plugin.java.JavaPlugin
import listener.InventoryClick
import listener.OnJoin
import listener.PlayerDeath
import sqlite.DataReader

class Main : JavaPlugin() {
    companion object {
        lateinit var plugin: Main
        val kills: HashMap<String, Int> = HashMap()
        val db: DataReader = DataReader("userdata.db")
    }

    override fun onEnable() {
        plugin = this

        println("registering commands.")
        getCommand("queue")?.setExecutor(ManageQueue())
        getCommand("refill")?.setExecutor(RefillCommand())
        getCommand("perks")?.setExecutor(Perks())
        getCommand("stats")?.setExecutor(Stats())

        println("loading pvpmap world.")
        Bukkit.createWorld(WorldCreator("pvpmap"))

        println("registering events.")
        Bukkit.getPluginManager().registerEvents(PlayerDeath(), this)
        Bukkit.getPluginManager().registerEvents(OnJoin(), this)
        Bukkit.getPluginManager().registerEvents(InventoryClick(), this)

        Bukkit.getWorld("pvpmap")?.isAutoSave = false

        db.open()

        println("Practice plugin enabled.")
    }

    override fun onDisable() {
        kills.forEach { uuid, value ->
            db.update("kills", "count = $value", "uuid=\"$uuid\"")
        }

        db.close()
        println("Practice plugin disabled.")
    }
}