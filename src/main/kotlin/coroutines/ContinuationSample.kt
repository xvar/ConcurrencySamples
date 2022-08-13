package coroutines

import kotlinx.coroutines.runBlocking
import util.log
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object ContinuationSample {

    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        log("Before")
        suspendCoroutine<Unit> {
                continuation -> continuation.resume(Unit)
        }
        log("After")
    }

}