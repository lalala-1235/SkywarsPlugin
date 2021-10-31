package sqlite

import main.Main
import org.sqlite.SQLiteConfig
import java.lang.Exception
import java.sql.*

class DataReader(databaseFileName: String) {
    private lateinit var connection: Connection
    private var dbFileName: String
    private var isOpened: Boolean = false
    private var statementOpened: Boolean = false
    private lateinit var statement: Statement

    companion object {
        init {
            try {
                Class.forName("org.sqlite.JDBC")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    init {
        this.dbFileName = databaseFileName
    }

    fun open(): Boolean {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:${Main.plugin.dataFolder.parentFile}/skywarsplugin/" + this.dbFileName)
            this.statement = this.connection.createStatement()
        } catch(e: SQLException) { e.printStackTrace(); return false }

        this.isOpened = true
        this.statementOpened = true
        return true
    }

    fun close(): Boolean {
        if(!this.isOpened || !this.statementOpened) return false

        try {
            this.statement.close()
            this.connection.close()
        } catch(e: SQLException) { e.printStackTrace(); return false}

        return true
    }

    fun getTable(name: String): ResultSet {
        return statement.executeQuery("select * from $name;")
    }

    fun update(tableName: String, thingToUpdate: String, condition: String) {
        statement.executeUpdate("update $tableName set $thingToUpdate where $condition;")
    }

    fun select(tableName: String, column: String, condition: String): ResultSet {
        val sql = "select \"$column\" from \"$tableName\" where $condition;"

        return statement.executeQuery(sql)
    }

    fun insert(tableName: String, value: String) {
        statement.executeUpdate("insert into $tableName values ($value);")
    }

    fun create(tableName: String, column: String) {
        statement.executeQuery("create table $tableName ($column);")
    }
}