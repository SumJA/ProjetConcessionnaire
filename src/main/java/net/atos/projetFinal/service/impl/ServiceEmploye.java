package net.atos.projetFinal.service.impl;

import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.EmployeRepository;
import net.atos.projetFinal.service.IEmployeService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implementation du service {@link IEmployeService}
 *
 */
@Service
public class ServiceEmploye implements IEmployeService {
    private final EmployeRepository dao;
    
    public ServiceEmploye(EmployeRepository dao) {
        this.dao = dao;
    }
	
	/**
	 * Retourne la liste de tous les employés sauvegardé en base
	 * 
	 * @return la liste de tous les employés en base
	 */
	@Override
	@Transactional(readOnly = true)
    public List<Employe> findAllEmploye() {
        return dao.findAll();
	}

	/**
	 * Créer un nouvel Employé
	 * 
	 * @param employe l'employé à créer en base, ne doit pas etre un {@literal null}
	 * @throws DataIntegrityViolationException si l'employé est déjà existant dans
	 *                                         la base
	 * @throws NullPointerException            si l'employé donné en paramètre est
	 *                                         null
	 * @return un Employe
	 */
	@Override
	@Transactional
	public Employe creerEmploye(@NotNull final Employe employe) {
		if (employe != null) {
			// Vérfication du respect de la contrainte d'unicité sur le username et l'email
			// de l'employé :
            List<Employe> employeVerificationDoublon = dao.findEmployeByUsernameOrEmail(employe.getNom(),
					employe.getEmail());
			if (employeVerificationDoublon.isEmpty()) {
                return dao.saveAndFlush(employe);
			} else {
				throw new DataIntegrityViolationException("Employé déjà existant");
			}
		} else {
			throw new NullPointerException("L'Employé fournie en paramètre est null");
		}
	}

	/**
	 * Supprimer un employé identifié par l'identifiant donnée en paramètre
	 * 
	 * @param idEmploye : l'identifiant de l'employé à supprimer, ne doit pas etre
	 *                  un {@literal null}
	 * @throws IllegalArgumentException dans le cas où {@code idEmploye} donné est
	 *                                  {@literal null}
	 * @throws NullPointerException     si l'id de l'employé donné en paramètre est
	 *                                  null
	 */
	@Override
	@Transactional
	public void supprimerEmployeParId(@NotNull final Long idEmploye) {
		if (idEmploye != null) {
            dao.deleteById(idEmploye);
		} else {
			throw new NullPointerException("L'identifiant de l'employé fournie en paramètre est null");
		}
	}

	/**
	 * Met à jour un ensemble d'employés
	 * 
	 * @param employes : la liste des employé à mettre à jour, ne doit pas etre un
	 *                 {@literal null} ou vide
	 * @throws IllegalArgumentException dans le cas où {@code employes} est une
	 *                                  liste vide ou {@literal null}
	 * @throws NoSuchElementException   si un employé n'existe pas en base
	 */
	@Override
	@Transactional
	public void modifierEmployes(@NotEmpty final List<Employe> employes) {
		if (employes.isEmpty()) {
			throw new IllegalArgumentException("La liste d'employés à mettre à jour est vide");
		} else {
			for (Employe employe : employes) {
                Optional<Employe> employeToUpdate = dao.findById(employe.getId());
				employeToUpdate.get().setNom(employe.getNom());
				employeToUpdate.get().setEmail(employe.getEmail());
				employeToUpdate.get().setPassword(employe.getPassword());
				employeToUpdate.get().setRole(employe.getRole());
                dao.save(employeToUpdate.get());
			}
            dao.flush();
		}
	}

	/**
	 * Met à jour un employé
	 * 
	 * @param employe : l'employé à mettre à jour, ne doit pas etre un
	 *                {@literal null}
	 * @throws IllegalArgumentException dans le cas où {@code employe} est un
	 *                                  {@literal null}
	 * @throws NoSuchElementException   si un employé n'existe pas en base
	 */
	@Override
	@Transactional
	public void modifierEmploye(@NotNull final Employe employe) {
		if (employe != null) {
            Optional<Employe> employeToUpdate = dao.findById(employe.getId());
			employeToUpdate.get().setNom(employe.getNom());
			employeToUpdate.get().setEmail(employe.getEmail());
			employeToUpdate.get().setPassword(employe.getPassword());
			employeToUpdate.get().setRole(employe.getRole());
            dao.save(employeToUpdate.get());
		} else {
			throw new NullPointerException("L'Employé fournie en paramètre est null");
		}
	}
    
    /**
     * Gets dao.
     *
     * @return Value of dao.
     */
    public EmployeRepository getDao() {
        return dao;
    }
}