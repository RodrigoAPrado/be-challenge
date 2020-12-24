package be.challenge.service.password.validation

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PasswordUpperCaseValidationComponentTest {
    @InjectMockKs
    lateinit var target: PasswordUpperCaseValidationComponent

    @ParameterizedTest
    @ValueSource(strings = ["", "a", "!", "1"])
    fun `should not validate password without a upper case`(input: String) {
        Assertions.assertFalse(target.validatePassword(input))
    }

    @Test
    fun `should validate password with a upper case`() {
        Assertions.assertTrue(target.validatePassword(VALID_PASSWORD))
    }

    companion object {
        private const val VALID_PASSWORD = "A"
    }
}