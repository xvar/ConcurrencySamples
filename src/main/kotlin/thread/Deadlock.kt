import kotlin.jvm.JvmStatic
import java.lang.Runnable
import java.util.concurrent.Executor
import kotlin.jvm.Synchronized

object Deadlock {
    @JvmStatic
    fun main(args: Array<String>) {
        val ping = PingPong()
        val pong = PingPong()
        val t1 = Thread { ping.ping(pong) }
        val t2 = Thread { pong.pong(ping) }
        t1.start()
        t2.start()
    }

    private class PingPong {
        @Synchronized
        fun ping(pingPong: PingPong) {
            println("ping")
            pingPong.pong(this)
        }

        @Synchronized
        fun pong(pingPong: PingPong) {
            println("pong")
            pingPong.ping(this)
        }
    }
}