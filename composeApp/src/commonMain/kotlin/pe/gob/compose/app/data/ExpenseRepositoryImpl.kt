package pe.gob.compose.app.data

import pe.gob.compose.app.domain.ExpenseRepository
import pe.gob.compose.app.model.Expense
import pe.gob.compose.app.model.ExpenseCategory

class ExpenseRepositoryImpl(private val expenseManager: ExpenseManager) : ExpenseRepository {

    override fun getAllExpenses(): List<Expense> = expenseManager.fakeExpenseList

    override fun addExpense(expense: Expense) {
        expenseManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        expenseManager.editExpense(expense)
    }

    override fun deleteExpense(expense: Expense) {
        expenseManager.deleteExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> = expenseManager.getCategories()
}