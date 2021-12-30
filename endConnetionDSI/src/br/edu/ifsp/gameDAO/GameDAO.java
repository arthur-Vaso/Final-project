package br.edu.ifsp.gameDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import br.edu.ifsp.model.Game;

public class GameDAO {
	private EntityManager geteEntityManager() {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		return em;
	}

	public Game saveGame(Game g) {
		EntityManager em = geteEntityManager();
		try {
			em.getTransaction().begin();

			if (g.getId() == null) {
				em.persist(g);
			} else {
				em.merge(g);
			}
		} finally {
			em.close();
		}

		return g;
	}
	
	public void removeGame(Integer id) {
		EntityManager em = geteEntityManager();
		Game remove = em.find(Game.class, id);
		
		try {
			em.getTransaction().begin();
			em.remove(remove);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void removeGame(String name) {
		EntityManager em = geteEntityManager();
		Game remove = em.find(Game.class, name);

		try {
			em.getTransaction().begin();
			em.remove(remove);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public Game fetchGameById(String name) {
		EntityManager em = geteEntityManager();
		Game recovery = null;
		
		try {
			recovery = em.find(Game.class, name);
			recovery.getTitle().isBlank();
		}catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Título não encontrado.");
		}finally {
			em.close();
		}
		
		return recovery;
	}

	public Game fetchGameById(Integer id) {
		EntityManager em = geteEntityManager();
		Game recovery = null;
		
		try {
			recovery = em.find(Game.class, id);
			recovery.getTitle().isBlank();
		}catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Título não encontrado.");
		}finally {
			em.close();
		}
		
		return recovery;
	}
}
