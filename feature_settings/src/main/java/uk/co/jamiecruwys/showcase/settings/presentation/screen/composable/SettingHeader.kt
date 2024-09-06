package uk.co.jamiecruwys.showcase.settings.presentation.screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.co.jamiecruwys.showcase.theme.gratitudeFont

@Composable
fun SettingHeader(title: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            fontFamily = gratitudeFont,
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
        )
        HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
    }
}
