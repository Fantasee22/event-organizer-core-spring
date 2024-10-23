package com.event_organizer_core_spring.core.dao.impl

import com.event_organizer_core_spring.core.dao.GenericDao
import org.hibernate.Session
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.hibernate.SessionFactory;

@Repository
@Transactional
class GenericDaoImpl<T, ID>(
    private val sessionFactory: SessionFactory,
    private val clazz: Class<T>
) : GenericDao<T, ID> {
    private fun getCurrentSession(): Session = sessionFactory.currentSession

    override fun save(entity: T): T {
        getCurrentSession().save(entity)
        return entity
    }

    override fun findById(id: ID): T? = getCurrentSession().get(clazz, id)

    override fun delete(entity: T) = getCurrentSession().delete(entity)

    override fun findAll(): List<T> = getCurrentSession().createQuery("from ${clazz.simpleName}", clazz).resultList
}