package br.edu.ifsp.gameDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import javax.swing.JOptionPane;

import br.edu.ifsp.model.Game;

public class GameDAO {

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		emf = Persistence.createEntityManagerFactory("databasePU");
		em = emf.createEntityManager();

		return em;
	}

	public Game saveGame(Game g) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();

			if (g.getId() == null) {
				try {
					em.persist(g);
				} catch (PersistenceException de) {
					JOptionPane.showMessageDialog(null, "Algum campo excedeu o limite de caracteres.");
				g = null;
				}
			} else {
				em.merge(g);
			}
			try {
				em.getTransaction().commit();
			} catch (RollbackException rbe) {
				JOptionPane.showMessageDialog(null, "Algum campo excedeu o limite de caracteres.");
				g = null;
			}
		} finally {
			em.close();
		}
		return g;
	}

	public void removeGame(Integer id) {
		EntityManager em = getEntityManager();
		Game remove = em.find(Game.class, id);

		try {
			em.getTransaction().begin();
			em.remove(remove);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public Game fetchGameById(Integer id) {
		EntityManager em = getEntityManager();
		Game recovery = null;

		try {
			recovery = em.find(Game.class, id);
			recovery.getTitle().isBlank();
		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Título não encontrado.");
		} finally {
			em.close();
		}

		return recovery;
	}

	public List<Game> fetchPersonByName() {
		EntityManager em = getEntityManager();

		List<Game> list = null;

		list = (List<Game>) em.createQuery("from Game").getResultList();

		return list;

	}
}
