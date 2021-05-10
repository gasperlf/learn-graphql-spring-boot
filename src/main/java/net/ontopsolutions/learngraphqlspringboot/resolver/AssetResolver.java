package net.ontopsolutions.learngraphqlspringboot.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.learngraphqlspringboot.domain.Asset;
import net.ontopsolutions.learngraphqlspringboot.domain.BankAccount;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class AssetResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors
            .newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<List<Asset>> assets(BankAccount bankAccount) {
        log.info("Retrieving asset to bank account id {}", bankAccount.getId());
        return CompletableFuture.supplyAsync(
                () -> {
                    return List.of(Asset.builder().id(UUID.randomUUID()).build());
                }, executorService);
    }
}
