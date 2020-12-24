package be.challenge.resource

import be.challenge.DTO.PasswordValidationResponseDTO
import be.challenge.service.PasswordValidationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/password"])
class PasswordResource {

    @Autowired
    lateinit var passwordValidationService: PasswordValidationService

    @GetMapping("/validate/")
    fun getPasswordValidation(): ResponseEntity<PasswordValidationResponseDTO> {
        return getPasswordValidation("")
    }

    @GetMapping("/validate/{password}")
    fun getPasswordValidation(@PathVariable("password") password: String): ResponseEntity<PasswordValidationResponseDTO> {
        return ResponseEntity.ok(
            PasswordValidationResponseDTO(
                valid = passwordValidationService.getPasswordValidation(
                    password
                )
            )
        )
    }
}