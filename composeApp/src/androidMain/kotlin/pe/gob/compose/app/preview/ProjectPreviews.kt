package pe.gob.compose.app.preview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.gob.compose.app.data.ExpenseManager
import pe.gob.compose.app.presentation.ExpensesUiState
import pe.gob.compose.app.ui.AlLExpensesHeader
import pe.gob.compose.app.ui.ExpenseScreen
import pe.gob.compose.app.ui.ExpensesItem
import pe.gob.compose.app.ui.ExpensesTotalHeader

@Preview(showBackground = true)
@Composable
private fun ExpensesTotalHeaderPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        ExpensesTotalHeader(total = 1028.8)
    }
}

@Preview(showBackground = true)
@Composable
private fun AllExpensesHeaderPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        AlLExpensesHeader()
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpensesItemPreview() {
    Box(modifier = Modifier.padding(8.dp)) {
        ExpensesItem(
            expense = ExpenseManager.fakeExpenseList[0]
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpenseScreenPreview() {
    ExpenseScreen(
        uiState = ExpensesUiState(
            expenses = ExpenseManager.fakeExpenseList,
            total = 1023.4
        )
    ) { }
}