package be.challenge.DTO

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PasswordValidationResponseDTO(
    @JsonProperty("valid")
    var valid: Boolean = false
)