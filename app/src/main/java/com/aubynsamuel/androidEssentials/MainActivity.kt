package com.aubynsamuel.androidEssentials

//noinspection SuspiciousImport
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.aubynsamuel.androidEssentials.presentation.navigation.Navigation
import com.aubynsamuel.androidEssentials.presentation.theme.CardItTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content)) { view, insets ->
//            val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
//            view.updatePadding(bottom = bottom)
//            insets
//        }
        setContent {
            CardItTheme {
                Navigation()
            }
        }
    }
}