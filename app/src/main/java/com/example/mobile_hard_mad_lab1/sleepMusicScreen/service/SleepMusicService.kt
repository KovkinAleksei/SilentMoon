package com.example.mobile_hard_mad_lab1.sleepMusicScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.sleepMusicScreen.model.SleepMusic

class SleepMusicService {
    fun generateSleepMusic() =
        arrayOf(
            SleepMusic(
                name = "Night Island",
                image = R.drawable.story_image1
            ),
            SleepMusic(
                name = "Sweet Sleep",
                image = R.drawable.story_image2
            ),
            SleepMusic(
                name = "Good Night",
                image = R.drawable.story_image3
            ),
            SleepMusic(
                name = "Moon Clouds",
                image = R.drawable.story_image4
            ),
            SleepMusic(
                name = "Sweet Sleep",
                image = R.drawable.story_image2
            ),
            SleepMusic(
                name = "Night Island",
                image = R.drawable.story_image1
            ),
            SleepMusic(
                name = "Moon Clouds",
                image = R.drawable.story_image4
            ),
            SleepMusic(
                name = "Good Night",
                image = R.drawable.story_image3
            ),

        )
}