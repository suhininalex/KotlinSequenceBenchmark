package com.suhininalex.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 7)
@Measurement(iterations = 15)
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
    fun chain_1_sequence(bh: Blackhole) {
        data.asSequence()
                .filter { true }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chain_1_list(bh: Blackhole) {
        data
                .filter { true }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chain_3_sequence(bh: Blackhole) {
        data.asSequence()
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chain_3_list(bh: Blackhole) {
        data
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chain_5_sequence(bh: Blackhole) {
        data.asSequence()
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chain_5_list(bh: Blackhole) {
        data
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .filter { true }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chain_10_sequence(bh: Blackhole) {
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
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chain_10_list(bh: Blackhole) {
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
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chainDecreasing_1_sequence(bh: Blackhole) {
        data.asSequence()
                .filter { it % 10 < 5 }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chainDecreasing_1_list(bh: Blackhole) {
        data
                .filter { it % 10 < 5 }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chainDecreasing_3_sequence(bh: Blackhole) {
        data.asSequence()
                .filter { it % 10 < 5 }
                .filter { it % 10 < 7 }
                .filter { it % 10 < 8 }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chainDecreasing_3_list(bh: Blackhole) {
        data
                .filter { it % 10 < 5 }
                .filter { it % 10 < 7 }
                .filter { it % 10 < 8 }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chainDecreasing_5_sequence(bh: Blackhole) {
        data.asSequence()
                .filter { it % 10 < 5 }
                .filter { it % 10 < 7 }
                .filter { it % 10 < 8 }
                .filter { it % 10 < 9 }
                .filter { it % 10 <= 9 }
                .forEach { bh.consume(it) }
    }

    @Benchmark
    fun chainDecreasing_5_list(bh: Blackhole) {
        data
                .filter { it % 10 < 5 }
                .filter { it % 10 < 7 }
                .filter { it % 10 < 8 }
                .filter { it % 10 < 9 }
                .filter { it % 10 <= 9 }
                .forEach { bh.consume(it) }
    }
}
