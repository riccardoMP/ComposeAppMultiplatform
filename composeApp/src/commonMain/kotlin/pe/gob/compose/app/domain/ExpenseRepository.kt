package pe.gob.compose.app.domain

import pe.gob.compose.app.model.Expense
import pe.gob.compose.app.model.ExpenseCategory

interface ExpenseRepository {
    fun getAllExpenses(): List<Expense>
    fun addExpense(expense: Expense)
    fun editExpense(expense: Expense)
    fun deleteExpense(expense: Expense)
    fun getCategories(): List<ExpenseCategory>
}