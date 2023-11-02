package ru.wb.stringesourcemultiplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.wb.stringesourcemultiplatform.ui.theme.StringКesourceMultiplatformTheme
import ru.wb.stringresourcemultiplatform.LocaleString
import ru.wb.stringresourcemultiplatform.Plural
import ru.wb.stringresourcemultiplatform.PluralRes
import ru.wb.stringresourcemultiplatform.StringRes
import ru.wb.stringresourcemultiplatform.pluralCompose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StringКesourceMultiplatformTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = pluralCompose(count = 1, res = Man))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StringКesourceMultiplatformTheme {
        Greeting("Android")
    }
}

object GreetingString : StringRes {
    override fun value(locale: LocaleString): String {
        return when (locale) {
            is Russian -> "Привет"
            is English -> "Hello"
            else -> "Hello"
        }
    }
}

class Russian(override val languageTag: String = "ru-RU") : LocaleString

class English(override val languageTag: String = "en-EN") : LocaleString








object Man : PluralRes {
    override fun value(locale: LocaleString): Plural {
        return when (locale) {
            is Russian -> ManRussian()
            is English -> ManEnglish()
            else -> ManEnglish()
        }
    }

    class ManRussian(
        override val zero: String = "человек",
        override val one: String = "человек",
        override val two: String = "человека",
        override val few: String = "человека",
        override val many: String = "человек",
        override val other: String = "человек"
    ) : Plural

    class ManEnglish(
        override val zero: String = "man",
        override val one: String = "man",
        override val two: String = "man",
        override val few: String = "man",
        override val many: String = "man",
        override val other: String = "man"
    ) : Plural
}