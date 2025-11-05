package ro.alexmamo.roomjetpackcompose.presentation.book_list.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun InsertBookFloatingActionButton(
    onInsertBookFloatingActionButtonClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onInsertBookFloatingActionButtonClick
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(
                id = R.string.open_insert_book_dialog
            )
        )
    }
}