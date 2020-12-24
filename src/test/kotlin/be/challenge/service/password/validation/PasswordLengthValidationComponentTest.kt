package be.challenge.service.password.validation

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PasswordLengthValidationComponentTest {

    @InjectMockKs
    lateinit var target: PasswordLengthValidationComponent

    @ParameterizedTest
    @ValueSource(strings = ["", "1", "12", "123", "1234", "12345", "123456", "12345678", "1 3456789", "12345678 ", "1 3 5 7 9"])
    fun `should not validate password without less than 9 characters`(input: String) {
        assertFalse(target.validatePassword(input))
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456789 ", "123aisdaiusd hiaduh"])
    fun `should not validate password with space characters`(input: String) {
        assertFalse(target.validatePassword(input))
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456789", "1234567890", "asaosdijaosdijaosdij"])
    fun `should validate password with 9 characters or more`(input: String) {
        assertTrue(target.validatePassword(input))
    }
}