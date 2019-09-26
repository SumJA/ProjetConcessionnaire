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
package net.atos.projetFinal.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.EmployeRepository;
import net.atos.projetFinal.service.IEmployeService;

/**
 * Implementation du service {@link IEmployeService}
 * 
 * @author Nils Vovan
 * @author Sumaira JAVAID
 * @author Kamel TRABELSI
 *
 */
@Service
public class ServiceEmploye implements IEmployeService {
	@Autowired
	EmployeRepository employeRepository;
	
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
			List<Employe> employeVerificationDoublon = employeRepository.findEmployeByNameOrEmail(employe.getNom(),
					employe.getEmail());
			if (employeVerificationDoublon.isEmpty()) {
				return employeRepository.saveAndFlush(employe);
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
			employeRepository.deleteById(idEmploye);
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
				Optional<Employe> employeToUpdate = employeRepository.findById(employe.getIdEmploye());
				employeToUpdate.get().setNom(employe.getNom());
				employeToUpdate.get().setEmail(employe.getEmail());
				employeToUpdate.get().setPassword(employe.getPassword());
				employeToUpdate.get().setRole(employe.getRole());
				employeRepository.save(employeToUpdate.get());
			}
			employeRepository.flush();
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
			Optional<Employe> employeToUpdate = employeRepository.findById(employe.getIdEmploye());
			employeToUpdate.get().setNom(employe.getNom());
			employeToUpdate.get().setEmail(employe.getEmail());
			employeToUpdate.get().setPassword(employe.getPassword());
			employeToUpdate.get().setRole(employe.getRole());
			employeRepository.save(employeToUpdate.get());
		} else {
			throw new NullPointerException("L'Employé fournie en paramètre est null");
		}
	}

}