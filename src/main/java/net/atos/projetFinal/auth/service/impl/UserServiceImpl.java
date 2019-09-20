/**
 * Implémentation de l'interface UserService
 * quipermet de créer un compte
 */
package net.atos.projetFinal.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.atos.projetFinal.auth.service.UserService;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.EmployeRepository;

/**
 * @author Sumaira
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private EmployeRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(Employe user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(user.getRole());
		userRepository.save(user);
	}

	@Override
	public Employe findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
