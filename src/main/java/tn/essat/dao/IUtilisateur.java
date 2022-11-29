package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Utilisateur;
@Repository
//Pour etre injecter dans le controller
public interface IUtilisateur extends JpaRepository<Utilisateur, Integer> {
	//integer est identificateur 
	public Utilisateur findByUsernameAndPassword(String m1, String m2);

}
