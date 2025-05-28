package com.aubynsamuel.androidEssentials.presentation.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddReaction
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    val searchBarState = rememberSearchBarState()
    val scope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val textFieldState = rememberTextFieldState()
    val context = LocalContext.current
    var searchText by remember { mutableIntStateOf(0) }

    @OptIn(ExperimentalMaterial3Api::class)
    val inputField = @Composable {
        SearchBarDefaults.InputField(
            modifier = Modifier,
            searchBarState = searchBarState,
            textFieldState = textFieldState,
            onSearch = { value ->
                if (value.toIntOrNull() is Int)
                    searchText = value.toInt()
                else {
                    searchText = 0
                    Toast.makeText(context, "Enter a number", Toast.LENGTH_LONG).show()
                }
            },
            placeholder = {
                Text(
                    "Search...",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            leadingIcon = {
                if (searchBarState.currentValue == SearchBarValue.Expanded) {
                    IconButton(onClick = {
                        scope.launch {
                            searchBarState.animateToCollapsed()
                            textFieldState.clearText()
                        }
                    }) {
                        Icon(
                            Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                } else {
                    /**/
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (textFieldState.text.isNotBlank())
                        textFieldState.clearText()
                    else
                        Toast.makeText(
                            context,
                            "Nothing to do",
                            Toast.LENGTH_LONG
                        ).show()
                }) {
                    if (textFieldState.text.isNotBlank())
                        Icon(Icons.Default.Clear, contentDescription = "Clear search")
                    else {
                        //
                    }
                }
            }
        )
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar =
            {
                CenterAlignedTopAppBar(
                    scrollBehavior = scrollBehavior,
                    title = {
                        SearchBar(
                            state = searchBarState,
                            inputField = inputField,
                        )
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Default.ToggleOff,
                                contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }, navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.AddReaction,
                                contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                )
                ExpandedFullScreenSearchBar(
                    state = searchBarState,
                    inputField = inputField,
                    content = {
                        LazyColumn(
                            contentPadding = PaddingValues(10.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            val list = List(searchText) { "Text $it" }
                            items(count = list.size) {
                                Text(
                                    text = list[it],
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp),
                                    textAlign = TextAlign.Center,
                                    fontSize = 18.sp
                                )
                            }

                        }
                    }
                )
            }
    )
    { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val list = List(100) { "Text $it" }
            items(count = list.size) {
                Text(
                    text = list[it],
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center, fontSize = 18.sp


                )
            }
        }
    }
}