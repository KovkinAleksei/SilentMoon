package com.example.mobile_hard_mad_lab1.playOptionScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.playOptionScreen.model.RelatedStory

class RelatedStoryService {
    private val moonClouds = "Moon Clouds"
    private val sweetSleep = "Sweet Sleep"
    private val nightIsland = "Night Island"

    fun generateRelatedStories() =
        arrayOf(
            RelatedStory(
                name = moonClouds,
                image = R.drawable.story_image3
            ),
            RelatedStory(
                name = sweetSleep,
                image = R.drawable.story_image2
            ),
            RelatedStory(
                name = nightIsland,
                image = R.drawable.story_image4
            ),
            RelatedStory(
                name = moonClouds,
                image = R.drawable.story_image3
            ),
            RelatedStory(
                name = sweetSleep,
                image = R.drawable.story_image2
            ),
            RelatedStory(
                name = nightIsland,
                image = R.drawable.story_image4
            ),
            RelatedStory(
                name = moonClouds,
                image = R.drawable.story_image3
            ),
            RelatedStory(
                name = sweetSleep,
                image = R.drawable.story_image2
            )
        )
}