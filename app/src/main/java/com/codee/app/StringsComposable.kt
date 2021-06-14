package com.codee.app

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.codee.core.strings.Strings


@Preview
@Composable
fun StringsComposable() {
    val strings by remember { Strings }

    Text (
        text = strings.hello,
        modifier = Modifier.width(IntrinsicSize.Max).height(IntrinsicSize.Max),
        color = Color.White
    )
}
