package com.example.smartbudget.Handler;

import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Request.DeleteExpenditureRequest;
import com.example.smartbudget.Response.DeleteExpenditureResponse;

public class DeleteExpenditureHandler extends Handler<DeleteExpenditureRequest, DeleteExpenditureResponse> {
    @Override
    protected DeleteExpenditureResponse handle(DeleteExpenditureRequest request) {
        DatabaseSqlManager.getInstance().createExpenditureDao().delete(request.getExpenditure());
        return new DeleteExpenditureResponse();
    }

    @Override
    protected DeleteExpenditureResponse fail(Exception e) {
        return new DeleteExpenditureResponse(e.getMessage());
    }
}
