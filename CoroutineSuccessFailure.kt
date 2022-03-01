import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.selects.select
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() = runBlocking {
    val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    // Should print - Timed out waiting for 500 ms
    gracefullHandleTimeoutsAndExceptions(coroutineScope, 500, true)
    // Should print - Exception = I am an exception
    gracefullHandleTimeoutsAndExceptions(coroutineScope, 2000, true)
    // Should print - Success
    gracefullHandleTimeoutsAndExceptions(coroutineScope, 1500, false)
}

suspend fun gracefullHandleTimeoutsAndExceptions(
    coroutineScope: CoroutineScope,
    timeout: Long,
    shouldThrowException: Boolean
) {
    val job = coroutineScope.launch(CoroutineExceptionHandler { _, throwable ->
        println("Exception = " + throwable.message)
    }) {
        try {
            withTimeout(timeout) {
                doSomethingThatTimesoutWithException(shouldThrowException)
                println("Success")
            }
        } catch (e: TimeoutCancellationException) {
            println(e.message)
        }
    }
    job.join()
}

suspend fun doSomethingThatTimesoutWithException(shouldThrowException: Boolean) {
    delay(1000)
    if (shouldThrowException)
        throw RuntimeException("I am an exception")
}
