package edu.hanu.online_banking_group17.Model.custom;


import edu.hanu.online_banking_group17.Model.LoansPackage;
import edu.hanu.online_banking_group17.rest.model.Column;
import edu.hanu.online_banking_group17.rest.model.Order;
import edu.hanu.online_banking_group17.rest.model.PagingRequest;
import edu.hanu.online_banking_group17.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LoansPackageRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    // manage customer
    public List<LoansPackage> getLoansPackageList(PagingRequest paging) {
        Map<String, Object> parameter = new HashMap<>();
        String sql = buildSqlGetLoansPackage(paging, false);

        Query query = entityManager.createNativeQuery(sql, LoansPackage.class);
        for (Map.Entry<String, Object> entry : parameter.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.setFirstResult(paging.getStart())
                .setMaxResults(paging.getLength());
        return query.getResultList();
    }

    private String buildSqlGetLoansPackage(PagingRequest paging, boolean isCount) {
        StringBuilder sqlBuilder = new StringBuilder(" FROM LOANS_PACKAGE");
        sqlBuilder.append(" WHERE 1 = 1 ");
        if (!isCount) {
            Order order = paging.getOrder()
                    .get(0);
            int columnIndex = order.getColumn();
            Column column = paging.getColumns()
                    .get(columnIndex);
            if (column != null) {
                if ("id".equals(column.getData())) {
                    sqlBuilder.append(" ORDER BY loan_package_id").append(" ").append(order.getDir());
                } else {
                    sqlBuilder.append(" ORDER BY ").append(Utility.camelToSnake(column.getData())).append(" ").append(order.getDir());
                }
            }
        }
        if (isCount) {
            return "SELECT COUNT(*) " + sqlBuilder.toString();
        } else {
            return "SELECT * " + sqlBuilder.toString();
        }
    }

    public Integer getTotalLoansPackage(PagingRequest paging) {
        Map<String, Object> parameter = new HashMap<>();
        String sql = buildSqlGetLoansPackage(paging, true);

        Query query = entityManager.createNativeQuery(sql);
        for (Map.Entry<String, Object> entry : parameter.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return Integer.valueOf(query.getSingleResult().toString());
    }
}
