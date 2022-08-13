import kotlin.jvm.JvmStatic
import Synchronized.Incrementor
import java.lang.Runnable
import kotlin.jvm.Synchronized

object Synchronized {
    @JvmStatic
    fun main(args: Array<String>) {
        val incrementor = Incrementor()
        for (i in 0..9) {
            Thread { incrementor.act() }.start()
        }
    }

    private class Incrementor {
        var i = 0
        @Synchronized
        fun act() {
            for (j in 0..9) {
                println(i++)
            }
        }
    }
}