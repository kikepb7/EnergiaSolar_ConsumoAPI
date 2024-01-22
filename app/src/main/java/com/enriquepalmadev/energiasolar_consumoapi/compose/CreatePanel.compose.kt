package com.enriquepalmadev.energiasolar_consumoapi.compose


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CreatePanel() {
    var textField1 by remember { mutableStateOf("") }
    var textField2 by remember { mutableStateOf("") }
    var floatField by remember { mutableFloatStateOf(0f) }
    var textField3 by remember { mutableStateOf("") }
    var textField4 by remember { mutableStateOf("") }
    var intField by remember { mutableStateOf(0) }
    var floatField2 by remember { mutableStateOf(0f) }
    var dateField by remember { mutableStateOf("") }

    var isKeyboardVisible by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = textField1,
            onValueChange = { textField1 = it },
            label = { Text("Marca") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            value = textField2,
            onValueChange = { textField2 = it },
            label = { Text("Categoría") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = floatField.toString(),
            onValueChange = { value ->
                floatField = value.toFloatOrNull() ?: 0f
            },
            label = { Text("Eficiencia") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            value = textField3,
            onValueChange = { textField3 = it },
            label = { Text("Imagen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            value = textField4,
            onValueChange = { textField4 = it },
            label = { Text("Modelo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = intField.toString(),
            onValueChange = { value ->
                intField = value.toIntOrNull() ?: 0
            },
            label = { Text("Potencia nominal") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = floatField2.toString(),
            onValueChange = { value ->
                floatField2 = value.toFloatOrNull() ?: 0f
            },
            label = { Text("Precio") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Use Date Picker or Date Text Field as per your preference
        DateTextField(
            value = dateField,
            onValueChange = { dateField = it },
            label = { Text("Fecha de producción") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Handle form submission
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.width(4.dp))
            Text("Registrar")
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DateTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val softwareKeyboardController = LocalSoftwareKeyboardController.current

    var isFocused by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = label,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                softwareKeyboardController?.hide()
                isFocused = false
            }
        ),
        modifier = modifier
            .onFocusChanged {
                isFocused = it.isFocused
            }
            .onGloballyPositioned { coordinates ->
                if (isFocused) {
                    // Ensure the keyboard is visible when the field gains focus
                    softwareKeyboardController?.show()
                }
            }
    )
}

@Preview(showBackground = true)
@Composable
fun CreatePanelPreview() {
    CreatePanel()
}