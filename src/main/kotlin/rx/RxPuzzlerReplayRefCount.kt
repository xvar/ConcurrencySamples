package rx

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observable.just
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject

object RxPuzzlerReplayRefCount {

    @JvmStatic
    fun main(args: Array<String>) {
        log()

        val connectable = just(Unit)
            .replay()
            .refCount()

        connectable
            .subscribeOn(Schedulers.computation())
            .subscribe {
                log("subscribe onNext 1")
            }

        connectable.subscribe {
            log("subscribe onNext 2")
        }

        Thread.sleep(1000L)
    }
}