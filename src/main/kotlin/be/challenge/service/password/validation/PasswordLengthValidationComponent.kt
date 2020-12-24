package be.challenge.service.password.validation

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("lengthValidation")
class PasswordLengthValidationComponent : PasswordValidationComponent {

    override fun validatePassword(password: String): Boolean {
        return validateNoBlankSpaces(password) && validateLength(password)
    }

    private fun validateNoBlankSpaces(password: String): Boolean {
        return !password.contains(" ")
    }

    private fun validateLength(password: String): Boolean {
        return password.length >= minLength
    }

    companion object {
        private const val minLength: Int = 9
    }
}