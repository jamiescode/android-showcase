package uk.co.jamiecruwys.showcase.settings.presentation.screen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.co.jamiecruwys.showcase.theme.getIconColor
import uk.co.jamiecruwys.showcase.theme.gratitudeFont

@Composable
fun switchSetting(
    icon: ImageVector,
    iconContentDescription: String,
    title: String,
    checked: Boolean,
    onClick: (Boolean) -> Unit,
) {
    Surface(
        color = Color.Transparent,
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        onClick = { onClick(!checked) },
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        icon,
                        contentDescription = iconContentDescription,
                        modifier = Modifier.size(24.dp),
                        tint = getIconColor(),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = title,
                        modifier = Modifier.padding(16.dp),
                        fontFamily = gratitudeFont,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Start,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = checked,
                    onCheckedChange = { onClick(!checked) },
                )
            }
        }
    }
}
