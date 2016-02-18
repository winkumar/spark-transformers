package com.flipkart.fdp.ml.modelinfo;

import java.util.ArrayList;
import java.util.HashMap;

public class DecisionTreeModelInfo implements ModelInfo {
    public int root;
    public HashMap<Integer, Integer> leftChildMap = new HashMap<Integer, Integer>();
    public HashMap<Integer, Integer> rightChildMap = new HashMap<Integer, Integer>();
    public HashMap<Integer, DecisionNode> nodeInfo = new HashMap<Integer, DecisionNode>();

    public DecisionTreeModelInfo() {

    }

    public static class DecisionNode {
        public int id;
        public int feature;
        public boolean isLeaf;
        public String featureType;
        public double threshold;
        public double predict;
        public double probability;
        public ArrayList<Double> categories;

        public DecisionNode() {
        }

    }

}
