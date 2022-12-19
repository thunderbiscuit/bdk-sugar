package com.bdkutilities.sugar

public fun String.parseBip21(): Bip21 {
    if (this.count { it == '?' } > 1) throw Exception("URI is incorrectly specified: more than one '?'")
    val (address, queryParameters) = this.split("?")
    if (address.take(8) != "bitcoin:") throw Exception("URI is incorrectly specified: doesn't start with 'bitcoin:'")
    println(queryParameters)

    val queryMap = queryParameters.split("&")
        .map { parameter ->
            parameter.split("=")
                .takeIf {
                    it.size == 2 && it[0].isNotBlank() && it[1].isNotBlank()
                }
        }.associateBy(
            { it?.get(0) },
            { it?.get(1) }
        )

    return Bip21(
        bitcoin = address.drop(8),
        amount = queryMap["amount"]?.toULong(),
        label = queryMap["label"],
        message = queryMap["message"]
    )
}

public data class Bip21(
    val bitcoin: String,
    val amount: ULong?,
    val label: String?,
    val message: String?,
)
