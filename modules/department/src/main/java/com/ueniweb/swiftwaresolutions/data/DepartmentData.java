package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

    @Data
    public class DepartmentData {

        private final String depName;

        private final int id;

        public DepartmentData(String depName, int id) {
            this.depName = depName;
            this.id = id;
        }

        public static DepartmentData newInstance(String depName, int id) {
            return new DepartmentData(depName, id);
        }

}
