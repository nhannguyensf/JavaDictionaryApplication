// Enum to store the dictionary data
enum EnumDictionaryData {
    ARROW_NOUN_1("Arrow", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "Here is one arrow: <IMG> -=>> </IMG>"),
    BOOK_NOUN_1("Book", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "A set of pages."),
    BOOK_NOUN_2("Book", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "A written work published in printed or electronic form."),
    BOOK_VERB_1("Book", EnumPartOfSpeech.VERB.getPartOfSpeech(), "To arrange for someone to have a seat on a plane."),
    BOOK_VERB_2("Book", EnumPartOfSpeech.VERB.getPartOfSpeech(), "To arrange something on a particular date."),
    DISTINCT_ADJECTIVE_1("Distinct", EnumPartOfSpeech.ADJECTIVE.getPartOfSpeech(), "Familiar. Worked in Java."),
    DISTINCT_ADJECTIVE_2("Distinct", EnumPartOfSpeech.ADJECTIVE.getPartOfSpeech(), "Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT_ADVERB_1("Distinct", EnumPartOfSpeech.ADVERB.getPartOfSpeech(), "Uniquely. Written \"distinctly\"."),
    DISTINCT_NOUN_1("Distinct", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "A keyword in this assignment."),
    DISTINCT_NOUN_2("Distinct", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "A keyword in this assignment."),
    DISTINCT_NOUN_3("Distinct", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "A keyword in this assignment."),
    DISTINCT_NOUN_4("Distinct", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "An advanced search option."),
    DISTINCT_NOUN_5("Distinct", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "Distinct is a parameter in this assignment."),
    PLACEHOLDER_ADJECTIVE_1("Placeholder", EnumPartOfSpeech.ADJECTIVE.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_ADVERB_1("Placeholder", EnumPartOfSpeech.ADVERB.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_CONJUNCTION_1("Placeholder", EnumPartOfSpeech.CONJUNCTION.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_INTERJECTION_1("Placeholder", EnumPartOfSpeech.INTERJECTION.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_NOUN_1("Placeholder", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_PREPOSITION_1("Placeholder", EnumPartOfSpeech.PREPOSITION.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_PRONOUN_1("Placeholder", EnumPartOfSpeech.PRONOUN.getPartOfSpeech(), "To be updated..."),
    PLACEHOLDER_VERB_1("Placeholder", EnumPartOfSpeech.VERB.getPartOfSpeech(), "To be updated..."),
    REVERSE_ADJECTIVE_1("Reverse", EnumPartOfSpeech.ADJECTIVE.getPartOfSpeech(), "On back side."),
    REVERSE_ADJECTIVE_2("Reverse", EnumPartOfSpeech.ADJECTIVE.getPartOfSpeech(), "Opposite to usual or previous arrangement."),
    REVERSE_NOUN_1("Reverse", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "A dictionary program's parameter."),
    REVERSE_NOUN_2("Reverse", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "Change to opposite direction."),
    REVERSE_NOUN_3("Reverse", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "The opposite."),
    REVERSE_NOUN_4("Reverse", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "To be updated..."),
    REVERSE_NOUN_5("Reverse", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "To be updated..."),
    REVERSE_NOUN_6("Reverse", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "To be updated..."),
    REVERSE_NOUN_7("Reverse", EnumPartOfSpeech.NOUN.getPartOfSpeech(), "To be updated..."),
    REVERSE_VERB_1("Reverse", EnumPartOfSpeech.VERB.getPartOfSpeech(), "Change something to opposite."),
    REVERSE_VERB_2("Reverse", EnumPartOfSpeech.VERB.getPartOfSpeech(), "Go back"),
    REVERSE_VERB_3("Reverse", EnumPartOfSpeech.VERB.getPartOfSpeech(), "Turn something inside out."),
    REVERSE_VERB_4("Reverse", EnumPartOfSpeech.VERB.getPartOfSpeech(), "Revoke ruling."),
    REVERSE_VERB_5("Reverse", EnumPartOfSpeech.VERB.getPartOfSpeech(), "To be updated..."),
    REVERSE_VERB_6("Reverse", EnumPartOfSpeech.VERB.getPartOfSpeech(), "To be updated..."),
    ;
    private final String keyword;
    private final String partOfSpeech;
    private final String definition;

    EnumDictionaryData(String keyword, String partOfSpeech, String definition) {
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
