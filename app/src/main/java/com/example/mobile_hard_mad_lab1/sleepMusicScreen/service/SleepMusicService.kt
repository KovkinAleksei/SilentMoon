package com.example.mobile_hard_mad_lab1.sleepMusicScreen.service

import com.example.mobile_hard_mad_lab1.R
import com.example.mobile_hard_mad_lab1.sleepMusicScreen.model.SleepMusic

class SleepMusicService {
    private val nightIsland = "Night Island"
    private val sweetSleep = "Sweet Sleep"
    private val goodNight = "Good Night"
    private val moonClouds = "Moon Clouds"

    fun generateSleepMusic() =
        arrayOf(
            SleepMusic(
                name = nightIsland,
                image = R.drawable.story_image1
            ),
            SleepMusic(
                name = sweetSleep,
                image = R.drawable.story_image2
            ),
            SleepMusic(
                name = goodNight,
                image = R.drawable.story_image3
            ),
            SleepMusic(
                name = moonClouds,
                image = R.drawable.story_image4
            ),
            SleepMusic(
                name = sweetSleep,
                image = R.drawable.story_image2
            ),
            SleepMusic(
                name = nightIsland,
                image = R.drawable.story_image1
            ),
            SleepMusic(
                name = moonClouds,
                image = R.drawable.story_image4
            ),
            SleepMusic(
                name = goodNight,
                image = R.drawable.story_image3
            ),
        )
}