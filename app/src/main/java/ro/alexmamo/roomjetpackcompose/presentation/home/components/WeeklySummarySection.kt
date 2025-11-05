package ro.alexmamo.roomjetpackcompose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import ro.alexmamo.roomjetpackcompose.R
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.*

@Composable
fun WeeklySummarySection(
    revenue: String = "$4.000.00",
    expense: String = "-$100.00"
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(357.dp)
                .height(152.dp)
                .clip(RoundedCornerShape(31.dp))
                .background(MainGreen)
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left Column: Saving on Goals
                Column(
                    modifier = Modifier.weight(0.4f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            progress = { 0.5f },
                            modifier = Modifier.size(60.dp),
                            color = BlueButton,
                            trackColor = Color.White,
                            strokeWidth = 3.dp

                        )
                        Icon(
                            painter = painterResource(id = R.drawable.car),
                            contentDescription = "Car Icon",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Saving On Goals",
                        modifier = Modifier.width(70.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = DarkText,
                        lineHeight = 18.sp
                    )
                }

                // Divider
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .fillMaxHeight()
                        .background(Color.White)
                )

                // Right Column: Revenue and Expense
                Column(
                    modifier = Modifier
                        .weight(0.6f)
                        .padding(start = 16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    // Revenue Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 10.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.salary),
                            contentDescription = "Salary Icon",
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Revenue last week",
                                fontFamily = PoppinsFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = DarkText,
                                lineHeight = 16.sp
                            )
                            Text(
                                text = revenue,
                                fontFamily = PoppinsFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = DarkText,
                                lineHeight = 20.sp
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(Color.White)
                    )

                    // Expense Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 10.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.food),
                            contentDescription = "Food Icon",
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Food last week",
                                fontFamily = PoppinsFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = DarkText,
                                lineHeight = 16.sp
                            )
                            Text(
                                text = expense,
                                fontFamily = PoppinsFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = OceanBlue,
                                lineHeight = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}