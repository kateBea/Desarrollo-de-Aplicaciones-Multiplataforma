package edu.villablanca.unscramblee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.villablanca.unscramblee.ui.theme.UT4Theme

class UnscrumbledMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RatingBarComposable()
                }
            }
        }
    }
}

@Composable
private fun RatingBarComposable() {
    var rating by remember { mutableStateOf(0) }
    val outlinedStar = painterResource(id = R.drawable.outlined_star)
    val filledStar = painterResource(id = R.drawable.filled_star)
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(5) { index ->
            Icon (
                //imageVector = if (index < rating) Icons.Filled.Star else Icons.Outlined.Star,
                painter = if (index < rating) filledStar else outlinedStar,
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .clickable {
                        rating = index + 1
                    }
                    .padding(4.dp)
            )
        }
    }
}