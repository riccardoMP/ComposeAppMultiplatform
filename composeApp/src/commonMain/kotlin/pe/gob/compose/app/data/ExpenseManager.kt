package pe.gob.compose.app.data

import pe.gob.compose.app.model.Expense
import pe.gob.compose.app.model.ExpenseCategory

object ExpenseManager {
    private var currentId = 1L

    val fakeExpenseList = mutableListOf(
        Expense(
            id = currentId++,
            amount = 70.0,
            description = "Weekly Buy",
            category = ExpenseCategory.SNACKS
        ),
        Expense(
            id = currentId++,
            amount = 100000.5,
            description = "Subaru XV",
            category = ExpenseCategory.CAR
        ),
        Expense(
            id = currentId++,
            amount = 120.0,
            description = "Weekend party",
            category = ExpenseCategory.PARTY
        ),
        Expense(
            id = currentId++,
            amount = 50.0,
            description = "Services",
            category = ExpenseCategory.OTHER
        ),
        Expense(
            id = currentId++,
            amount = 50.0,
            description = "The Micaela",
            category = ExpenseCategory.COFFEE
        )
    )

    fun addNewExpense(expense: Expense) {
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun editExpense(expense: Expense) {
        val index: Int = fakeExpenseList.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            fakeExpenseList[index] =
                fakeExpenseList[index].copy(
                    amount = expense.amount,
                    category = expense.category,
                    description = expense.description
                )
        }
    }

    fun deleteExpense(expense: Expense) {
        val index: Int = fakeExpenseList.indexOfFirst { it.id == expense.id }

        fakeExpenseList.removeAt(index)
    }

    fun getCategories(): List<ExpenseCategory> {
        return listOf(
            ExpenseCategory.CAR,
            ExpenseCategory.COFFEE,
            ExpenseCategory.HOUSE,
            ExpenseCategory.OTHER,
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACKS
        )
    }
}
