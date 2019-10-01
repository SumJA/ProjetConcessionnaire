package net.atos.projetFinal.auth.validator;

import net.atos.projetFinal.auth.service.UserService;
import net.atos.projetFinal.model.Employe;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Valideur qui implémente org.springframework.validation.Validator de Spring
 * Validator Pour la validation du formulaire d'inscription Les codes d'erreurs
 * "Size.userForm.nom" sont définis dans le fichier validation.yaml
 *
 */
@Component
public class UserValidator implements Validator {
    private final UserService userService;
    
    public UserValidator(UserService userService) {
        this.userService = userService;
    }
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Employe.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employe user = (Employe) target;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 45) {
			errors.rejectValue("nom", "Size.userForm.username");
		}
        
        if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("nom", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		if (user.getEmail().length() < 6 || user.getEmail().length() > 45) {
			errors.rejectValue("email", "Size.userForm.email");
		}

		if (userService.findByUsername(user.getEmail()) != null) {
			errors.rejectValue("email", "Duplicate.userForm.email");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}

	}
}