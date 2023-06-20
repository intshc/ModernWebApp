package com.example.cardatabase.repository;

import com.example.cardatabase.domain.Owner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;

    @Test
    @DisplayName("저장")
    void saveOwner() {
        repository.save(Owner.builder()
                .firstName("Lucy")
                .lastName("Smith")
                .build());
        Assertions.assertThat(repository.findByFirstName("Lucy").isPresent()).isTrue();
    }

    @Test
    @DisplayName("저장 후 삭제")
    void deleteOwners() {
        repository.save(Owner.builder()
                .firstName("Lucy")
                .lastName("Morrison")
                .build());
        repository.deleteAll();
        Assertions.assertThat(repository.count()).isEqualTo(0);
    }
}