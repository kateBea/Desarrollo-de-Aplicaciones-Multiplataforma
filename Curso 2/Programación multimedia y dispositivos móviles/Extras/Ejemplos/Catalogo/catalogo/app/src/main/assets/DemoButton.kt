import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DemoButton(){
    Column {
        Text(text = "Demo button")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "normal")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Otro")
        }
    }
}