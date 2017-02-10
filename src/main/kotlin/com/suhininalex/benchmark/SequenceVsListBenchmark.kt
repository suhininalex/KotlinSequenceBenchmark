package com.suhininalex.benchmark

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
open class SequenceVsListBenchmark {

    @Param("1000000")
    var listSize: Int = 0

    var _data: List<Int>? = null

    val data: List<Int>
        get() = _data!!

    @Setup
    fun setup(){
        _data = (1..listSize).toList()
    }

    @Benchmark
    fun chain_1_sequence() {
        data.asSequence()
                .filter { true }
                .forEach { }
    }

    @Benchmark
    fun chain_1_list() {
        data
                .filter { true }
                .forEach { }
    }

    @Benchmark
    fun chain_3_sequence() {
        data.asSequence()
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { }
    }

    @Benchmark
    fun chain_3_list() {
        data
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { }
    }

    @Benchmark
    fun chain_5_sequence() {
        data.asSequence()
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { }
    }

    @Benchmark
    fun chain_5_list() {
        data
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { }
    }

    @Benchmark
    fun chain_10_sequence() {
        data.asSequence()
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { }
    }

    @Benchmark
    fun chain_10_list() {
        data
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { }
    }

    @Benchmark
    fun chainDecreasing_1_sequence() {
        data.asSequence()
                .filter { it % 10 < 5 }
                .forEach { }
    }

    @Benchmark
    fun chainDecreasing_1_list() {
        data
                .filter { it % 10 < 5 }
                .forEach { }
    }

    @Benchmark
    fun chainDecreasing_3_sequence() {
        data.asSequence()
                .filter { it % 10 < 5 }
                .filter { it % 10 < 7 }
                .filter { it % 10 < 8 }
                .forEach { }
    }

    @Benchmark
    fun chainDecreasing_3_list() {
        data
                .filter { it % 10 < 5 }
                .filter { it % 10 < 7 }
                .filter { it % 10 < 8 }
                .forEach { }
    }

    @Benchmark
    fun chainDecreasing_5_sequence() {
        data.asSequence()
                .filter { it % 10 < 5 }
                .filter { it % 10 < 7 }
                .filter { it % 10 < 8 }
                .filter { it % 10 < 9 }
                .filter { it % 10 <= 9 }
                .forEach { }
    }

    @Benchmark
    fun chainDecreasing_5_list() {
        data
                .filter { it % 10 < 5 }
                .filter { it % 10 < 7 }
                .filter { it % 10 < 8 }
                .filter { it % 10 < 9 }
                .filter { it % 10 <= 9 }
                .forEach { }
    }
}
