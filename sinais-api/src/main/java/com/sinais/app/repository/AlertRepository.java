package com.sinais.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sinais.app.domain.Alert;
import com.sinais.app.domain.User;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByUser(User user);
}
