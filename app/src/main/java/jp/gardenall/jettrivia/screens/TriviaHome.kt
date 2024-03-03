package jp.gardenall.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import jp.gardenall.jettrivia.component.Questions

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    Questions(viewModel = viewModel)
}