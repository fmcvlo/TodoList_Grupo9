package ro.alexmamo.roomjetpackcompose.presentation.book_list.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ro.alexmamo.roomjetpackcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListTopBar() {
    TopAppBar (
        title = {
            Text(
                text = stringResource(
                    id = R.string.book_list_screen_title
                )
            )
        }
    )
}