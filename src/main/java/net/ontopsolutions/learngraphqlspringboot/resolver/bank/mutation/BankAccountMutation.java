package net.ontopsolutions.learngraphqlspringboot.resolver.bank.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.learngraphqlspringboot.domain.bank.BankAccount;
import net.ontopsolutions.learngraphqlspringboot.domain.bank.Client;
import net.ontopsolutions.learngraphqlspringboot.domain.bank.Currency;
import net.ontopsolutions.learngraphqlspringboot.domain.bank.input.CreateBankAccountInput;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {

    public BankAccount createBankAccount(CreateBankAccountInput input){
        log.info("Creating bank account {}", input);
        Client client = Client.builder().firstName(input.getFirstName()).build();
        return BankAccount.builder()
                .id(UUID.randomUUID())
                .client(client)
                .currency(Currency.EUR)
                .build();
    }
}
