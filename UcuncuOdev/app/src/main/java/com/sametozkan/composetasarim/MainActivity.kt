package com.sametozkan.composetasarim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sametozkan.composetasarim.ui.theme.Black
import com.sametozkan.composetasarim.ui.theme.Blue
import com.sametozkan.composetasarim.ui.theme.ComposeTasarimTheme
import com.sametozkan.composetasarim.ui.theme.Gray
import com.sametozkan.composetasarim.ui.theme.Green
import com.sametozkan.composetasarim.ui.theme.Red
import com.sametozkan.composetasarim.ui.theme.White
import com.sametozkan.composetasarim.ui.theme.robotoBold
import com.sametozkan.composetasarim.ui.theme.robotoMedium
import com.sametozkan.composetasarim.ui.theme.robotoRegular

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTasarimTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Anasayfa()
                }
            }
        }
    }
}

@Composable
fun Anasayfa() {
    Scaffold(topBar = { Toolbar() }, bottomBar = {
        NavigationBar()
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Background()
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                AvailableBalance()
                CustomCard()
                Transaction()
            }

        }
    }
}

@Composable
fun NavigationBar() {
    NavigationBar(containerColor = White, contentColor = Black) {
        NavigationBarItem(selected = true, onClick = {}, icon = {
            Icon(
                Icons.Default.Home, contentDescription = ""
            )
        })
        NavigationBarItem(selected = false, onClick = {}, icon = {
            Icon(
                Icons.Default.Favorite, contentDescription = ""
            )
        })
        NavigationBarItem(selected = false, onClick = {}, icon = {
            Icon(
                Icons.Default.Email, contentDescription = ""
            )
        })
        NavigationBarItem(selected = false, onClick = {}, icon = {
            Icon(
                Icons.Default.Settings, contentDescription = ""
            )
        })
    }
}

@Composable
fun Background() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .height(500.dp)
                .background(Blue)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tech),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .graphicsLayer(alpha = 0.2f),
                contentScale = ContentScale.FillWidth
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .height(500.dp)
                .background(Gray)
        )
    }
}

@Composable
fun AvailableBalance() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.CheckCircle,
                contentDescription = "",
                tint = White,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                text = stringResource(id = R.string.us_dollar),
                fontSize = 16.sp,
                color = White,
                fontFamily = robotoMedium
            )
            Icon(Icons.Default.ArrowDropDown, contentDescription = "", tint = White)
        }
        Text(
            text = "$20,000",
            fontSize = 36.sp,
            fontFamily = robotoBold,
            color = White,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Text(
            text = stringResource(id = R.string.available_balance),
            fontSize = 16.sp,
            fontFamily = robotoMedium,
            color = White,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(10.dp),
            border = BorderStroke(1.dp, White)
        ) {
            Row {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = "",
                    tint = White,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
                Text(
                    text = stringResource(id = R.string.add_money),
                    fontSize = 16.sp,
                    color = White,
                    fontFamily = robotoMedium,
                )
            }
        }
    }
}

@Composable
fun CustomCard() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Transparent), shape = RoundedCornerShape(16.dp), colors = CardColors(
            containerColor = White,
            contentColor = Black,
            disabledContainerColor = White,
            disabledContentColor = Black
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painterResource(id = R.drawable.send),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "",
                    tint = LocalContentColor.current
                )
                Text(
                    text = stringResource(id = R.string.send),
                    fontSize = 16.sp,
                    fontFamily = robotoMedium,
                )
            }
            VerticalDivider(modifier = Modifier.height(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painterResource(id = R.drawable.request),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "",
                    tint = LocalContentColor.current
                )
                Text(
                    text = stringResource(id = R.string.request),
                    fontSize = 16.sp,
                    fontFamily = robotoMedium,
                )
            }
            VerticalDivider(modifier = Modifier.height(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painterResource(id = R.drawable.bank),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "",
                    tint = LocalContentColor.current
                )
                Text(
                    text = stringResource(id = R.string.bank),
                    fontSize = 16.sp,
                    fontFamily = robotoMedium,
                )
            }
        }
    }
}

@Composable
fun Transaction() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            Text(
                text = stringResource(id = R.string.transaction),
                fontSize = 22.sp,
                fontFamily = robotoBold
            )
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            shape = RoundedCornerShape(16.dp),
            colors = CardColors(
                containerColor = White,
                contentColor = Black,
                disabledContainerColor = White,
                disabledContentColor = Black
            )
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.spending),
                        modifier = Modifier.size(24.dp),
                        contentDescription = ""
                    )
                    Text(
                        text = stringResource(id = R.string.spending),
                        fontSize = 22.sp,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        fontFamily = robotoRegular,
                    )
                    Text(
                        text = "$500",
                        fontSize = 22.sp,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        color = Red,
                        fontFamily = robotoRegular,
                    )
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
                }
                HorizontalDivider()
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.income),
                        modifier = Modifier.size(24.dp),
                        contentDescription = ""
                    )
                    Text(
                        text = stringResource(id = R.string.income),
                        fontSize = 22.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        text = "$3000",
                        fontSize = 22.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        color = Green
                    )
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
                }
                HorizontalDivider()
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.bills),
                        modifier = Modifier.size(24.dp),
                        contentDescription = ""
                    )
                    Text(
                        text = stringResource(id = R.string.bills),
                        fontSize = 22.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        text = "-$800",
                        fontSize = 22.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        color = Red
                    )
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
                }
                HorizontalDivider()
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.savings),
                        modifier = Modifier.size(24.dp),
                        contentDescription = ""
                    )
                    Text(
                        text = stringResource(id = R.string.savings),
                        fontSize = 22.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        text = "$1000",
                        fontSize = 22.sp,
                        fontFamily = robotoRegular,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        color = Green
                    )
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(title = {
        TextField(value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_payments),
                    fontSize = 10.sp,
                    color = Black,
                    fontFamily = robotoRegular
                )
            },
            modifier = Modifier.padding(vertical = 10.dp),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = White,
                focusedContainerColor = White,
            )
        )
    }, navigationIcon = {
        IconButton(onClick = {}) {
            Icon(
                painterResource(id = R.drawable.trophy),
                modifier = Modifier.size(24.dp),
                contentDescription = stringResource(id = R.string.menu_icon),
                tint = White
            )
        }
    }, actions = {
        IconButton(onClick = {}) {
            Icon(
                painterResource(id = R.drawable.notification),
                modifier = Modifier.size(24.dp),
                contentDescription = stringResource(id = R.string.more_icon),
                tint = White
            )
        }
    }, colors = topAppBarColors(
        containerColor = Blue
    )
    )
}


@Preview(showBackground = true)
@Composable
fun AnasayfaPreview() {
    ComposeTasarimTheme {
        Anasayfa()
    }
}