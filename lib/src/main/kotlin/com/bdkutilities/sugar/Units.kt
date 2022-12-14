package com.bdkutilities.sugar

public inline val Int.sat get() = this.toULong()
public inline val Long.sat get() = this

public inline val Int.btc: ULong
    get() {
        return (this * 100_000_000).toULong()
    }

public inline val Float.btc: ULong
    get() {
        return if (this < 0.00000001) throw Exception("Invalid bitcoin amount") else (this * 100_000_000).toULong()
    }

public inline val Double.btc: ULong
    get() {
        return if (this < 0.00000001) throw Exception("Invalid bitcoin amount") else (this * 100_000_000).toULong()
    }
