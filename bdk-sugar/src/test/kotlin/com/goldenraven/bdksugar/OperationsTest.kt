package com.goldenraven.bdksugar

import kotlin.test.Test
import kotlin.test.assertEquals

class OperationsTest {

    @Test
    fun timesTwoReturnsTimes2() {
        assertEquals(4, timesTwo(2), "2 times 2 equals 4")
    }

    @Test
    fun squareSquares() {
        assertEquals(16, square(4), "Square of 4 should be 16")
    }
}
