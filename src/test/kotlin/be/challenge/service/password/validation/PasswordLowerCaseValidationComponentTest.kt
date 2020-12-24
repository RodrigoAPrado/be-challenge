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
class PasswordLowerCaseValidationComponentTest {

    @InjectMockKs
    lateinit var target: PasswordLowerCaseValidationComponent

    @ParameterizedTest
    @ValueSource(strings = ["", "A", "!", "1"])
    fun `should not validate password without a lower case`(input: String) {
        Assertions.assertFalse(target.validatePassword(input))
    }

    @Test
    fun `should validate password with a lower case`() {
        Assertions.assertTrue(target.validatePassword(VALID_PASSWORD))
    }

    companion object {
        private const val VALID_PASSWORD = "a"
    }
}