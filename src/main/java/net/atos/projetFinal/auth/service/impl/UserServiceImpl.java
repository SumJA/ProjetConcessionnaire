package net.atos.projetFinal.auth.service.impl;

import net.atos.projetFinal.auth.service.UserService;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.EmployeRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implémentation de l'interface UserService
 * quipermet de créer un compte
 *
 */
@Service
public class UserServiceImpl implements UserService {
    private final EmployeRepository userRepository;
    
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserServiceImpl(EmployeRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
	@Override
	public void save(Employe user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(user.getRole());
		userRepository.saveAndFlush(user);
	}

	@Override
	public Employe findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}