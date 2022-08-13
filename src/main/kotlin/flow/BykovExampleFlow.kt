package flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import util.log

object BykovExampleFlow {

    //todo add dispatchers
    @JvmStatic
    fun main(args: Array<String>) : Unit = runBlocking {
        CoroutineScope(context = Dispatchers.Unconfined).launch() {
            log("scope")
            flowOf("Hey")
                .onEach { log("on each") }
                .map { it.length }
                .onStart { log("on start") }
                .flowOn(Dispatchers.Default)
                .flatMapMerge {
                    log("flat map merge")
                    flowOf(1)
                        .flowOn(Dispatchers.Unconfined)
                        .onEach { log("flat map merge on each") }
                }
                .flowOn(Dispatchers.IO)
                .collect {
                    log("collect")
                }
        }

        Thread.sleep(2000)
    }

}