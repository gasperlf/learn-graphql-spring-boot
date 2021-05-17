package net.ontopsolutions.learngraphqlspringboot.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.learngraphqlspringboot.domain.bank.BankAccount;
import net.ontopsolutions.learngraphqlspringboot.domain.bank.Client;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@Slf4j
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount){
        log.info("Retrieving client to bank account id {}",bankAccount.getId());
        return Client.builder()
                .id(bankAccount.getId())
                .firstName(Optional.ofNullable(bankAccount.getClient().getFirstName()).orElse("Lewis"))
                .lastName(Optional.ofNullable(bankAccount.getClient().getLastName()).orElse("Florez"))
                .middleNames(Arrays.asList("Mr.")).build();
    }
}
