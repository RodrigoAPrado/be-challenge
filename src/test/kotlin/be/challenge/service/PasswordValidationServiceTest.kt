package be.challenge.service

import be.challenge.service.password.validation.PasswordValidationComponent
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Qualifier

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PasswordValidationServiceTest {

    @InjectMockKs
    lateinit var target: PasswordValidationService

    @MockK
    @Qualifier("lengthValidation")
    private lateinit var passwordLenghtValidationComponent: PasswordValidationComponent

    @MockK
    @Qualifier("digitValidation")
    private lateinit var passwordDigitsValidationComponent: PasswordValidationComponent

    @MockK
    @Qualifier("lowerCaseValidation")
    private lateinit var passwordLowerCaseValidationComponent: PasswordValidationComponent

    @MockK
    @Qualifier("upperCaseValidation")
    private lateinit var passwordUpperCaseValidationComponent: PasswordValidationComponent

    @MockK
    @Qualifier("specialCharactersValidation")
    private lateinit var passwordSpecialCharactersValidationComponent: PasswordValidationComponent

    @MockK
    @Qualifier("characterRepetition")
    private lateinit var passwordCharacterRepetitionValidationComponent: PasswordValidationComponent


    @BeforeEach
    fun setup() {
        every { passwordLenghtValidationComponent.validatePassword(PASSWORD) } answers { true }
        every { passwordDigitsValidationComponent.validatePassword(PASSWORD) } answers { true }
        every { passwordLowerCaseValidationComponent.validatePassword(PASSWORD) } answers { true }
        every { passwordUpperCaseValidationComponent.validatePassword(PASSWORD) } answers { true }
        every { passwordSpecialCharactersValidationComponent.validatePassword(PASSWORD) } answers { true }
        every { passwordCharacterRepetitionValidationComponent.validatePassword(PASSWORD) } answers { true }
    }

    @Test
    fun `should return false when a validation is false`() {
        every { passwordLenghtValidationComponent.validatePassword(PASSWORD) } answers { false }
        assertFalse(target.getPasswordValidation(PASSWORD))
    }

    @Test
    fun `should return true when all validations are true`() {
        assertTrue(target.getPasswordValidation(PASSWORD))
    }

    companion object {
        private const val PASSWORD = "abc"
    }

}