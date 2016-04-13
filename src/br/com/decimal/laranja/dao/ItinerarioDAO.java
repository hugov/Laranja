package br.com.decimal.laranja.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.decimal.laranja.entity.Itinerario;
import br.com.decimal.laranja.exception.DaoException;

@Service
public class ItinerarioDAO {

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;

	/**
	 * Retorna todos os Itinerarios
	 *
	 * @return
	 * @throws DaoException
	 */
	public List<Itinerario> selectAll() throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();

			return session.selectList("Itinerario.selectAll");

		} catch (Exception e) {
			throw new DaoException("Erro no método selectAll [ItinerarioDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	/**
	 * Retorna o Itinerario de acordo com o ID informado
	 *
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Itinerario selectById(int id) throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();

			return (Itinerario) session.selectOne("Itinerario.selectById", id);

		} catch (Exception e) {
			throw new DaoException("Erro no método selectById [ItinerarioDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	/**
	 * Atualiza o Itinerario
	 *
	 * @param linha
	 * @throws DaoException
	 */
	public void insert(Itinerario linha) throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();

			session.insert("Itinerario.insert", linha);

			session.commit();

		} catch (Exception e) {
			throw new DaoException("Erro no método insert [ItinerarioDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * Insere o Itinerario
	 *
	 * @param linha
	 * @throws DaoException
	 */
	public void update(Itinerario linha) throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();

			session.update("Itinerario.update", linha);

			session.commit();

		} catch (Exception e) {
			throw new DaoException("Erro no método update [ItinerarioDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * Exclui o Itinerario
	 * 
	 * @param id
	 * @throws DaoException
	 */
	public void delete(int id) throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();
			
			session.delete("Itinerario.delete", id);
			
			session.commit();
			
		} catch (Exception e) {
			throw new DaoException("Erro no método delete [ItinerarioDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
