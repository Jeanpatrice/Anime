package com.phatherjay.anime.tests


import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidateInputTest {
    @Test
    fun whenInputIsValid(){
        val name = "Goku"
        val result = ValidateInput.validateInput(name)
        assert(result.equals(true))
    }

    @Test
    fun whenInputIsInValid(){
        val name = ""
        val result = ValidateInput.validateInput(name)
        assert(result.equals(false))
    }

    @Test
    fun whenInputIsNull(){
        val name = null
        val result = name?.let { ValidateInput.validateInput(it) }
        result?.equals(false)?.let { assert(it) }
    }
}