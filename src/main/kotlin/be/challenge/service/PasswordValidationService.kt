package be.challenge.service

import be.challenge.service.password.validation.PasswordValidationComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class PasswordValidationService {

    @Autowired
    @Qualifier("lengthValidation")
    private lateinit var passwordLenghtValidationComponent: PasswordValidationComponent

    @Autowired
    @Qualifier("digitValidation")
    private lateinit var passwordDigitsValidationComponent: PasswordValidationComponent

    @Autowired
    @Qualifier("lowerCaseValidation")
    private lateinit var passwordLowerCaseValidationComponent: PasswordValidationComponent

    @Autowired
    @Qualifier("upperCaseValidation")
    private lateinit var passwordUpperCaseValidationComponent: PasswordValidationComponent

    @Autowired
    @Qualifier("specialCharactersValidation")
    private lateinit var passwordSpecialCharactersValidationComponent: PasswordValidationComponent

    @Autowired
    @Qualifier("characterRepetition")
    private lateinit var passwordCharacterRepetitionValidationComponent: PasswordValidationComponent

    private val passwordValidationComponentList: MutableList<PasswordValidationComponent> = arrayListOf()

    fun getPasswordValidation(password: String): Boolean {
        if (passwordValidationComponentList.isEmpty()) {
            initializePasswordValidationComponentList()
        }
        for (passwordValidationComponent in passwordValidationComponentList) {
            if (!passwordValidationComponent.validatePassword(password)) {
                return false
            }
        }
        return true
    }

    fun initializePasswordValidationComponentList() {
        passwordValidationComponentList.add(passwordLenghtValidationComponent)
        passwordValidationComponentList.add(passwordDigitsValidationComponent)
        passwordValidationComponentList.add(passwordLowerCaseValidationComponent)
        passwordValidationComponentList.add(passwordUpperCaseValidationComponent)
        passwordValidationComponentList.add(passwordSpecialCharactersValidationComponent)
        passwordValidationComponentList.add(passwordCharacterRepetitionValidationComponent)
    }
}