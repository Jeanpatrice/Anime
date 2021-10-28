package com.phatherjay.anime.tests

object ValidateInput {
    fun validateInput(name:String): Boolean{
        return !(name.isBlank() && name.isEmpty())
    }
}