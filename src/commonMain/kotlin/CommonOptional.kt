package com.h0tk3y.kotlin.mpp.optional

expect class Optional<T : Any> {
    fun get(): T
    fun isPresent(): Boolean
    /* ... */
}

expect object Optionals {
    fun <T : Any> of(t: T): Optional<T>
    fun empty(): Optional<Nothing>
}