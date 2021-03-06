package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.UpdateBudgetRequest;
import com.example.smartbudget.Response.UpdateBudgetResponse;

public class UpdateBudgetHandler extends Handler<UpdateBudgetRequest, UpdateBudgetResponse> {
    @Override
    protected UpdateBudgetResponse handle(UpdateBudgetRequest request) {
        DatabaseSqlManager.getInstance().createBudgetDao().update(request.getBudget(), request.getUser());
        return new UpdateBudgetResponse(request.getBudget());
    }

    @Override
    protected UpdateBudgetResponse fail(Exception e) {
        return new UpdateBudgetResponse(e.getMessage());
    }
}
