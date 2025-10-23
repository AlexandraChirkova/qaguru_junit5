package components;

public enum SortType {

        POPULAR("Популярные",       "relevance"),
        NEW("Новинки",              "created-desc"),
        PRICE_ASC("Сначала дешевые","price-asc"),
        PRICE_DESC("Сначала дорогие","price-desc"),
        RATING("Высокий рейтинг",   "rating");

        public final String label;
        public final String sortParam;

        SortType(String label, String sortParam) {
            this.label = label;
            this.sortParam = sortParam;
        }
}
