package ru.wb.stringresourcemultiplatform

interface PluralRes {
    fun value(locale: LocaleString): Plural
}

interface Plural {
    val zero: String
    val one: String
    val two: String
    val few: String
    val many: String
    val other: String
}