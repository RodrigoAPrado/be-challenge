package be.challenge.service.password.validation

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("upperCaseValidation")
class PasswordUpperCaseValidationComponent : PasswordValidationComponent {
    override fun validatePassword(password: String): Boolean {
        return password.any { it.isUpperCase() }
    }
}