package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import uk.co.jamiecruwys.gratitude.presentation.screen.GratitudeViewModel

@Composable
fun gratitudeInput(viewModel: GratitudeViewModel) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
                .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            value = textFieldValue,
            onValueChange = { newText ->
                textFieldValue = newText
            },
            placeholder = {
                Text(
                    text = "What are you grateful for?",
                    color = Color.White,
                )
            },
            maxLines = 1,
            colors =
                TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    cursorColor = Color.White,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                ),
            modifier = Modifier.weight(1f),
        )
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            onClick = {
                viewModel.addEntry(textFieldValue.text)
                textFieldValue = textFieldValue.copy(text = "")
            },
        ) {
            Icon(Icons.AutoMirrored.Default.Send, contentDescription = "Send", tint = Color.White)
        }
    }
}
