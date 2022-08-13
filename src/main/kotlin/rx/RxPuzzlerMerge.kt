package rx

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observable.just
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import util.log

object RxPuzzlerMerge {

    @JvmStatic
    fun main(args: Array<String>) {
        log()

        Observable
            .merge(
                just(Unit).subscribeOn(Schedulers.computation()),
                just(Unit).subscribeOn(Schedulers.io())
            )
            .subscribe {
                log("subscribe onNext")
            }

        Thread.sleep(100L)
    }
}