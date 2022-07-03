package com.pluu.kspsample;

import com.pluu.annotation.PluuSample;

public class SampleJava {
    @PluuSample
    public String a2;

    @PluuSample
    public int b2;

    @PluuSample
    public Sample2.SampleEnum c2;

    @PluuSample
    public Type d2;

    public enum Type {
        A, B, C, D
    }
}
