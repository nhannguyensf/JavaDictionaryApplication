// Enum for different parts of speech
enum PartOfSpeech {
    NOUN("noun"),
    VERB("verb"),
    ADJECTIVE("adjective"),
    ADVERB("adverb"),
    CONJUNCTION("conjunction"),
    INTERJECTION("interjection"),
    PRONOUN("pronoun"),
    PREPOSITION("preposition"),
    ;
    private final String partOfSpeech;
    PartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}
// Enum to store the dictionary data
enum DictionaryData {
    ARROW_NOUN_1("Arrow",PartOfSpeech.NOUN.getPartOfSpeech(), "Here is one arrow: <IMG> -=>> </IMG>"),
    BOOK_NOUN_1("Book",PartOfSpeech.NOUN.getPartOfSpeech(), "A set of pages."),
    BOOK_NOUN_2("Book",PartOfSpeech.NOUN.getPartOfSpeech(), "A written work published in printed or electronic form."),
    BOOK_VERB_1("Book", PartOfSpeech.VERB.getPartOfSpeech(), "To arrange for someone to have a seat on a plane."),
    BOOK_VERB_2("Book", PartOfSpeech.VERB.getPartOfSpeech(), "To arrange something on a particular date."),
    DISTINCT_ADJECTIVE_1("Distinct", PartOfSpeech.ADJECTIVE.getPartOfSpeech(), "Familiar. Worked in Java."),
    DISTINCT_ADJECTIVE_2("Distinct", PartOfSpeech.ADJECTIVE.getPartOfSpeech(), "Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT_ADVERB_1("Distinct", PartOfSpeech.ADVERB.getPartOfSpeech(), "Uniquely. Written \"distinctly\"."),
    DISTINCT_NOUN_1("Distinct",PartOfSpeech.NOUN.getPartOfSpeech(), "A keyword in this assignment."),
    DISTINCT_NOUN_2("Distinct",PartOfSpeech.NOUN.getPartOfSpeech(), "A keyword in this assignment."),
    DISTINCT_NOUN_3("Distinct",PartOfSpeech.NOUN.getPartOfSpeech(), "A keyword in this assignment."),
    DISTINCT_NOUN_4("Distinct",PartOfSpeech.NOUN.getPartOfSpeech(), "An advanced search option."),
    DISTINCT_NOUN_5("Distinct",PartOfSpeech.NOUN.getPartOfSpeech(), "Distinct is a parameter in this assignment."),
    PLACEHOLDER_ADJECTIVE_1("Placeholder", PartOfSpeech.ADJECTIVE.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_ADVERB_1("Placeholder", PartOfSpeech.ADVERB.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_CONJUNCTION_1("Placeholder", PartOfSpeech.CONJUNCTION.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_INTERJECTION_1("Placeholder", PartOfSpeech.INTERJECTION.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_NOUN_1("Placeholder",PartOfSpeech.NOUN.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_PREPOSITION_1("Placeholder", PartOfSpeech.PREPOSITION.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_PRONOUN_1("Placeholder", PartOfSpeech.PRONOUN.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_VERB_1("Placeholder", PartOfSpeech.VERB.getPartOfSpeech(), "To be updated..."),
    REVERSE_ADJECTIVE_1("Reverse", PartOfSpeech.ADJECTIVE.getPartOfSpeech(), "On back side."),
    REVERSE_ADJECTIVE_2("Reverse", PartOfSpeech.ADJECTIVE.getPartOfSpeech(), "Opposite to usual or previous arrangement."),
    REVERSE_NOUN_1("Reverse",PartOfSpeech.NOUN.getPartOfSpeech(), "A dictionary program's parameter."),
    REVERSE_NOUN_2("Reverse",PartOfSpeech.NOUN.getPartOfSpeech(), "Change to opposite direction."),
    REVERSE_NOUN_3("Reverse",PartOfSpeech.NOUN.getPartOfSpeech(), "The opposite."),
    REVERSE_VERB_1("Reverse", PartOfSpeech.VERB.getPartOfSpeech(), "Change something to opposite."),
    REVERSE_VERB_2("Reverse", PartOfSpeech.VERB.getPartOfSpeech(), "Go back"),
    REVERSE_VERB_3("Reverse", PartOfSpeech.VERB.getPartOfSpeech(), "Revoke ruling."),
    ;
    private final String keyword;
    private final String partOfSpeech;
    private final String definition;

    DictionaryData(String keyword, String partOfSpeech, String definition) {
        this.keyword = keyword;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }
    @Override
    public String toString() {
        return this.keyword + " [" + this.partOfSpeech + "]" + " : " + this.definition;
    }
}
