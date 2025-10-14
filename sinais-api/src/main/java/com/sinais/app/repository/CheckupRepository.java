package com.sinais.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sinais.app.domain.Checkup;
import com.sinais.app.domain.User;

public interface CheckupRepository extends JpaRepository<Checkup, Long> {
    List<Checkup> findByUser(User user);
}
