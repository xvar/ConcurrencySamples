import kotlin.jvm.JvmStatic
import java.lang.Runnable

object RaceCondition {
    @JvmStatic
    fun main(args: Array<String>) {
        val incrementor = Incrementor()
        for (i in 0..9) {
            Thread { incrementor.act() }.start()
        }
    }

    private class Incrementor {
        var i = 0
        fun act() {
            for (j in 0..9) {
                println(i++)
            }
        }
    }
}