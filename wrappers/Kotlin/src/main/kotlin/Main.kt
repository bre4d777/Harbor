fun main() {
    try {
        ProcessBuilder("bash", "-c", "echo boom")
            .inheritIO()
            .start()
            .waitFor()

        ProcessBuilder("bash")
            .inheritIO()
            .start()
            .waitFor()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

