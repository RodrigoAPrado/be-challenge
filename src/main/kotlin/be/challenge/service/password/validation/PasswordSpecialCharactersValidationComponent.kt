package be.challenge.service.password.validation

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("specialCharactersValidation")
class PasswordSpecialCharactersValidationComponent : PasswordValidationComponent {

    override fun validatePassword(password: String): Boolean {
        for (specialCharacter: Char in passwordSpecialCharacters) {
            if (password.contains(specialCharacter)) {
                return true
            }
        }
        return false
    }

    companion object {
        private const val passwordSpecialCharacters = "!@#$%^&*()-+"
    }

}