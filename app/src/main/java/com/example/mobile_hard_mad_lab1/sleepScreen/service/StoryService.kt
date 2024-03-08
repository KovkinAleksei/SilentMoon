package com.example.mobile_hard_mad_lab1.sleepScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.sleepScreen.model.SleepStory

class StoryService {
    private val nightIsland = "Night Island"
    private val sweetSleep = "Sweet Sleep"

    fun generateStories() =
        arrayOf(
            SleepStory(
                name = nightIsland,
                image = R.drawable.story_image1
            ),
            SleepStory(
                name = sweetSleep,
                image = R.drawable.story_image2
            ),
            SleepStory(
                name = nightIsland,
                image = R.drawable.story_image3
            ),
            SleepStory(
                name = sweetSleep,
                image = R.drawable.story_image4
            )
        )
}