package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import util.log

object FirstCoroutine {

    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        coroutineScope {
            launch {
                delay(1000L)
                log("World!")
            }
            log("Hello,")
        }
    }

}