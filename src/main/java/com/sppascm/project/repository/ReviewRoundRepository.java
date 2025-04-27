package com.sppascm.project.repository;

import com.sppascm.project.model.ReviewRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRoundRepository extends JpaRepository<ReviewRound, Long> {
}
