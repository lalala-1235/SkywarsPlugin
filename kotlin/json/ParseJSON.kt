package json

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.FileReader

class ParseJSON {
    companion object {
        fun parse(location: String): JSONObject {

            val parser = JSONParser()
            val reader = FileReader(location)

            return (parser.parse(reader) as JSONObject)
        }
    }
}
