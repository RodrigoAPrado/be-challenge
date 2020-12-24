package be.challenge.service.password.validation

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PasswordCharacterRepetitionValidationComponentTest {

    @InjectMockKs
    lateinit var target: PasswordCharacterRepetitionValidationComponent

    @ParameterizedTest
    @ValueSource(strings = ["aba", "abA", "AbTp9!foA", "AbTp9!foo"])
    fun `should not validate password with character repetition`(input: String) {
        assertFalse(target.validatePassword(input))
    }

    @Test
    fun `should validate password without character repetition`() {
        assertTrue(target.validatePassword(VALID_PASSWORD))
    }

    companion object {
        private const val VALID_PASSWORD = "abc"
    }
}