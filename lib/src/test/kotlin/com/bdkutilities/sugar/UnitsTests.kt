package com.bdkutilities.sugar

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class UnitsTests {
    @Test
    fun `Negative satoshi values don't make sense`() {
        assertFailsWith<Exception> {
            val satoshis: ULong = (-1000).sat
        }
    }
}
