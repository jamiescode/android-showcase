package com.jamiescode.showcase.construction.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import com.jamiescode.showcase.construction.R
import com.jamiescode.showcase.theme.gratitudeFont

@Composable
fun underConstructionScreen(viewModel: UnderConstructionViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.onRandomButtonPressed()
    }

    val state =
        viewModel.stateLiveData.asFlow().collectAsState(
            initial = UnderConstructionViewModel.State.Initial,
        )

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(R.drawable.construction),
            contentDescription = stringResource(R.string.under_construction_icon_content_description),
            modifier = Modifier.size(96.dp),
        )
        Text(
            text = stringResource(R.string.under_construction_title),
            fontFamily = gratitudeFont,
            fontSize = 44.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.under_construction_description),
            fontFamily = gratitudeFont,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(32.dp))
        underConstructionImageState(state = state.value)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(64.dp),
            onClick = { viewModel.onRandomButtonPressed() },
        ) {
            Text(
                text = stringResource(R.string.under_construction_image_button_text),
                fontFamily = gratitudeFont,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
