package ru.wb.stringresourcemultiplatform

fun string(res: StringRes): String = res.value(ResourceStringConfig.currentLocale)

fun string(res: StringRes, vararg formatArgs: Any): String =
    string(res = res).format(*formatArgs)

fun plural(count: Int, res: PluralRes): String {
    return when {
        count == 0 || count % 10 == 0 -> res.value(ResourceStringConfig.currentLocale).zero
        count == 1 || count % 10 == 1 -> res.value(ResourceStringConfig.currentLocale).one
        count == 2 || count % 10 == 2 -> res.value(ResourceStringConfig.currentLocale).two
        count == 3 || count == 4 || count % 10 == 3 || count % 10 == 4 -> res.value(ResourceStringConfig.currentLocale).few
        count == 5 || count == 6 || count == 7 || count == 8 || count == 9 || count % 10 == 5 || count % 10 == 6 || count % 10 == 7 || count % 10 == 8 || count % 10 == 9 -> res.value(ResourceStringConfig.currentLocale).many
        else -> res.value(ResourceStringConfig.currentLocale).zero
    }
}

fun plural(count: Int, res: PluralRes, vararg formatArgs: Any): String {
    return plural(count, res).format(*formatArgs)
}