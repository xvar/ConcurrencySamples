package rx

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

object Just {
    @JvmStatic
    fun main(args: Array<String>) {
        val disposable = Flowable.just(1)
            .doOnNext { log("onNext", it) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe {
                log("subscribe", it)
            }
        Thread.sleep(1000)
        disposable.dispose()
    }
}