package br.com.decimal.laranja.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.decimal.laranja.entity.Linha;
import br.com.decimal.laranja.exception.DaoException;

@Service
public class LinhaDAO {

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;

	/**
	 * Retorna todos as Linhas
	 *
	 * @return
	 * @throws DaoException
	 */
	public List<Linha> selectAll() throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();

			return session.selectList("Linha.selectAll");

		} catch (Exception e) {
			throw new DaoException("Erro no método selectAll [LinhaDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	/**
	 * Retorna a Linha de acordo com o ID informado
	 *
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Linha selectById(int id) throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();

			return (Linha) session.selectOne("Linha.selectById", id);

		} catch (Exception e) {
			throw new DaoException("Erro no método selectById [LinhaDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	/**
	 * Atualiza a Linha
	 *
	 * @param linha
	 * @throws DaoException
	 */
	public void insert(Linha linha) throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();

			session.insert("Linha.insert", linha);

			session.commit();

		} catch (Exception e) {
			throw new DaoException("Erro no método insert [LinhaDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * Insere a Linha
	 *
	 * @param linha
	 * @throws DaoException
	 */
	public void update(Linha linha) throws DaoException {

		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {

			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();

			session.update("Linha.update", linha);

			session.commit();

		} catch (Exception e) {
			throw new DaoException("Erro no método update [LinhaDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * Exclui a Linha
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
			
			session.delete("Linha.delete", id);
			
			session.commit();
			
		} catch (Exception e) {
			throw new DaoException("Erro no método delete [LinhaDAO]", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
