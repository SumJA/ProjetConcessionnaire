package net.atos.projetFinal.service;

import net.atos.projetFinal.exception.InvalidUserRole;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.EmployeRepository;
import net.atos.projetFinal.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implementation du service {@link GestionEmployeService}
 */
@Service
public class GestionEmployeServiceImpl implements GestionEmployeService {
    @Autowired
    private EmployeRepository employeRepository;
    
    @Autowired
    private UserService userService;
    
    /**
     * Retourne la liste de tous les employés sauvegardé en base
     *
     * @return la liste de tous les employés en base
     */
    @Override
    @Transactional(readOnly = true)
    public List<Employe> trouverTousLesEmployes() {
        return employeRepository.findAll();
    }
    
    /**
     * @param employe l'employé à créer en base, ne doit pas etre un {@literal null}
     * @return l"Employe sauvegardé
     * @throws DataIntegrityViolationException si l'employé est déjà existant dans la base ou si une contrainte défini
     *                                         par le schema des données n'est pas respecté
     * @throws NullPointerException            si l'employé donné en paramètre est un {@literal null}
     * @throws InvalidUserRole                 si le Role de l'employé est null ou ne respecte pas le modèle de
     *                                         donnnées.
     */
    @Override
    @Transactional
    public Employe creerEmploye(@NotNull final Employe employe) throws InvalidUserRole {
        if (employe == null)
            throw new NullPointerException("L'Employé fournie en paramètre est null");
        else {
            List<Employe> employeVerificationDoublon =
                    employeRepository.findEmployeByUsernameOrEmail(employe.getUsername(),
                            employe.getEmail());
            if (employeVerificationDoublon.isEmpty()) {
                employe.setPassword("AUTO_Generated"); //TODO : generate random String Password
                employe.setPasswordConfirm("AUTO_Generated");
                return userService.save(employe);
            } else {
                throw new DataIntegrityViolationException("Nom d'utilisateur ou Email déjà utilisée");
            }
        }
    }
    
    /**
     * Supprimer un employé identifié par l'identifiant donnée en paramètre
     *
     * @param idEmploye : l'identifiant de l'employé à supprimer, ne doit pas etre un {@literal null}
     * @throws IllegalArgumentException dans le cas où {@code idEmploye} donné est {@literal null}
     * @throws NullPointerException     si l'id de l'employé donné en paramètre est null
     */
    @Override
    @Transactional
    public void supprimerEmployeParId(@NotNull final Long idEmploye) {
        if (idEmploye != null) {
            employeRepository.deleteById(idEmploye);
        } else {
            throw new NullPointerException("L'identifiant de l'employé fournie en paramètre est null");
        }
    }
    
    /**
     * Met à jour un ensemble d'employés
     *
     * @param employes : la liste des employé à mettre à jour, ne doit pas etre un {@literal null} ou vide
     * @throws IllegalArgumentException dans le cas où {@code employes} est une liste vide ou {@literal null}
     */
    @Override
    @Transactional
    public void modifierEmployes(@NotEmpty final List<Employe> employes) {
        if (employes.isEmpty()) {
            throw new IllegalArgumentException("La liste d'employés à mettre à jour est vide");
        } else {
            for (Employe employe : employes) {
                modifierEmploye(employe);
            }
        }
    }
    
    /**
     * Met à jour un employé
     *
     * @param employe : l'employé à mettre à jour, ne doit pas etre un {@literal null}
     * @throws IllegalArgumentException dans le cas où {@code employe} est un {@literal null}
     * @throws NoSuchElementException   si un employé n'existe pas en base
     */
    @Override
    @Transactional
    public void modifierEmploye(@NotNull final Employe employe) {
        if (employe != null) {
            Optional<Employe> employeToUpdate = employeRepository.findById(employe.getId());
            employeToUpdate.get().setNom(employe.getNom());
            employeToUpdate.get().setEmail(employe.getEmail());
            employeToUpdate.get().setPassword(employe.getPassword());
            employeToUpdate.get().setRole(employe.getRole());
            employeRepository.save(employeToUpdate.get());
        } else {
            throw new NullPointerException("L'Employé fournie en paramètre est null");
        }
    }
    
    /**
     * Gets dao.
     *
     * @return Value of dao.
     */
    public EmployeRepository getEmployeRepository() {
        return employeRepository;
    }
}