package pe.gob.compose.app.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.viewmodel.viewModel
import pe.gob.compose.app.data.ExpenseManager
import pe.gob.compose.app.data.ExpenseRepositoryImpl
import pe.gob.compose.app.getColorsTheme
import pe.gob.compose.app.presentation.ExpensesViewModel
import pe.gob.compose.app.ui.ExpenseScreen
import androidx.compose.runtime.getValue
import moe.tlaster.precompose.navigation.path
import pe.gob.compose.app.model.Expense
import pe.gob.compose.app.ui.ExpensesDetailScreen

@Composable
fun Navigation(navigator: Navigator) {

    val colors = getColorsTheme()
    val viewModel = viewModel(modelClass = ExpensesViewModel::class) {
        ExpensesViewModel(ExpenseRepositoryImpl(ExpenseManager))
    }

    NavHost(
        modifier = Modifier.background(color = colors.backgroundColor),
        navigator = navigator,
        initialRoute = "/home"
    ) {

        scene(route = "/home") {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ExpenseScreen(uiState) { expense ->
                navigator.navigate("/addExpenses/${expense.id}")
            }
        }

        scene(route = "/addExpenses/{id}?") {
            val idFromPath = it.path<Long>("id")
            val expenseToEditOrAdd: Expense? =
                idFromPath?.let { id -> viewModel.getExpensesWithId(id) }

            ExpensesDetailScreen(
                expenseToEdit = expenseToEditOrAdd,
                categoryList = viewModel.getCategories()
            ) { expense ->
                if (expenseToEditOrAdd == null) {
                    viewModel.addExpense(expense)
                } else {
                    viewModel.editExpense(expense)
                }

                navigator.popBackStack()
            }

        }
    }
}