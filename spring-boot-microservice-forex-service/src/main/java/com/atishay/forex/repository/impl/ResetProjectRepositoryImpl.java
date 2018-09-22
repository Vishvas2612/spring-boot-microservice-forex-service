package com.atishay.forex.repository.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.atishay.forex.repository.ResetProjectRepository;

@Repository
public class ResetProjectRepositoryImpl implements ResetProjectRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public <T> List<T> getAllRecords(T t) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = (CriteriaQuery<T>) builder.createQuery(t.getClass());
		Root<T> criteriaRoot = (Root<T>) criteria.from(t.getClass());

		criteria.select(criteriaRoot);

		TypedQuery<T> typedQuery = entityManager.createQuery(criteria);
		return typedQuery.getResultList();
	}

	@Override
	public <T> void remove(T t) {
		entityManager.remove(entityManager.merge(t));
	}

}
