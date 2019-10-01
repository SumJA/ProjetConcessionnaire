package net.atos.projetFinal.auth.service.impl;

import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.EmployeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Pour implémenter le login/auth, on implémente l'interface :
 * org.springframework.security.core.userdetails.UserDetailsService
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final EmployeRepository userRepository;
    
    public UserDetailsServiceImpl(EmployeRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		Employe user = userRepository.findByUsername(username);
        
        if (user == null)
			throw new UsernameNotFoundException(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getNom()));
        return new org.springframework.security.core.userdetails.User(user.getPassword(), user.getPassword(),
				grantedAuthorities);
	}
}