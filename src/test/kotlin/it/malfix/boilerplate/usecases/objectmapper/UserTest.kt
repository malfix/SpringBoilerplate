package it.malfix.boilerplate.usecases.objectmapper

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

private val objectMapper = jacksonObjectMapper()
    .registerModule(JavaTimeModule())
    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

internal class UserTest {

    @Test
    internal fun serialization() {
        val username = User(
            name = "Ciccio",
            surname = "Pasticcio",
            birthDate = LocalDate.of(1983, 3, 23)
        )

        val actual = objectMapper.writeValueAsString(username)

        //language=JSON
        assertEquals(
            objectMapper.readTree(
                "{\n  \"name\": \"Ciccio\",\n  \"surname\": \"Pasticcio\",\n  \"birthDate\": \"1983-03-23\"\n}"
            ), objectMapper.readTree(actual)
        )
    }

    @Test
    internal fun deserialization() {
        //language=JSON
        val json = "{\n  \"name\": \"Ciccio\",\n  \"surname\": \"Pasticcio\",\n  \"birthDate\": \"1983-03-23\"\n}"
        val actual = objectMapper.readValue(json, User::class.java)

        assertEquals(User(
            name = "Ciccio",
            surname = "Pasticcio",
            birthDate = LocalDate.of(1983, 3, 23)
        ), actual)

    }
}