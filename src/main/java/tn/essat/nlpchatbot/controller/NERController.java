package tn.essat.nlpchatbot.controller;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.essat.nlpchatbot.entity.Enum.Type;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/nlp")
public class NERController {

    @Autowired
    private StanfordCoreNLP coreNLP;

    @PostMapping
    @RequestMapping("/ner")
    public Set<String> ner (@RequestBody final String message, @RequestParam final Type type) {

        CoreDocument coreDoc = new CoreDocument(message);
        coreNLP.annotate(coreDoc);
        List<CoreLabel> coreLabels = coreDoc.tokens();
        return new HashSet<>(collectList(coreLabels, type));

    }

    private List<String> collectList(List<CoreLabel> coreLabels, final Type type ) {
        return coreLabels
                .stream()
                .filter(coreLabel -> type.getTypeName().equalsIgnoreCase(coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class)))
                .map(CoreLabel::originalText)
                .collect(Collectors.toList());
    }
}
