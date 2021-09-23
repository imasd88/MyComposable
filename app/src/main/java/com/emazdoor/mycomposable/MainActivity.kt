package com.emazdoor.mycomposable

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val array = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8)
        setContent {
//            ScrollableColumnDemo()
            LazyColumns() {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun LazyColumns(selectedItem: (String) -> Unit) { //RecyclerView
//    val scrollState = rememberScrollState()
    LazyColumn(Modifier.clickable { selectedItem("item clicked") }) {
        items(100) {
            Text(
                text = "Name ${it + 1}",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it selected") }
            )
            Divider(color = Color.DarkGray, thickness = 5.dp)
        }
    }
}

@Composable
fun ScrollableColumnDemo() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for (i in 1..100) {
            Text(
                text = "User name $i",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun ColumnLayout(array: List<Int>) {
    Column(
        modifier = Modifier

            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        for (element in array)
            ListItem(
                text = { Text("Two line list item with 40x40 icon") },
                secondaryText = { Text("Secondary text $element") },
                icon = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }
            )
//                Greeting("$element")
//                Greeting("iOS")
//                Greeting("Web")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Red)
            .border(2.dp, color = Color.DarkGray)
            .shadow(1.dp)
            .padding(10.dp)
            .clickable {
                Log.e("ASD", "I am clicked")
            }

    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    Greeting("Android")
    BoxWithBackground()
}

@Composable
fun BoxLayout() {
    Box(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize(),
//        contentAlignment = Alignment.TopCenter,
    ) {
        Box(
            modifier = Modifier
                .background(Color.DarkGray)
                .align(Alignment.TopCenter)
                .fillMaxHeight()
                .width(100.dp)
        )
        Text(
            text = "Aligned Text",
            modifier = Modifier
                .background(Color.Magenta)
                .align(Alignment.TopCenter)
        )
    }
}

@Composable
fun BoxWithBackground() {
    val context = LocalContext.current
    Box() {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )

        Text(
            text = "Add to Cart", style = MaterialTheme.typography.h6, modifier = Modifier.align(
                Alignment.TopEnd
            )
        )
        IconButton(
            onClick = { Toast.makeText(context, "CLicked the button", Toast.LENGTH_LONG).show() },
//            colors = ButtonDefaults.textButtonColors(
//                backgroundColor = Color.Red,
//                contentColor = Color.Blue
//            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
                .border(2.dp, color = Color(R.color.black), CircleShape)
        ) {
            Icon(
                Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.DarkGray, modifier = Modifier.size(30.dp)
            )
        }

    }
}

