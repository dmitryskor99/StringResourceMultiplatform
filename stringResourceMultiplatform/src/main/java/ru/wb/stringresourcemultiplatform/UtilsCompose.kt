package ru.wb.stringresourcemultiplatform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@Composable
@ReadOnlyComposable
fun stringCompose(res: StringRes): String = string(res)

@Composable
@ReadOnlyComposable
fun stringCompose(res: StringRes, vararg formatArgs: Any): String = string(res, *formatArgs)

@Composable
@ReadOnlyComposable
fun pluralCompose(count: Int, res: PluralRes): String = plural(count, res)

@Composable
@ReadOnlyComposable
fun pluralCompose(count: Int, res: PluralRes, vararg formatArgs: Any): String =
    plural(count, res, *formatArgs)