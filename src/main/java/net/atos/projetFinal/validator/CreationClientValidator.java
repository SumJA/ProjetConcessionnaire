/**
 * Valideur qui implémente org.springframework.validation.Validator de Spring Validator
 * Pour la validation du formulaire d'ajout de client
 * Les codes d'erreurs "Size.userForm.username" sont définis dans le fichier validation.yaml
 */
package net.atos.projetFinal.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.atos.projetFinal.controller.CreationClientForm;

/**
 * @author Nils
 *
 */
@Component
public class CreationClientValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CreationClientForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codePostal", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ville", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty");
	}
	

}
