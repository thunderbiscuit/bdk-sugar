package com.bdkutilities.sugar

import org.bitcoindevkit.TransactionDetails

infix fun TransactionDetails.before(other: TransactionDetails): Boolean {
    val thisHeight = this.confirmationTime?.height
    val otherHeight = other.confirmationTime?.height

    return if (thisHeight == null) {
        false
    } else if (otherHeight == null) {
        true
    } else {
        (thisHeight < otherHeight)
    }
}
