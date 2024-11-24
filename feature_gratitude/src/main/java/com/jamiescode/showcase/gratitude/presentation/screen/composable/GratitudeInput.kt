package com.jamiescode.showcase.gratitude.presentation.screen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jamiescode.showcase.gratitude.R
import com.jamiescode.showcase.gratitude.presentation.screen.GratitudeViewModel
import com.jamiescode.showcase.theme.getIconColor
import com.jamiescode.showcase.theme.gratitudeFont

@Composable
fun gratitudeInput(viewModel: GratitudeViewModel) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.input_hint),
            textAlign = TextAlign.Center,
            fontFamily = gratitudeFont,
            fontSize = 20.sp,
        )
        gratitudeTextField(
            viewModel = viewModel,
            tintColor = getIconColor(),
        )
    }
}

@Composable
fun gratitudeTextField(
    viewModel: GratitudeViewModel,
    tintColor: Color,
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val submitEntry = {
        viewModel.addEntry(textFieldValue.text)
        textFieldValue = textFieldValue.copy(text = "")
        keyboardController?.hide()
        viewModel.scrollListToNewItem()
    }
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 32.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            textStyle = TextStyle.Default.copy(fontFamily = gratitudeFont, fontSize = 21.sp),
            modifier = Modifier.weight(1f),
            value = textFieldValue,
            onValueChange = { newText ->
                textFieldValue = newText
            },
            keyboardOptions =
                KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    imeAction = ImeAction.Send,
                ),
            keyboardActions =
                KeyboardActions(
                    onSend = { submitEntry() },
                ),
            maxLines = 1,
            colors =
                TextFieldDefaults.colors().copy(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = tintColor,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = tintColor,
                    unfocusedIndicatorColor = tintColor,
                ),
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(
            onClick = { submitEntry() },
        ) {
            Icon(
                Icons.AutoMirrored.Default.Send,
                contentDescription = stringResource(R.string.input_send_icon_content_desc),
                tint = tintColor,
            )
        }
    }
}
