/**
 * MIT License

Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package net.atos.projetFinal.exception.controller;

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