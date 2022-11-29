package tn.essat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.essat.dao.IMessage;
import tn.essat.dao.IUtilisateur;
import tn.essat.model.Message;
import tn.essat.model.Utilisateur;

@Controller
public class AppCont {
	@Autowired
	IUtilisateur dao_u;
	@Autowired
	IMessage dao_m;

	@GetMapping("/messagesreceive/{id}")
	public String f1(Model m, @PathVariable("id") int id) {
		List<Message> liste1 = dao_m.getAllMessageReceive(id);
		m.addAttribute("liste", liste1);
		return "page2";
	}

	@GetMapping("/login")
	public String f2(Model m) {

		return "connexion";
	}

	@GetMapping("/verif")
	public String f3(Model m, HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("login");
		String password = request.getParameter("password");
		Utilisateur u = dao_u.findByUsernameAndPassword(username, password);
		if (u == null) {
			session.setAttribute("type", "warning");
			session.setAttribute("message", "Verifier vos parametres");
			return "redirect:/login";
			
		} else {
			session.setAttribute("user", u);
			return "redirect:/messagesreceive/" + u.getId();
		}

	}
	@GetMapping("/deconnexion")
	public String f4(Model m,HttpSession session) {
		session.removeAttribute("user");
		session.setAttribute("type", "info");
		session.setAttribute("message", "Merci pour votre connexion");
		return"redirect:/login";
	}
	
	@GetMapping("/envoyer")
		public String f5(Model m) {
		Message m1 =new Message();
		List <Utilisateur> users=dao_u.findAll();
		m.addAttribute("m1", m1);
		m.addAttribute("users", users);
		return "send";
			
		}
	@PostMapping("/save")
	public String f6(Model m, @ModelAttribute Message m1,HttpSession session) {
		dao_m.save(m1);
		Utilisateur u=(Utilisateur) session.getAttribute("user");
		return "redirect:/messagesreceive/"+u.getId();
	}
	}


