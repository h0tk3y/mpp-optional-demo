package com.h0tk3y.kotlin.mpp.optional

actual class Optional<T : Any> {
    actual fun get(): T = valueOrNull ?: throw NoSuchElementException()
    actual fun isPresent(): Boolean = valueOrNull != null
    /* ... */

    private val valueOrNull: T?

    constructor(value: T) {
        valueOrNull = value
    }

    constructor() {
        valueOrNull = null
    }
}

actual object Optionals {
    actual fun <T : Any> of(t: T): Optional<T> = Optional(t)
    actual fun empty(): Optional<Nothing> = Optional()
}