package json

class GetJSONDataMap {
    companion object {
        private val parse = ParseJSON.parse("./plugins/skywarsplugin/pvpmap.json")

        fun get(name: String, index: Int, indexInside: Int): Int {
            return (((parse[name] as List<*>)[index] as List<*>)[indexInside] as Long).toInt()
        }

        fun getNumbers(name: String): Int {
            return (parse[name] as List<*>).size
        }
    }
}