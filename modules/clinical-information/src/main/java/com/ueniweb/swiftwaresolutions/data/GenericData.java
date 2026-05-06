package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

    @Data
    public class GenericData {

        private Integer id;

        private String name;

        public GenericData(final Integer id, final String name) {
            this.id = id;
            this.name = name;
        }

        public static com.ueniweb.swiftwaresolutions.data.GenericData createNewInstance(final Integer id, final String name) {
            return new com.ueniweb.swiftwaresolutions.data.GenericData(id, name);
        }
}
