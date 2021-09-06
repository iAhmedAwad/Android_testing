package com.trianglz.android_testing

import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import org.junit.Test

class RegistrationUtilTest{

    //Naming convention should follow (MethodName_StateUnderTest_ExpectedBehavior)
    @Test
    fun validateRegistration_emptyUserName_returnsFalse() {
        // Given is username, password, confirmPassword

        val result = RegistrationUtil.validateRegistration(
            "", "123456aF",
            "123456aF"
        )

        //assertEquals(result, false)
        assertThat(result).isFalse()

        //assertThat("some text").

    }

    @Test
    fun validateRegistration_validUsernameAndRepeatedPassword_returnsTrue() {
        // Given is username, password, confirmPassword

        val result = RegistrationUtil.validateRegistration(
            "pony", "123456aF",
            "123456aF"
        )

        assertThat(result).isTrue()

    }

    @Test
    fun validateRegistration_usernameExists_returnsFalse() {
        // Given is username, password, confirmPassword

        val result = RegistrationUtil.validateRegistration(
            "Doe", "123456aF",
            "123456aF"
        )


        assertThat(result).isFalse()

    }

    @Test
    fun validateRegistration_emptyPassword_returnsFalse() {
        // Given is username, password, confirmPassword

        val result = RegistrationUtil.validateRegistration(
            "Doe", "",
            "123"
        )

        assertThat(result).isFalse()

    }

    @Test
    fun validateRegistration_incorrectlyConfirmedPassword_returnsFalse() {
        // Given is username, password, confirmPassword

        val result = RegistrationUtil.validateRegistration(
            "pony", "324",
            "123"
        )

        assertThat(result).isFalse()

    }

}