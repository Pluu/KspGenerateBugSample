# KSP Generate Check

## Result

|                                   | Kotlin 1.6.21 + KSP 1.6.21-1.0.6 | Kotlin 1.7.0 + KSP 1.7.0-1.0.6 |
| :-------------------------------: | :------------------------------: | :----------------------------: |
|              String               |                O                 |               O                |
|                Int                |                O                 |               O                |
| Inner enum class in another files |                O                 |               O                |
|         Inner enum class          |                O                 |               X                |

## Kotlin 1.6.21 + KSP 1.6.21-1.0.6

Kotlin

```bash
w: [ksp] /.../SampleKotlin.kt:7: >> property: a1 : kotlin.String
w: [ksp] /.../SampleKotlin.kt:10: >> property: b1 : kotlin.Int
w: [ksp] /.../SampleKotlin.kt:13: >> property: c1 : com.pluu.kspsample.Sample2.SampleEnum
w: [ksp] /.../SampleKotlin.kt:16: >> property: d1 : com.pluu.kspsample.SampleKotlin.Type
```

Java

```bash
w: [ksp] /.../SampleJava.java:7: >> property: a2 : kotlin.String
w: [ksp] /.../SampleJava.java:10: >> property: b2 : kotlin.Int
w: [ksp] /.../SampleJava.java:13: >> property: c2 : com.pluu.kspsample.Sample2.SampleEnum
w: [ksp] /.../SampleJava.java:16: >> property: d2 : com.pluu.kspsample.SampleJava.Type
```

## Kotlin 1.7.0 + KSP 1.7.0-1.0.6

Kotlin

```bash
w: [ksp] /.../SampleKotlin.kt:7: >> property: a1 : kotlin.String
w: [ksp] /.../SampleKotlin.kt:10: >> property: b1 : kotlin.Int
w: [ksp] /.../SampleKotlin.kt:13: >> property: c1 : com.pluu.kspsample.Sample2.SampleEnum
w: [ksp] /.../SampleKotlin.kt:16: >> property: d1 : com.pluu.kspsample.SampleKotlin.Type
```

Java

```bash
w: [ksp] /.../SampleJava.java:7: >> property: a2 : kotlin.String
w: [ksp] /.../SampleJava.java:10: >> property: b2 : kotlin.Int
w: [ksp] /.../SampleJava.java:13: >> property: c2 : com.pluu.kspsample.Sample2.SampleEnum
w: [ksp] Unable to process:PluuProcessor:   d2
```