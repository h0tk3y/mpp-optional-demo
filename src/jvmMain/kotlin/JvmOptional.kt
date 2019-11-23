package com.h0tk3y.kotlin.mpp.optional

actual typealias Optional<T> = java.util.Optional<T>

actual object Optionals {
    actual fun <T : Any> of(t: T): Optional<T> = java.util.Optional.of(t)
    actual fun empty(): Optional<Nothing> = java.util.Optional.empty()
}