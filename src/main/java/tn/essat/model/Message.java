package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "u_send_id")
	private Utilisateur usersend;
	@ManyToOne
	@JoinColumn(name = "u_rec_id")
	private Utilisateur userreceive;
	private String sujet;
	private String contenu;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(Integer id, Utilisateur user_send, Utilisateur user_receive, String sujet, String contenu) {
		super();
		this.id = id;
		this.usersend = user_send;
		this.userreceive = user_receive;
		this.sujet = sujet;
		this.contenu = contenu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Utilisateur getUsersend() {
		return usersend;
	}

	public void setUsersend(Utilisateur usersend) {
		this.usersend = usersend;
	}

	public Utilisateur getUserreceive() {
		return userreceive;
	}

	public void setUserreceive(Utilisateur userreceive) {
		this.userreceive = userreceive;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
