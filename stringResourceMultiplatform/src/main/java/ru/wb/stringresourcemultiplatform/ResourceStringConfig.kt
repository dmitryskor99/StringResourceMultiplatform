package ru.wb.stringresourcemultiplatform

object ResourceStringConfig {
    private var _currentLocale: LocaleString? = null
    internal val currentLocale: LocaleString get() {
        require(_currentLocale != null) {
            "locale not specified in ResourceStringConfig"
        }
        return _currentLocale!!
    }

    fun setLocale(locale: LocaleString) {
        _currentLocale = locale
    }
}