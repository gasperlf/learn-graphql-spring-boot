package net.ontopsolutions.learngraphqlspringboot.resolver;

import graphql.execution.DataFetcherResult;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.learngraphqlspringboot.domain.BankAccount;
import net.ontopsolutions.learngraphqlspringboot.domain.Client;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public DataFetcherResult<Client> client(BankAccount bankAccount) {
        log.info("Retrieving client to bank account id {}", bankAccount.getId());

        return DataFetcherResult.<Client>newResult()
                .data(Client.builder()
                        .id(bankAccount.getId())
                        .firstName("Lewis")
                        .lastName("Florez")
                        .middleNames(Arrays.asList("Mr.")).build())
                //.error(new GenericGraphQLError("Could no get sub-client-id"))
                .build();
    }
}
