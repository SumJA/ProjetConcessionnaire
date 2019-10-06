package net.atos.projetFinal.service.auth;

import net.atos.projetFinal.exception.InvalidUserRole;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.model.Role;
import net.atos.projetFinal.repo.EmployeRepository;
import net.atos.projetFinal.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Implémentation de l'interface UserService quipermet de créer un compte
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private EmployeRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public Employe save(@NotNull Employe user) throws InvalidUserRole {
        if (user == null)
            throw new NullPointerException("l'Utilisateur donné en paramètre est null");
        else if (user.getRole() == null)
            throw new InvalidUserRole("Le role de l'Utilisateur est null");
        else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Optional<Role> role = roleRepository.findRoleByName(user.getRole().getNom());
            if (role.isPresent()) {
                user.setRole(role.get());
                return userRepository.saveAndFlush(user);
            } else
                throw new InvalidUserRole("Role de l'Utilisateur non valide");
        }
    }
    
    @Override
    public Employe findByUsername(@NotNull String username) {
        return userRepository.findByUsername(username);
    }
    
}