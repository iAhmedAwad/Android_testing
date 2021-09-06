package com.trianglz.android_testing

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ResourceComparatorTest{

    private val resourceCompare = ResourceComparator()

    @Test
    fun isEqual_sameAsGivenString_returnsTrue(){

        val context = ApplicationProvider.getApplicationContext<Context>()

        val result = resourceCompare.isEqual(context, R.string.app_name, "testing_demo")

        assertThat(result).isTrue()
    }

    @Test
    fun isEqual_DifferentFromGivenString_returnsFalse(){


        val context = ApplicationProvider.getApplicationContext<Context>()

        val result = resourceCompare.isEqual(context, R.string.app_name, "meh")

        assertThat(result).isFalse()
    }
}