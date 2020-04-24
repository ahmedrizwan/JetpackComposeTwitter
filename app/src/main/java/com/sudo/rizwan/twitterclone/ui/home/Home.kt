package com.sudo.rizwan.twitterclone.ui.home

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.material.Scaffold
import androidx.ui.material.ScaffoldState

@Composable
fun Home(scaffoldState: ScaffoldState = remember { ScaffoldState() }) {
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { AppDrawer() },
        bodyContent = { modifier -> Content(scaffoldState = scaffoldState) },
        floatingActionButton = { Fab() },
        bottomAppBar = { BottomBar() }
    )
}
