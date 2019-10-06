package net.atos.projetFinal.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Un controller Advice qui va intercepter et gérer les exceptions générées par
 * les méthodes annotées avec.
 * 
 * Ce controller est une extension de
 * {@link org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver}.
 * et implémente {@link ErrorViewResolver}
 * 
 * {@inheritDoc}
 * 
 * @author Sumaira JAVAID
 *
 */
@ControllerAdvice
public class CtrlAdvice extends DefaultHandlerExceptionResolver implements ErrorViewResolver {

	/**
	 * Résous une vue d'erreur pour les détails spécifiés
	 * 
	 * @param request la source de la requete
	 * @param status  le status http de l'erreur
	 * @param model   le model suggérer pour être utilisé avec la vue
	 * @return un {@link ModelAndView} résolus ou un {@code null}
	 */
	@ExceptionHandler(Exception.class)
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        // FIXME : not working
		ModelAndView mav = new ModelAndView();

		mav.addObject("MsgErr", status.getReasonPhrase());
        mav.setViewName("error");

		return mav;
	}

}