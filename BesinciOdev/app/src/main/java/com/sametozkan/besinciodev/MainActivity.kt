package com.sametozkan.besinciodev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sametozkan.besinciodev.ui.theme.BackgroundColor
import com.sametozkan.besinciodev.ui.theme.BesinciOdevTheme
import com.sametozkan.besinciodev.ui.theme.ButonColor
import com.sametozkan.besinciodev.ui.theme.IslemButonColor
import com.sametozkan.besinciodev.ui.theme.IslemColor
import com.sametozkan.besinciodev.ui.theme.Mavi
import com.sametozkan.besinciodev.ui.theme.SayiColor
import com.sametozkan.besinciodev.ui.theme.SonucColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BesinciOdevTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HesapMakinesi()
                }
            }
        }
    }
}

@Composable
fun HesapMakinesi() {
    val islem = remember {
        mutableStateOf("")
    }

    val sonuc = remember {
        mutableStateOf("0.0")
    }

    fun sonucHesapla(islemStr: String): Double {
        if (islemStr.isNotEmpty()) {
            val lastChar = islemStr.last()
            if (lastChar.isDigit()) {
                val sayilar = islemStr.split("+").map {
                    it.toDouble()
                }
                return sayilar.sum()
            } else {
                val yeniIslemStr = islemStr.substringBeforeLast(lastChar)
                return sonucHesapla(yeniIslemStr)
            }
        }
        return 0.0
    }

    val sayiOnClick: (String) -> Unit = {
        islem.value = islem.value.plus(it)
        sonuc.value = sonucHesapla(islem.value).toString()
    }

    val noktaOnClick: (String) -> Unit = {
        if (it.isNotEmpty()) {
            val lastChar = it.last()
            if (lastChar.isDigit()) {
                if (!it.substringAfterLast('+')
                        .contains('.')
                ) {
                    islem.value = it.plus(".")
                }
            }
        }
    }

    val artiOnClick: (String) -> Unit = {
        if (it.isNotEmpty()) {
            val lastChar = it.last()
            println("Last $lastChar - ${lastChar.isDigit()}")
            if (lastChar.isDigit()) {
                islem.value = islem.value.plus("+")
            }
        }
    }

    val sifirlaOnClick = {
        islem.value = ""
        sonuc.value = "0.0"
    }

    val temizleOnClick = {
        if (islem.value.isNotEmpty()) {
            islem.value = islem.value.dropLast(1)
            sonuc.value = sonucHesapla(islem.value).toString()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .weight(0.4f, true)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = islem.value,
                fontSize = 28.sp,
                color = IslemColor
            )
            Text(
                modifier = Modifier.padding(10.dp),
                text = sonuc.value,
                fontSize = 36.sp,
                color = SonucColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f, true)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.7f, true),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f, true),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TusButton(text = "1", onClick = { sayiOnClick("1") })
                    TusButton(text = "2", onClick = { sayiOnClick("2") })
                    TusButton(text = "3", onClick = { sayiOnClick("3") })
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f, true),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TusButton(text = "4", onClick = { sayiOnClick("4") })
                    TusButton(text = "5", onClick = { sayiOnClick("5") })
                    TusButton(text = "6", onClick = { sayiOnClick("6") })
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f, true),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TusButton(text = "7", onClick = { sayiOnClick("7") })
                    TusButton(text = "8", onClick = { sayiOnClick("8") })
                    TusButton(text = "9", onClick = { sayiOnClick("9") })
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f, true),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TusButton(
                        textColor = Mavi,
                        text = ".",
                        onClick = { noktaOnClick(islem.value) },
                        buttonColor = IslemButonColor
                    )
                    TusButton(text = "0", onClick = { sayiOnClick("0") })
                    TusButton(
                        textColor = Mavi,
                        text = "C",
                        onClick = { sifirlaOnClick() },
                        buttonColor = IslemButonColor
                    )
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.3f, true),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TusButton(
                    textColor = Mavi,
                    text = "+", onClick = { artiOnClick(islem.value) }, modifier =
                    Modifier
                        .weight(0.75f, true)
                        .fillMaxWidth(), buttonColor = IslemButonColor
                )
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = IslemButonColor),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f, true)
                        .padding(10.dp),
                    onClick = { temizleOnClick() }) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_backspace_24),
                        contentDescription = "backspace"
                    )
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun HesapMakinesiPreview() {
    BesinciOdevTheme {
        HesapMakinesi()
    }
}

@Composable
fun TusButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color = ButonColor,
    textColor: Color = SayiColor,
    fontSize: TextUnit = 32.sp
) {
    TextButton(
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(10.dp)
            .fillMaxHeight(),
        onClick = onClick
    ) {
        Text(text = text, fontSize = fontSize, color = textColor)
    }
}
