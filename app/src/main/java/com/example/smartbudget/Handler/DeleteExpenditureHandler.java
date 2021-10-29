package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.DeleteExpenditureRequest;
import com.example.smartbudget.Response.DeleteExpenditureResponse;

public class DeleteExpenditureHandler {
    public DeleteExpenditureResponse deleteExpenditure(DeleteExpenditureRequest request){
        try {
            // TODO delete expenditures here
            DatabaseSqlManager.getInstance().createExpenditureDao();
            return new DeleteExpenditureResponse();
        } catch (Exception e){
            return new DeleteExpenditureResponse(e.getMessage());
        }
    }
}
