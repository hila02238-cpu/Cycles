package com.example.cycles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.abs


fun calculateSeries(epsilon: Double): List<String> {
    var sum = 0.0
    var term = 1.0
    var n = 1

    while (abs(term) >= epsilon) {
        sum += term
        n++
        term = 1.0 / (n * n)
    }

    return listOf(
        "Сумма ряда: ${"%.6f".format(sum)}",
        "Последнее слагаемое: ${"%.6e".format(term)}",
        "Количество повторений: ${n - 1}"
    )
}


@Composable
fun CycleScreen() {

    var inputText by remember { mutableStateOf("0.0001") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Введите малое число (epsilon)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )

        val epsilon = inputText.toDoubleOrNull()

        if (epsilon != null && epsilon > 0) {
            calculateSeries(epsilon).forEach { Text(text = it) }
        } else if (inputText.isNotEmpty()) {
            Text(text = "Введите положительное число")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCycleScreen() {
    CycleScreen()
}