package com.bdkutilities.sugar

import kotlin.test.Test

class Bip21Tests {
    @Test
    fun `Parse BIP21 URI`() {
        val uri = "bitcoin:175tWpb8K1S7NmH4Zx6rewF9WQrcZv245W?amount=50&label=Luke-Jr&message=Donation%20for%20project%20xyz"
        val uriData = uri.parseBip21()
        println(uriData)
    }
}