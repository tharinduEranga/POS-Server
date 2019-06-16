package lk.ijse.absd.servlets.repository.other;

import lk.ijse.absd.servlets.repository.spec.impl.*;

public class RepoFactory {
    public enum RepoTypes{
        CUSTOMER,ITEM,ORDERS,ORDER_DETAIL,ADMIN
    }

    public <T>T getRepo(RepoTypes repoTypes){
        switch (repoTypes){
            case CUSTOMER:
                return (T) new CustomerRepoimpl();
            case ORDERS:
                return (T) new OrderRepoimpl();
            case ITEM:
                return (T) new ItemRepoimpl();
            case ORDER_DETAIL:
                return (T) new OrderDetailRepoimpl();
            case ADMIN:
                return (T) new AdminRepoimpl();
            default:
                return null;
        }
    }
}
