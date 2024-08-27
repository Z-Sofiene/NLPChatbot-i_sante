package tn.essat.nlpchatbot.config;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class NLPConfig {

    @Bean
    public StanfordCoreNLP stanfordCoreNLP() {
        Properties properties = new Properties();
        properties.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
        return new StanfordCoreNLP(properties);
    }
}
