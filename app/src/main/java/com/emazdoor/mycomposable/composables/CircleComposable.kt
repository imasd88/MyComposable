package com.emazdoor.mycomposable.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CircleComposable(text: String, block: () -> Unit) {
    Card(
        shape = CircleShape,
        backgroundColor = Color.White,
        modifier = Modifier
            .size(150.dp)
            .clickable(indication = null, interactionSource = MutableInteractionSource()) { block() },
        elevation = 2.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = text)
        }

    }
}
