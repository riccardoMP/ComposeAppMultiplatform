package pe.gob.compose.app.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.ElectricCar
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.OtherHouses
import androidx.compose.material.icons.filled.PartyMode
import androidx.compose.ui.graphics.vector.ImageVector

data class Expense(
    val id: Long = -1,
    val amount: Double,
    val category: ExpenseCategory,
    val description: String
){
    val icon = category.icon
}

enum class ExpenseCategory(val icon: ImageVector) {
    PARTY(Icons.Default.PartyMode),
    SNACKS(Icons.Default.Fastfood),
    COFFEE(Icons.Default.Coffee),
    CAR(Icons.Default.ElectricCar),
    HOUSE(Icons.Default.House),
    OTHER(Icons.Default.OtherHouses),
}