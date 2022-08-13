package coroutines

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import util.log

object SupervisorJobSample {

    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        val job = SupervisorJob()
        launch(job) {
            delay(1000)
            throw Error("Some error")
        }
        launch(job) {
            delay(2000)
            log("Will be printed")
        }
        job.join()
    }

}