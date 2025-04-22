package rs.banka4.bank_service.tx.executor;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rs.banka4.bank_service.domain.trading.db.ForeignBankId;
import rs.banka4.bank_service.tx.TxExecutor;
import rs.banka4.bank_service.tx.data.Transaction;

/**
 * A transaction executor capable of delivering transactions across banks.
 */
@Service
@Slf4j
public class InterbankTxExecutor implements TxExecutor {
    public InterbankTxExecutor(InterbankExecutorConfig config) {
        log.debug("IBEX config: {}", config);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ForeignBankId submitTx(Transaction td) {
        final var txId = ForeignBankId.our(UUID.randomUUID());
        return txId;
    }
}
