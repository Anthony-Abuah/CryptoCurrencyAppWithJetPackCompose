package com.example.thecryptocurrencyapp.presentation.coin_detail

import android.graphics.Paint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis.Companion.Style
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.thecryptocurrencyapp.data.remote.dto.TeamMember
import com.example.thecryptocurrencyapp.domain.model.Coin
import com.example.thecryptocurrencyapp.presentation.Screen
import com.example.thecryptocurrencyapp.presentation.coin_detail.component.CoinTag
import com.example.thecryptocurrencyapp.presentation.coin_detail.component.TeamListItem
import com.example.thecryptocurrencyapp.presentation.coin_list.components.CoinListItem
import com.google.accompanist.flowlayout.FlowRow
import java.lang.reflect.Modifier


@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(modifier = androidx.compose.ui.Modifier.fillMaxSize()){
        state.coin?.let {coin ->
            LazyColumn(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){
                item {
                    Row(
                        modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = androidx.compose.ui.Modifier.weight(8f)
                        )
                        Text(
                            text = if (coin.isActive) "active" else "not active",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = androidx.compose.ui.Modifier
                                .align(CenterVertically)
                                .weight(2f)

                        )
                    }
                    Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2
                    )

                    Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3
                    )

                    Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = androidx.compose.ui.Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach {tag->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3
                    )

                    Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
                }
                items(
                    coin.teams
                ){ teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = androidx.compose.ui.Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    Divider()
                }
            }
        }

        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Center)

            )
        }
        if (state.isLoading){
            CircularProgressIndicator(modifier = androidx.compose.ui.Modifier.align(Center))
        }

    }
}