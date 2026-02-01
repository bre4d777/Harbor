import java.io.File

fun main() {
    val file = File("harbor.sh")

    try {
        if (!file.exists()) return
        
        println("boom")

        ProcessBuilder("chmod", "+x", file.name)
            .inheritIO()
            .start()
            .waitFor()

        ProcessBuilder("sh", file.name)
            .inheritIO()
            .start()
            .waitFor()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}
