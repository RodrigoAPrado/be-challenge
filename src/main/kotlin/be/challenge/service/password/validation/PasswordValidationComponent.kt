package be.challenge.service.password.validation

interface PasswordValidationComponent {
    fun validatePassword(password: String): Boolean
}