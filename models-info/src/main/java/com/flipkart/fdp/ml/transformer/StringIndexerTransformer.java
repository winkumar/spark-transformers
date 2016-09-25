package com.flipkart.fdp.ml.transformer;

import com.flipkart.fdp.ml.modelinfo.StringIndexerModelInfo;

import java.util.Map;
import java.util.Set;

/**
 * Transforms input/ predicts for a String Indexer model representation
 * captured by  {@link com.flipkart.fdp.ml.modelinfo.StringIndexerModelInfo}.
 */
public class StringIndexerTransformer implements Transformer {

    private final StringIndexerModelInfo modelInfo;

    public StringIndexerTransformer(final StringIndexerModelInfo modelInfo) {
        this.modelInfo = modelInfo;
    }

    public double predict(final String s) {
        final Double index = modelInfo.getLabelToIndex().get(s);
        if (null == index) {
            throw new RuntimeException("Unseen label :" + s);
        }
        return index;
    }

    @Override
    public void transform(Map<String, Object> input) {
        Object inp = input.get(modelInfo.getInputKeys().iterator().next());
        String stringInput = (null != inp)?inp.toString() : "";
        input.put(modelInfo.getOutputKeys().iterator().next(), predict(stringInput));
    }

    @Override
    public Set<String> getInputKeys() {
        return modelInfo.getInputKeys();
    }

    @Override
    public Set<String> getOutputKeys() {
        return modelInfo.getOutputKeys();
    }

}
