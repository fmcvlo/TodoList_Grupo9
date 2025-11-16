package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.LettersAndIcons
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.PoppinsFontFamily

@Composable
fun Input(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    placeholder: String = "",
    enabled: Boolean = true,
    singleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var passwordVisible by remember { mutableStateOf(false) }

    val inputTextStyle = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontSize = 12.sp,      // ↓ más chico para entrar en 41dp
        lineHeight = 14.sp,
        color = LettersAndIcons
    )

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Label
        Text(
            text = label,
            modifier = Modifier.padding(bottom = 8.dp, start = 16.dp),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            color = LettersAndIcons,
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            // Input Field
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 51.dp),
                enabled = enabled,
                singleLine = singleLine,
                placeholder = {
                    if (placeholder.isNotEmpty()) {
                        Text(
                            text = placeholder,
                            fontFamily = PoppinsFontFamily,
                            fontSize = 12.sp,
                            color = LettersAndIcons.copy(alpha = 0.6f)
                        )
                    }
                },
                visualTransformation = if (isPassword && !passwordVisible) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = if (isPassword) KeyboardType.Password else keyboardType
                ),
                trailingIcon = {
                    if (isPassword) {
                        IconButton(
                            onClick = { passwordVisible = !passwordVisible }
                        ) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                tint = LettersAndIcons
                            )
                        }
                    }
                },
                textStyle = inputTextStyle,
                shape = RoundedCornerShape(18.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = LightGreen,
                    unfocusedContainerColor = LightGreen,
                    disabledContainerColor = LightGreen.copy(alpha = 0.5f),
                    focusedBorderColor = LightGreen,
                    unfocusedBorderColor = LightGreen,
                    disabledBorderColor = LightGreen.copy(alpha = 0.5f),
                    focusedTextColor = LettersAndIcons,
                    unfocusedTextColor = LettersAndIcons,
                    disabledTextColor = LettersAndIcons.copy(alpha = 0.5f),
                    cursorColor = LettersAndIcons
                ),
            )
        }
    }
}
