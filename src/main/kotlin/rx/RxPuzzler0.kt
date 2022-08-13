package rx

import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import util.log

object RxPuzzler0 {

    @JvmStatic
    fun main(args: Array<String>) {
        log()

        val subject = BehaviorSubject.create<Unit>()

        subject
            .subscribeOn(Schedulers.computation())
            .subscribe {
                log("subscribe onNext")
            }

        Thread.sleep(100L)

        subject.onNext(Unit)

        Thread.sleep(2000L)
    }
}