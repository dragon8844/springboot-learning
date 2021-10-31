package com.dragon.elasticsearch.dataobject;

/**
 * @author lilong
 */
public class FieldAnalyzer {

    /**
     * IK 最大化分词
     *
     * 会将文本做最细粒度的拆分
     */
    public static final String IK_MAX_WORD = "ik_max_word";

    /**
     * IK 智能分词
     *
     * 会做最粗粒度的拆分
     */
    public static final String IK_SMART = "ik_smart";
}
