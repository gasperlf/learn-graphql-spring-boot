package net.ontopsolutions.learngraphqlspringboot.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.learngraphqlspringboot.domain.BankAccount;
import net.ontopsolutions.learngraphqlspringboot.domain.Client;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class ClientResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors
            .newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<Client> client(BankAccount bankAccount) {
        log.info("Retrieving client to bank account id {}", bankAccount.getId());
        return CompletableFuture.supplyAsync(
                () -> {
                    return Client.builder()
                            .id(bankAccount.getId())
                            .firstName("Lewis")
                            .lastName("Florez")
                            .middleNames(Arrays.asList("Mr.")).build();
                }, executorService);


    }
}
