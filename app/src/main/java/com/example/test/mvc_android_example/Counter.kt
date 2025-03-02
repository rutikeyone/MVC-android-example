package com.example.test.mvc_android_example

class Counter {
    var count: Int = 0
        private set

    fun increment() {
        count++
    }

    fun decrement() {
        if (count > 0) {
            count--
        }
    }
}