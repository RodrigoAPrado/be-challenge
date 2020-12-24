package be.challenge.service.password.validation

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("characterRepetition")
class PasswordCharacterRepetitionValidationComponent : PasswordValidationComponent {
    override fun validatePassword(password: String): Boolean {
        var characterCache: String = ""
        for (currentCharacter: Char in password) {
            if (characterCache.contains(currentCharacter.toLowerCase())) {
                return false
            }
            characterCache += currentCharacter.toLowerCase()
        }
        return true
    }
}