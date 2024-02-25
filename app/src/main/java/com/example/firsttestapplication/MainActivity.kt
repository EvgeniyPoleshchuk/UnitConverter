package com.example.firsttestapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firsttestapplication.ui.theme.FirstTestApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            FirstTestApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    var expanded by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    var numberState by remember { mutableDoubleStateOf(0.0) }
    var textButton by remember { mutableStateOf("Select") }
    var textButton2 by remember { mutableStateOf("Select") }
    var result by remember { mutableDoubleStateOf(0.0) }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Unit Converter", modifier = Modifier.padding(10.dp), fontSize = 25.sp)

        OutlinedTextField(text, onValueChange = { text = it }, label = { Text("Enter value") })
        Spacer(modifier = Modifier.padding(5.dp))
        Row() {
            Box() {
                Button(onClick = { expanded = true }) {
                    Text(textButton)
                    Icon(Icons.Default.ArrowDropDown, "Arrow Down")
                }
                DropdownMenu(expanded, onDismissRequest = { expanded = false }) {
                    DropdownMenuItem({ Text("Centimetre") },
                        onClick = {
                            textButton = "Сантиметр"
                            numberState = (text.toDouble() * 10)
                            expanded = false
                        }
                    )
                    DropdownMenuItem({ Text("Meter") },
                        onClick = {
                            textButton = "Метр"
                            numberState = (text.toDouble() * 1000)
                            expanded = false
                        }
                    )
                    DropdownMenuItem({ Text("Foot") },
                        onClick = {
                            textButton = "Фут"
                            numberState = (text.toDouble() * 304.8)
                            expanded = false

                        }
                    )
                    DropdownMenuItem({ Text("Millimeter") },
                        onClick = {
                            textButton = "Миллиметр"
                            numberState = text.toDouble()
                            expanded = false
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))

            Box() {
                Button(onClick = { expanded2 = true }) {
                    Text(textButton2)
                    Icon(Icons.Default.ArrowDropDown, "Arrow Down")
                }
                DropdownMenu(expanded2, onDismissRequest = { expanded2 = false }) {
                    DropdownMenuItem({ Text("Сантиметр") },
                        onClick = {
                            textButton2 = "Centimeter"
                            result = (numberState / 10)
                            expanded2 = false
                        }
                    )
                    DropdownMenuItem({ Text("Meter") },
                        onClick = {
                            textButton2 = "Метр"
                            result = (numberState / 1000)
                            expanded2 = false
                        }
                    )
                    DropdownMenuItem({ Text("Foot") },
                        onClick = {
                            textButton2 = "Фут"
                            result = (numberState / 304.8)
                            expanded2 = false
                        }
                    )
                    DropdownMenuItem({ Text("Millimeter") },
                        onClick = {
                            textButton2 = "Миллиметр"
                            result = numberState
                            expanded2 = false
                        }
                    )

                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result:")
        Text(result.toString(), fontSize = 40.sp)


    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}