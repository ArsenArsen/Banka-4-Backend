package rs.banka4.bank_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.banka4.bank_service.repositories.*;
import rs.banka4.bank_service.utils.DataSourceService;

/** Handles routes used by E2E tests. !!! RISKY !!! */
@RestController
@RequestMapping("/e2e")
@RequiredArgsConstructor
@Profile("e2e")
@Slf4j
public class E2ETestController {
    private final DataSourceService dataSource;
    private final Flyway flyway;

    @GetMapping("/redo-data")
    public void redoData() {
        /* A little trolling. */
        log.info("yeetus deletus the datatus");
        flyway.clean();
        flyway.migrate();

        dataSource.insertData(true);
    }
}
