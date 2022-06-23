package ru.netology.nmedia
import org.junit.Test

internal class FormatterKtTest {

    @Test
    fun formatCounter() {

        var result = doCounterformat(100)
        assert(result == "100")

        result = doCounterformat(1000)
        assert(result == "1К")

        result = doCounterformat(1100)
        assert(result == "1.1К")

        result = doCounterformat(1150)
        assert(result == "1.1К")

        result = doCounterformat(15_550)
        assert(result == "15.5К")

        result = doCounterformat(1_000_000)
        assert(result == "1М")

        result = doCounterformat(1_100_000)
        assert(result == "1.1М")

        result = doCounterformat(10_600_000)
        assert(result == "10.6М")


    }


}