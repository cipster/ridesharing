package ro.arnia.ridesharing.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.util.Arrays;
import java.util.Collection;

@Configuration
class ApplicationConfig extends AbstractMongoConfiguration {

  @Override
  protected String getDatabaseName() {
    return "test";
  }

  @Override
  public MongoClient mongoClient() {
    return new MongoClient();
  }

  @Override
  protected Collection<String> getMappingBasePackages() {
    return Arrays.asList("ro.arnia.ridesharing.domain.model.personRepository");
  }
}