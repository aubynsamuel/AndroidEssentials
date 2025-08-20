package com.aubynsamuel.androidEssentials.presentation.screens.carousel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aubynsamuel.androidEssentials.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HorizontalMultiBrowseCarouselSample() {

    data class CarouselItem(
        val id: Int,
        @DrawableRes val imageResId: Int,
        val contentDescriptionResId: String,
    )

    val items =
        listOf(
            CarouselItem(
                0,
                R.drawable.wallpaper_need_for_speed,
                "R.string.carousel_image_1_description"
            ),
            CarouselItem(
                1,
                R.drawable.uncharted,
                "R.string.carousel_image_2_description"
            ),
            CarouselItem(
                2, R.drawable.headphones, "R.string.carousel_image_3_description)"
            ),
            CarouselItem(
                3,
                R.drawable.groot,
                "R.string.carousel_image_4_description"
            ),
            CarouselItem(4, R.drawable.beautiful, "R.string.carousel_image_5_description"),
            CarouselItem(
                5,
                R.drawable.android,
                "R.string.carousel_image_1_description"
            ),
            CarouselItem(6, R.drawable.no80, "R.string.carousel_image_6_description"),
            CarouselItem(
                7,
                R.drawable.suzuki,
                "R.string.carousel_image_7_description"
            ),
        )

    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { items.count() },
        preferredItemWidth = 300.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { i ->
        val item = items[i]
        Column {
            Text(
                text = "Name : ${item.id}",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier
                    .height(230.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge),
                painter = painterResource(id = item.imageResId),
                contentDescription = item.contentDescriptionResId,
                contentScale = ContentScale.Crop
            )
        }
    }
}