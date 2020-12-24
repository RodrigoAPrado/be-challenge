package be.challenge.resource

import be.challenge.DTO.PasswordValidationResponseDTO
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(PasswordResource::class)
class IntegrationTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @ParameterizedTest
    @ValueSource(strings = ["", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok"])
    fun `should return false when password is invalid`(input: String) {
        val response = mvc.perform(
            get(PASSWORD_VALIDATION_URL + input)
        ).andExpect(status().isOk).andReturn().response

        val responseDTO = mapper.readValue(response.contentAsString, PasswordValidationResponseDTO::class.java)
        assertFalse(responseDTO.valid)
    }

    @Test
    fun `should return true when password is valid`() {
        val response = mvc.perform(
            get(PASSWORD_VALIDATION_URL + VALID_PASSWORD)
        ).andExpect(status().isOk).andReturn().response

        val responseDTO = mapper.readValue(response.contentAsString, PasswordValidationResponseDTO::class.java)
        assertTrue(responseDTO.valid)
    }


    companion object {
        private const val PASSWORD_VALIDATION_URL = "/password/validate/"

        private const val VALID_PASSWORD = "AbTp9!fok"
    }
}