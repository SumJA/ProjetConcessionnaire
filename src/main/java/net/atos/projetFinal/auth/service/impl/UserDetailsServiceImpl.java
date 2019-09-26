/**
 * Pour implémenter le login/auth, on implémente l'interface :
 * org.springframework.security.core.userdetails.UserDetailsService 
 */
package net.atos.projetFinal.auth.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.EmployeRepository;

/**
 * @author Sumaira
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
    private EmployeRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Employe user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getNomRole()));
        System.out.println(grantedAuthorities);
        
        return new org.springframework.security.core.userdetails.User(user.getNom(), user.getPassword(), grantedAuthorities);
    }
}
