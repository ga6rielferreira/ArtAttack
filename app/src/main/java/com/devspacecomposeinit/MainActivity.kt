package com.devspacecomposeinit

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devspacecomposeinit.ui.theme.ComposeInitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeInitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val artist = Artist(
                        name = "Leonardo Da Vinci",
                        lastStateOnline = "3 minutos ago",
                        image = R.drawable.ic_leonardo_da_vinci,
                        art = R.drawable.ic_mona_lisa
                    )
                    ArtistCard(artist)
                }
            }
        }
    }
}

@Composable
fun ArtistCard(artist: Artist) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .padding(3.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = artist.image),
                contentDescription = "Artist Image",
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = artist.name, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = artist.lastStateOnline, color = Color.DarkGray
                )
            }
        }
        Column {
            Card(
                modifier = Modifier
                    .padding(3.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            )
            {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = artist.art),
                    contentDescription = "Artist art"

                )
            }
        }
    }
}

data class Artist(
    val name: String,
    val lastStateOnline: String,
    @DrawableRes val image: Int,
    @DrawableRes val art: Int,
)

@Preview(showBackground = true)
@Composable
fun ArtistCardPreview() {
    ComposeInitTheme {
        val artist = Artist(
            name = "Leonardo Da Vinci",
            lastStateOnline = "3 minutes ago",
            image = R.drawable.ic_leonardo_da_vinci,
            art = R.drawable.ic_mona_lisa,
        )
        ArtistCard(artist)
    }

}

