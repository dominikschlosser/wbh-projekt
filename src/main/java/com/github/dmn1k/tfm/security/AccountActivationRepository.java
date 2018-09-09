package com.github.dmn1k.tfm.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AccountActivationRepository extends JpaRepository<AccountActivation, Long> {
    AccountActivation findByToken(@Param("token") String token);
}