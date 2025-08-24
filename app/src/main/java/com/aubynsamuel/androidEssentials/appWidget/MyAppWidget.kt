package com.aubynsamuel.androidEssentials.appWidget

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
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
    val countKeyString = "count"
    val countKey = intPreferencesKey(countKeyString)

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MaterialTheme {
                MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        val count = currentState(key = countKey) ?: 0
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
                text = "Counter: $count",
                modifier = GlanceModifier.Companion.padding(12.dp)
            )

            Row(horizontalAlignment = Alignment.Companion.CenterHorizontally) {
                Button(
                    text = "Increment",
                    onClick = actionRunCallback<Increment>()
                )
                Spacer(modifier = GlanceModifier.Companion.width(20.dp))
                Button(
                    text = "Decrement",
                    onClick = actionRunCallback<Decrement>()
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

class Increment() : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            val currentCount = prefs[MyAppWidget().countKey]
            if (currentCount != null) {
                prefs[MyAppWidget().countKey] = currentCount + 1
            } else {
                prefs[MyAppWidget().countKey] = 1
            }
        }
        MyAppWidget().update(context, glanceId)
    }
}

class Decrement() : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            val currentCount = prefs[MyAppWidget().countKey]
            if (currentCount != null) {
                prefs[MyAppWidget().countKey] = currentCount - 1
            } else {
                prefs[MyAppWidget().countKey] = 0
            }
        }
        MyAppWidget().update(context, glanceId)
    }
}