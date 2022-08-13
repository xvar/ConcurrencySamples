package rx

import io.reactivex.rxjava3.core.Flowable
import util.log

object Transformations {

    @JvmStatic
    fun main(args: Array<String>) {
        val disposable = Flowable.range(0, 10)
            .doOnNext { log("flowable onNext", it) }
            .map { 'a' + it }
            .doOnNext { log("map onNext", it) }
            .toList()
            .map { it.joinToString("") }
            .doOnSuccess { log("single success", it) }
            .subscribe()

        Thread.sleep(2000)
        disposable.dispose()
    }


}