package com.ueniweb.swiftwaresolutions.repository;


import com.ueniweb.swiftwaresolutions.domain.User;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NoRecordFoundException;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.security.MessageDigest;
import java.util.List;


@Repository
@RequiredArgsConstructor
@Slf4j
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final EntityManager entityManager;

    @Override
    public User login(String userName, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        Predicate userNamePredicate = criteriaBuilder.equal(userRoot.get("name"), userName);
        Predicate isBlockPredicate = criteriaBuilder.equal(userRoot.get("isBlock"), 0);
        criteriaQuery.where(userNamePredicate, isBlockPredicate);
        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);

        List<User> userList = query.getResultList();
        if (userList.isEmpty()) {
            throw new NoRecordFoundException("Invalid Credentials");
        }
        String encryptedPassword = this.encryptPassword(password);
        User user = userList.get(0);
        String storedEncryptedPassword = user.getPass();
        if (encryptedPassword.equals(storedEncryptedPassword)) {
            return user;
        } else {
            throw new NotFoundException("Invalid Credentials");
        }
    }

    public String encryptPassword (String password) {
        byte[] unencodedPassword = password.getBytes();
        MessageDigest md 	= null;
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch (Exception e)
        {}
        md.reset();
        md.update(unencodedPassword);
        byte[] encodedPassword = md.digest();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < encodedPassword.length; i++)
        {
            if (((int) encodedPassword[i] & 0xff) < 0x10)
            {
                buf.append("0");
            }
            buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
        }
       return buf.toString();
    }
}
