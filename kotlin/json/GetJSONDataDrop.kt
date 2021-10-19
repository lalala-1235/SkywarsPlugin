package json

import org.json.simple.JSONObject

class GetJSONDataDrop {
    companion object {
        private val parse = ParseJSON.parse("./plugins/skywarsplugin/drop.json")

        fun get(name: String, inside1: String): Int {
            return ((parse[name] as JSONObject)[inside1] as Long).toInt()
        }

        fun get(name: String, inside1: String, inside2: String): Int {
            return (((parse[name] as JSONObject)[inside1] as JSONObject)[inside2] as Long).toInt()
        }

        fun get(name: String, inside1: String, inside2: String, inside3: String): Int {
            return ((((parse[name] as JSONObject)[inside1] as JSONObject)[inside2] as JSONObject)[inside3] as Long).toInt()
        }
    }
}

/*
* name: {
*       inside1: {
*                 inside2: ...
*                 }
*       }
*
*
*/