package be.challenge.service.password.validation

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PasswordSpecialCharactersValidationComponentTest {

    @InjectMockKs
    lateinit var target: PasswordSpecialCharactersValidationComponent

    @ParameterizedTest
    @ValueSource(strings = ["", "A", "a", "1", "/", "\\"])
    fun `should not validate password without a valid special character`(input: String) {
        Assertions.assertFalse(target.validatePassword(input))
    }

    @ParameterizedTest
    @ValueSource(strings = ["!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+"])
    fun `should validate password with a special character`(input: String) {
        Assertions.assertTrue(target.validatePassword(input))
    }
}