package it.malfix.boilerplate.usecases.objectmapper

import java.time.LocalDate

data class User(
    val name: String,
    val surname: String,
    val birthDate: LocalDate
)
