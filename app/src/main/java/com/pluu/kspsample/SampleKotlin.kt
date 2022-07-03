package com.pluu.kspsample

import com.pluu.annotation.PluuSample

class SampleKotlin {
    @PluuSample
    lateinit var a1: String

    @PluuSample
    var b1: Int = 0

    @PluuSample
    lateinit var c1: Sample2.SampleEnum

    @PluuSample
    lateinit var d1: Type

    enum class Type {
        A, B, C;
    }
}