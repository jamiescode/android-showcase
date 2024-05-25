package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.co.jamiecruwys.showcase.theme.gratitudeFont
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun gratitudeDateDivider(date: Date?, dateStringFallback: String,) {
    val string = date?.let {
        SimpleDateFormat("EEEE MMMM dd yyyy").format(it)
    } ?: dateStringFallback
    Text(
        modifier = Modifier.fillMaxWidth().background(Color.White).padding(horizontal = 16.dp, vertical = 8.dp),
        text = string,
        fontFamily = gratitudeFont,
        fontSize = 16.sp,
    )
}
