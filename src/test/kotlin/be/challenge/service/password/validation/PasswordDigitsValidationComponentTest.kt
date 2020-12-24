package be.challenge.service.password.validation

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PasswordDigitsValidationComponentTest {

    @InjectMockKs
    lateinit var target: PasswordDigitsValidationComponent

    @ParameterizedTest
    @ValueSource(strings = ["", "a", "!"])
    fun `should not validate password without a digit`(input: String) {
        assertFalse(target.validatePassword(input))
    }

    @Test
    fun `should validate password with a digit`() {
        assertTrue(target.validatePassword(VALID_PASSWORD))
    }

    companion object {
        private const val VALID_PASSWORD = "1"
    }
}