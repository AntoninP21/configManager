package com.App.repository;

import com.tonpackage.model.Talk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalkRepository extends JpaRepository<Talk, Long> {}
