package net.ontopsolutions.learngraphqlspringboot.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.learngraphqlspringboot.domain.BankAccount;
import net.ontopsolutions.learngraphqlspringboot.domain.Client;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount){
        log.info("Retrieving client to bank account id {}",bankAccount.getId());
        return Client.builder()
                .id(bankAccount.getId())
                .firstName("Lewis")
                .lastName("Florez")
                .middleNames(Arrays.asList("Mr.")).build();
    }
}
