package edu.hanu.online_banking_group17.Repository;


import edu.hanu.online_banking_group17.Model.LoansPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansPackageRepository extends JpaRepository<LoansPackage,Long> {
}
