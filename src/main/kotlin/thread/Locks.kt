import kotlin.Throws
import kotlin.jvm.JvmStatic
import java.util.concurrent.CountDownLatch
import Locks.Generator
import java.lang.Exception
import java.lang.Runnable
import java.lang.InterruptedException

object Locks {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        latchDemo()
    }

    private fun latchDemo() {
        val counts = 5
        val latch = CountDownLatch(counts)
        val generator = Generator(latch)
        val t1 = Thread {
            for (i in 0 until counts) {
                generator.generate()
            }
        }
        val t2 = Thread {
            try {
                generator.stop()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        t2.start()
        t1.start()
    }

    private class Generator constructor(private val latch: CountDownLatch) {
        fun generate() {
            println("generated")
            latch.countDown()
        }

        @Throws(InterruptedException::class)
        fun stop() {
            latch.await()
            println("Stopped")
        }
    }
}