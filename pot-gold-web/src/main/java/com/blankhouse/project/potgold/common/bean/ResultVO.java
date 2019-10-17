package com.blankhouse.project.potgold.common.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author hujia
 * @date 2019/1/22
 * @since 1.0.0
 */
public class ResultVO {

    /**
     * log_id : 7384587323131805014
     * words_result_num : 13
     * words_result : [{"words":"少"},{"words":"点"},{"words":"有"},{"words":"不得板橋"},{"words":"利"},{"words":"下数行秋茶"},{
     * "words":"河内詔"},{"words":"一"},{"words":"煩授動務"},{"words":"書"},{"words":"但患不能脱"},{"words":"志離城郭造吏逢"},{"words
     * ":"覲牧因涉那界皆精"}]
     */

    @SerializedName("log_id")
    private long logId;
    @SerializedName("words_result_num")
    private int wordsResultNum;
    @SerializedName("words_result")
    private List<WordsResultBean> wordsResult;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public int getWordsResultNum() {
        return wordsResultNum;
    }

    public void setWordsResultNum(int wordsResultNum) {
        this.wordsResultNum = wordsResultNum;
    }

    public List<WordsResultBean> getWordsResult() {
        return wordsResult;
    }

    public void setWordsResult(List<WordsResultBean> wordsResult) {
        this.wordsResult = wordsResult;
    }

    public static class WordsResultBean {
        /**
         * words : 少
         */

        @SerializedName("words")
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
