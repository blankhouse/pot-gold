package com.blankhouse.project.potgold.enums;

/**
 * @author hujia
 * @date 17/10/2019
 * @since 1.0.0
 */
public class ENUMS {
    public enum OcrProce {
        TRANSFER(1),
        UPLOAD(2),
        SUCCESS(3),
        ;
        private Integer value;

        OcrProce(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

    }
}
