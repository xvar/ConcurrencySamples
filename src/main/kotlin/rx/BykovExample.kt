package rx

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import util.log
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.TimeUnit

object BykovExample {

    private val myScheduler = Schedulers.from(Executors.newSingleThreadExecutor())

    @JvmStatic
    fun main(args: Array<String>) {
        Observable.just("Hey")
            .subscribeOn(Schedulers.io())
            .map(String::length)
            .subscribeOn(Schedulers.computation())
            .observeOn(myScheduler)
            .doOnSubscribe { log("doOnSubscribe") }
            .flatMap {
                log("flatMap")
                Observable.timer(1, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.single())
                    .doOnSubscribe { log("doOnSubscribe flat map") }
            }.subscribe {
                log("subscribe")
            }

        Thread.sleep(2000)
    }

}