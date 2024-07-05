import java.io.InputStreamReader

internal actual class SharedFileReader {
    actual fun loadFile(fileName: String): String {
        val androidFilePath = "assets/station.json"
        return javaClass.classLoader?.getResourceAsStream(androidFilePath).use { stream ->
            InputStreamReader(stream).use { reader ->
                reader.readText()
            }
        }
    }
}