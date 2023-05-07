package edu.hanu.online_banking_group17.Repository;


import edu.hanu.online_banking_group17.Model.SavingPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingPackageRepository extends JpaRepository<SavingPackage, Long> {
}
