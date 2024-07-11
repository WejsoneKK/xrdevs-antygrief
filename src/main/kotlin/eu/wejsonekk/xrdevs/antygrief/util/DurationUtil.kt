package eu.wejsonekk.xrdevs.antygrief.util

object DurationUtil {
    fun formatDuration(seconds: Long): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60

        return when {
            minutes > 0 && remainingSeconds > 0 -> "$minutes minutes $remainingSeconds seconds"
            minutes > 0 -> "$minutes minutes"
            else -> "$remainingSeconds seconds"
        }
    }
}