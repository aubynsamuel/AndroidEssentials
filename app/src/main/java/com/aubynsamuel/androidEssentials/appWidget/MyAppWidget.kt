package com.aubynsamuel.androidEssentials.appWidget

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.aubynsamuel.androidEssentials.MainActivity

class MyAppWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        provideContent {
            MaterialTheme {
                MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        var counter by remember { mutableIntStateOf(0) }
        Column(
            modifier = GlanceModifier.Companion.fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer).padding(16.dp),
            verticalAlignment = Alignment.Companion.CenterVertically,
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {
            Text(
                text = "Android Essentials",
                modifier = GlanceModifier.Companion.padding(12.dp), style = TextStyle().copy(
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize
                )
            )

            Text(
                text = "Counter: $counter",
                modifier = GlanceModifier.Companion.padding(12.dp)
            )

            Row(horizontalAlignment = Alignment.Companion.CenterHorizontally) {
                Button(
                    text = "Increment",
                    onClick = { counter++ }
                )
                Spacer(modifier = GlanceModifier.Companion.width(20.dp))
                Button(
                    text = "Decrement",
                    onClick = { counter-- }
                )
            }

            Spacer(modifier = GlanceModifier.Companion.height(10.dp))

            Button(
                text = "Open App",
                onClick = actionStartActivity<MainActivity>()
            )
        }
    }
}