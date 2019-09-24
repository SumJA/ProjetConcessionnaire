/**
 * Valideur qui implémente org.springframework.validation.Validator de Spring Validator
 * Pour la validation du formulaire d'inscription
 * Les codes d'erreurs "Size.userForm.nom" sont définis dans le fichier validation.yaml
 */
package net.atos.projetFinal.auth.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.projetFinal.auth.service.UserService;
import net.atos.projetFinal.model.Employe;

/**
 * @author Sumaira
 *
 */
@Component
public class UserValidator implements Validator {
	@Autowired
    private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Employe.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employe user = (Employe) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty");
        if (user.getNom().length() < 6 || user.getNom().length() > 45) {
            errors.rejectValue("nom", "Size.inscription.nom");
        }
        
        if (userService.findByUsername(user.getNom()) != null) {
            errors.rejectValue("nom", "Duplicate.inscription.nom");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.inscription.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.inscription.passwordConfirm");
        }
	}
	

}
