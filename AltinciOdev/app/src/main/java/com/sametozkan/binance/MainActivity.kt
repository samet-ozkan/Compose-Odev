package com.sametozkan.binance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sametozkan.binance.ui.theme.BackgroundColor
import com.sametozkan.binance.ui.theme.BinanceTheme
import com.sametozkan.binance.ui.theme.BottomBarColor
import com.sametozkan.binance.ui.theme.Gray
import com.sametozkan.binance.ui.theme.Green
import com.sametozkan.binance.ui.theme.Red
import com.sametozkan.binance.ui.theme.SelectedButtonColor
import com.sametozkan.binance.ui.theme.White
import com.sametozkan.binance.ui.theme.Yellow
import com.sametozkan.binance.ui.theme.textStyleNormal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BinanceTheme {
                Anasayfa()
            }
        }
    }
}

@Composable
fun Anasayfa() {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar =
        { BottomNavBar() },
    )
    { paddingValues ->
        Content(paddingValues)
    }
}

@Preview(showBackground = true, device = "id:pixel_2")
@Composable
fun AnasayfaPreview() {
    Anasayfa()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logo_binance_app),
                contentDescription = "Left Image",
                modifier = Modifier
                    .size(46.dp)
                    .padding(start = 16.dp)
            )
        },
        title = {},
        actions = {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth(0.3f)) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_payment_24),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(24.dp)
                )

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundColor,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
    )
}


@Composable
fun Content(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(horizontal = 16.dp).padding(vertical = 5.dp)
        ) {
            Text(
                text = "Toplam Bakiye",
                color = White,
                fontSize = 14.sp,
                style = textStyleNormal,
                modifier = Modifier.padding(end = 5.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                tint = Gray,
                contentDescription = "Logo",
                modifier = Modifier.size(16.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "$14.320047",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                style = textStyleNormal,
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = { },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Yellow,
                    contentColor = BackgroundColor
                )
            ) {
                Text(
                    text = "Fon Ekle",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Gray, thickness = 1.dp)
        Refer2EarnSection()
        HorizontalDivider(color = Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "İzleme Listesi",
                color = Gray,
                fontSize = 20.sp,
                style = textStyleNormal,
                modifier = Modifier.padding(end = 10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Coin",
                color = Color.White,
                style = textStyleNormal,
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        SelectionOptions()
        Spacer(modifier = Modifier.height(8.dp))
        CoinList()
    }
}

@Composable
fun Refer2EarnSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 5.dp)
            .background(BottomBarColor)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Refer2Earn Together",
                    color = Gray,
                    fontSize = 14.sp,
                )
                Text(
                    text = "Refer2Earn: Earn Up to 1550USDC Token Voucher",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.earn_together),
                contentDescription = "Refer Image",
                modifier = Modifier.size(100.dp).padding(10.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun SelectionOptions() {
    val options = listOf("Popüler", "Piyasa Değeri", "Fiyat", "24s Değişim")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(options) { option ->

            if (option == "Popüler") {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SelectedButtonColor,
                        contentColor = White
                    ),
                    shape = RoundedCornerShape(24.dp),
                    contentPadding = PaddingValues(
                        10.dp,
                    ),
                    modifier = Modifier.padding(end = 8.dp).wrapContentSize()
                ) {
                    Text(
                        text = option,
                        color = White,
                        fontSize = 12.sp
                    )
                }
            } else {
                Text(
                    text = option,
                    color = Gray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }
    }
}

@Composable
fun CoinList() {
    val context = LocalContext.current

    val coins = listOf(
        Coin(
            name = "Bitcoin",
            abbreviation = "BTC",
            percentageChange = 2.46,
            marketValue = 58990.7,
            icon = ImageBitmap.imageResource(context.resources, R.drawable.btc)
        ),
        Coin(
            name = "Ethereum",
            abbreviation = "ETH",
            percentageChange = 3.14,
            marketValue = 2518.94,
            icon = ImageBitmap.imageResource(context.resources, R.drawable.eth)
        ),
        Coin(
            name = "BNB",
            abbreviation = "BNB",
            percentageChange = 6.27,
            marketValue = 533.9,
            icon = ImageBitmap.imageResource(context.resources, R.drawable.bnb)
        ),
        Coin(
            name = "Flow",
            abbreviation = "FLOW",
            percentageChange = -7.12,
            marketValue = 0.56227,
            icon = ImageBitmap.imageResource(context.resources, R.drawable.flow)
        ),
        Coin(
            name = "Gnosis",
            abbreviation = "GNO",
            percentageChange = 3.2,
            marketValue = 147.44,
            icon = ImageBitmap.imageResource(context.resources, R.drawable.gno)
        ),
        Coin(
            name = "DigiByte",
            abbreviation = "DGB",
            percentageChange = -2.2,
            marketValue = 0.006527,
            icon = ImageBitmap.imageResource(context.resources, R.drawable.dgb)
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(coins) { coin ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    bitmap = coin.icon,
                    contentDescription = "Coin Image",
                    modifier = Modifier.size(24.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = coin.name,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = coin.abbreviation,
                        color = Gray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${if (coin.percentageChange >= 0) "+" else ""}${coin.percentageChange}%",
                        color = if (coin.percentageChange >= 0) Green else Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "${"%.2f".format(coin.marketValue)} $",
                        color = White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 2.dp)
                        )
                }
            }
        }
    }
}

@Composable
fun BottomNavBar() {
    var selectedIndex by remember { mutableStateOf(0) }
    val items = listOf("Piyasalar", "Square", "Dönüştür", "Keşfedin", "Portföy")
    val icons = listOf(
        painterResource(id = R.drawable.baseline_bar_chart_24),
        painterResource(id = R.drawable.baseline_rss_feed_24),
        painterResource(id = R.drawable.baseline_compare_arrows_24),
        painterResource(id = R.drawable.baseline_explore_24),
        painterResource(id = R.drawable.baseline_account_balance_wallet_24)
    )

    NavigationBar(
        containerColor = BottomBarColor,
        contentColor = White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = icons[index],
                        contentDescription = item
                    )
                },
                label = { Text(item) },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = White,
                    selectedTextColor = White,
                    unselectedIconColor = Gray,
                    unselectedTextColor = Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}