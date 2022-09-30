package org.inha.contracts;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hyperledger.fabric.contract.ClientIdentity;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.annotation.Transaction.TYPE;
import org.hyperledger.fabric.shim.ChaincodeException;
import org.hyperledger.fabric.shim.ledger.KeyValue;
import org.hyperledger.fabric.shim.ledger.QueryResultsIterator;
import org.inha.models.AccountHistory;
import org.inha.utils.JsonUtils;

@Contract(
        name = "AccountHistoryContract",
        info = @Info(
                title = "Account History Management Contract",
                description = "Hyperledger-based management.",
                version = "0.0.1-SNAPSHOT",
                license = @License(
                        name = "Apache 2.0 License",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
@Default
public class AccountHistoryContract implements ContractInterface, AccountHistoryContractInterface {

    public AccountHistoryContract() {
    }

    @Override
    @Transaction(intent = TYPE.SUBMIT)
    public void createAccountHistory(Context ctx, Integer income, Integer outcome, String bankName,
            String accountNumber, LocalDateTime timeStamp, String remarks) {

        // 해당 조직의 예산 사용 내역을 추가할 수 있는 사람인지 확인해야함.
        ClientIdentity clientIdentity = ctx.getClientIdentity();


        //
    }

    @Override
    @Transaction(intent = TYPE.SUBMIT)
    public void updateAccountHistory(Context ctx, String historyId, Integer income, Integer outcome,
            String bankName, String accountNumber, LocalDateTime timeStamp, String remarks) {

        // 해당 조직의 예산 사용 내역을 수정할 수 있는 사람인지 확인해야함.

    }

    @Override
    @Transaction(intent = TYPE.SUBMIT)
    public void deleteAccountHistory(Context ctx, String historyId) {

        // 해당 조직의 예산 사용 내역을 삭제할 수 있는 사람인지 확인해야함.
    }

    @Override
    @Transaction(intent = TYPE.EVALUATE)
    public AccountHistory getAccountHistory(Context ctx, String historyId) {

        // 조회 권한 있는지 확인해야함.

        byte[] rawJson = ctx.getStub().getState(historyId);
        if (isEmpty(rawJson))
            throw new ChaincodeException("no record for the history ID.");


        AccountHistory accountHistory;
        try {
            accountHistory = JsonUtils.deserialize(rawJson, AccountHistory.class);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("fail to deserialize json object");
        }

        return accountHistory;
    }

    private boolean isEmpty(byte[] rawJson) {
        return rawJson.length == 0;
    }

    @Override
    @Transaction(intent = TYPE.EVALUATE)
    public List<AccountHistory> getAccountHistoriesBetween(Context ctx, Date startDate, Date endDate) {

        // 조회 권한 있는지 확인해야함.

        QueryResultsIterator<KeyValue> result = ctx.getStub().getQueryResult(
                String.format("{ "
                        + "    \"selector\": { "
                        + "        \"timestamp\": {"
                        + "            $gte: {%s}"
                        + "            $lte: {%s}"
                        + "        }"
                        + "    },"
                        + "    \"use_index\": {"
                        + "        [\"_design/indexDateDoc\", \"indexDate\"]"
                        + "    }"
                        + "}", startDate.toString(), endDate.toString()));

        List<AccountHistory> res = new ArrayList<>();
        result.forEach(item -> {
            try {
                res.add(JsonUtils.deserialize(item.getValue(), AccountHistory.class));

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("fail to deserialize json object");
            }
        });

        return res;
    }
}
