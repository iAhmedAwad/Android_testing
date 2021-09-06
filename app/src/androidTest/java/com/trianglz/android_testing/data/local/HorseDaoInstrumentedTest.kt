package com.trianglz.android_testing.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import com.trianglz.android_testing.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
@ExperimentalCoroutinesApi
class HorseDaoInstrumentedTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: HorsesDatabase
    private lateinit var dao: HorseDao


    @Before
    fun setUp() {

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            HorsesDatabase::class.java
        )
            .allowMainThreadQueries().build()

        dao = database.horseDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertHorse() = runBlockingTest {
        val horse = Horse("Pony", 82700.0, 1)
        dao.addHorse(horse)

        val allHorses = dao.getAllHorses().getOrAwaitValue()

        assertThat(allHorses).contains(horse)
    }

    @Test
    fun deleteHorse() = runBlockingTest {
        val horse = Horse("Pony", 82700.0, 1)
        dao.addHorse(horse)
        dao.deleteHorse(horse)
        val allHorses = dao.getAllHorses().getOrAwaitValue()

        assertThat(allHorses).doesNotContain(horse)
    }
}