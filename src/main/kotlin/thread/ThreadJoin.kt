import java.lang.Exception
import kotlin.Throws
import kotlin.jvm.JvmStatic
import java.lang.Runnable
import java.lang.InterruptedException

object ThreadJoin {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val incrementor = Incrementor()
        val t1 = Thread { incrementor.act() }
        val t2 = Thread {
            try {
                t1.join()
                incrementor.act()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        val t3 = Thread {
            try {
                t2.join()
                incrementor.act()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        t1.start()
        t2.start()
        t3.start()
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