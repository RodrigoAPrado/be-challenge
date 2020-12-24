package be.challenge.service.password.validation

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("lowerCaseValidation")
class PasswordLowerCaseValidationComponent : PasswordValidationComponent {
    override fun validatePassword(password: String): Boolean {
        return password.any { it.isLowerCase() }
    }
}