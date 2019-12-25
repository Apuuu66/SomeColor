package com.guier.jpa.specification.service;

import com.guier.jpa.specification.po.User;
import com.guier.jpa.specification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void query() {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                return null;
            }
        };
        userRepository.findAll();
    }
}
