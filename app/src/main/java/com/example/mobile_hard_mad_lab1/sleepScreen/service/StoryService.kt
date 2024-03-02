package com.example.mobile_hard_mad_lab1.sleepScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.sleepScreen.model.SleepStory

class StoryService {
    fun generateStories() =
        arrayOf(
            SleepStory(
                name = "Night Island",
                image = R.drawable.story_image1
            ),
            SleepStory(
                name = "Sweet Sleep",
                image = R.drawable.story_image2
            ),
            SleepStory(
                name = "Night Island",
                image = R.drawable.story_image3
            ),
            SleepStory(
                name = "Sweet Sleep",
                image = R.drawable.story_image4
            )
        )
}